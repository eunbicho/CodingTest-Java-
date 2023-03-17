import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int c1, c2, p1, p2;
		

		c1= scan.nextInt();
		p1= scan.nextInt();
		c2= scan.nextInt();
		p2= scan.nextInt();
		

		c1=c1*p2+c2*p1;
		p1=p1*p2;
		int gcd= getGcd(c1, p1);
		
		System.out.println(c1/gcd+" "+p1/gcd);
	}//main
	
	public static int getGcd(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGcd(b, a%b);
	}
}