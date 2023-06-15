import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{

	static int N, ans;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[] src = {0, 1, 2, 3}; // 상하좌우
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력받기
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		// 중복 순열 이용하기
		dup_perm(0, new int[5]);
		
		// 정답 출력
		System.out.println(ans);
		

	}

	private static void dup_perm(int nth, int[] choosed) {
		if(nth == choosed.length) {
//			System.out.println(Arrays.toString(choosed));
			
			// 이 순서대로 방향을 이동시켰을 때, 가장 큰 블록 수 갱신하기
			int max = move(choosed);
			ans = Math.max(ans, max);
			
			return;
		}
		
		for(int i=0; i<src.length; i++) {
			choosed[nth] = src[i];
			dup_perm(nth+1, choosed);
		}
	}

	// 방향 순서대로 이동시켰을 때, 가장 큰 블록 수 리턴하기
	private static int move(int[] choosed) {
		
		// 임시 맵 temp 만들기
		int[][] temp = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				temp[r][c] = map[r][c];
			}
		}
		
		// 한 방향씩 움직이면서 temp 변화시키기
		for(int i=0; i<choosed.length; i++) {
			int d = choosed[i]; // 움직일 방향 (0:상, 1:하, 2:좌, 3:우)
			switch(d) {
			
				case 0:
					for(int c=0; c<N; c++) {
						Deque<Integer> deque = new ArrayDeque<>();
						boolean canCombine = true;
						for(int r=0; r<N; r++) {
							if(r == 0 && temp[r][c] !=0) { // 첫번째 원소 먼저 넣기
								deque.add(temp[r][c]);
								continue;
							}
							// 덱에 있는 마지막 원소 꺼내서 비교
							if(!deque.isEmpty() && deque.getLast() == temp[r][c]) {
								if(canCombine) { // 합칠 수 있을 때
									// 같으면 마지막 원소 빼서 두배하고 넣기
									deque.add(deque.pollLast()*2);
									canCombine = false;
								}
								else {
									if(temp[r][c] != 0) {
										deque.add(temp[r][c]);
									}
									canCombine = true;
								}
								
								
							// 마지막 원소랑 다르면 
							} else {
								
								if(temp[r][c] != 0) {
									deque.add(temp[r][c]);
									canCombine = true;
								}
								
							}
							
						}
						// 덱에 있는 원소들 순서대로 꺼내서 재배치
						for(int r=0; r<N; r++) {
							if(deque.peek() != null) {
								temp[r][c] = deque.poll();
							} else {
								deque.poll();
								temp[r][c] = 0;
							}
						}
						
					}
//					System.out.println("////위로 이동/////");
//					for(int[] row : temp) {
//						System.out.println(Arrays.toString(row));
//					}
					
					break;
					
				case 1:
					for(int c=0; c<N; c++) {
						Deque<Integer> deque = new ArrayDeque<>();
						boolean canCombine = true;
						for(int r=N-1; r>=0; r--) {
							if(r == N-1 && temp[r][c] != 0) { // 첫번째 원소 먼저 넣기
								deque.add(temp[r][c]);
								continue;
							}
							// 덱에 있는 마지막 원소 꺼내서 비교
							if(!deque.isEmpty() && deque.getLast() == temp[r][c]) {
								if(canCombine) { // 합칠 수 있을 때
									// 같으면 마지막 원소 빼서 두배하고 넣기
									deque.add(deque.pollLast()*2);
									canCombine = false;
								}
								else {
									if(temp[r][c] != 0) {
										deque.add(temp[r][c]);
									}
									
									canCombine = true;
								}
								
								
							// 마지막 원소랑 다르면 
							} else {
								if(temp[r][c] != 0) {
									deque.add(temp[r][c]);
									canCombine = true;
								}
								
							}
							
						}
						// 덱에 있는 원소들 순서대로 꺼내서 재배치
						for(int r=N-1; r>=0; r--) {
							if(deque.peek() != null) {
								temp[r][c] = deque.poll();
							} else {
								deque.poll();
								temp[r][c] = 0;
							}
						}
						
					}
//					System.out.println("////아래로 이동/////");
//					for(int[] row : temp) {
//						System.out.println(Arrays.toString(row));
//					}
					break;
					
				case 2:
					for(int r=0; r<N; r++) {
						Deque<Integer> deque = new ArrayDeque<>();
						boolean canCombine = true;
						for(int c=0; c<N; c++) {
							if(c == 0 && temp[r][c] != 0) { // 첫번째 원소 먼저 넣기
								deque.add(temp[r][c]);
								continue;
							}
							// 덱에 있는 마지막 원소 꺼내서 비교
							if(!deque.isEmpty() && deque.getLast() == temp[r][c]) {
								if(canCombine) { // 합칠 수 있을 때
									// 같으면 마지막 원소 빼서 두배하고 넣기
									deque.add(deque.pollLast()*2);
									canCombine = false;
								}
								else {
									if(temp[r][c] != 0) {
										deque.add(temp[r][c]);
									}
									
									canCombine = true;
								}
								
								
							// 마지막 원소랑 다르면 
							} else {
								if(temp[r][c] != 0) {
									deque.add(temp[r][c]);
									canCombine = true;
								}
								
							}
							
						}
						// 덱에 있는 원소들 순서대로 꺼내서 재배치
						for(int c=0; c<N; c++) {
							if(deque.peek() != null) {
								temp[r][c] = deque.poll();
							} else {
								deque.poll();
								temp[r][c] = 0;
							}
						}
						
					}
//					System.out.println("////왼쪽으로 이동/////");
//					for(int[] row : temp) {
//						System.out.println(Arrays.toString(row));
//					}
					break;
					
				case 3:
					for(int r=0; r<N; r++) {
						Deque<Integer> deque = new ArrayDeque<>();
						boolean canCombine = true;
						for(int c=N-1; c>=0; c--) {
							if(c == N-1 && temp[r][c] != 0) { // 첫번째 원소 먼저 넣기
								deque.add(temp[r][c]);
								continue;
							}
							// 덱에 있는 마지막 원소 꺼내서 비교
							if(!deque.isEmpty() && deque.getLast() == temp[r][c]) {
								if(canCombine) { // 합칠 수 있을 때
									// 같으면 마지막 원소 빼서 두배하고 넣기
									deque.add(deque.pollLast()*2);
									canCombine = false;
								}
								else {
									if(temp[r][c] != 0) {
										deque.add(temp[r][c]);
									}
									canCombine = true;
								}
								
								
							// 마지막 원소랑 다르면 
							} else {
								if(temp[r][c] != 0) {
									deque.add(temp[r][c]);
									canCombine = true;
								}
								
							}
							
						}
						// 덱에 있는 원소들 순서대로 꺼내서 재배치
						for(int c=N-1; c>=0; c--) {
							if(deque.peek() != null) {
								temp[r][c] = deque.poll();
							} else {
								deque.poll();
								temp[r][c] = 0;
							}
						}
						
					}
//					System.out.println("////오른쪽으로 이동/////");
//					for(int[] row : temp) {
//						System.out.println(Arrays.toString(row));
//					}
					break;
				
			}
			
		}
		
		// temp에서 가장 큰 블록 리턴시키기
//		System.out.println("////5번 끝남!/////");
//		for(int[] row : temp) {
//			System.out.println(Arrays.toString(row));
//		}
		
		int max_value = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				max_value = Math.max(max_value, temp[r][c]);
			}
		}
		
		
		return max_value;
	}

	

}
