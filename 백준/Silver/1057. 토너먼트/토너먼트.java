import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, Jimin, Hansu;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		Jimin = Integer.parseInt(tokens.nextToken());
		Hansu = Integer.parseInt(tokens.nextToken());
		
		int round = 0;
		
		while(Jimin != Hansu) {	
			round++;
			Jimin = Jimin/2 + Jimin%2;
			Hansu = Hansu/2 + Hansu%2;
		
		}
		
		System.out.println(round);
	}
}