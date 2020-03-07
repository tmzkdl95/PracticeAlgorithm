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
	static Queue<fish> q = new LinkedList<fish>();//물고기를 담을 큐
	static int w = 5; //weight
	static int h = 5; //height
	static int[] W = {0,0,1,-1};
	static int[] H = {1,-1,0,0};
	static boolean[][] ck;
	//map 물고기 찾아서 q에 넣기
	static void find_fish(int start_h,int start_w) {
		//범위 넘어갈 경우
		if(start_w <0 || start_h<0 || start_h>=h ||start_w>= w) {
			return ;
		}
		//방문 한 곳 탐색 x 
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
		int answer = 0; //물고기 잡은 횟수
		//맵 정보
		map = new fish[h][w];
		
		int move_h = (h*2)-1;
		int move_w = (w*2)-1; //9 = 012343210
		int[] arr_h = new int[move_h];
		int[] arr_w = new int[move_w];
		//물고기 이동 좌표 설정
		for(int i=0; i<move_h; i++) {
			if(i>move_h/2) { arr_h[i] = (move_h-1)-i; } //5일경우 배열 -> 0123210
			else  arr_h[i] = i;
		}
		for(int i=0; i<move_w; i++) {
			if(i>move_w/2) { arr_w[i] = (move_w-1)-i; } //5일경우 배열 -> 0123210
			else  arr_w[i] = i;
		}
		
		//물고기 정보 입력
		int fish_num=3;
		for(int i=0; i<fish_num; i++) {
			q.add(new fish(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),++num));
		}
		
		//작살던지기 시뮬레이션 
		for(int try_j =0; try_j<w; try_j++) {
			
			while(!q.isEmpty()) {
				//처음 위치에서 speed 만큼 동작 후 위치/방향 설정하기
				int next_w = q.peek().w;
				int next_h = q.peek().h;
				int next_dir = q.peek().dir;
	
				//물고기 동작 코드
				//1)map에 있는 q.peek() 물고기 위치를 null로 바꾸고
				map[q.peek().h][q.peek().w] = null;
				   
				/*2)물고기가 동작함
				 *if( q.peek().dir == 북 || q.peek().dir() ==남){
				 *	next_h = (q.peek().h + q.peek().speed) % move_h
				 * 
				 *else if(q.peek().dir = 동 || q.peek().dir() == 서){
				 *	next_w = (q.peek().w + q.peek().speed) % move_w
				 *}
				 */
				
				//3)이동 후 q.peek()값 수정하기
				q.peek().h = next_h;
				q.peek().w = next_w;
				q.peek().dir = next_dir;
				
				//도착지점에 물고기가 있다면 크기 비교해서 큰놈이 먹음
				if(map[next_w][next_h] != null) {
					if(map[next_w][next_h].num < q.peek().num) {
						map[next_w][next_h] =q.poll();
					}	
				}
				//도착지점에 물고기 놓기
				else
					map[next_w][next_h] = q.poll();
			}
			
			//물고기 배치가 끝났으면 작살을 던진다.
			for(int i=0; i<h; i++) {
				//작살 던졌는데 물고기 있으면 answer ++ 후 해당 물고기 삭제
				if(map[i][try_j] != null) {
					answer ++;
					map[i][try_j] = null;
					break;
				}
			}
			
			//다시 map에 있는 물고기들 q에 넣기
			  ck = new boolean[h][w];
			  find_fish(0,0);
		
		}//작살 1회 끝
		
		System.out.println("잡힌 물고기 : " + answer);
	}

}
