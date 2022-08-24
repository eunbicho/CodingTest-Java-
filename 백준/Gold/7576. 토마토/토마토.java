import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans, cnt;
	static int [][] box;
	static Queue<Point> q = new LinkedList<>();
	static int [][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		box = new int[N][M];
		cnt = 0;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				box[r][c] = Integer.parseInt(tokens.nextToken());
				
				// 익은 토마토 큐에 담기
				if(box[r][c] == 1) {
					q.offer(new Point(r, c));
					
				}
				else if(box[r][c] == 0) {
					cnt++;
				}
				
			}
		} // 입력
		
		bfs();
		System.out.println(ans);

	}


	private static void bfs() {
		
		int depth = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Point head = q.poll();
				
				for(int d=0; d<deltas.length; d++) {
					int nr = head.r + deltas[d][0];
					int nc = head.c + deltas[d][1];
					if(isIn(nr, nc) && box[nr][nc] == 0) {
						q.offer(new Point(nr, nc));
						
						box[nr][nc] = 1;
						cnt--;
					}
				}
				
			}
			
			if(q.isEmpty()) {
				break;
			}
			
			
			
//			for(int [] row : box) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			
			depth++;
//			System.out.println(depth);
			
			// 한 턴 끝낼 때마다 다 익었는지 확인 -> 다 익었으면 bfs 그만! 이 depth까지가 답.
			

		}
		
		
		// 다 끝났으면
		if(cnt == 0) {
			ans = depth;
		} else {
			ans = -1;
		}
		
		

		
	}


	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
