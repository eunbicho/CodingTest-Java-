import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int D, K, A, B;
	static int[] fibo = new int[30];
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		D = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		// 피보나치 수열 만들기
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i=2; i<fibo.length; i++) {
			fibo[i] = fibo[i-2] + fibo[i-1];
			
		}
		
		// A*fibo[D-3]+B*fibo[D-2] = K
		// B*fibo[D-2] = K-(A*fibo[D-3])
		// B = {K-(A*fibo[D-3])} / fibo[D-2] -> 나머지가 0이라면 그때의 A, B 출력
		A = 0;
		while(true) {
			A++;
			if((K-(A*fibo[D-3])) % fibo[D-2] == 0) {
				B = (K-(A*fibo[D-3])) / fibo[D-2];
				break;
			}
		}
		
		System.out.println(A);
		System.out.println(B);

	}

}