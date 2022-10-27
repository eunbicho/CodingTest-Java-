

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, ans;
	static int[][] map;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력
		
		ans = Integer.MIN_VALUE; // 최댓값 초기
		
		// 1. 네모 모양으로 탐색했을 때 나올 수 있는 최댓값 구하기
		for (int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-2; j++) {
				int area = calArea_square(i, j);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 2. 작대기 모양으로 탐색했을 때 나올 수 있는 최댓값 구하기
		
		// 2-1. 가로 모양일 때 
		for (int i=0; i<=N-1; i++) {
			for(int j=0; j<=M-4; j++) {
				int area = calArea_line(i, j, "w"); // width: 가로 방향 넓이 구하기
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 2-2. 세로 모양일 때
		for (int i=0; i<=N-4; i++) {
			for(int j=0; j<=M-1; j++) {
				int area = calArea_line(i, j, "l"); // length: 세로 방향 넓이 구하기
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 3. 모자 모양으로 탐색했을 때 나올 수 있는 최댓값 구하기
		
		// 3-1. ㅜ모양일 때
		for (int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_hat(i, j, "a");
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 3-2. ㅗ모양일 때
		for (int i=1; i<=N-1; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_hat(i, j, "b");
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 3-3. ㅏ모양일 때
		for (int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-2; j++) {
				int area = calArea_hat(i, j, "c");
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 3-4. ㅓ모양일 때
		for (int i=0; i<=N-3; i++) {
			for(int j=1; j<=M-1; j++) {
				int area = calArea_hat(i, j, "d");
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		
		// 4. 니은 모양으로 탐색했을 때 나올 수 있는 최댓값 구하기
		
		// 4-1. ㄴ모양1
		for (int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-2; j++) {
				int area = calArea_nieun(i, j, 1);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 4-2. ㄴ모양1 뒤집은거
		for (int i=0; i<=N-3; i++) {
			for(int j=1; j<=M-1; j++) {
				int area = calArea_nieun(i, j, 2);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 4-3. ㄱ모양1
		for (int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-2; j++) {
				int area = calArea_nieun(i, j, 3);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 4-4. ㄱ모양1 뒤집은거
		for (int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-2; j++) {
				int area = calArea_nieun(i, j, 4);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 4-5. ㄴ모양2
		for (int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_nieun(i, j, 5);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 4-6. ㄴ모양2 뒤집은거
		for (int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_nieun(i, j, 6);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 4-7. ㄱ모양2
		for (int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_nieun(i, j, 7);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
				
		// 4-8. ㄱ모양2 뒤집은거
		for (int i=1; i<=N-1; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_nieun(i, j, 8);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 5. 꺾인 모양으로 탐색했을 때 나올 수 있는 최댓값 구하기
		
		// 5-1.
		for (int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-2; j++) {
				int area = calArea_last(i, j, 1);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 5-2.
		for (int i=0; i<=N-3; i++) {
			for(int j=1; j<=M-1; j++) {
				int area = calArea_last(i, j, 2);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 5-3.
		for (int i=0; i<=N-2; i++) {
			for(int j=2; j<=M-1; j++) {
				int area = calArea_last(i, j, 3);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		// 5-4.
		for (int i=0; i<=N-2; i++) {
			for(int j=0; j<=M-3; j++) {
				int area = calArea_last(i, j, 4);
				ans = Math.max(ans, area); // ans에 최댓값 갱신
			}
		}
		
		System.out.println(ans);
		

	}

	private static int calArea_last(int i, int j, int cases) {
		
		int area = 0;
		
		switch(cases) {
		case 1:
			area = map[i][j] + map[i+1][j]+map[i+1][j+1]+map[i+2][j+1];
			break;
		case 2:
			area = map[i][j] + map[i+1][j]+map[i+1][j-1]+map[i+2][j-1];
			break;
		case 3:
			area = map[i][j] + map[i][j-1]+map[i+1][j-1]+map[i+1][j-2];
			break;
		case 4:
			area = map[i][j] + map[i][j+1]+map[i+1][j+1]+map[i+1][j+2];
			break;
		
			
		}
		return area;
	}

	private static int calArea_nieun(int i, int j, int cases) {
		
		int area = 0;
		
		switch(cases) {
		case 1:
			area = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+2][j+1];
			break;
		case 2:
			area = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+2][j-1];
			break;
		case 3:
			area = map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+2][j+1];
			break;
		case 4:
			area = map[i][j]+map[i+1][j]+map[i+2][j]+map[i][j+1];
			break;
		case 5:
			area = map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+1][j+2];
			break;
		case 6:
			area = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j];
			break;
		case 7:
			area = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+2];
			break;
		case 8:
			area = map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j+2];
			break;
			
		}
		return area;
	}

	// 모자모양 영역 계산 함수
	private static int calArea_hat(int i, int j, String dir) {
		
		int area = 0;
		
		if(dir.equals("a")) { // ㅜ
			area = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1];
		} else if(dir.equals("b")) { // ㅗ
			area = map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j+1];
		} else if(dir.equals("c")) { // ㅏ
			area = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j+1];
		} else if(dir.equals("d")) { // ㅓ
			area = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j-1];
		}
		
		return area;
	}

	// 작대기 영역 계산 함수
	private static int calArea_line(int i, int j, String dir) {
		int area = 0;
		if(dir.equals("w")) { // 가로 방향이라면
			area = map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3];
		} else if(dir.equals("l")) { // 세로 방향이라면
			area = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j];
		}
		return area;
	}

	// 왼쪽 위 시작 좌표를 넣으면 그 좌표를 기준으로 네모를 만들어 영역 넓이를 반환해준다.
	private static int calArea_square(int i, int j) {
		int area = map[i][j]+map[i][j+1]+map[i+1][j]+map[i+1][j+1];
		return area;
		
	}

}
