import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int A = Integer.parseInt(tokens.nextToken());
		int B = Integer.parseInt(tokens.nextToken());
		int C = Integer.parseInt(tokens.nextToken());
		
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);

		

	}

}
