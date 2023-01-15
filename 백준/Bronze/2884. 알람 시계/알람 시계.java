

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, M;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		H = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		// 1. M에서 45를 뺀다
		
		// 2. 그 결과가 0이거나 양수면 M만 변하고 답 출력!
		//    그 결과가 음수라면 M-45한 값의 절댓값이 60에서 뺀 값이되고 H는 -1한 값
		
		if(M-45 >= 0) {
			M = M-45;
			System.out.println(H + " " + M);
		} else {
			M = 60 - (-1 * (M-45));
			if(H-1 < 0) { // 0시에서 뒤로 가면 23시!
				H = 23;
			} else {
				H = H-1;
			}
			System.out.println(H + " " + M);
		}

	}

}
