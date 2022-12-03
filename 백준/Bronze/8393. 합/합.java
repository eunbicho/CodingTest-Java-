
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(input.readLine());
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += i;
		}
		System.out.println(sum);

	}

}
