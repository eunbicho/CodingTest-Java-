import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(input.readLine());
		for(int i=0; i<N/4; i++) {
			output.append("long ");
		}
		output.append("int");
		System.out.println(output);
		

	}

}
