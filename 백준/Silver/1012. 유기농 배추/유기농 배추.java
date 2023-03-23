import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, M, N, K;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(input.readLine());
		
		for(int t=0; t<T; t++) {
			
			int ans = 0;
			
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			map = new int[N][M];
			
			// map 정보 채우기 (배추가 있는 곳에 1 넣기)
			for(int k=0; k<K; k++) {
				tokens = new StringTokenizer(input.readLine());
				int c = Integer.parseInt(tokens.nextToken());
				int r = Integer.parseInt(tokens.nextToken());
				
				map[r][c] = 1; // 배추가 있는 곳에 1 넣기	
			}
	
			
			// bfs로 지렁이 개수 파악하기
			
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(map[n][m] == 1) {
						bfs(new Point(n, m));
						ans++;
					}
				}
			}
			
			
			output.append(ans).append("\n");
			
		}
		System.out.println(output);
		
	}
	
	public static void bfs(Point p) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		map[p.r][p.c] = 0; // 방문한 곳은 0으로 바꾸기
		
		while(!q.isEmpty()) {
			
			
			int size = q.size();
			while(size-- > 0) {
				Point head = q.poll();
				for(int d=0; d<deltas.length; d++) {
					int nr = head.r + deltas[d][0];
					int nc = head.c + deltas[d][1];
					if(isIn(nr, nc) && map[nr][nc] == 1) { // 주위에 배추가 있으면
						q.add(new Point(nr, nc)); // 큐에 넣고
						map[nr][nc] = 0; // 방문처리
						
					}
				}
			}
			
			
		}
		
		
		
	}

	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<M;
	}

	public static class Point{
		int r, c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

}
