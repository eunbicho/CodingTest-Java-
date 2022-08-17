import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] image;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		image = new int[N][N];
		
		for(int r=0; r<N; r++) {
			String str = input.readLine();
			for(int c=0; c<N; c++) {
				image[r][c] = str.charAt(c)-'0';
			}
		} // 입력 끝
		
		Compression(0, 0, N); // 0,0 좌표부터 8x8 안에서 압축 가능한지 탐색 
		System.out.println(output);

	}
	
	public static void Compression(int r, int c, int size) {
		
		//System.out.println(r +" " + c);
		// 압축 가능하면 그 색으로 압축!
		if(isPossible(r, c, size)) {
			output.append(image[r][c]);
			return;
		}
		
		// 압축이 불가능하다면
		int newSize = size/2; // 반으로 나눠서 탐색
		
		output.append('(');
		
		Compression(r, c, newSize); // 왼쪽 위
		Compression(r, c + newSize, newSize); // 오른쪽 위
		Compression(r + newSize, c, newSize); // 왼쪽 아래
		Compression(r + newSize, c + newSize, newSize); // 오른쪽 아래
		
		output.append(')');
		
	}
	
	
	public static boolean isPossible(int r, int c, int size) {
		int color = image[r][c]; // 이 구역의 색 저장
		
		// 이 사이즈 안에 하나라도 다른 값이 있으면 압축 못함
		for(int i = r; i < r+size; i++) {
			for(int j=c; j < c+size; j++) {
				if(color != image[i][j]) {
					return false; // 색이 다른게 하나라도 생기면 false 반환
				}
			}
		}
		
		return true;
	}

}
