
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   static int N, start, end, mid;
   static int[] nums;
   static List<Integer> D = new ArrayList<>();

   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer tokens;

   public static void main(String[] args) throws Exception{
      N = Integer.parseInt(input.readLine());
      tokens = new StringTokenizer(input.readLine());
      
      nums = new int[N];
      for(int i=N-1; i>=0; i--) {
         nums[i] = Integer.parseInt(tokens.nextToken());
      }
      

      for(int num : nums)  {
        if (D.size() == 0 || D.get(D.size() - 1) < num) {
          D.add(num);
        } else {
           int idx = binary_search(D, num);
           D.set(idx, num);
          
        }
      }
      
      System.out.println(N-D.size());

   }

   public static int binary_search(List<Integer> arr, int val) {
        int idx = 0;
	   	start = 0;
        end = arr.size() - 1;
        
        while (start <= end) {
          mid = (start + end) / 2;
          
          if (arr.get(mid) >= val) {
            end = mid - 1;
            idx = mid;
          } else {
            start = mid + 1;
          }
        }
        
        return idx;
      }

      

}
