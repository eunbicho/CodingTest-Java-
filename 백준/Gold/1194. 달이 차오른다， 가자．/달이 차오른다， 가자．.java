

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

		// 출발 좌표
		int startR = -1;
		int startC = -1;

		for (int r = 0; r < N; r++) {
			char[] row = input.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = row[c];
				if (map[r][c] == '0') { // 출발 좌표 저장
					startR = r;
					startC = c;
				}
			}
		} // 입력

		ans = Integer.MAX_VALUE;
		ans = bfs(startR, startC);

		System.out.println(ans);

	}

	private static int bfs(int startR, int startC) {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][1<<6];

		visited[startR][startC][0] = true;
		q.offer(new Point(startR, startC, 0));

		int turn = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point head = q.poll();
				int r = head.r;
				int c = head.c;
				int keys = head.keys;
				//System.out.println(head);
				for (int d = 0; d < deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					int nxtBit = keys;
					
					if (isIn(nr, nc) && !visited[nr][nc][keys] && map[nr][nc] != '#') {
						if (map[nr][nc] == '1') { // 출구를 만나면 여기까지 온 최단거리 반환
							return turn;
						}
						// 빈칸이면 그냥 이동!
						else if(map[nr][nc] == '.' || map[nr][nc] == '0') {
							visited[nr][nc][keys] = true;
							q.offer(new Point(nr, nc, keys));
						}
						// 만약 문이라면 해당 열쇠가 있어야만 가능
						else if (map[nr][nc]>='A' && map[nr][nc]<='F') {
							if (canOpen(map[nr][nc], keys)) {
								visited[nr][nc][keys] = true;
								q.offer(new Point(nr, nc, keys));
							}
						}
						// 열쇠라면
						else if (map[nr][nc]>='a' && map[nr][nc] <='f') {
							nxtBit |= (1 << (map[nr][nc]-'a'));
							
							// keys에 담고 이동
							visited[nr][nc][nxtBit] = true;
							q.offer(new Point(nr, nc, nxtBit));
							//System.out.println(map[nr][nc] + "열쇠획득!");
						}

					}
				}
			}
			
			turn++;
		}
		return -1;

	}

	private static boolean isIn(int r, int c) {

		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	private static boolean canOpen(char door, int keys) {
		// door에 맞는 key가 keys에 있는지 확인
		return (keys & (1<< (door-'A')))  > 0;
		
	}

	public static class Point {
		int r, c, keys;

		public Point(int r, int c, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.keys = keys;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", keys=" + keys + "]";
		}
		
		

	}

}
