package samsung_2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dust{
	int h;
	int w;
	int dust;
	Dust(int h, int w, int dust){
		this.h = h;
		this.w = w;
		this.dust = dust;
	}
}
public class samsung2019_dust {
	static Queue<Dust> q = new LinkedList<Dust>();
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	static int w,h;
	
	static int[][] map;// = {{0,0,0,0,0},{0,0,31,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,6}};
						/*{{0,6,0},
			   			  {6,7,6},
			   			  {0,6,0}};*/ 
	static boolean[][] ck;// = new boolean[map.length][map[].length];
	public static void dfs(int cur_w,int cur_h) {
		
		if(cur_w<0 || cur_h <0 || cur_w >= h || cur_h >= w) {
			//map ���� �Ѿ�� ��� return
			return ;
		}
		
		if(ck[cur_h][cur_w]) {
			//�湮 �� ���̸� return
			return ;
		}
		
		//�ƴϸ� Ž�� �� �湮ó��
		ck[cur_h][cur_w] = true;
		//map�� ������ ���� 0�� �ƴ϶�� ���� ������ ���� �� ������ ���� q�� �߰�
		if(map[cur_h][cur_w] != 0) {
			//������ ���� �� �ִ� ������ Ȯ��
			if(map[cur_h][cur_w]>=5) {
				int dust_s = map[cur_h][cur_w] / 5;
				int dust_r = map[cur_h][cur_w] % 5;
				
				q.add(new Dust(cur_h,cur_w, dust_s+dust_r));
				//map[cur_x][cur_y] = dust_s + dust_r;
				
				//�� �������� ������
				for(int i=0; i<4; i++) {
					int next_h = cur_h + X[i];
					int next_w = cur_w + Y[i];
					
					if(next_h<0 || next_w<0 || next_h >= map.length || next_w >= map.length) { continue ;}
					
					q.add(new Dust(next_h,next_w,dust_s));
				}
			}
			else
				q.add(new Dust(cur_h,cur_w,map[cur_h][cur_w]));
		} //���� Ȯ�� ������ �Ϸ�
		
		for(int i=0; i<4; i++) {
			int next_h = cur_h + X[i];
			int next_w = cur_w + Y[i];
			
			dfs(next_h,next_w);
		}
			
		
	}
	
	static void init_ck(boolean[][] ck, int map[][]) {
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				ck[i][j] = false;
				map[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][w];
		ck = new boolean[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// �̼����� ������
		int sec = 2;
		
		for (int test = 0; test < sec; test++) {
			dfs(0, 0);
			init_ck(ck, map);
			while (!q.isEmpty()) {
				// q�� �ִ� �� �ű�� ����
				map[q.peek().h][q.peek().w] += q.peek().dust;
				q.poll();
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("END");
		}
		
		
		
	}

}
