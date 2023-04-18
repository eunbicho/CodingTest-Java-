import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] burger = new int[3];	// 햄버거 가격을 저장할 배열 생성 
		int[] drink = new int[2];	// 음료수 가격을 저장할 배열 생성
		// 가장 저렴한 햄버거, 음료수를 저장할 변수에 Integer에 가장 큰 값을 지정
		int bm =Integer.MAX_VALUE, dm = Integer.MAX_VALUE; 
		
		for (int i=0; i<3; i++) {	 // 반복문 
			burger[i] = sc.nextInt(); // 햄버거 가격 입력받기 
			
			if(bm > burger[i]) {	// buger가 bm보다 작으면
				bm = burger[i];		// bm은 buger가 됨.
			}
		}
		
		for(int i=0; i<2; i++) {	// 반복문 
			drink[i] = sc.nextInt(); // 음료수 가격 입력받기 

			if(dm > drink[i])		// drink가 dm보다 작으면 
				dm = drink[i];		// dm은 drink가 됨.
		}
		System.out.println(bm + dm - 50);	// 세트 가격 출력
		sc.close();
	}
}