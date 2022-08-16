import java.util.Scanner;

public class Main {

	static int N, cnt, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if(N % 5 == 0) {
			answer = N / 5;
		} else {
			while(N>=0) {
				N-=3;
				cnt++;
				if(N % 5 == 0) {
					answer = cnt + (N / 5);
					break;
				}
				if(N<0)
					answer = -1;
			}
			
		}
		
		System.out.println(answer);
	}

}
