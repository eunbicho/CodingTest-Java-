import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String s;
	static int ans;
	static boolean isP;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		s = input.readLine();
		isP = true;
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				isP = false;
				break;
			}
		}
		
		if(isP)
			ans = 1;
		
		System.out.println(ans);
			

	}

}
