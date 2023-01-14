

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map = new int[1001][1001];
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
    static StringTokenizer tokens;
    
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(input.readLine());
        long left = 0, right = 0, sum = 0;

        for (int r = 0; r < n; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
                sum += map[r][c];
                if (map[r][c] > right)
                    right = map[r][c];
            }
        }

        while (left + 1 < right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt += mid > map[i][j] ? map[i][j] : mid;
                }
            }

            if (((double) cnt / sum) >= 0.5)
                right = mid;
            else
                left = mid;
        }

        System.out.println(right);

    }

}

