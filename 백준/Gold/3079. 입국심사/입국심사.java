import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long M;
	static int[] time;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws Exception{
		
//		    a(7)  b(10)
//		0    1       2
//		1    1       2
//		2    1       2
//		3    1       2
//		4    1       2
//		5    1       2
//		6    1       2
//		7    3       2
//		8    3       2
//		9    3       2
//		10   3       4
//		11   3       4
//		12   3       4
//		13   3       4
//		14   5       4
//		15   5       4
//		16   5       4
//		17   5       4
//		18   5       4
//		19   5       4
//		20   5       -
//		21   6
//		22   6
//		23   6
//		24   6
//		25   6
//		26   6
//		27   6
// 		28   완료
		
		
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Long.parseLong(tokens.nextToken());
		
		time = new int[N];
		int longestTime = 0;
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(input.readLine());
			longestTime = Math.max(longestTime, time[i]);
		}
		
		long left = 0L;
		long right = (longestTime)*1000000000L;
		long ans = 0L;
		
        while (left<= right){
            long mid = (left+right) / 2;
            
            long cnt = 0;
            for(int i=0;i<N;i++){
                cnt += (mid / time[i]);

            }
            
            if(cnt >= M){
                ans = mid;
                right = mid-1;
            }  else if (cnt < M){
                left = mid +1;

            }
        }

        System.out.println(ans);
		
		

	}

}
