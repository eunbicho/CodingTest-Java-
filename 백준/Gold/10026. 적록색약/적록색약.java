import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String str = input.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c);
			}
		} // 입력
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					visited[r][c] = true;
					dfs(r, c);
					cnt++;
				}
				
			}
		}
		output.append(cnt + " ");
		
		// visited 초기화
		for(int i=0; i<N; i++) {			
			Arrays.fill(visited[i], false);
		}
		cnt = 0;
		
		// 적록색맹용 배열로 만들기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 'G') {
					map[r][c] = 'R';
				}
			}
		}
		
		// 다시 돌려
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					visited[r][c] = true;
					dfs(r, c);
					cnt++;
				}
				
			}
		}
		output.append(cnt);
		
		System.out.println(output);

	}

	private static void dfs(int r, int c) {
		for(int d=0; d<deltas.length; d++) {
			
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
				
			}
		}
		
	}

	private static boolean isIn(int r, int c) {

		return r>=0 && r<N && c>=0 && c<N;
	}

}
