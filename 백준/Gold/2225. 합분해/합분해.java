import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[][] dp;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		dp = new int[N+1][K+1]; // 인덱스 0 안 쓸거
		
		// 초기값 채워넣기
		for(int n=1; n<=N; n++) {
			dp[n][1] = 1;
		}
		
		for(int k=1; k<=K; k++) {
			dp[1][k] = k;
		}
		
		// dp 배열 만들기
		for(int n=2; n<=N; n++) {
			for(int k=1; k<=K; k++) {
				dp[n][k] = (dp[n][k-1]+dp[n-1][k])%1000000000;
			}
		}
		
		
		
		System.out.println(dp[N][K]);
		
		
	}

}
