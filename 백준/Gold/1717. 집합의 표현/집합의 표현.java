import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] root;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		
		root = new int[n+1];
		
		for(int i=0; i<n+1; i++) {
			root[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(input.readLine());
			int op = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			if(op == 1)
				isUnion(a, b);
			else if(op == 0)
				union(a, b);
			
		}
		System.out.println(output);

	}

	

	// output 갱신하는 함수
	private static void isUnion(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) {
			output.append("YES\n");
			return;
		}
			
		
		output.append("NO\n");
		
		
	}
	
	public static int find(int x) {
		if(x == root[x])
			return x;
		
		return root[x] = find(root[x]);
	}
	
	// b의 부모를 a의 부모로 치환하는 연산
	private static void union(int a, int b) {
		a = find(a); // a의 부모 찾기
		b = find(b); // b의 부모 찾기
		
		if(a != b) {
			if(a < b) {
				root[b] = a;
			} else {
				root[a] = b;
			}
		}
		
	}
	


}
