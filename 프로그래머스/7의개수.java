class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i=0; i<array.length; i++){
            String num = String.valueOf((array[i]));
            for(int j=0; j<num.length(); j++){
                if(num.charAt(j) == '7'){
                    answer++;
                }
            }
        }
        return answer;
    }
}
