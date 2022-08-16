import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int maxArea, area; 
	static int cnt;
	static int[][] map;
	static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
			
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		
		map = new int[n][m];
		
		for(int r=0; r<n; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<m; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(map[r][c] == 1) { // 방문을 안했고, 그 자리가 1이라면
					cnt++;
					dfs(r, c);
					
					maxArea = Math.max(maxArea, area);
					area = 0;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxArea);
		

	}
	
	public static void dfs(int r, int c) {
		map[r][c] = 0; // 방문처리
		area++; // 넓이 1개씩 더하기
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(Isin(nr, nc)) {
				if(map[nr][nc] == 1) // 1이고 방문 안한 곳이면
					dfs(nr, nc);
			}
		}
	}
	
	private static boolean Isin(int r, int c) {
		return ( r>=0 && r<n && c >=0 && c<m );
	}

}
