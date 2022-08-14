import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	// 1 1 2 2 2 8
	static int[] correct = {1, 1, 2, 2, 2, 8};
	static int[] white = new int[6];
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<6; i++) {
			white[i] = Integer.parseInt(tokens.nextToken());
			output.append(correct[i]-white[i] + " ");
		}
		System.out.println(output);
		

	}

}
