import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long [] nums;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		
		nums = new long[N];
		for(int i=0; i<N; i++) {
			nums[i] = Long.parseLong(tokens.nextToken());
		}
		
		Arrays.sort(nums);
		
		int lp = 0;
		int rp = N-1;
		long ans1 = 0;
		long ans2 = 0;
		
		long min = Long.MAX_VALUE;
		while(true) {
			if(lp == rp)
				break;
			
			if(Math.abs(nums[lp]+nums[rp])<min) {
				min = Math.abs(nums[lp]+nums[rp]);
				ans1 = nums[lp];
				ans2 = nums[rp];
				
			}
			
			if(nums[lp]+nums[rp] > 0)
				rp--;
			else
				lp++;

		}
		System.out.println(ans1 + " " +ans2);
	}

}
