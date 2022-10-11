

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c, ans;
	static int[] belt;
	static HashSet<Integer> set = new HashSet<>();
	static ArrayList<Integer> list = new ArrayList<>();

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		d = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());

		belt = new int[N];
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(input.readLine());
		} // 입력

		ans = Integer.MIN_VALUE;
		int cnt = 1;
		int[] s = new int[3001];
		s[c]++;
		for (int i = 0; i < k; i++) {
			if (s[belt[i]] == 0)
				cnt++;
			s[belt[i]]++;
		}

		for (int i = 0; i < belt.length; i++) {
			if (s[belt[(i + k) % belt.length]] == 0)
				cnt++;
			s[belt[(i + k) % belt.length]]++;

			s[belt[i]]--;
			if (s[belt[i]] == 0)
				cnt--;
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}

}
