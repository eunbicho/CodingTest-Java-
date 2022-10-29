

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int sum = 0;
		while(tokens.hasMoreTokens()) {
			int n = Integer.parseInt(tokens.nextToken());
			sum += n*n;
		}
		System.out.println(sum % 10);

	}

}
