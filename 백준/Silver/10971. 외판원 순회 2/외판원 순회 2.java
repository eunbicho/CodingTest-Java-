import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, mincost;
	static int[][] graph;
	static boolean[] visited;
	static int[] src;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		graph = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력

		mincost = Integer.MAX_VALUE;
		src = new int[N-1];
		for(int i=0; i<N-1; i++) {
			src[i] = i+1;
		}
		
		
		perm(0, new int[N-1], new boolean[N]);
		System.out.println(mincost);

	}


	private static void perm(int nth, int[] choosed, boolean[] visited) {
		if(nth == choosed.length) {
			//System.out.println(Arrays.toString(choosed));
			
			int cost = 0;
			if(graph[0][choosed[0]] == 0) {
				return;
			} else {				
				
				cost += graph[0][choosed[0]]; // 0에서 다음 첫번째 도시
				for(int i=0; i<choosed.length-1; i++) {
					if(graph[choosed[i]][choosed[i+1]] == 0) {
						
						return;
					}else {						
						cost += graph[choosed[i]][choosed[i+1]];
					}
				}
				
				if(graph[choosed[choosed.length-1]][0] == 0) {
					
					return;
				} else {					
					cost += graph[choosed[choosed.length-1]][0];
					
					mincost = Math.min(cost, mincost);
					//System.out.println(mincost);
					
					return;
				}
			}
		}
		
		for(int i=0; i<src.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[nth] = src[i];
				perm(nth+1, choosed, visited);
				visited[i] = false;
			}
		}
		
	}

}
