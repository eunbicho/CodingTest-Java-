import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt, num; // N, 단지수, 각 단지별 집 수
	static List<Integer> nums = new ArrayList<>();
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			String str = input.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
//		
//		for(int [] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		// 탐색
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==1) {
					dfs(r, c);
					cnt++; // 단지 수 늘리기
					nums.add(num); // num(각 단지의 집 수) 추가하고
					num = 0; // 초기화
				}
			}
		}
		
		Collections.sort(nums); // 오름차순 정렬
		
		// 출력
		output.append(cnt).append('\n');
		for(int i=0; i<nums.size(); i++) {
			output.append(nums.get(i)).append('\n');
		}
		System.out.println(output);
		

	}


	private static void dfs(int r, int c) {
		map[r][c] = 0; // 방문처리
		num++; // 방문처리 한 집 카운트
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr, nc)) {
				if(map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
		
	}


	private static boolean isIn(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<N;
	}

}
