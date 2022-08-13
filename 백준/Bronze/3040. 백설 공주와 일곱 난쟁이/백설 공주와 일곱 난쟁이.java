
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int[] nums = new int[9];
	static int[] answer = new int[7];
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(input.readLine());
		}
		
		//System.out.println(Arrays.toString(nums));
		comb(0, new int[7], 0);
		for(int i=0; i<7; i++) {
			System.out.println(answer[i]);
		}
		
		
	}
	
	public static void comb(int nth, int [] choosed, int start) {
		if(nth == 7) {
			//System.out.println(Arrays.toString(choosed));
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += choosed[i];
			}
			
			if(sum == 100) {
				answer = Arrays.copyOf(choosed, 7);
			}
			
			return;
		}
		
		for(int i = start; i<nums.length; i++) {
			choosed[nth] = nums[i];
			comb(nth+1, choosed, i+1);
		}
		
		
	}

}
