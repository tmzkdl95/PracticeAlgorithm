package samsung_swTest;

import java.util.ArrayList;
import java.util.Scanner;


//core ��ġ�� ������ Ŭ���� ����
class coreInfo{
	int h;
	int w;
	int cnt;
	int[] dir = new int[4];
	
	coreInfo(int h, int w, int[] dir, int cnt){
		this.h = h;
		this.w = w;
		this.dir= dir;
		this.cnt = cnt;
		/*
		for(int i : dir) {
			if(i!=0) {this.dir.add(i);}
		}
		*/
	}
}

public class mexinos_sampleTest {
	
	static ArrayList<coreInfo> ci = new ArrayList<coreInfo>();
	static int line = 0;
	
	//�켱 �����ڸ��� ������ �ھ� ��ġ Ž��
	public static void findCore(int h, int w, int[][] cell, boolean[][] ck) {
	
		//�����ڸ� ���� ������ ����
		if( h<=0 || w<=0 || h>=cell.length-1 || w>=cell.length-1) {return ;}
		//�湮�� �� ����
		if(ck[h][w]) {return ;}
		
		//�湮 üũ
		ck[h][w] = true;
		//core ��ġ ����
		if(cell[h][w] == 1) {
			int line = 0;
			int cnt = 0;
			//�� �Ǵ�
			int temp_h = h;
			int temp_w = w;
			int[] temp_dir = new int[4];
			//�����̵�
			while(temp_h != 0) {
				--temp_h;
				++line;
				if(cell[temp_h][w] != 0) {break;}
				if(temp_h == 0) {temp_dir[0]=line; cnt++; break;}
			}
			//�Ʒ�
			temp_h = h;
			line = 0;
			while(temp_h != cell.length-1) {
				++temp_h;
				++line;
				if(cell[temp_h][w] != 0) { break;}
				if(temp_h == cell.length-1) {temp_dir[1]=line; cnt++; break;}
			}
			//������
			temp_w = w;
			line = 0;
			while(temp_w != cell.length-1) {
				++temp_w;
				++line;
				if(cell[h][temp_w] != 0) { break;}
				if(temp_w == cell.length-1) {temp_dir[2]=line; cnt++; break;}
			}
			//����
			temp_w = w;
			line = 0;
			while(temp_w != 0) {
				--temp_w;
				++line;
				if(cell[h][temp_w] != 0) {break;}
				if(temp_w == 0) {temp_dir[3]=line; cnt++; break;}
			}
			ci.add(new coreInfo(h,w,temp_dir,cnt));
		}
		
		findCore(h-1,w,cell,ck);
		findCore(h+1,w,cell,ck);
		findCore(h,w+1,cell,ck);
		findCore(h,w-1,cell,ck);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 0;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int[][] cell = new int[n][n];
		boolean[][] ck = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cell[i][j] = s.nextInt();
			}
		}
		findCore(1,1,cell,ck);
		
		System.out.println(ci.size());
		
		for(int i=0; i<ci.size(); i++) {
			for(int j=0; j<ci.get(i).dir.length; j++) {
				System.out.print(" "+ci.get(i).dir[j]);
			}
			System.out.println();
		}
		// 1=��, 2=�Ʒ�, 3=����, 4=������

		
		
	}

}
