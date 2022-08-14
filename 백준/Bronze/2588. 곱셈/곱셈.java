import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		
		int n1 = Integer.parseInt(input.readLine());
		int n2 = Integer.parseInt(input.readLine());
		
		int n3 = n1 * ((n2 % 100)%10);
		int n4 = n1 * ((n2 % 100)/10);
		int n5 = n1 * (n2/100);
		int n6 = n1 * n2;
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		System.out.println(n6);

	}
	

}
