package samsung_2018;

import java.util.ArrayList;
import java.util.Scanner;

import javax.management.Query;

public class papulation_movement {
	static int N;
	static int L;
	static int R;
	static int[][] map = new int[50][50];
	static int[][] ck = new int[50][50];
	static int[] X = { 0, 0, 1, -1 };
	static int[] Y = { 1, -1, 0, 0 };
	static int cnt;

	public static void print_map() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		papulation_movement p = new papulation_movement();
		Scanner s = new Scanner(System.in);

		N = s.nextInt();
		L = s.nextInt();
		R = s.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = s.nextInt();
			}
		}
		System.out.println("답 :" + solution());
	}

	static int solution() {
		int ret = 0;
		boolean flag;
		
		do {
			flag = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ck[i][j] = 0;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문하지 않은 곳 방문
					if (ck[i][j] == 0) {
						cnt = 0;
						int sum = find(i, j, -1); // 이전 국가
						if (cnt > 1) {
							flag = true;
							move(i, j, sum / cnt);
						} else
							ck[i][j] = 2;
					}
				}
			}

			if (flag)
				++ret;
		} while (flag);

		return ret;
	}

	public static int find(int x, int y, int value) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return 0;
		} // 범위가 넘어갈경우
		if (ck[x][y] != 0) {
			return 0;
		} // 방문했으면 return
		if (value != -1) {
			int diff = Math.abs(value - map[x][y]);
			if (diff < L || diff > R) {
				return 0;
			}
		}

		ck[x][y] = 1;
		++cnt;
		int sum = map[x][y]; // 초기 인구수

		// 상하좌우 이동 후 해당 인구수 sum에 더하기
		sum += find(x - 1, y, map[x][y]);
		sum += find(x + 1, y, map[x][y]);
		sum += find(x, y - 1, map[x][y]);
		sum += find(x, y + 1, map[x][y]);

		return sum;
	}

	public static void move(int x, int y, int value) {
		if (x < 0 || y < 0 || x >= map.length || y >= map.length) {
			return;
		}
		if (ck[x][y] != 1) {
			return;
		} // 방문했으면 return

		ck[x][y] = 2;
		map[x][y] = value;

		move(x, y + 1, value);
		move(x, y - 1, value);
		move(x + 1, y, value);
		move(x - 1, y, value);

	}
}
