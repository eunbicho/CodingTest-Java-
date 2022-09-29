import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int length;
    public static char[] expression;
    public static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  

        length = Integer.parseInt(input.readLine());
        expression = input.readLine().toCharArray();

        dfs(2, expression[0] - '0'); // 지금 숫자, 
        System.out.println(max);
    }

    public static void dfs(int now, int total) {

        // 종료 조건
        if(now>=length){
            max = Math.max(max, total);
            return;
        }

        // 괄호를 사용하지 않음 A+B
        dfs(now + 2, calculate(total, expression[now] - '0', expression[now - 1]));


        // now부터 시작하는 괄호를 사용함. A+(B+C)
        if(now+2<length){
            int sum = calculate(expression[now] - '0', expression[now + 2] - '0', expression[now + 1]);
            int sumTotal = calculate(total, sum, expression[now - 1]);
            dfs(now + 4, sumTotal);

        }

    }

    // 계산 결과 반환
    public static int calculate(int sum, int plus, char sep) {
        if(sep=='+')
            return sum + plus;
        if(sep=='-')
            return sum - plus;
        return sum * plus;
    }

}
