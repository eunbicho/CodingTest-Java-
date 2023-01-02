import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, Jimin, Hansu, round;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		Jimin = Integer.parseInt(tokens.nextToken());
		Hansu = Integer.parseInt(tokens.nextToken());
		
		go: while(true) {
			round++;

			// 현재 인원 확인 (인원에 따라 반복 횟수 결정)
			// 짝수라면 N/2번 반복, 홀수라면 N/2+1번 반복
			if(N%2 == 0) {
				N = N/2;
			} else if(N%2 == 1) {
				N = N/2+1;
			}
			
			// 앞에서부터 2명씩 경기시키기
			// 2명의 번호를 확인해서 
			// 그 두 명이 지민, 한수라면 종료.
			// 둘 중에 한명만 지민 또는 한수라면 한명의 번호 업데이트하기
			
			int p1 = -1;
			int p2 = 0;
			for(int i=1; i<=N; i++) {
				p1 += 2;
				p2 = p1+1;
				
				// 두 사람이 경기에서 만났다면
				if((p1 == Jimin && p2 == Hansu) || (p1 == Hansu && p2 == Jimin)) {
					// 라운드 멈추기!
					break go;
				}
				// 둘 중에 한명만 있는 경우(지민이만 있는 경우)
				else if( p1 == Jimin || p2 == Jimin) {
					// 이번에 이겨야하니까 다음 라운드에서의 번호 업데이트
					Jimin = i;

				}
				// 둘 중에 한명만 있는 경우(한수만 있는 경우)
				else if(p1 == Hansu || p2 == Hansu) {
					// 이번에 이겨야하니까 다음 라운드에서의 번호 업데이트
					Hansu = i;

				}
			}
			
			
		}
		
		System.out.println(round);

	}

}
