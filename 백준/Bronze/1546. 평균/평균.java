
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int MAX = Integer.MIN_VALUE;
	static double[] list;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		list = new double[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(tokens.nextToken());
			list[i] = n;
			MAX = Math.max(MAX, n);
		} // 입력 받으면서 최댓값 찾기
	
		
		// 점수 고치면서 합계 구하기
		double sum = 0;
		for(int i=0; i<N; i++) {
			list[i] = (list[i]/MAX)*100;
			
			sum += list[i];
			
		}
		
		// 새로운 평균 출력
		System.out.println(sum/N);

	}

}
