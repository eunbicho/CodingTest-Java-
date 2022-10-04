

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

	static int N, M, totalCnt;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static List<Point> src = new ArrayList<>(); // 빈 부분 담기
	static List<Point> virus = new ArrayList<>(); // 바이러스 담기
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if (map[r][c] == 0) {
					src.add(new Point(r, c)); // 빈 칸 찾아놓기
				} else if(map[r][c] == 2) {
					virus.add(new Point(r, c)); // 바이러스 담기
				}
			}
		} // 입력

		comb(0, new Point[3], 0);
		// System.out.println(totalCnt);
		System.out.println(max);

	}

	private static void comb(int nth, Point[] choosed, int startIdx) {
		if (nth == choosed.length) {
			//System.out.println(Arrays.toString(choosed));
			totalCnt++;

			// 빈 칸 중에 3개를 뽑았으면 calZeroCnt 함수에서 안전 영역 크기 계산 후 max값 갱신
			max = Integer.max(max, calZeroCnt(choosed));
			return;
		}

		for (int i = startIdx; i < src.size(); i++) {
			choosed[nth] = src.get(i);
			comb(nth + 1, choosed, i + 1);
		}

	}

	private static int calZeroCnt(Point[] choosed) {

		// 원래 맵 복사본 만들기
		int temp[][] = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				temp[r][c] = map[r][c];
			}
		}

		// 뽑힌 세 부분에 벽 세우기
		for (int i = 0; i < choosed.length; i++) {
			int r = choosed[i].r;
			int c = choosed[i].c;
			temp[r][c] = 1;
		}

		// 바이러스 퍼뜨리기
		int cnt = 0;
		cnt = bfs(temp);

		return cnt;
	}

	private static int bfs(int[][] temp) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for(int i=0; i<virus.size(); i++) {			
			q.offer(virus.get(i));
			visited[virus.get(i).r][virus.get(i).c] = true;
		}

		int turn = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point head = q.poll();
				int r = head.r;
				int c = head.c;
				
				for (int d = 0; d < deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if (isIn(nr, nc) && !visited[nr][nc] && temp[nr][nc] == 0) {
						q.offer(new Point(nr, nc));
						visited[nr][nc] = true;
						temp[nr][nc] = 2;
					}
				}

			}
			turn++;
		}

//		for (int[] row : temp) {
//			System.out.println(Arrays.toString(row));
//		}

		int cnt = 0; // 0의 개수 (안전지대 개수)
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (temp[r][c] == 0) {
					cnt++;
				}
			}
		}
		return cnt;

	}

	private static boolean isIn(int r, int c) {

		return r >= 0 && r < N && c >= 0 && c < M;
	}

	public static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
