import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, T, ans;
	static int[][] cave;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T++; // 테케 1부터 시작
		while(true) {			
			N = Integer.parseInt(input.readLine());
			if(N == 0)break;
			cave = new int[N][N];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					cave[r][c] = Integer.parseInt(tokens.nextToken());
				}
			} // 한 테케 입력
			
			int start = 0;
			int end = N-1;
			int[][] D = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {				
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}
			
			D[start][start] = cave[0][0];
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.offer(new Point(0, 0, D[0][0]));
			
			while(!pq.isEmpty()) {
				Point head = pq.poll();
				visited[head.r][head.c] = true;
				
				for(int d=0; d<deltas.length; d++) {
					int nr = head.r+ deltas[d][0];
					int nc = head.c + deltas[d][1];
					if(isIn(nr, nc)) {
						if(!visited[nr][nc] && head.minrupee + cave[nr][nc] < D[nr][nc]) {
							D[nr][nc] = head.minrupee + cave[nr][nc];
							pq.offer(new Point(nr, nc, D[nr][nc]));
						}
					}
				}
			}
			
			
			
			
			ans = D[end][end];
			
			output.append(String.format("Problem %d: %d%n", T, ans)); // 한 테케 출력
			T++;
		}
		System.out.println(output);

	}
	
	private static boolean isIn(int nr, int nc) {
		
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

	static class Point implements Comparable<Point>{
		int r;
		int c;
		int minrupee;
		public Point(int r, int c, int minrupee) {
			super();
			this.r = r;
			this.c = c;
			this.minrupee = minrupee;
		}
		@Override
		public int compareTo(Point o) {
			
			return this.minrupee - o.minrupee;
		}
		
		
	}

}