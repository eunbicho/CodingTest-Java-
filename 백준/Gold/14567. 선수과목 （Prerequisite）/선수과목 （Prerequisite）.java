import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N];
		Arrays.fill(arr, 1);
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			
			pq.offer(new Point(A, B));
			
		}
		
		while(!pq.isEmpty()) {
			Point head = pq.poll();

			int a = head.a;
			int b = head.b;
			
			if(arr[b-1] < arr[a-1]+1) {				
				arr[b-1] = arr[a-1]+1;
			}
		}
		
		for(int num : arr) {
			output.append(num+" ");
		}

		System.out.println(output);
	}
	
	public static class Point implements Comparable<Point>{
		int a, b;

		public Point(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Point o) {
			
			return this.a-o.a;
		}

		@Override
		public String toString() {
			return "Point [a=" + a + ", b=" + b + "]";
		}
		
		
		
	}

}
