
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int pay;
	static int[] coin = {1, 2, 5, 7};
	static int[] dp;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		pay = Integer.parseInt(input.readLine());
		dp = new int[pay+1];
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		for(int i=1; i<=pay; i++) {
			for(int j=0; j<4; j++) {				
				if(i-coin[j]<0) continue;
				dp[i] = Math.min(dp[i], dp[i-coin[j]]+1);
			}
		}
		System.out.println(dp[pay]);

	}

}
