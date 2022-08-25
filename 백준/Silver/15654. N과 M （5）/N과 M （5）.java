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
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			src[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(src);
		
		perm(0, new int[M], new boolean[N]);
		System.out.println(output);

	}

	private static void perm(int nth, int[] choosed, boolean[] visited) {
		if(nth == choosed.length) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i] + " ");
			}
			output.append('\n');
			return;
		}
		
		for(int i=0; i<src.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[nth] = src[i];
				perm(nth+1, choosed, visited);
				visited[i] = false;
			}
		}
		
	}

}

