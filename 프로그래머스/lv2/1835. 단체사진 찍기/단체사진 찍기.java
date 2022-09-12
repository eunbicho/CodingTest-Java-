import java.util.Arrays;

public class Solution {

	static char[] names = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int totalCnt;
	
	public static int solution(int n, String[] data) {
        int answer = 0;
        
        perm(0, new char[8], new boolean[8], data);
        answer = totalCnt;
        System.out.println(answer);
        totalCnt = 0;
        return answer;
    }
	
	// 조건을 만족하는지 확인해주는 함수
	public static boolean isSatisfied(String[] data, char[] choosed) {
		
		// 한 조건씩 반복
		for(int i=0; i<data.length; i++) {
			char p1 = data[i].charAt(0);
			char p2 = data[i].charAt(2);
			char compare = data[i].charAt(3);
			int interval = data[i].charAt(4)-'0';
//			System.out.println(p1 + " " + p2 + " " + compare + " " + interval + " ");
			
			// p1과 p2 사이 간격 계산 (p1과 p2가 저장된 인덱스 차이 -1)
			int index1 = 0;
			int index2 = 0;
			int count = 0;
			for(int j=0; j<choosed.length; j++)
			{
				if(choosed[j] == p1){
					index1 = j;
					
				} else if(choosed[j] == p2){
					index2 = j;
					
				}	
			}
			count = Math.abs(index1-index2)-1;
			
			// 계산한 간격이 조건에 맞으면 true, 틀리면 false
			// 여기서는 조건에 안 맞는 경우만 체크. for문 다 돌면 true반환하게끔
			if(compare == '<') {
				if(count >= interval) {
					return false;
				}
				
				
			} else if(compare == '>') {
				if(count <= interval) {
					return false;
				}
				
			} else if(compare == '=') {
				if(count != interval) {
//					System.out.println(count +"와" + interval + "은 다릅니다.");
					return false;
				}
				
			}
//			System.out.println(count +"와" + interval);
//			System.out.println(i + "번째 조건 true");
			
		}
		
		// 조건 반복문 다 돌았는데도 false인게 없으면 true 반환
		return true;
	}
	
	
	public static void perm(int nth, char[] choosed, boolean[] isSelected, String[] data) {
		if(nth == choosed.length) {
//			System.out.println(Arrays.toString(choosed));
			
			// 여기서 조건에 맞는지 확인하고 경우의 수 올리기
			if(isSatisfied(data, choosed)) {
				totalCnt++; // 조건이 다 true이면 경우의 수 증가
				return;
			} else {
				return; // 아니면 경우의 수 증가 안하고 리턴
			}
			
		}
		
		for(int i=0; i<8; i++) {
			if(!isSelected[i]) {
				choosed[nth] = names[i];
				isSelected[i] = true;
				perm(nth+1, choosed, isSelected, data);
				isSelected[i] = false;
			}
		}
	}
	

}
