import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int INF = 98765432;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = reader.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int[][] dist = new int[N+1][N+1];

        for(int i = 1; i<=N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0; i<N-1; i++) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            dist[x][y] = d; dist[y][x] = d;
        }

        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=N; j++) {
                for(int k = 1; k<=N; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        for(int i = 0; i<M; i++) {
            String[] input = reader.readLine().split(" ");
            System.out.println(dist[Integer.parseInt(input[0])][Integer.parseInt(input[1])]);
        }
    }
}