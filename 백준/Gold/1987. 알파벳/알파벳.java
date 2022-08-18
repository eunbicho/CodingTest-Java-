import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C, answer;
	static char[][] map;
	static boolean[] visited;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		
		for(int r=0; r<R; r++) {
			String str = input.readLine();
			for (int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
//		for(char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		dfs(0, 0, 0);
		System.out.println(answer);

	}
	
	static void dfs(int r, int c, int cnt) {
		if(visited[map[r][c]-'A']) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		visited[map[r][c]-'A'] = true;
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc)) {
				dfs(nr, nc, cnt+1);
			}
		}
		
		visited[map[r][c]-'A'] = false;
		
		
		
	}
	
	public static boolean isIn(int r, int c) {
		return (r >=0 && r<R && c>=0 && c<C);
	}

}
