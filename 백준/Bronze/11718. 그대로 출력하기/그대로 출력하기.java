import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		String msg = "";
		while((msg = input.readLine()) != null) {			
			System.out.println(msg);
		}

	}

}
