
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, hour, cnt;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static List<Point> border = new ArrayList<>();
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력
		
		while(!isClear()) {
			
			if(calCnt() != 0) {				
				cnt = calCnt();
			}
			bfs();
			for(int i=0; i<border.size(); i++) {
				map[border.get(i).r][border.get(i).c] = 0;
			}
			border.clear();
			hour++;
			
//			for(int[] row: map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
		}

		System.out.println(hour);
		System.out.println(cnt);

	}

	// 맵에 남아있는 1 개수 계산
	private static int calCnt() {
		int cnt = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	// 치즈가 다 녹았는지 확인하는 함수
	private static boolean isClear() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] != 0)
					return false;
			}
		}
		return true;
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		
		q.offer(new Point(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			while(size-- >0) {
				
				Point head = q.poll();
				int r = head.r;
				int c = head.c;
				for(int d=0; d<deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if(isIn(nr, nc) && !visited[nr][nc]) {
						if(map[nr][nc] == 1) { // 1이면 녹게 하기
							border.add(new Point(nr, nc));
						} else { // 0이면 탐색 고
							q.offer(new Point(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}
				
				
				
			}
		}
		
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		
		return nr>=0 && nr < R && nc >=0 && nc <C;
	}

	public static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
