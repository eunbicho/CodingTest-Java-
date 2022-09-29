import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
 
		int N = Integer.parseInt(input.readLine());
 
		int[][] Cost = new int[N][3];
 
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
 
			Cost[i][Red] = Integer.parseInt(tokens.nextToken());
			Cost[i][Green] = Integer.parseInt(tokens.nextToken());
			Cost[i][Blue] = Integer.parseInt(tokens.nextToken());
		} // 입력 
 
		for (int i = 1; i < N; i++) {
			Cost[i][Red] += Math.min(Cost[i-1][Green], Cost[i-1][Blue]);
			Cost[i][Green] += Math.min(Cost[i-1][Red], Cost[i-1][Blue]);
			Cost[i][Blue] += Math.min(Cost[i-1][Red], Cost[i-1][Green]);
		}
 
		int answer = Math.min(Math.min(Cost[N-1][Red], Cost[N-1][Green]), Cost[N-1][Blue]);
		System.out.println(answer);
	}

}
