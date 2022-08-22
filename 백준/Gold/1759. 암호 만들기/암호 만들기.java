import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] src;
	static char[] choosed;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		src = new char[C];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<C; i++) {
			src[i] = tokens.nextToken().charAt(0);
		} // src에 저장
		comb(0, new char[L], 0);

		tokens = new StringTokenizer(output.toString());
		List<String> list = new ArrayList<String>();
		while(tokens.hasMoreTokens()) {
			list.add(tokens.nextToken());
		}

		StringBuilder new_output = new StringBuilder();
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			new_output.append(list.get(i)).append('\n');
		}
		System.out.println(new_output);
		


	}
	
	public static void comb(int nth, char[] choosed, int startIdx) {
		if(nth == choosed.length) {
//			System.out.println(Arrays.toString(choosed));
//			System.out.println("-");
			
			// 오름차순으로 정렬
			char[] answer = Arrays.copyOf(choosed, choosed.length);
			Arrays.sort(answer);
			//System.out.println(Arrays.toString(answer));

			// 조건: 최소 한 개의 모음, 최소 두 개의 자음 포함, 오름차순
			int mo = 0;
			int ja = 0;
			for(int i=0; i<answer.length; i++) {
				if(answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u') {
					mo++;
				} else {
					ja++;
				}
			}
			
			// 모음 자음 조건을 만족하면
			if(mo>=1 && ja>=2) {
				for(int i=0; i<answer.length; i++) {					
					output.append(answer[i]);
				}
				output.append('\n');
			}
			
			return;
		}
		
		for(int i=startIdx; i<src.length; i++) {	
				choosed[nth] = src[i];
				comb(nth+1, choosed, i+1);			
			
		}
	}

}
