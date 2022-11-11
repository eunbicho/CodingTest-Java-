import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int n=0; n<commands.length; n++){
            int[] row = commands[n];
            int i = row[0];
            int j = row[1];
            int k = row[2];
            

            // temp에는 i, j에 따라 자른 애들 담기
            int[] temp = new int[j-i+1];
            for(int m=0, start=i-1; m<temp.length; m++, start++){
                temp[m] = array[start];
            }
            // 정렬
            Arrays.sort(temp);
            answer[n] = temp[k-1];
        }
        
        
        return answer;
    }
}