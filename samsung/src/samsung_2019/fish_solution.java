package samsung_2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class fish{
	int w;
	int h;
	int speed;
	int dir;
	int num;
	
	fish(int w, int h,int speed,int dir,int num){
		this.w = w;
		this.h = h;
		this.speed = speed;
		this.dir = dir; // 1 : up / 2 : down / 3 : left / 4 : right
		this.num = num;
	}
}



public class fish_solution {
	static fish[][] map;
	static Queue<fish> q = new LinkedList<fish>();//����⸦ ���� ť
	static int w = 5; //weight
	static int h = 5; //height
	static int[] W = {0,0,1,-1};
	static int[] H = {1,-1,0,0};
	static boolean[][] ck;
	//map ����� ã�Ƽ� q�� �ֱ�
	static void find_fish(int start_h,int start_w) {
		//���� �Ѿ ���
		if(start_w <0 || start_h<0 || start_h>=h ||start_w>= w) {
			return ;
		}
		//�湮 �� �� Ž�� x 
		if(ck[start_h][start_w] == true) {
			return ;
		}
		
		if(map[start_h][start_w] != null) {
			q.add(map[h][w]);
		}
		for(int i=0; i<4; i++) {
			int next_h = start_h + H[i];
			int next_w = start_w + W[i];
			
			find_fish(next_h,next_w);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int answer = 0; //����� ���� Ƚ��
		//�� ����
		map = new fish[h][w];
		
		int move_h = (h*2)-1;
		int move_w = (w*2)-1; //9 = 012343210
		int[] arr_h = new int[move_h];
		int[] arr_w = new int[move_w];
		//����� �̵� ��ǥ ����
		for(int i=0; i<move_h; i++) {
			if(i>move_h/2) { arr_h[i] = (move_h-1)-i; } //5�ϰ�� �迭 -> 0123210
			else  arr_h[i] = i;
		}
		for(int i=0; i<move_w; i++) {
			if(i>move_w/2) { arr_w[i] = (move_w-1)-i; } //5�ϰ�� �迭 -> 0123210
			else  arr_w[i] = i;
		}
		
		//����� ���� �Է�
		int fish_num=3;
		for(int i=0; i<fish_num; i++) {
			q.add(new fish(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),++num));
		}
		
		//�ۻ������ �ùķ��̼� 
		for(int try_j =0; try_j<w; try_j++) {
			
			while(!q.isEmpty()) {
				//ó�� ��ġ���� speed ��ŭ ���� �� ��ġ/���� �����ϱ�
				int next_w = q.peek().w;
				int next_h = q.peek().h;
				int next_dir = q.peek().dir;
	
				//����� ���� �ڵ�
				//1)map�� �ִ� q.peek() ����� ��ġ�� null�� �ٲٰ�
				map[q.peek().h][q.peek().w] = null;
				   
				/*2)����Ⱑ ������
				 *if( q.peek().dir == �� || q.peek().dir() ==��){
				 *	next_h = (q.peek().h + q.peek().speed) % move_h
				 * 
				 *else if(q.peek().dir = �� || q.peek().dir() == ��){
				 *	next_w = (q.peek().w + q.peek().speed) % move_w
				 *}
				 */
				
				//3)�̵� �� q.peek()�� �����ϱ�
				q.peek().h = next_h;
				q.peek().w = next_w;
				q.peek().dir = next_dir;
				
				//���������� ����Ⱑ �ִٸ� ũ�� ���ؼ� ū���� ����
				if(map[next_w][next_h] != null) {
					if(map[next_w][next_h].num < q.peek().num) {
						map[next_w][next_h] =q.poll();
					}	
				}
				//���������� ����� ����
				else
					map[next_w][next_h] = q.poll();
			}
			
			//����� ��ġ�� �������� �ۻ��� ������.
			for(int i=0; i<h; i++) {
				//�ۻ� �����µ� ����� ������ answer ++ �� �ش� ����� ����
				if(map[i][try_j] != null) {
					answer ++;
					map[i][try_j] = null;
					break;
				}
			}
			
			//�ٽ� map�� �ִ� ������ q�� �ֱ�
			  ck = new boolean[h][w];
			  find_fish(0,0);
		
		}//�ۻ� 1ȸ ��
		
		System.out.println("���� ����� : " + answer);
	}

}
