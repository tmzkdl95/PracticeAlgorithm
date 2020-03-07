package samsung_swTest;

import java.util.ArrayList;
import java.util.Scanner;


//core 위치를 저장할 클래스 생성
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
	
	//우선 가장자리를 제외한 코어 위치 탐색
	public static void findCore(int h, int w, int[][] cell, boolean[][] ck) {
	
		//가장자리 포함 범위면 리턴
		if( h<=0 || w<=0 || h>=cell.length-1 || w>=cell.length-1) {return ;}
		//방문한 곳 리턴
		if(ck[h][w]) {return ;}
		
		//방문 체크
		ck[h][w] = true;
		//core 위치 저장
		if(cell[h][w] == 1) {
			int line = 0;
			int cnt = 0;
			//상 판단
			int temp_h = h;
			int temp_w = w;
			int[] temp_dir = new int[4];
			//위로이동
			while(temp_h != 0) {
				--temp_h;
				++line;
				if(cell[temp_h][w] != 0) {break;}
				if(temp_h == 0) {temp_dir[0]=line; cnt++; break;}
			}
			//아래
			temp_h = h;
			line = 0;
			while(temp_h != cell.length-1) {
				++temp_h;
				++line;
				if(cell[temp_h][w] != 0) { break;}
				if(temp_h == cell.length-1) {temp_dir[1]=line; cnt++; break;}
			}
			//오른쪽
			temp_w = w;
			line = 0;
			while(temp_w != cell.length-1) {
				++temp_w;
				++line;
				if(cell[h][temp_w] != 0) { break;}
				if(temp_w == cell.length-1) {temp_dir[2]=line; cnt++; break;}
			}
			//왼쪽
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
		// 1=위, 2=아래, 3=왼쪽, 4=오른쪽

		
		
	}

}
