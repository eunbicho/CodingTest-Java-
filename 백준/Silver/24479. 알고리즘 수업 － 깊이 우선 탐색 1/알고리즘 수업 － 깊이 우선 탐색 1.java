import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R, cnt;
	static List[] graph;
	static int[] order;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken())+1;
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		order = new int[N];
		
		makeGraphList();
		dfsList(R, new boolean[N]);

		for(int i=1; i<N; i++) {
			output.append(order[i]).append('\n');
		}
		System.out.println(output);
	}

	static void dfsList(int v, boolean[] visited) {
		visited[v] = true;
		order[v] = ++cnt;
		//output.append(order[v]).append('\n');
		
		List<Integer> childs = graph[v];
		for(Integer child : childs) {
			if(!visited[child]) {
				visited[child] = true;
				dfsList(child, visited);
			}
		}
		
		
	}

	static void makeGraphList() throws IOException {
		graph = new List[N];
		for(int i=1; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<N; i++) {
			Collections.sort(graph[i]);
		}
		
	}

}
