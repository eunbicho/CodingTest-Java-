import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, A, B, SNAP;
	static boolean primecheck[] = new boolean[100001];
	static int primecnt[] = new int[100001];
	static int dp[];

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception {

		prime_init();

		T = Integer.parseInt(input.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());

			if (primecnt[B] - primecnt[A - 1] == 0) {
				SNAP = -1;
			} else if (check(N) && !primecheck[N]) {
				SNAP = 0;
			} else {
				dp = new int[3000001];
				SNAP = Integer.MAX_VALUE - 1;
				dp[N] = 0;
				bfs();
				SNAP = SNAP == Integer.MAX_VALUE - 1 ? -1 : SNAP;
			}
			System.out.println(SNAP);
		}
	}

	private static void bfs() {
		Queue<Integer> index = new LinkedList<Integer>();

		index.offer(N);

		int num, tmpnum;

		while (!index.isEmpty()) {

			for (int i = 0, size = index.size(); i < size; i++) {
				num = index.poll();
				for (int d = 0; d < 4; d++) {
					tmpnum = snapping(num, d);
					if (tmpnum != N && dp[tmpnum] == 0) {
						dp[tmpnum] = dp[num] + 1;

						if (check(tmpnum) && !primecheck[tmpnum]) {
							SNAP = dp[tmpnum];
							return;
						}

						index.offer(tmpnum);
					}
				}
			}
		}

	}

	private static boolean check(int tmpnum) {
		if (tmpnum < A || B < tmpnum)
			return false;
		else
			return true;
	}

	private static int snapping(int num, int i) {
		switch (i) {
		case 0:
			return num / 2;
		case 1:
			return num / 3;
		case 2:
			return num + 1;
		case 3:
			return num == 0 ? 0 : num - 1;
		}
		return -1;
	}

	private static void prime_init() {
		for (int i = 2; i < 100001; i++) {
			if (!primecheck[i]) {
				for (int j = i + i; j < 100001; j += i) {
					primecheck[j] = true;
				}
				primecnt[i]++;
			}
			primecnt[i] += primecnt[i - 1];
		}
	}
}

