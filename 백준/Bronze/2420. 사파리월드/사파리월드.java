
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

		public static void main(String args[]) throws IOException {
			
			tokens = new StringTokenizer(input.readLine());
			long n = Long.parseLong(tokens.nextToken());
			long m = Long.parseLong(tokens.nextToken());
			
			long result = n + (m * -1);
			System.out.println(Math.abs(result));
		}
	

}
