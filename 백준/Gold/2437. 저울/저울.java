import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] nums;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(input.readLine());
		nums = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		// 오름차순으로 정렬
		Arrays.sort(nums);
		
		int sum = 0;
		int ans = 0;
		boolean noProblem = true;
		for(int i=0; i<N; i++) {
			
			if(nums[i] >= sum+2){
				ans = sum+1;
				noProblem = false;
				break;
			}
			
			sum += nums[i];
			

		}
		
		if(noProblem)
			ans = sum+1;
		
	
		System.out.println(ans);

	}

}
