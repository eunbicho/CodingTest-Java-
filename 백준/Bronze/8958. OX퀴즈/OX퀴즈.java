

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int ans;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		int tc = Integer.parseInt(input.readLine());
		for(int t=0; t<tc; t++) { // tc마다 반복	
			
			String s= input.readLine();
			char[] c = s.toCharArray();
			int score = 0;
			for(int i=0; i<c.length; i++) {
				if(c[i] == 'O') {
					ans+=++score;
					
				} else if(c[i]=='X') {
					score = 0;
				}
			}
			output.append(ans).append("\n");
			ans = 0;
		}
		System.out.println(output);

	}

}
