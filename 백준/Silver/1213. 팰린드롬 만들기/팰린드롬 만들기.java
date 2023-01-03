import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader input = new BufferedReader((new InputStreamReader(System.in)));
	
	public static void main(String[] args) throws IOException {
		
		// 입력받기
		String name = input.readLine();
		int len = name.length();
		
		// a부터 z까지 총 26개의 알파벳 개수를 셀 count 배열이다.
		int[] count = new int[26];
		
		// 알파벳 개수를 count배열에 저장한다. 
		// 'A'-'A' = 0, 'B'-'A' = 1 ... 을 이용한 코드
		for(int i = 0; i < len; i++) {
			count[name.charAt(i)-'A']++;
		}
		
		// 홀수 개수를 셀 cnt (내 코드에서는 oddCount)
		// 홀수 개수인 알파벳의 인덱스를 나타내는 oddIdx
		int cnt = 0, oddIdx = 0;
		
		for(int i = 0; i < 26; i++) {
			if(count[i] % 2 == 1) { // 홀수 개수가 있으면 cnt를 올리고 그 알파벳 인덱스를 저장해놓는다.
				cnt++;
				oddIdx = i;
			}
		}
		
		// 홀수 개수가 1이상이면 팰린드롬을 만들지 못한다.
		if(cnt > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		
		int idx = 0;
		char[] ans = new char[len];
		
		for(int i = 0; i < 26; i++) {
			// 개수가 2 이상인 것들 (짝수개이고, 남아있는 개수가 있다면 순서대로 넣는다. 대칭이 되게!)
			// (char)65 = 'A'
			while(count[i] >= 2) { 
				ans[idx] = ans[len-1-idx] = (char)(65+i);
				idx++;
				count[i] -= 2;
			}
		}
		
		// 홀수개인 알파벳을 알맞은 자리에 (가운데에) 넣어준다.
		if(cnt == 1) ans[idx] = (char) (65+oddIdx);
		
		// 정답 출력
		System.out.println(new String(ans));
	}
}