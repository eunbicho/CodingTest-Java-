import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int[] plan;
	static String ans = "YES";
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		
		map = new int[N][N]; 
		plan = new int[M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(r==c) // 출발점과 도착점이 같은 경우에도 항상 여행 가능 
					map[r][c] = 1;
			}
		}
		
//		tokens = new StringTokenizer(input.readLine());
//		for(int i=0; i<M; i++) {
//			plan[i] = Integer.parseInt(tokens.nextToken())-1;
//		}
		
		//플로이드 워셜
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][k] == 1 & map[k][j]==1) { // k를 거쳐서 i에서 j로 갈 수 있다면
						map[i][j] = 1; // map에 그 정보 저장
					}
				}
			}
		}
		
//		int idx = 0;
//		while(idx < N-1) {
//			int prev = plan[idx];
//			int next = plan[idx+1];
//			if(map[prev][next] != 1) {
//				ans = "NO";
//			}
//			idx++;
//		}

		
		tokens = new StringTokenizer(input.readLine());
		int start = Integer.parseInt(tokens.nextToken());
		
		for(int i=0; i<M-1; i++) {
			int end = Integer.parseInt(tokens.nextToken());
			
			if(map[start-1][end-1]==0) {
				ans = "NO";
				break;
			}
			start = end;
		}
		
		System.out.println(ans);
	}
}