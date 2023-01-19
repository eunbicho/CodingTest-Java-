import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

   static int N, C, left, right, dis, ans;
   static int[] houses;

   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer tokens;

   public static void main(String[] args) throws Exception {
      tokens = new StringTokenizer(input.readLine());
      N = Integer.parseInt(tokens.nextToken());
      C = Integer.parseInt(tokens.nextToken());
      houses = new int[N];
      ans = Integer.MIN_VALUE;

      for (int i = 0; i < N; i++) {
         houses[i] = Integer.parseInt(input.readLine());
      }

      Arrays.sort(houses);

      // 간격을 이분탐색!

      left = 1; // 가능한 최소거리
      right = houses[N-1] - houses[0]; // 가능한 최대거리

      while (left <= right) {
         int mid = (left + right) / 2; // 정답 후보
         int start = houses[0]; 
         int cnt = 1; // 공유기 개수(맨 왼쪽집에 하나 설치하고 시작)

         // 간격 dis를 기준으로 공유기 설치
         for (int i = 0; i < N; i++) { // 집집마다 검색
            dis = houses[i] - start; // 간격
            if (dis >= mid) { // 만약 첫번째 집과의 거리가 더 크다면 찾았다고 cnt 올려주고, 내가 찾는집에 이번 집을 넣어준다.
               cnt++;
               start = houses[i];
            }
         }

         if (cnt >= C) {
            // 실제 설치될 공유기보다 많이 설치 -> 공유기 수 줄이기 -> 오른쪽으로 이동해 더 긴 간격 찾기
            ans = mid;
            left = mid + 1;
         } else {
            // 공유기를 C보다 적게 설치 -> 공유기 더 설치해야함 -> 왼쪽으로 이동해 더 짧은 간격 찾기
            right = mid - 1;
         }
      }
      System.out.println(ans);

   }

}