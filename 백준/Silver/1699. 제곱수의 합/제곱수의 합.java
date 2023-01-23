import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, ans;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(input.readLine());
		
		int d[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            d[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (d[i] > d[i - j * j] + 1) {
                    d[i] = d[i - j * j] + 1;
                }
            }
        }
        System.out.println(d[N]);
	}

}



