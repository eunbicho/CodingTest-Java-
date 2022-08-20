import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, K;
	static int[] check;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		check = new int[100001]; // 위치할 수 있는 범위
		if(N==K) {
			System.out.println("0");
			return;
		}
		BFS(N, K);
		System.out.println(check[K]);

	}

	private static void BFS(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		check[n] = 0;
		queue.offer(n);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(check[k]!=0) break;
			
			if(x+1<check.length && check[x+1]==0) {
				check[x+1] = check[x]+1;
				queue.offer(x+1);
			}
			
			if((x-1>=0) && check[x-1]==0) {
				queue.offer(x-1);
				check[x-1] = check[x]+1; // 이동할 수 있는 경우
			}
			
			
			if((x*2<check.length)&&check[2*x]==0) {
				queue.offer(2*x);
				check[2*x] = check[x]+1;
			}
		}
		
	}

}
