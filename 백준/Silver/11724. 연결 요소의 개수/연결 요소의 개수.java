import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] map;
	static boolean[] check;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
	
		map = new int[N+1][N+1];
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			
			map[u][v] = map[v][u] = 1; // 연결 정보 저장
			
		}
		
		check = new boolean[N+1];
		
		for(int n=1; n<=N; n++) {
			check[n] = false;
		} // 초기화
		
		
		for(int n=1; n<=N; n++) {
			if(!check[n]) { // 체크가 안된 n이면 
				dfs(n); // 연결된 애들을 모두 true로 바꿔주기
				ans++;
			}
		} 
		
		System.out.println(ans);
		
		

	}

	private static void dfs(int n) {
		check[n] = true;
		
		for(int i=1; i<=N; i++) {
			if(map[n][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
		
	}

}
