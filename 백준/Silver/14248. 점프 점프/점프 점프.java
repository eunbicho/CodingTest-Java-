

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, start, ans;
	static int[] stones;
	static boolean[] visited;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(input.readLine());
		
		stones = new int[n];
		visited = new boolean[n];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<n; i++) {
			stones[i] = Integer.parseInt(tokens.nextToken());
		} // 입력
		start = Integer.parseInt(input.readLine());
		
		dfs(start-1);
		System.out.println(ans);
		
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		ans++;
		
		// 오른쪽으로 가보기
		int idx = cur + stones[cur];
		if(idx < n) {
			if(!visited[idx])
				dfs(idx);
		}
			
		
		// 왼쪽으로 가보기
		int idx2 = cur - stones[cur];
		if(idx2 >= 0) {
			if(!visited[idx2])
				dfs(idx2);
		}
			
	}

}
