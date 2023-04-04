
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] map;
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력
		
		int n=N, m=M;
		
		for(int i=0; i<Math.min(N, M)/2; i++) {
			
			rotate(i, 2*n + 2*m -4);
			n -= 2;
			m -= 2;
		}
		
		print();
		

	}

	private static void print() {
		
		for(int r=0; r<N; r++) {
			
			for(int c=0; c<M; c++) {
				output.append(String.format("%d ",map[r][c]));
			}
			output.append("\n");
		}
		
		System.out.println(output);
		
		
	}

	private static void rotate(int start, int len) {
		int rr = R % len;
		for(int i=0; i<rr; i++) {
			
			int startVal = map[start][start];
			int r = start;
			int c = start;
			int dir = 0;
			
			while (dir < 4 ) {
				int nr = r + deltas[dir][0];
				int nc = c + deltas[dir][1];
				
				if(nr == start && nc == start) break;
				if(nr >= start && nr < N-start && nc >= start && nc <M-start) {
					map[r][c] = map[nr][nc];
					r = nr;
					c = nc;
				} else 
					dir++;
			}
			
//			for(int d=0; d<deltas.length; d++) {
//				int nr = r + deltas[d][0];
//				int nc = c + deltas[d][1];
//				
//				if(nr == start && nc == start) break;
//				if(nr >= start && nr < N-start && nc >= start && nc <M-start) {
//					map[r][c] = map[nr][nc];
//					r = nr;
//					c = nc;
//				} else
//				{
//					for(int[] row : map)
//						System.out.println(Arrays.toString(row));
//					continue;
//				}
//			}
			map[start+1][start] = startVal;
		}
		
		
	}

}
