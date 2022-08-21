import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static List[] graph;
	static int[] depths;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken())+1;
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		depths = new int[N];
		Arrays.fill(depths, -1);
		depths[R] = 0;
		
		makeGraphList();
		bfsList();
		
		for(int i=1; i<N; i++) {
			output.append(depths[i]).append('\n');
		}
		
		System.out.println(output);

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
		
	}
	
	static void bfsList() {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N];
		
		q.offer(R);
		visited[R] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-->0) {
				int head = q.poll();
				visited[head] = true;
			
				List<Integer> childs = graph[head];
				

				for(Integer child : childs) {
					if(!visited[child]) {
						visited[child] = true;
						//System.out.println(child);
						depths[child] = depths[head]+1; // 큐에 담을 때  depth값 저장
						q.offer(child);
					}
				}
				
				
			}
		}
		
	}

}
