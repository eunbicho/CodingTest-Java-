class Solution {
    static char[][] map;
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        // 전체 맵 행,열 길이
        int R = wallpaper.length;
        int C = wallpaper[0].length();
        
        // 지도에 추가
        map = new char[R][C];
        
        // 시작점, 끝점 좌표 변수
        int r_min = Integer.MAX_VALUE;
        int c_min = Integer.MAX_VALUE;
        int r_max = Integer.MIN_VALUE;
        int c_max = Integer.MIN_VALUE;
        
        // 입력 받기: 입력받으면서 r,c의 최솟값과 최댓값 각각 구하기
        for(int r=0; r<wallpaper.length; r++){
            String s = wallpaper[r];
            for(int c=0; c<s.length(); c++){
                map[r][c] = s.charAt(c);
                if(map[r][c] == '#'){ // 문서면, 좌표 확인 후 끝점 좌표 변수 갱신
                    r_min = Math.min(r_min, r);
                    c_min = Math.min(c_min, c);
                    r_max = Math.max(r_max, r);
                    c_max = Math.max(c_max, c);
                }
            }
        }
        
        answer[0] = r_min;
        answer[1] = c_min;
        answer[2] = r_max+1;
        answer[3] = c_max+1;
        
        // map 출력
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
        
        return answer;
    }
}