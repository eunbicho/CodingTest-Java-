

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = 1;
		
		for(int i=0; i<3; i++) {
			int num = Integer.parseInt(input.readLine());
			n *= num;
		}
		String s = Integer.toString(n); // 곱한 값들 string으로 바꾸기
		
		int cnt = 0;
		for(int i=0; i<=9; i++) {			
			char index = (char)(i+'0'); // 인덱스 char로 변화
			
			cnt = 0;
			for(int j=0; j<s.length(); j++) { // 인덱스마다 반복
				char s_num = s.charAt(j);// s의 char 하나씩 가져오기
				if(s_num == index) {
					cnt++;
				}
			}
			System.out.println(cnt);
			
		}
		

	}

}
