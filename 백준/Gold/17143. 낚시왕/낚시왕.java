

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int R, C, M;
	static int[][] map;
	static List<Shark> sharks = new ArrayList<>();
	static int answer; // 낚시왕이 잡은 상어 크기의 합

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken()) + 1;
		C = Integer.parseInt(tokens.nextToken()) + 1;
		M = Integer.parseInt(tokens.nextToken());

		map = new int[R][C]; // 격자판 만들기

		for (int i = 0; i < M; i++) { // 주어진 상어 정보 리스트에 저장하기
			tokens = new StringTokenizer(input.readLine());

			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int z = Integer.parseInt(tokens.nextToken());

			sharks.add(new Shark(r, c, s, d, z));
			map[r][c] = 1; // 상어가 있는 곳을 지도에 1로 표시

		}

		// C초동안 반복
		for (int i = 1; i < C; i++) {
			// 1. 낚시왕이 오른쪽으로 한 칸 이동 (반복문 돌면서 i번째 열로 이동한 상태)
//			System.out.println("낚시왕 이동 후 상어 잡기 전 상태: " + i + "초");
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			
			// 2. i번째 열에서 가장 가까운 상어가 있으면 잡고 answer에 크기 더하기
			for (int r = 1; r < R; r++) {
				if (map[r][i] == 1) {
					int index = findShark(r, i); // 이 r, i 좌표에 있는 상어 찾기
					answer += sharks.get(index).z; // answer에 크기 더하기
					map[r][i] = 0;
					sharks.remove(index); // 상어 지도에서도 지우기, 리스트에서도 지우기
					break; // 한마리만 잡고 끝내야함
				}
			}

//			System.out.println("상어 잡은 결과");
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}

			// 3. 상어들 이동
//			System.out.println("이동 전 상어들 상태");
//			System.out.println(sharks);
			move();

			//System.out.println(i+"초 후 상어 이동 결과");
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			//System.out.println("상어들 상태");
			//System.out.println(sharks);
		}
		
		System.out.println(answer);

	}

	// 1초동안 상어들 이동하게 만드는 함수
	private static void move() {
		
		// 리스트에 있는 상어들 순서대로 이동시키기
		for(int i=0; i<sharks.size(); i++) {
			sharks.get(i).move();
		}
		//System.out.println("상어 이동 결과");
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		
		// 이동이 끝나고 한 칸에 여러 상어들 겹치는 부분 처리 (지도에 2이상인 부분에 해당하는 상어들 처리)
		for(int r=1; r<R; r++) {
			for(int c=1; c<C; c++) {
				if(map[r][c] >= 2) {
					eatSharks(r, c);
				}
			}
		}

	}

	// 해당 좌표에 있는 상어들 중에 가장 크기가 큰 상어만 남기고 나머지 상어 제거 (sharks에서도 지우고 지도에도 1로 변경)
	private static void eatSharks(int r, int c) {

		List<Shark> dup_sharks = new ArrayList<>(); // 중첩된 상어들

		for (int i = 0; i < sharks.size(); i++) {
			if (sharks.get(i).r == r && sharks.get(i).c == c) { 
				dup_sharks.add(sharks.get(i));
			}
		}
		
		int maxSize = -1;
		int maxIndex = -1;
		for(int i=0; i<dup_sharks.size(); i++) {
			if(dup_sharks.get(i).z > maxSize) {  // 가장 크기가 큰 상어 찾기
				maxSize = dup_sharks.get(i).z;
				maxIndex = i;
			}	
		}
		
		// dup_sharks에서 가장 크기 큰 상어 빼고 나머지 상어들을 sharks에서 제거
		dup_sharks.remove(maxIndex); // 가장 큰 상어 제거하면 dup_sharks에는 나머지 상어들만 남는다 (먹히는 상어들)
		sharks.removeAll(dup_sharks); // sharks에서 dup_sharks과 같은 리스트 값을 제거한다.
		// 2이상의 숫자였던 해당좌표부분 지도를 1로 변경
		map[r][c] = 1;
		dup_sharks.clear();
	}

	// 해당 좌표에 있는 상어를 찾아주는 함수 (sharks의 인덱스 반환)
	private static int findShark(int r, int c) {
		for (int i = 0; i < sharks.size(); i++) {
			if (sharks.get(i).r == r && sharks.get(i).c == c) { // 있으면 해당 인덱스 리턴
				return i;
			}
		}
		return -1; // 없으면 -1 리턴

	}

	public static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d; // 1:위, 2:아래, 3:오른쪽, 4:왼쪽
			this.z = z;
		}
		
		public void move() { // 상어마다 1초동안 움직이는 함수
			
			// 현재 위치를 지도에서 제거(1빼주기)
			map[r][c] -= 1;
			
			
			// 주어진 방향과 속력(이동 칸 수)대로 이동 (단, 이동하다가 벽에 부딪히면 방향 바꿔서 반복)
			for(int i=0; i<s; i++) {
				if(d==1) {
					int nr = this.r-1;
					if(nr > 0) { // 범위 안이면 이동
						//System.out.println(r+","+c + "에서 위로 이동!");
						this.r -=1;
					} else { // 범위 밖이면 방향 바꾸기
						//System.out.println(r+","+c + "에서 방향 전환! 아래로 이동!");
						this.d = 2;
						this.r +=1;
					}
					
				} else if(d==2) {
					int nr = this.r+1;
					if(nr < R) { // 범위 안이면 이동 
						//System.out.println(r+","+c + "에서 아래로 이동!");
						this.r +=1;
					} else { // 범위 밖이면 방향 바꾸기
						//System.out.println(r+","+c + "에서 방향 전환! 위로 이동!");
						this.d = 1;
						this.r -=1;
					}
					
				} else if(d==3) {
					int nc = this.c+1;
					if(nc < C) { // 범위 안이면 이동 
						//System.out.println(r+","+c + "에서 오른쪽으로 이동!");
						this.c +=1;
					} else { // 범위 밖이면 방향 바꾸기
						//System.out.println(r+","+c + "에서 방향 전환! 왼쪽으로 이동!");
						this.d = 4;
						this.c -=1;
					}
					
				} else if(d==4) {
					int nc = this.c-1;
					if(nc > 0) { // 범위 안이면 이동 
						//System.out.println(r+","+c + "에서 왼쪽으로 이동!");
						this.c -=1;
					} else { // 범위 밖이면 방향 바꾸기
						//System.out.println(r+","+c + "에서 방향 전환! 오른쪽으로 이동!");
						this.d = 3;
						this.c +=1;
					}
				}
					
			}
			//System.out.println("하나 이동 끝! 현재 위치: "+r+","+c);
			
			// 이동 끝나면 이동한 위치를 지도에 표시(해당 좌표에 1더하기)
			map[r][c] += 1;
			
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

}
