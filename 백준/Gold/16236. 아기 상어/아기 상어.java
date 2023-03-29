import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static Shark s;
	static PriorityQueue<Point> eatableFishes = new PriorityQueue<>();
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 9) { // 상어 위치 파악
					s = new Shark(r, c, 2, 0, 0);
				}
			}
		} // 초기화
		
		bfs(new Point(s.r, s.c, 0));
		
		
		// 더 먹을 물고기가 없을 때까지 반복
		while(!eatableFishes.isEmpty()) {
			eat();
			bfs(new Point(s.r, s.c, 0));	
		}
		
		System.out.println(s.time);
		
//		System.out.println(eatableFishes.toString());
//		System.out.println(eatableFishes.poll());
		

	}
	
	
	// 상어 정보 갱신: 크기 갱신, 이동거리(시간) 갱신, 먹은 물고기 수 갱신
	// map 정보 갱신
	private static void eat() {
//		System.out.println("먹기 전");
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//			
//		}
		
		Point fish = eatableFishes.poll(); // 물고기 뽑기
		
		// 1. 현재 자리 0으로 바꾸기
		map[s.r][s.c] = 0;
		
		// 2. 이동할 곳 9로 바꾸고 상어 위치 바꾸기
		map[fish.r][fish.c] = 9;
		s.r = fish.r;
		s.c = fish.c;
		
		// 3. 물고기수+1 하기 (현재 크기랑 같으면, 물고기 수 초기화하고 현재크기+1)
		s.countFish += 1;
		if(s.countFish == s.size) {
			s.countFish = 0;
			s.size += 1;
		}
		
		// 4. shark time에 뽑은 point.d 더해주기
		s.time += fish.d;
		
		// 5. eatable Fish 초기화
		eatableFishes.clear();
		
//		System.out.println("먹은 후");
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//			
//		}
//		System.out.println(s.time);
//		
	}


	private static void bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.add(p);
		visited[p.r][p.c] = true;
		
		while(!q.isEmpty()) {
			Point head = q.poll();
			
			for(int d=0; d<deltas.length; d++) {
				int nr = head.r + deltas[d][0];
				int nc = head.c + deltas[d][1];
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] <= s.size) {
					q.add(new Point(nr, nc, head.d+1));
					visited[nr][nc] = true;
					// 먹을 수 있으면 리스트에 담기
					if(map[nr][nc] < s.size && map[nr][nc] != 0) {
						eatableFishes.add(new Point(nr, nc, head.d+1));
					}
				}
			}
		}
		
	}


	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<N;
	}


	public static class Shark{
		int r, c, size, time, countFish;
		
		public Shark(int r, int c, int size, int time, int countFish) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.time = time;
			this.countFish = countFish;
		}
	}
	
	
	public static class Point implements Comparable<Point>{
		int r, c, d;
		
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
		
		
		@Override
		public String toString() {
			
			return "(r:" + r +" : "+ "c:"+ c +" : "+ "d:"+ d +")";
		}
		
		// 정렬할 때, 상어와 거리가 가장 가까운 순.
				// 거리가 같다면, 가장 위에 있는 물고기.
				// 그것도 같다면 가장 왼쪽에 있는 물고기.

		@Override
		public int compareTo(Point o) {
			if(this.d == o.d) {
				if(this.r == o.r) {
					return this.c-o.c;
				}
				return this.r-o.r;
			} 
			return this.d-o.d;
		}
	
}

}
