import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long ans = 1;
	static List[] graph;
	static boolean[] visited;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a].add(b);
			graph[b].add(a);

		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				ans = (ans * bfs(i))%1000000007;
			}
		}
		
		System.out.println(ans);

	}

	private static int bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		int count = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Integer head = q.poll();
				
				//System.out.println(head + " " +count);
				List<Integer> childs = graph[head];
				for (Integer child : childs) {
					if (!visited[child]) {				
						q.offer(child);
						visited[child] = true;
						count += 1;
					}
				}
			}
		}
		
		return count;

	}

}
