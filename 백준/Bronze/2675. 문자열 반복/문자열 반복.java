

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, R;
	static String S;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			R = Integer.parseInt(tokens.nextToken());
			S = tokens.nextToken();
			
			StringBuilder newS = new StringBuilder();
			for(int s=0; s<S.length(); s++) {
				char c = S.charAt(s);
				
				for(int r=0; r<R; r++) {
					newS.append(Character.toString(c));
				}
				
			}
			output.append(newS).append("\n");
			
		}
		System.out.println(output);

	}

}
