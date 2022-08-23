import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static List[] graph;
	static boolean[] visited;
	static boolean isAnswer;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		makeGraph();
		for(int i=0; i<N; i++) {			
			dfsList(i, new boolean[N], 0);
		}
		if(isAnswer)
			System.out.println(1);
		else
			System.out.println(0);

	}

	private static void dfsList(int v, boolean[] visited, int depth) {
		visited[v] = true;	
		int d = depth;

		if(d>=4) {
			isAnswer = true;
			return;
		}

		
		List<Integer> childs = graph[v];
		for(Integer child: childs) {
			if(!visited[child]) {
				dfsList(child, visited, depth+1);
			}
		}
		visited[v] = false;
		
	}

	private static void makeGraph() throws IOException {
		graph = new List[N];
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a].add(b);
			graph[b].add(a);
			
		}
		
	}
	


}