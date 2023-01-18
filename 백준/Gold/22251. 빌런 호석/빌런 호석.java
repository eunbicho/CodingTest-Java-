import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, P, X, ans;
	// 0~9까지 각 숫자에 대한 상태값 저장 
	static int[] hc = {4, 55, 66, 18, 49, 24, 8, 54, 0, 16};
	static int[] z1 =  new int[6];
	static int[] z2 = new int[6];
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 1~N층까지 이용 가능
		K = Integer.parseInt(tokens.nextToken()); // 최대 자리수
		P = Integer.parseInt(tokens.nextToken()); // 최대 반전시킬 개수
		X = Integer.parseInt(tokens.nextToken()); // 엘리베이터가 멈춰있는 실제층
		
		// 현재 층수 정보 채우기
		for(int i=0; i<6; i++) {
			z1[i] = X % 10; 
			X /= 10;
		}
		
		for(int floor=1; floor<=N; floor++) { // 1층부터 N층까지 확인
			int cur = floor;
			int t=0; // 반전시킬 수 있는 개수 합 저장 변수
			
			for(int i=0; i<6; i++){ // 최대 자릿수는 6자리
				
				// bitCount : 주어진 정수를 이진수로 바꿨을 때 1의 개수합을 반환
				// hc[z1[i]]^hc[z2[i]] : 두 비트의 상태가 다를 때, xor값은 1이 됨
				// => hc[z1[i]에서 hc[z2[i]]로 변할 때 1의 개수를 세주면 뒤집어야하는 세그먼트 요소의 개수 구하기 가능!
				
				z2[i] = cur % 10;
				cur /= 10;
				t += Integer.bitCount(hc[z1[i]]^hc[z2[i]]); 
			}
			
			if(t<=P) { // 반전개수가 최대 반전시킬 수 있는 P개 이하를 만족한다면
				ans++; // 경우의 수 1 증가 시키기
			}
		
		}
		
		System.out.println(ans-1);

	}

}
