import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int ans;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		
		String s = input.readLine();
		ans = s.length();
		
		for(int i=0; i<s.length()-1; i++) {
			if(isPalindrome(s.substring(i))) {
				break;
			}
			ans++;
		}
		System.out.println(ans);

	}
	
	public static boolean isPalindrome(String s) {
		
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}

}
