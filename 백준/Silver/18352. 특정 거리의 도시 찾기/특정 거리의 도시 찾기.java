import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, X;
	static List[] graph;
	static ArrayList<Integer> answer;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		
		answer = new ArrayList<>();
		makeGraph();
		
		bfs(new Point(X, 0));
		
		

	}
	
	public static void bfs(Point start) {
		
		Queue<Point> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(start);
		visited[start.n] = true;
		
		while(!q.isEmpty()) {
			Point head = q.poll();
//			System.out.println(head);
			if(head.k == K)
				answer.add(head.n);
			List<Integer> children = graph[head.n];
			for(int child : children) {
				if(!visited[child]) {
					q.add(new Point(child, head.k+1));
					visited[child] = true;
				}
			}
			
		}
		
		// answer 오름차순 정렬
		Collections.sort(answer);
		
		// answer가 비어있으면 -1 출력, 아니면 내용물들 출력
		if(answer.size() == 0) {
			output.append(-1);
		} else {
			for(int i=0; i<answer.size(); i++) {
				output.append(answer.get(i)).append("\n");
			}
			answer.toArray();
		}
		
		System.out.println(output);
		
		
	}
	
	public static class Point{
		int n, k;
		
		Point(int n, int k) {
			this.n = n;
			this.k = k;
		}
		
		
		@Override
		public String toString() {
			
			return "n: " + n + " : "+ "k: " +k;
		}
	}

	public static void makeGraph() throws Exception{
		
		graph = new List[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a].add(b);
		}
		
	}

}
