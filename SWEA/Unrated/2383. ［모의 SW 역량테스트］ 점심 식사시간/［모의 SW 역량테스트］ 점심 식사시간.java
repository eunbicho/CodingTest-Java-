

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, ans;
	static int[][] map;
	static List<Person> people = new ArrayList<>();
	static List<Stair> stairs = new ArrayList<>();
	
	static List<Person> onStair1 = new ArrayList<>();
	static List<Person> waiting1 = new ArrayList<>();
	
	static List<Person> onStair2 = new ArrayList<>();
	static List<Person> waiting2 = new ArrayList<>();
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c] == 1) { // 사람 위치 저장
						people.add(new Person(r, c));
					} else if(map[r][c] >= 2) { // 계단 위치 저장
						stairs.add(new Stair(r, c, map[r][c]));
					}
				}
			} // 입력
			
			ans = Integer.MAX_VALUE;
			// 사람들을 두 그룹으로 나누는 경우의 수 (1번 계단, 2번 계단)
			// = 최대 2^10가지? 부분집합 이용하기
			subset(0, new boolean[people.size()]);
			
			output.append(String.format("#%d %d%n", t, ans));
			
			// 리스트 초기화, 정답 초기화
			people.clear();
			stairs.clear();
			onStair1.clear();
			onStair2.clear();
			waiting1.clear();
			waiting2.clear();
			
			
		} // tc
		
		System.out.println(output);

	}
	
	public static void subset(int toCheck, boolean[] checked) {
		if(toCheck == checked.length) {
			//System.out.println(Arrays.toString(checked));
			
			List<Person> temp = new ArrayList<>();
			for(Person p : people) {
				temp.add(p);
			}
		
			
			// true -> 1번 계단, false -> 2번 계단으로 나누기
			for(int i=0; i<checked.length; i++) {
				if(checked[i] == true) {
					temp.get(i).toStair = calDis(temp.get(i).r, temp.get(i).c, stairs.get(0).r, stairs.get(0).c);
					temp.get(i).stairNum = 1;
					temp.get(i).walk = stairs.get(0).k;
				} else {
					temp.get(i).toStair = calDis(temp.get(i).r, temp.get(i).c, stairs.get(1).r, stairs.get(1).c);
					temp.get(i).stairNum = 2;
					temp.get(i).walk = stairs.get(1).k;
				}
			}

			// 한 사람당 이동 시간 = 계단까지 이동 거리 +1 + 계단거리 
			
			// 매 분마다 다음 항목들 확인
			
			// 0. (onStage 사이즈가 3미만이면) waiting에 있는 사람들을 올릴 수 있을 때까지 onStair에 올리고 waiting에서 삭제
			// 1. 각 사람마다 계단 도착 시간+1 분이 되면 리스트에 추가하는 작업 진행 
			//         (onStage 사이즈가 3미만일 때만) onStair 리스트에 추가, 
			//         (onStage가 3이면) waiting 리스트에 사람 추가 
			// 2. onStair에 있는 애들 계단 하나씩 내려가게 하기
			// 3. 한 사람이 계단을 모두 내려갔으면 사람리스트, 계단 대기 리스트에서 삭제
			
			int time = 0;
			while(!temp.isEmpty()) {
				time++;
				//System.out.println(time);
				
				// step 0: 1번, 2번 계단 대기열에 사람이 있다면 onStair에 올릴 수 있을 때까지 올리고 waiting에서 삭제
				if(!waiting1.isEmpty()) {
					// onStair1번에 자리가 있을 때
					while(onStair1.size()<3 && !waiting1.isEmpty()) {
						onStair1.add(waiting1.get(0));
						waiting1.remove(0);
					}
				}
				
				if(!waiting2.isEmpty()) {
					// onStair2번에 자리가 있을 때
					while(onStair2.size()<3 && !waiting2.isEmpty()) {
						onStair2.add(waiting2.get(0));
						waiting2.remove(0);
					}
				}
				
				// step 1: 각 사람마다 계단 도착 시간+1 분이 되면 리스트에 추가하는 작업 진행
				for(int i=0; i<temp.size(); i++) {
					int stairNum = temp.get(i).stairNum;
					if(temp.get(i).toStair+1 == time) { // 계단 내려가야하는 사람이 있다면
						// (onStair 사이즈가 3미만일 때만) onStair 리스트에 추가, 
						// (onStair가 3이면) waiting 리스트에 사람 추가 
						if(stairNum == 1) { // 선택한 계단이 1번 계단일 경우
							if(onStair1.size()<3) {
								onStair1.add(temp.get(i));
							} else if(onStair1.size() == 3) {
								waiting1.add(temp.get(i));
							}
						} else { // 선택한 계단이 2번 계단일 경우
							if(onStair2.size()<3) {
								onStair2.add(temp.get(i));
							} else if(onStair2.size() == 3) {
								waiting2.add(temp.get(i));
							}
						}
					}
				}
				
				// step 2: onStair에 있는 애들 계단 (시간됐으면) 하나씩 내려가게 하기 -> 시간됐으면: 현재시간이 toStair+1보다 클 때
				for(int i=onStair1.size()-1; i>=0; i--) { // 1번 계단
					if(onStair1.get(i).toStair+1 < time) {						
						onStair1.get(i).walk -= 1;
						if(onStair1.get(i).walk == 0) {
							temp.remove(onStair1.get(i));
							onStair1.remove(i);
						}
					}
				}
				
				for(int i=onStair2.size()-1; i>=0; i--) { // 2번 계단
					if(onStair2.get(i).toStair+1 < time) {
						onStair2.get(i).walk -= 1;
						if(onStair2.get(i).walk == 0) {
							temp.remove(onStair2.get(i));
							onStair2.remove(i);
						}						
					}
				}
				
//				// people 확인
//				System.out.println(temp);
//				// waiting 확인
//				System.out.println("waiting1" + waiting1);
//				System.out.println("waiting2" + waiting2);
//				// onStair 확인
//				System.out.println("onStair1:" + onStair1);
//				System.out.println("onStair2:" + onStair2);
			}
			ans = Math.min(ans, time);
			//System.out.println(ans);
			
			// 변수 초기화
			onStair1.clear();
			onStair2.clear();
			waiting1.clear();
			waiting2.clear();
			
			
			return;
		}
		
		checked[toCheck] = true;
		subset(toCheck+1, checked);
		checked[toCheck] = false;
		subset(toCheck+1, checked);
		
	}
	
	public static int calDis(int r, int c, int r2, int c2) {
		return Math.abs(r-r2) + Math.abs(c-c2);
	}
	
	public static class Person{
		int r, c, stairNum, toStair; // stairNum: 선택한 계단번호 , toStair: 선택한 계단까지의 거리
		int walk = Integer.MAX_VALUE; // 남은 계단 수

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public Person(int toStair) {
			super();
			this.toStair = toStair;
		}

		@Override
		public String toString() {
			return "Person [r=" + r + ", c=" + c + ", stairNum=" + stairNum + ", toStair=" + toStair + ", walk=" + walk
					+ "]";
		}
		
		
		
	}
	
	public static class Stair{
		int r, c, k;

		public Stair(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}

}
