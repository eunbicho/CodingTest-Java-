
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int[] counts = {5, 5, 5, 5, 5}; // 1,2,3,4,5칸 색종이 
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		map = new int[10][10];
		for(int r=0; r<10; r++) {
			tokens = new StringTokenizer(input.readLine());			
			for(int c=0; c<10; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력
		
		dfs(0, 0, 0);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		

	}

	private static void dfs(int r, int c, int count) {
		if(r == 9 && c > 9) {
			ans = Math.min(ans, count);
			return;
		}
		
		if(count >= ans) return;
		
		if(c>9) {
			dfs(r+1, 0, count);
			return;
		}
		
		if(map[r][c] == 1) {
			for(int size=4; size>=0; size--) { 
				if(counts[size]>0 && isOk(r, c, size+1)) { // 0번부터 사이즈 1, 1번은 2니까 1 더한게 크기
					attach(r, c, size+1);
					counts[size]--;
					dfs(r, c+1, count+1);
					detach(r, c, size+1);
					counts[size]++;
				}
			}
		} else
			dfs(r, c+1, count);
	}
	
	// 색종이 붙이는 함수
	public static void attach(int r, int c, int size) {
		for(int i=r; i < r+size; i++) {
			for(int j=c; j<c+size; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	// 색종이 떼는 함수
	public static void detach(int r, int c, int size) {
		for(int i=r; i < r+size; i++) {
			for(int j=c; j<c+size; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	public static boolean isOk(int r, int c, int size) {
		for(int i=r; i < r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(!isIn(i, j) || map[i][j]!=1)
					return false;
			}
		}
		return true;
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<10 && c<10;
	}

}
