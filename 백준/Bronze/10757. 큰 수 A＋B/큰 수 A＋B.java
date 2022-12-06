import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
		
		BigInteger A = new BigInteger(tokens.nextToken());
		BigInteger B = new BigInteger(tokens.nextToken());
		
		A = A.add(B);
		
		System.out.println(A.toString());
	}
}