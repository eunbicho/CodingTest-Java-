import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R;
	static int [][] map;
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 상 좌 하
	
	static int [] dr = {0, 1, 0, -1};
	static int [] dc = {1, 0, -1, 0};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력 끝
		
		
		// 사이클 횟수
		int cycle = Math.min(N, M)/2;
		
		
		for(int i=0; i<R; i++) { // R번 반복
			for(int j=0; j<cycle; j++) { // 한 사이클마다 반복
				int cr = j;
				int cc = j;
				
				int value = map[cr][cc];
				
//				for(int d=0; d<deltas.length; d++) {
//					System.out.println(d);
//					int nr = cr + deltas[d][0];
//					int nc = cc + deltas[d][1];
//					
//					if(nr>=j && nc >=j && nr<N-j && nc<M-j) {
//						map[cr][cc] = map[nr][nc];
//						cr = nr;
//						cc = nc;
//					}
//					else
//						continue;
//				}
				
				int dir = 0;
				while(dir<4) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(nr>=j && nc >=j && nr<N-j && nc<M-j) {
						map[cr][cc] = map[nr][nc];
						cr = nr;
						cc = nc;
					}
					else dir++;
				}
				map[j+1][j] = value;
					
				
			}
			
			
		}
		
		// 출력
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				System.out.print(map[r][c] +" ");
			}
			System.out.println();
		}

	}
	
	private static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<M);
	}

}
