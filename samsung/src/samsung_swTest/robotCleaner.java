package samsung_swTest;

import java.util.Scanner;

/*
* 
로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 
청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다.
지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.

로봇 청소기는 다음과 같이 작동한다.

1. 현재 위치를 청소한다.
2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
3. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
4. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
5. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
6. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
-로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다

-입력
첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)

둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.

셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.

로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.

-출력
로봇 청소기가 청소하는 칸의 개수를 출력한다.

-예시
입력값 :
3 3
1 1 0
1 1 1
1 0 1
1 1 1
출력값 :
1

입력값 :
11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

출력값:
57
 */

class robot{
	int r,c,d,cnt;
	int clear;
	robot(int r, int c, int d, int clear){
		this.r = r;
		this.c = c;
		this.d = d;
		cnt = 0;
		this.clear = clear;
	}
}

public class robotCleaner {
    //청소 안한지역 : 0, 청소 한지역은 2, 벽은 1 	
	
	//청소 시작
	public static int startClean(int[][] map, int r, int c, int d) {
		int answer = 0;
		//robot 생성
		robot rb = new robot(r,c,d,0);
		
		//청소 시작
		while(true) {
			
			//1. 현재 위치를 청소한다.
			if(map[rb.r][rb.c] == 0) {
				map[rb.r][rb.c] = 2;
				rb.cnt++;
			}
			
			//2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
			for(int i=0; i<4; i++) {
				//왼쪽 회전
				if(rb.d-1<0) {
					rb.d = 3;
				}else {
					rb.d = rb.d -1;
				}
				//3. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
				if(rb.d == 0) {
				  //map 범위 내에만 탐색
				  if(rb.r-1>=0 && map[rb.r-1][rb.c]!=1) {
					if(map[rb.r-1][rb.c]==0) {
						  rb.r = rb.r-1;
						  rb.clear = 0;
						  break;
					}
				  }
				}
				else if(rb.d == 1) {
				  if(rb.c+1<map[0].length && map[rb.r][rb.c+1]!=1) {
					if(map[rb.r][rb.c+1]==0) {
						  rb.c = rb.c+1;
						  rb.clear = 0;
						  break;
					}	
				  }
				}
				else if(rb.d == 2) {
				   if(rb.r+1<map.length && map[rb.r+1][rb.c] != 1) {
					if(map[rb.r+1][rb.c]==0) {
						  rb.r = rb.r+1;
						  rb.clear = 0;
						  break;
					}
				   }
				}
				else if(rb.d == 3) {
				   if(rb.c-1>=0 && map[rb.r][rb.c-1] != 1) {
					if(map[rb.r][rb.c-1]==0) {
						  rb.c = rb.c-1;
						  rb.clear = 0;
						  break;
					}
				 }
				}
				rb.clear = 1;
			}
			
			//4. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
			if(rb.clear == 1 ) {
				if(rb.d == 0) {
					if(rb.r+1<map.length && map[rb.r+1][rb.c] != 1) {
					  rb.r = rb.r+1;
					  rb.clear = 0; // 후진했기때문에 초기화
					}else {
					  rb.clear = 2;
					}
				}
				else if(rb.d == 1) {
					if(rb.c-1>=0 && map[rb.r][rb.c-1] != 1) {
						  rb.c = rb.c-1;
						  rb.clear = 0; // 후진했기때문에 초기화
					}else {
						  rb.clear = 2;
					}
				}
				else if(rb.d == 2) {
					if(rb.r-1>=0 && map[rb.r-1][rb.c] != 1) {
						  rb.r = rb.r-1;
						  rb.clear = 0; // 후진했기때문에 초기화
					}else {
						  rb.clear = 2;
					}				
				}
				else if(rb.d == 3) {
					if(rb.c+1<map[0].length && map[rb.r][rb.c+1] != 1) {
						  rb.c = rb.c+1;
						  rb.clear = 0; // 후진했기때문에 초기화
					}else {
						  rb.clear = 2;
					}
				}
			}
			
			//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			if(rb.clear == 2) {
				break;
			}
		}
		answer = rb.cnt;
		return answer;
	}
	
	
	public static void main(String[] args) {
		// 문제풀이는 항상 입력값 받는거 우선 작성
		int N,M,r,c,d;
		
		//첫출 N,M 받기
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt(); 
		//r,c,d 입력
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		//Map 입력
		int[][] map = new int[N][M]; //map
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Start");
		startClean(map,r,c,d);
		System.out.println("End");
		

	}

}
