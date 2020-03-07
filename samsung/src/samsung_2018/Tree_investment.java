package samsung_2018;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


class Tree implements Comparable<Tree>{
	int x;
	int y;
	int age;
	Tree(int x, int y, int age){
		this.x = x -1; //�迭 ũ��� 0���� �����ϱ� ����
		this.y = y -1;
		this.age = age;
	}
	
	public int compareTo(Tree target) {
		if(this.age > target.age) return 1;
		else return -1;
	}
}
public class Tree_investment {

	static Queue<Tree> cur_q = new PriorityQueue<Tree>();
	static Queue<Tree> next_q = new PriorityQueue<Tree>();
	static Queue<Tree> live_tree = new LinkedList<Tree>();
	static Queue<Tree> dead_tree = new LinkedList<Tree>();
	
	static int[] X = {-1,-1,-1,0,0,1,1,1};
	static int[] Y = {1,0,-1,1,-1,1,0,-1};
	
	static int n;
	static int m;
	static int k;
	static int[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		//�� ����/����/�⵵ �Է�
		n = s.nextInt();
		m = s.nextInt();
		k = s.nextInt();
		int add[][] = new int[n][n];
		map = new int[n][n];
		
		//��� �Է¹ޱ�
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				add[i][j] = s.nextInt();
				map[i][j] = 5;
			}
		}
		
		int x,y,z;
		//���� ��ġ �Է�
		for(int i=0; i<m; i++) {
			x = s.nextInt();
			y = s.nextInt();
			z = s.nextInt();
			cur_q.add(new Tree(x,y,z));
		}
		
		
		for(int i=0; i<k; i++){
			//Spring
			while(!cur_q.isEmpty()) {
				Tree cur_tree = cur_q.peek(); cur_q.poll();
				
				// cur_tree�� �� �� �ִ��� ������ �Ǻ�
				// ������ ���̺��� ��� ���� ũ�ٸ�  �� �� �ִ� ����
				// ���̸�ŭ ����� �����Ѵ�.
				if(cur_tree.age <= map[cur_tree.x][cur_tree.y]) {
					map[cur_tree.x][cur_tree.y] -= cur_tree.age;
					Tree next_tree = new Tree(cur_tree.x+1,cur_tree.y+1,cur_tree.age+1);
					
					live_tree.add(next_tree);
					next_q.add(next_tree);//(?)
				}
				else
					dead_tree.add(cur_tree);
			}
			
			//Summer
			//���� �������� (��������/2) ��ŭ ������ �ִ� ĭ�� ��� ����
			while(!dead_tree.isEmpty()) {
					Tree cur_dead_tree = dead_tree.peek(); dead_tree.poll();
					int energy = (cur_dead_tree.age / 2);
					
					map[cur_dead_tree.x][cur_dead_tree.y] += energy;
			}
			
			//fall
			//������ �����Ѵ�.
			while(!live_tree.isEmpty()) {
				Tree cur_live_tree = live_tree.peek(); live_tree.poll();
				if((cur_live_tree.age%5) ==0) {
					for(int m=0; m<8; m++) {
						int next_x = cur_live_tree.x + X[m];
						int next_y = cur_live_tree.y + Y[m];
					
						if(next_x<0 || next_y<0 || next_x>=n || next_y>=n) { continue ;}
						
						next_q.add(new Tree(next_x+1,next_y+1,1));
				
					}
					
				}else
					continue;
			}
			
			//winter
			//�Է¹��� ����� ���� ��Ų��
		
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					map[a][b] += add[a][b];
				}
			}
			
			// 1���� ������ ������ ������ ������ ������ �ȴ�.
			//cur_q = next_q; //�̷����ϸ� ������ �ƴ� �ּҰ� ����� -> next_q�� �����ϸ� cur_q���� ������
			//next_q ����
			while(!next_q.isEmpty()){
				cur_q.add(next_q.poll());
			}
		}
		
		System.out.println(cur_q.size());
	}

}
