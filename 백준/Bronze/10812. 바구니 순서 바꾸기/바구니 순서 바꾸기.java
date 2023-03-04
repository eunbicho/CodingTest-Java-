import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N + 1];
		int rot[] = new int[N + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());

			for (int j = 0; j < end - mid + 1; j++) {
				rot[begin + j] = arr[mid + j];
			}
			for (int j = 0; j < mid - begin; j++) {
				rot[begin + end - mid + 1 + j] = arr[begin + j];
			}
			for (int j = begin; j <= end; j++) {
				arr[j] = rot[j];
			}
		}
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}