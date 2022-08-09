import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, cnt; // 붙일 색종이 개수, 겹쳐진 칸의 개수
	//static int [][] nums; // 떨어진 거리 저장 배열
	static int [][] map = new int[100][100]; // 색종이 붙일 영역 배열
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		//nums = new int[N][2];
		
		
		for(int t=0; t<N; t++) {
			tokens = new StringTokenizer(input.readLine());
			int startc = Integer.parseInt(tokens.nextToken());
			int startr = Integer.parseInt(tokens.nextToken());
	
			// r, c가 왼쪽 아래 모서리로 시작되는 크기가 10인 정사각형 붙이기
			for(int r = 100-1-startr-9; r <= 100-1-startr; r++) {
				for(int c = startc; c <= startc+9; c++) {
					
					if(map[r][c] == 1) { // 이미 붙여져있는 영역이라면
						cnt++;
					}else if(map[r][c] == 0) { // 안붙여져있는 영역이라면
						map[r][c] = 1; // 색종이 붙인 영역들은 1로 바꿔주기
					}
					
				}
			}
			
//			for(int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			
		} // 색종이 다 붙였다!
		System.out.println(100*N-cnt);
		
		

	}

}
