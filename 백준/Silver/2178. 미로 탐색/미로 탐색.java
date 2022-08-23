import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static int[][] visited;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			String str = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);

	}

	private static void bfs(int r, int c) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[][] visited = new boolean[N][M];
		queue.offer(r);
		queue.offer(c);
		visited[r][c] = true;
		cnt++;
		
		while(!queue.isEmpty()) {
			r = queue.poll();
			c = queue.poll();
			for(int d=0; d<deltas.length; d++) {						
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				if(Isin(nr, nc)) {
					if(map[nr][nc] == 1 && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						map[nr][nc] = map[r][c]+1;
						queue.offer(nr);
						queue.offer(nc);
					}
				}
			}
			
		}
		
		
	}

	private static boolean Isin(int nr, int nc) {
		
		return (nr>=0 && nr<N && nc>=0 && nc<M);
	}

}