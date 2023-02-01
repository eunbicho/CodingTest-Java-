import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] maxDp;
	static int[] minDp;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(input.readLine());
		maxDp = new int[3];
		minDp = new int[3];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			int n3 = Integer.parseInt(tokens.nextToken());
			
			if(i == 0) {
				maxDp[0] = minDp[0] = n1;
				maxDp[1] = minDp[1] = n2;
				maxDp[2] = minDp[2] = n3;
			} else {
				
				// 최댓값 구하기
				int prevMaxDp_0 = maxDp[0];
				int prevMaxDp_2 = maxDp[2];
				
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + n1;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + n3;
				maxDp[1] = Math.max(Math.max(prevMaxDp_0, maxDp[1]), prevMaxDp_2) + n2;

				// // 최솟값 구하기
				int prevMinDp_0 = minDp[0], prevMinDp_2 = minDp[2];
				minDp[0] = Math.min(minDp[0], minDp[1]) + n1;
				minDp[2] = Math.min(minDp[1], minDp[2]) + n3;
				minDp[1] = Math.min(Math.min(prevMinDp_0, minDp[1]), prevMinDp_2) + n2;
				
				
				
			}
			
		}
		output.append(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " ");
		output.append(Math.min(minDp[0], Math.min(minDp[1], minDp[2])) + "\n");
		System.out.println(output);
		
		
	}

}
