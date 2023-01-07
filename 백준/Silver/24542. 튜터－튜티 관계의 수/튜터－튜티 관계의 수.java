import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.StringTokenizer;

public class Main {

	static int N, M, count;
	static long ans = 1;
	static List[] graph;
	static boolean[] visited;

	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph = new List[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a].add(b);
			graph[b].add(a);

			
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
				if(count !=0) {
					ans = (ans * count) % 1000000007;	
				}
				count = 0;
			}
		}
		System.out.println(ans);
		

	}

	private static void dfs(int v) {
		visited[v] = true;
		count++;
		
		List<Integer> childs = graph[v];
		for(Integer child : childs) {
			if(!visited[child]) {
				dfs(child);
			}
		}
		
	}

}
