import java.util.Scanner;

/* # 문제 - 로봇청소기
 * N x M map 제공
 * 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 지도 칸은 (r=h,c=w)로 표현
 * 
 * 1. 현재 위치를 청소한다.
 * 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
 * 	a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 *  b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 *  c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다. 
 *  d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 * 로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
 * 
 * # 입력 방식
 * 1. 첫 줄에 세로 N, 가로 M 입력 (3 <= N,m <=50)
 * 2. 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
 * 3. Map 정보 입력 빈칸은 0, 벽은 1로 주어짐. 장소의 모든 외곽은 벽. 로봇청소기가 있는 칸의 상태는 항상 빈칸
 * 
 * # 출력
 * 1. 로봇 청소기가 청소한 칸의 개수 출력
 * 
 */

//로봇 정보를 담고있는 클래스
class robotLocation{
	int h;
	int w;
	int d;
	robotLocation(int r,int c, int d){
		h = r;
		w = c;
		this.d = d;
	}
	
}
public class robotCleaner {
	
	//청소기 알고리즘
	public void robotAlgo(int[][] map,robotLocation rb) {
		//청소여부 체크 변수
		boolean[][] mapCk = new boolean[map.length][map[0].length];
		int cnt = 0; //청소한 칸 개수 카운터
		
		
		//청소 알고리즘 시작
		loop:
		while(true) {
			//1.현재 장소 청소
			mapCk[rb.h][rb.w] = true;
			cnt ++;
			
			//2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
			// c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다. 
			// d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			if(mapCk[rb.h-1][rb.w]&&mapCk[rb.h+1][rb.w]&&mapCk[rb.h][rb.w+1]&&mapCk[rb.h][rb.w-1] ||
				map[rb.h-1][rb.w] == 1 && map[rb.h+1][rb.w] == 1 && map[rb.h][rb.w-1] == 1 && map[rb.h][rb.w+1] == 1) {
				//뒤로 한칸 후진
				// 현재 방향이 북쪽인경우 남쪽으로 한칸이동
				if(rb.d == 0) {
					//뒤쪽방향이 벽인경우 break
					if(map[rb.h+1][rb.w]==1 || rb.h+1>map.length) {
						break loop;
					}else {
						rb.h = rb.h+1;
					}
				}
				// 현재 방향이 동쪽인 경우 서쪽으로 한칸 이동
				else if(rb.d == 1) {
					if(map[rb.h][rb.w-1]==1 || rb.w-1<0) {
						break loop;
					}else {
						rb.w = rb.w-1;
					}
				}
				// 현재 방향이 남쪽인 경우
				else if(rb.d == 2) {
					if(map[rb.h-1][rb.w]==1 || rb.h-1<0) {
						break loop;
					}else {
						rb.h = rb.h-1;
					}
				}
				// 현재 방향이 서쪽인 경우
				else if(rb.d == 3) {
					if(map[rb.h][rb.w+1]==1 || rb.w+1<map.length) {
						break loop;
					}else {
						rb.w = rb.w+1;
					}
				}
			}
			//왼쪽방향으로 청소할 것이 남아있는 경우
			//a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
			//b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			else {
				if(rb.d==0) {
					//a.북쪽방향기준 왼쪽. 서쪽 청소할 공간이 있는경우 방향 회전 후 한칸 청소
					if(mapCk[rb.h][rb.w-1] == false && map[rb.h][rb.w-1] != 1) {
						mapCk[rb.h][rb.w-1] = true;
						rb.d = 1;
						rb.w = rb.w-1;
						//1번 이동
					}
					//b.그 방향으로 회전 후 다시 2번
					else if(mapCk[rb.h][rb.w-1] == true && map[rb.h][rb.w-1] != 1){
						rb.d = 1;
						//2번 이동
					}
				}
				else if(rb.d==1) {
					if(mapCk[rb.h-1][rb.w] == false && map[rb.h-1][rb.w] != 1) {
						mapCk[rb.h-1][rb.w] = true;
						rb.d = 2;
						rb.h = rb.h-1;
						//1번 이동
					}
					else if(mapCk[rb.h-1][rb.w] == true && map[rb.h-1][rb.w] != 1){
						rb.d = 2;
						//2번 이동
					}
					
				}
				else if(rb.d==2) {
					if(mapCk[rb.h][rb.w+1] == false && map[rb.h][rb.w+1] != 1) {
						mapCk[rb.h][rb.w+1] = true;
						rb.d = 3;
						rb.w = rb.w+1;
						//1번 이동
					}
					else if(mapCk[rb.h][rb.w+1] == true && map[rb.h][rb.w+1] != 1){
						rb.d = 3;
						//2번 이동
					}
					
				}
				else if(rb.d==3) {
					if(mapCk[rb.h+1][rb.w] == false && map[rb.h+1][rb.w] != 1) {
						mapCk[rb.h][rb.w+1] = true;
						rb.d = 0;
						rb.w = rb.w+1;
						//1번 이동
					}
					else if(mapCk[rb.h][rb.w-1] == true && map[rb.h+1][rb.w] != 1){
						rb.d = 0;
						//2번 이동
					}
				}
				
			}
		}
		
		System.out.println("청소한  칸의 개수 : "+cnt);
		
	}
	
	
	//map Print
	public static void printMap(int[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		robotCleaner rbc = new robotCleaner();
		Scanner sc = new Scanner(System.in);
		// # 입력값 작성
		// 1. 첫 줄에 세로 N, 가로 M 입력 (3 <= N,m <=50)
		int N,M;
		N = sc.nextInt();
		M = sc.nextInt();
		// 2. 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다.
		int r,c,d;
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		robotLocation rb = new robotLocation(r,c,d);
		
		//3. Map 정보 입력 빈칸은 0, 벽은 1로 주어짐. 장소의 모든 외곽은 벽. 로봇청소기가 있는 칸의 상태는 항상 빈칸
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//청소 알고리즘 시작
		rbc.robotAlgo(map,rb);

	}

}
