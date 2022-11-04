

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static String S;
	static StringBuilder output = new StringBuilder();
	
	// a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
	static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		S = input.readLine();
		char[] s = S.toCharArray();
		
		boolean b = false;
		for(int i=0; i<alphabet.length; i++) {
			for(int j=0; j<s.length; j++) {
				if(alphabet[i] == s[j] && !visited[i]) {
					output.append(j + " ");
					visited[i] = true;
					b = true;
				}
			}
			if(b == false) {
				output.append(-1 + " ");
			}
			b = false;
		}
		System.out.println(output);

	}

}
