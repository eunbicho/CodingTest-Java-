

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, B, C; // N: 시험장 개수
	static long ans;
	static int[] A; // 각 시험장에 있는 응시자 수
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		A = new int[N];
		for(int i=0; i<A.length; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());	
		}
		tokens = new StringTokenizer(input.readLine());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		// 입력
		
		for(int i=0; i<A.length; i++) {
			long n = A[i]-B;
			
			// n이 0이거나 0보다 작으면
			if(n<=0) {
				ans += 1; // 총감독관 한명으로도 커버 가능
			} else { // 부감독관도 필요한 상황 
				if(n<=C) {
					ans += 2;
				} else {
					if(n%C==0) {
						ans += 1+n/C;
					} else if(n%C!=0){
						ans += 1+n/C+1;
					}
				}
				
			}
			
		}
		
		System.out.println(ans);
		

	}

}
