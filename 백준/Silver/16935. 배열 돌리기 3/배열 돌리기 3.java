import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(input.readLine());
		for(int r=0; r<R;r++) {
			int order = Integer.parseInt(tokens.nextToken());
			switch(order) {
			case 1:
				calculate1();
				break;
				
			case 2:
				calculate2();
				break;
				
			case 3:
				calculate3();
				break;
				
			case 4:
				calculate4();
				break;
				
			case 5:
				calculate5();
				break;
		
			case 6:
				calculate6();
				break;
				
			}
			
		}
		
		// 출력
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		

	}
	
	// 상하반전
	private static void calculate1() {
		for(int i=0; i<N/2; i++) { 
			int[] temp = new int[M];

			// temp에 한줄을 담아놓고
			for(int c=0; c<M; c++) {
				temp[c] = map[i][c];
			}
			
			// 그 줄에 반전시킬 배열을 담는다 
			for(int c=0; c<M; c++) {
				map[i][c] = map[N-(i+1)][c];
			}
			
			// 반대부분에 temp를 담는다
			for(int c=0; c<M; c++) {
				map[N-(i+1)][c] = temp[c];
			}
			
		}
		
//		// 확인용 코드
//		for(int [] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("1");
		
	}
	
	// 좌우반전
	private static void calculate2() {
		for(int i=0; i<M/2; i++) { 
			int[] temp = new int[N];

			// temp에 한줄을 담아놓고
			for(int r=0; r<N; r++) {
				temp[r] = map[r][i];
			}
			
			// 그 줄에 반전시킬 배열을 담는다 
			for(int r=0; r<N; r++) {
				map[r][i] = map[r][M-(i+1)];
			}
			
			// 반대부분에 temp를 담는다
			for(int r=0; r<N; r++) {
				map[r][M-(i+1)] = temp[r];
			}
			
		}
		
		
//		// 확인용 코드
//		for(int [] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("2");
		
		
	}
	
	// 오른쪽으로 90도 회전
	private static void calculate3() {
		
		// 돌아갈 새로운 배열 생성
		int[][] new_map = new int[M][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				new_map[c][(N-1)-r] = map[r][c];
			}
		}
		
		// map이 new_map을 가리키게 하기
		map = new_map;
		
		int temp = M;
		M = N;
		N = temp;
		
//		// 확인용 코드
//		for(int [] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		
//		System.out.println("3");
		
	}
	
	// 왼쪽으로 90도 회전
	private static void calculate4() {
		// 돌아갈 새로운 배열 생성
		int[][] new_map = new int[M][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				new_map[(M-1)-c][r] = map[r][c];
			}
		}
		
		// map이 new_map을 가리키게 하기
		map = new_map;
		
		int temp = M;
		M = N;
		N = temp;
		
//		// 확인용 코드
//		for(int [] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		
//		System.out.println("4");
		
	}
	
	// 그룹을 시계방향으로 회전
	private static void calculate5() {
		// 돌아갈 새로운 배열 생성
		int[][] new_map = new int[N][M];
		
		// 1) 1->2
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<M/2; c++) {
				new_map[r][c+(M/2)] = map[r][c];
			}
		}
		
		// 2) 2->3
		for(int r=0; r<N/2; r++) {
			for(int c=M/2; c<M; c++) {
				new_map[r+(N/2)][c] = map[r][c];
			}
		}
		
		// 3) 3->4
		for(int r=N/2; r<N; r++) {
			for(int c=M/2; c<M; c++) {
				new_map[r][c-(M/2)] = map[r][c];
			}
		}
		
		// 4) 4->1
		for(int r=N/2; r<N; r++) {
			for(int c=0; c<M/2; c++) {
				new_map[r-(N/2)][c] = map[r][c];
			}
		}
		
		// map이 new_map을 가리키게 하기
		map = new_map;
		
//		// 확인용 코드
//		for(int [] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		
//		System.out.println("5");
		
	}
	
	// 그룹을 반시계방향으로 회전
	private static void calculate6() {
		// 돌아갈 새로운 배열 생성
		int[][] new_map = new int[N][M];
		
		// 1) 1->4
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<M/2; c++) {
				new_map[r+(N/2)][c] = map[r][c];
			}
		}
		
		// 2) 4->3
		for(int r=N/2; r<N; r++) {
			for(int c=0; c<M/2; c++) {
				new_map[r][c+(M/2)] = map[r][c];
			}
		}
		
		// 3) 3->2
		for(int r=N/2; r<N; r++) {
			for(int c=M/2; c<M; c++) {
				new_map[r-(N/2)][c] = map[r][c];
			}
		}
		
		// 4) 2->1
		for(int r=0; r<N/2; r++) {
			for(int c=M/2; c<M; c++) {
				new_map[r][c-(M/2)] = map[r][c];
			}
		}
		
		// map이 new_map을 가리키게 하기
		map = new_map;
		
//		// 확인용 코드
//		for(int [] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
//		
//		System.out.println("6");
		
	}
	
	

}
