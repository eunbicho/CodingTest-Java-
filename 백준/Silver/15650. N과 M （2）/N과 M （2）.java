import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] src;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		src = new int[N];
		for(int i=0; i<N; i++) {
			src[i] = i+1;
		}
		
		comb(0, new int[M],0);
		System.out.println(output);

	}

	private static void comb(int nth, int[] choosed, int startIdx) {
		if(nth == choosed.length) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i] + " ");
			}
			output.append('\n');
			return;
		}
		
		for(int i=startIdx; i<src.length; i++) {
			
			choosed[nth] = src[i];
			comb(nth+1, choosed, i+1);
			
		}
		
	}

}
