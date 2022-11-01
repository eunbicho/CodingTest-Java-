

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i=0; i<10; i++) {
			int N = Integer.parseInt(input.readLine());
			int rest = N % 42;
			set.add(rest);
		}
		System.out.println(set.size());

	}

}
