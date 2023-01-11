import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main{
    
    static char[][] map;
    static int N, M;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static boolean isCycle;
	static Point start;
	static char color;
	static boolean[][] visited;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
    	tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
        
        map = new char[N][M];
        
        for(int r=0; r<N; r++) {
			String s = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = s.charAt(c);
			}
		}
    
        escape: for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                visited = new boolean[N][M];
                start = new Point(r, c);
                if(dfs(new Point(r, c), 1)) {
                    isCycle = true;
                	output.append("Yes");
                    break escape;
                }
            }
        }
        
     // 다 살펴봐도 사이클 없으면 no 출력
     		if(!isCycle) {
     			output.append("No");
     		}
     		
     		System.out.println(output);
    }
    
	public static boolean dfs(Point cur, int k) {        
        visited[cur.r][cur.c] = true;
        for(int d = 0; d < 4; d++) {
            int nr = cur.r + deltas[d][0];
            int nc = cur.c + deltas[d][1];
            
            if(isIn(nr, nc) && map[cur.r][cur.c] == map[nr][nc]) {
                if(visited[nr][nc] == false) {
                    visited[nr][nc] = true;
                    if(dfs(new Point(nr, nc), k + 1)) return true;
                } else {
                    if(k >= 4 && new Point(nr, nc).equals(start)) return true;
                }
            }
        }
        return false;
    }
    
private static boolean isIn(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<M;
	}

	public static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
			
		}

		public boolean equals(Point o) {
			return (this.r == o.r && this.c == o.c);
		}
	
	}	
}

