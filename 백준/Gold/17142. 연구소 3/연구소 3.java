import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int emptySpace, answer = Integer.MAX_VALUE;
	static int[][] map;
	
	static List<Virus> list = new ArrayList<>();
	static Virus[] choosedVirus;
	static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	 public static int[] dx = {1, 0, -1, 0};
	    public static int[] dy = {0, 1, 0, -1};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		choosedVirus = new Virus[M];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				
				if(map[i][j] == 0) {
					emptySpace++; // 빈 공간 개수 세기
				} else if(map[i][j] == 2) {
					list.add(new Virus(i, j)); // 바이러스들의 위치 저장
				}
				
			}
		} // 입력 끝
		
		if(emptySpace == 0) { // 빈칸이 없는 경우
			System.out.println(0);
			return;
		}
		
		combination(0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1: answer); 
		// answer가 초기값 그대로이면 모든 빈칸에 바이러스를 퍼뜨릴 수 없는 경우이므로 -1 출력. 아니면 answer 출력 
		
		

	}
	
	private static void combination(int nth, int start) {
		if(nth == M) { // M개를 뽑았으면 바이러스 퍼뜨리기
			spread(emptySpace);
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			choosedVirus[nth] = list.get(i);
			combination(nth+1, i+1);
		}
	}

	private static void spread(int emptySpace) {
		Queue<Virus> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		
		for(Virus v : choosedVirus) {
			q.add(v);
			visit[v.x][v.y] = true;
		}
		
		int time=0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Virus cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
//					System.out.println(nx +" " + ny);
					
					if(!isIn(nx, ny)) // 범위를 넘어서면
						continue;
					if(visit[nx][ny] || map[nx][ny] == 1) // 새로 이동하는 곳이 이미 방문 한 곳이거나 벽이면
						continue;
					
					if(map[nx][ny] == 0) { // 빈칸이면 빈칸수 감소
						emptySpace--;
					}
					
					q.add(new Virus(nx, ny));
					visit[nx][ny] = true;
				}
			}
			
			time++;
			
			if(time >= answer) {
				return;
			}
			
			if(emptySpace <=0) {
				answer = time;
			}
		}
		
	}

	private static boolean isIn(int nx, int ny) {
		
		return nx>=0 && nx<N && ny>=0 && ny<N;
	}

	public static class Virus{
		int x;
		int y;
		
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
