

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder n1 = new StringBuilder();
	static StringBuilder n2 = new StringBuilder();
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		n1.append(tokens.nextToken());
		n2.append(tokens.nextToken());
		
		n1.reverse();
		n2.reverse();
		
		if(Integer.parseInt(n1.toString()) > Integer.parseInt(n2.toString())) {
			System.out.println(n1);
		} else {
			System.out.println(n2);
		}
		

	}

}
