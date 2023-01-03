import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, K, ans;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	
	// 시작 좌표와 끝 좌표
	static int startR, startC, endR, endC;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		startR = R-1;
		startC = 0;
		endR = 0;
		endC = C-1;
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			String s = input.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = s.charAt(c);
			}
		} // 입력
		
		visited[startR][startC] = true;
		dfs(startR, startC, 1); // 출발점 넣기!
		System.out.println(ans);

	}
	
	private static void dfs(int r, int c, int move) {
		
		
		// 도착했으면 리턴
		if(r==endR && c==endC) {
			
			if(move == K) {
				ans++;
				
				return;
			}
		}
		
		for(int d=0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && map[nr][nc] != 'T' && !visited[nr][nc]) {
				
				visited[nr][nc] = true;
				dfs(nr, nc, move+1);
				visited[nr][nc] = false;
				
			}
			
		}
	}

	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<R && c>=0 && c<C;
	}

}
