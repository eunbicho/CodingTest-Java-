import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String ans = "yes";
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		while(true) {
			String s = input.readLine();
			if(s.equals("0")) {
				break;
			}
			char[] c = s.toCharArray();
			int loop = c.length/2 + c.length%2;
			for(int i=0; i<loop; i++) {
				if(c[i] != c[(c.length-1)-i]) {
					ans = "no";
					break;
				}
			}
			output.append(ans).append("\n");
			ans = "yes";
		}
		System.out.println(output);

	}

}
