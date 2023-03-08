import java.util.*;

class Solution {
    public String[] solution(String[] record){
        String[] answer = {};
        List<String> ans = new ArrayList<String>();
        
        // 방법
        // 1) 모든 메세지를 아이디로 작성한다.
        // 2) 닉네임을 바꾸는 부분이 있으면 Map 정보(아이디:닉네임)를 변경한다.
        // 3) 모든 메세지를 다 살펴보면 모든 메세지의 아이디를 최종 변경된 닉네임으로 변경한다.
        
        // 변수
        // 1) 아이디와 닉네임을 매핑시키는 Map
        HashMap<String, String> info = new HashMap<>();
        
        // 2) 문자열을 자를 Tokenizer
        StringTokenizer tokens;
        
        // 3) type
        String type = "";
        String uid = "";
        String nick = "";
        
        // record 한 줄씩 확인
        for(int i=0; i<record.length; i++){
            tokens = new StringTokenizer(record[i]);
            type = tokens.nextToken();
            
            switch(type){
                case "Enter":
                    // 문장 저장, 아이디:닉네임 매칭저장
                    uid = tokens.nextToken();
                    nick = tokens.nextToken();
                    
                    ans.add(uid + "님이 들어왔습니다.");
                    // answer[i] = uid + "님이 들어왔습니다.";
                    info.put(uid, nick);
                    
                    break;
                    
                case "Leave":
                    // 문장 저장
                    uid = tokens.nextToken();
                    ans.add(uid + "님이 나갔습니다.");
                    // answer[i] = uid + "님이 나갔습니다.";
                    
                    break;
                    
                case "Change":
                    // 아이디:닉네임 매칭저장
                    uid = tokens.nextToken();
                    nick = tokens.nextToken();
                    
                    info.put(uid, nick);
                    break;       
            }            
        }
        
        // System.out.println(info);
        
        
        // 최종 변경된 닉네임으로 변경
        for(int i=0; i<ans.size(); i++){
            tokens = new StringTokenizer(ans.get(i), "님");
            uid = tokens.nextToken();
            nick = info.get(uid);
            
            ans.set(i, nick + "님" + tokens.nextToken());
            // answer[i] = nick + "님" + tokens.nextToken();
        
        }
        
        answer = ans.toArray(new String[ans.size()]);
        
        return answer;
    }
}