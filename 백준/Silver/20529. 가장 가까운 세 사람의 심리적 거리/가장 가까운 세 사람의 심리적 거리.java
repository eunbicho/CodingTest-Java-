import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

   static int T, N, ans;
   static String[] s;
   static int[] idx;
   
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer tokens;
   static StringBuilder output = new StringBuilder();
   
   public static void main(String[] args) throws Exception{
      
      T = Integer.parseInt(input.readLine());
      for(int t=0; t<T; t++) {
     	 ans = Integer.MAX_VALUE;
    	 N = Integer.parseInt(input.readLine());
         tokens = new StringTokenizer(input.readLine());
         s = new String[N]; // s에 mbti 저장
         idx = new int[N];
         for(int i=0; i<N; i++) {
            idx[i] = i;
         }
         for(int i=0; i<N; i++) {
            s[i] = tokens.nextToken();         
         }
         
         if(N>=3 && N<=32) {
        	 comb(0, new int[3], 0);
         }
         else {
        	 ans = 0;
         }
         
         output.append(ans).append("\n");
         
      }
      System.out.println(output);

   }
   
   private static void comb(int nth, int[] choosed, int startIdx) {
      if(nth == choosed.length) {
         //System.out.println(Arrays.toString(choosed));
         // choosed에 있는 값을 인덱스로 해서 s에 있는 세 학생의 심리적 거리를 계산하고, 최솟값 갱신
         // 심리적 거리 = (0, 1), (0, 2), (1, 2) 더한 값
         
         int idx1 = choosed[0];
         int idx2 = choosed[1];
         int idx3 = choosed[2];
         int dis = cal(s[idx1], s[idx2])+cal(s[idx1], s[idx3])+cal(s[idx2], s[idx3]);
         
         ans = Math.min(ans, dis);
         return;
      }
      
      for(int i=startIdx; i < s.length; i++) {
         choosed[nth] = idx[i];
         comb(nth+1, choosed, i+1);
      }
      
   }

   // 심리적 거리 계산 함수
   public static int cal(String s1, String s2) {
      int cnt = 0;
	  // 다른 알파벳의 개수 반환
	  for(int i=0; i<4; i++) {
		  if(s1.charAt(i) != s2.charAt(i)) {
			  cnt++;
		  }
	  }
      return cnt;
   }

}