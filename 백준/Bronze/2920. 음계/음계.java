

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}

		String ans = "";
		// 맨 앞이 1이면 ascending으로 간주하고 1씩 커지는게 아니라면 mix로 출력
		if (arr[0] == 1) {
			int idx = 0;
			ans = "ascending";
			while (++idx < 8) {
				
				if(arr[idx] != arr[idx-1]+1) {
					ans = "mixed";
					break;
				}
			}
		}

		// 맨 앞이 8이면 descending으로 간주 1씩 작아지는게 아니라면 mix로 출력
		else if (arr[0] == 8) {
			int idx = 0;
			ans = "descending";
			while (++idx < 8) {
				if(arr[idx] != arr[idx-1]-1) {
					ans = "mixed";
					break;
				}
			}
		}

		// 맨 앞이 1도 8도 아니면 믹스
		else {
			ans = "mixed";
		}
		System.out.println(ans);
	}

}
