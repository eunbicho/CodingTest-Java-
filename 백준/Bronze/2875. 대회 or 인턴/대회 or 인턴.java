

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, ans;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		while(true) {
			// 한 팀 만들고 남은 인원 확인
			N = N-2;
			M = M-1;
			
			if(N<0 || M <0) {
				System.out.println(ans);
				break;
			}
			
			ans = ans + 1;
			
			if(N+M == K) {
				System.out.println(ans);
				break;
			} else if(N+M > K) {
				if(N == 0 || M == 0) {
					System.out.println(ans);
					break;
				}
			} else if(N+M < K) {
				System.out.println(ans-1);
				break;
			}
		}

	}

}
