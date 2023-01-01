import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static BufferedReader input = new BufferedReader((new InputStreamReader(System.in)));
	
	public static void main(String[] args) throws Exception {
		
		char[] name  = input.readLine().toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		
		// 1. 어떤 알파벳이 몇 개 있는지 파악
		for(int i=0; i<name.length; i++) {
			int count = 1;
			if(map.containsKey(name[i])) {
				count = map.get(name[i])+1;
			}
			map.put(name[i], count);
		}

		
		// 2. 홀수개가 2개 이상이면 쏘리 출력
		
		int oddCount = 0;
		char oddChar = 'a';
		
		for (Map.Entry<Character, Integer> pair : map.entrySet()) {
			if(pair.getValue() % 2 == 1) {
				oddCount++;
				oddChar = pair.getKey();
			}
			if(oddCount >=2 ) {
				System.out.println("I'm Sorry Hansoo");
				break;
			}
		
		}

		// 3. 홀수개가 1개이하라면 2로 나눈 개수만큼 문자열 만들기
		if(oddCount <=1 ) {
			
			StringBuilder half = new StringBuilder();
			for (Map.Entry<Character, Integer> pair : map.entrySet()) {
				for(int i=0; i<pair.getValue()/2; i++) {
					half.append(pair.getKey());
				}
			}
			
			
			// 4. 사전순으로 정렬
			char[] chars = half.toString().toCharArray();
			Arrays.sort(chars);
			
			half.delete(0, half.length());
			for(int i=0; i<chars.length; i++) {
				half.append(chars[i]);
			}
			
			StringBuilder ans = new StringBuilder(half.toString());
			
			// 5. 홀수 있었으면 1개 붙이고
			if(oddCount == 1) {
				
				ans.append(oddChar);
			}
			
			// 6. 정렬한거 거꾸로 해서 붙여서 출력하기
			half.reverse();
			ans.append(half);
			
			// 7. 답 출력하기
			System.out.println(ans);
			
		}

	}

}
