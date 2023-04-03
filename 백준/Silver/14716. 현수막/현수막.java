import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int M, N, ans;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
	static List<int[]> word;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		map = new int[M][N];
		word = new ArrayList<>();
		
		for(int r=0; r<M; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1)
					word.add(new int[] {r, c});
			}
		} // 입력
		
		for(int i=0; i<word.size(); i++) {
			int[] head = word.get(i);
			int r = head[0];
			int c = head[1];
			if(map[r][c] == 1) { // 방문 안했으면 dfs로 쭉쭉 탐색
				dfs(new int[] {r, c});
				ans++;
			}
		}
		
		System.out.println(ans);
		
		

	}

	private static void dfs(int[] w) {
		
		int r = w[0];
		int c = w[1];
		
		map[r][c] = 0; // 방문처리
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc) && map[nr][nc] == 1) { // 안에 있고 방문 안한 곳이면 dfs로 탐색
				dfs(new int[] {nr, nc});
			}
		}
		
	}

	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<M && c>=0 && c<N;
	}

}
