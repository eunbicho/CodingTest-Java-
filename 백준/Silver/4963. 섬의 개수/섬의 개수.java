import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w, h;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		while(true) {
			int ans = countIsland();
			if(ans == -1) // 종료 코드를 만나면 while문 탈출
				break;
			output.append(ans).append("\n");
		}
		System.out.println(output);
		

	}
	
	public static int countIsland() throws Exception{
		
		int count = 0; // 섬의 개수 저장할 변수
		List<int[]> list = new ArrayList<>();
		
		tokens = new StringTokenizer(input.readLine());
		
		w = Integer.parseInt(tokens.nextToken());
		h = Integer.parseInt(tokens.nextToken());
		
		if(w == 0 && h == 0) { // 종료 코드
			return -1;
		}
		
		map = new int[h][w];
		
		
		for(int r=0; r<h; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<w; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) {
					list.add(new int[]{r, c});
				}
					
			}
		} // 맵 입력
		
	
		
		
		boolean[][] visited = new boolean[h][w];

		for(int i=0; i<list.size(); i++) {
			int[] poll = list.get(i);
			
			int r = poll[0];
			int c = poll[1];
			
		
			if(!visited[r][c]) {
				dfs(r, c, visited);
				count++;
				
			}
		}
		
		return count;
	}

	private static void dfs(int r, int c, boolean[][] visited) {
		
		visited[r][c] = true;
		map[r][c] = 0;
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc))
			
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				
				dfs(nr, nc, visited);
				
			}
		}
		
		
	}

	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<h && c>=0 && c<w;
	}

}
