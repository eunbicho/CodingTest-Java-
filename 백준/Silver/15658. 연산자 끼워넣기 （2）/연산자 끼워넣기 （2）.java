import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N;
	static int[] nums;
	static int[] operators = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		nums = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<4; i++) {
			operators[i] = Integer.parseInt(tokens.nextToken());
		}
		// input 처리
		
		dfs(0, nums[0]); // 0: 시작 depth, nums[0]: 첫번째 숫자
		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int depth, int result) {
		if(depth == N-1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operators[i]>0) { // 연산자가 있으면
 				operators[i]--; // 일단 한 개 사용!
 				
 				int result_temp = 0; // 임시 변수에 그 연산자로 계산한 결과 저장
 				switch (i) {
				case 0:
					result_temp = result + nums[depth+1];
					break;
				case 1:
					result_temp = result - nums[depth+1];
					break;
				case 2:
					result_temp = result * nums[depth+1];
					break;
				case 3:
					result_temp = result / nums[depth+1];
					break;
				}
 				dfs(depth+1, result_temp);
 				operators[i]++; // 연산자 사용 안한 척
				
			}
		}
		
	}

}
