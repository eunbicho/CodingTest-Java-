import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		if(N >= 90 && N <=100) {
			System.out.println("A");
		} else if(N>=80 && N<=89) {
			System.out.println("B");
		} else if(N>=70 && N<=79) {
			System.out.println("C");
		} else if(N>=60 && N<=69) {
			System.out.println("D");
		} else {
			System.out.println("F");
		} 

	}

}
