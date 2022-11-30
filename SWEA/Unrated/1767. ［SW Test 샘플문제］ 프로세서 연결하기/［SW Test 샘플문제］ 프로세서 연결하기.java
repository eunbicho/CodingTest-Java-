
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {

	static int T, N, maxCore, ans;
	static int[][] map;
	
	// 사방탐색
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	// 가장자리 제외 연결하려는 core만 관리하는 리스트
	static List<Point> coreList = new ArrayList<>();
	
	// 입출력
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			
			coreList.clear();
			maxCore = Integer.MIN_VALUE;
			ans = Integer.MAX_VALUE;
			
			// map 구성
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					// core이면서 경계선에 없는 것들을 coreList에 담기
					if(map[r][c] == 1 && r!=0 && c!=0 && r!=N-1&& c!=N-1) { 
						coreList.add(new Point(r, c));
						map[r][c] = map[r][c];
					}
				}
			} // 입력
			
			dfs(0, 0);
	
			output.append(String.format("#%d %d%n", t, ans));
		}
		System.out.println(output);

	}
	
	private static void dfs(int idx, int cnt) { // cnt는 코어의 개수
		
		// 더 따질 필요가 없는 경우 종료
		// 아직 따지지 않은 코어(5)+현재까지 연결된 코어(2) < maxCore(8)
		if(coreList.size()-idx+cnt<maxCore) return;
		
		// 기저조건
		// idx가 coreList에 있는 전체를 다 따진 경우
		if(idx == coreList.size()) {
			// complete code
			// maxCore와 cnt 비교, 전선의 길이를 고려해서 ans 갱신
			int len = cal(); // 현재 시점에 놓여진 전선의 길이 계산
			
			// 최대 최소 따지기
			if(maxCore < cnt) {
				maxCore = cnt;
				ans = len;
			} else if(maxCore == cnt) {
				ans = Math.min(ans, len);
			}
			return;
		}
		
		// 현재 idx의 좌표 구해서 (r, c)
		// 현재 좌표에서 놓을 수 있는 전선을 연결해보기 
		// (4방 모두 가능한지 확인하고 가능하면 전선 놓고 다음 코어로 dfs연결 계속하기)
		
		Point cur = coreList.get(idx);
		int r = cur.r;
		int c = cur.c;
		
		for(int d=0; d<deltas.length; d++) {
			// 전선을 깔 수 있는지 확인
			if(isOk(r, c, d)) {
				setLine(r, c, d, 2); // 전선을 놓는다!
				dfs(idx+1, cnt+1);
				setLine(r, c, d, 0); // 전선을 지운다!
			}
		}
		
		// 현재 코어를 연결하지 않고 계속 진행
		dfs(idx+1, cnt);
		
		
	}

	// 전선을 놓고 회수하는 메서드
	private static void setLine(int r, int c, int d, int s) {
		int nr = r;
		int nc = c;
		while(true) {
			nr = nr + deltas[d][0];
			nc = nc + deltas[d][1];
			if(nr <0 || nc <0 || nr >= N || nc >= N) break;
			map[nr][nc] = s;
		}
		
		
	}

	// 전선을 끝까지 놓을 수 있는지 확인
	private static boolean isOk(int r, int c, int d) {
		int nr = r;
		int nc = c;
		while(true) {
			nr = nr + deltas[d][0];
			nc = nc + deltas[d][1];
			if(nr <0 || nc <0 || nr >= N || nc >= N) break;
			if(map[nr][nc] >=1 ) return false; // 실패
		}
		return true;
	}

	private static int cal() {
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 2) cnt++;
			}
		}
		return cnt;
		
	}

	public static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}

}
