

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int K, cnt_A, cnt_B;
	static int[][] memo;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		
		K = Integer.parseInt(input.readLine());
		memo = new int[K+1][2];
		
		// k가 1인 경우
		if(K>=1) {
			
			memo[1][0] = 0;
			memo[1][1] = 1;
			
			if(K>=2) {
				
				// k가 2인 경우
				memo[2][0] = 1;
				memo[2][1] = 1;
			}
		}
				
		if(K>=3) {			
			for(int i=3; i<K+1; i++) {
				memo[i][0] = memo[i-2][0] + memo[i-1][0];
				memo[i][1] = memo[i-2][1] + memo[i-1][1];	
			}
				
			
		}
		
		
		
		System.out.println(memo[K][0] + " " + memo[K][1]);
	}

}
