import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int n, m;
	// static char[] array;
	static Map<Character, Character> map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// a:b, b:c, c:d

		n = Integer.parseInt(input.readLine());
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String s = input.readLine();
			char c1 = s.charAt(0);
			char c2 = s.charAt(5);
			map.put(c1, c2);
		}

		m = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < m; i++) {

			String s = input.readLine();
			char c1 = s.charAt(0);
			char c2 = s.charAt(5);
			char key = c1;
			int size = map.size();
			char ans = 'F';

			while (size-- > 0) {
				if (map.get(key)!= null && map.get(key) == c2) {
					ans = 'T';
				} else if(map.get(key)!= null){
					key = map.get(key);
				} else {
					break;
				}
			}
			output.append(ans).append("\n");
		}
		System.out.println(output);

	}

}
