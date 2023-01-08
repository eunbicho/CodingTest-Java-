import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int T, n;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static long[][] dp = new long[65][10]; // dp[i][j] : i는 자리 수, j는 시작하는 수

	public static void main(String[] args) throws Exception {

		// N자리의 S로 시작하는 수에 대한 줄어들지 않는 수의 개수
		// = (N - 1)자리의 S로 시작하는 수부터 (N - 1)자리의 9까지의 줄어들지 않는 수의 개수

		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {

			int n = Integer.parseInt(input.readLine());
			 
			// 1자리수 모두 1개
			 for(int i=0; i<10; i++) {
				 dp[1][i]=i+1;
			 }
			 for(int i=2; i<=n; i++) {
				 dp[i][0] = 1; // 어떤 자리수여도 9로 시작하는건 1개 
				 for(int j=1; j<10; j++) {
					 dp[i][j] =dp[i-1][j] + dp[i][j-1];
				 }
			 }
			 	
			 output.append(dp[n][9]).append("\n");
		
		}
		System.out.println(output);

	}
}
