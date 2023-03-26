class Solution {
    public int[] solution(String s) {
        
        // System.out.println(s.length());
        int[] answer = new int[s.length()]; // 정답 배열 
        
        int[] pos = new int[26]; // 알파벳 별 인덱스 위치를 갱신할 배열
        for(int i=0; i<pos.length; i++){
            pos[i] = -1; // 모두 -1로 초기화
        }
        
        // 알파벳 하나씩 보기
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
           
            // pos배열 값이 -1이라면 (처음 나온 알파벳이면)
            // 정답 배열에 -1 추가하고 현재 인덱스 값으로 갱신!
            if(pos[c-'A'-32] == -1){
                answer[i] = -1;
                pos[c-'A'-32] =i;
                
            // pos배열 값이 -1이 아니라면 (처음 나온 알파벳이 아니면)
            // 정답 배열에 차이를 추가하고 현재 인덱스 값으로 갱신!
            } else { 
                answer[i] = i-pos[c-'A'-32];
                pos[c-'A'-32] = i;
            }
        }
        
        
        return answer;
    }
}