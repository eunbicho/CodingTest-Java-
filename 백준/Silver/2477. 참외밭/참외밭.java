import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	final static int E = 1;
	final static int W = 2;
	final static int S = 3;
	final static int N = 4;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());

		Point[] pList = new Point[6];
		Point prev = new Point(0, 0);
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			switch (dir) {	// 좌표로 변환
			case E:
				pList[i] = new Point(prev.x + len, prev.y);
				break;
			case W:
				pList[i] = new Point(prev.x - len, prev.y);
				break;
			case S:
				pList[i] = new Point(prev.x, prev.y - len);
				break;
			case N:
				pList[i] = new Point(prev.x, prev.y + len);
				break;
			}
			prev = pList[i];
		}

		int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;
		int midX = 0, midY = 0;
		for (int i = 0; i < 6; i++) {	// 각 X, Y의 최대값, 최소값 구하기
			if (maxX < pList[i].x) {
				maxX = pList[i].x;
			}
			if (minX > pList[i].x) {
				minX = pList[i].x;
			}
			if (maxY < pList[i].y) {
				maxY = pList[i].y;
			}
			if (minY > pList[i].y) {
				minY = pList[i].y;
			}
		}

		for (int i = 0; i < 6; i++) {	// 중간 점 구하기
			if (pList[i].x > minX && pList[i].x < maxX) {
				midX = pList[i].x;
			}
			if (pList[i].y > minY && pList[i].y < maxY) {
				midY = pList[i].y;
			}
		}

		int lenX = 0, lenY = 0;
		for (int i = 0; i < 6; i++) {	// 중간점을 통해 작은 사각형의 각 변의 길이 구하기
			if (pList[i].x == midX && pList[i].y != midY) {
				lenY = Math.max(pList[i].y, midY) - Math.min(pList[i].y, midY);
			}
			if (pList[i].y == midY && pList[i].x != midX) {
				lenX = Math.max(pList[i].x, midX) - Math.min(pList[i].x, midX);
			}
		}

		int big = (maxX - minX) * (maxY - minY);	// 큰 사각형의 넓이
		int small = lenX * lenY;	// 작은 사각형의 넓이

		bw.write(String.valueOf((big - small) * K));
		bw.flush();
		bw.close();
		br.close();
	}
}

class Point {	// 좌표 표현을 위한 Point 클래스
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}