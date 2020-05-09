package samsung_swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다.
 * 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 
 * 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다.
 * (r, c)는 r행 c열을 의미한다.
 *
공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 A(r,c)이다.

1초 동안 아래 적힌 일이 순서대로 일어난다.

1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
 -(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
 -인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
 -확산되는 양은 Ar,c/5이고 소수점은 버린다.
 -(r, c)에 남은 미세먼지의 양은 A(r,c) - (A(r,c)/5)×(확산된 방향의 개수) 이다.
2. 공기청정기가 작동한다.
 -공기청정기에서는 바람이 나온다.
 -위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
 -바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
 -공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
확산예시
 0초            1초     
000     010    
050  -> 111
000     010

 0초            1초             
500     310    
000  -> 100
000     000

[입력]
첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.
둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다.
공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다.
-1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.

[출력]
첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.

-예제입력 1
7 8 1
 0 0 0 0 0 0 0 9
 0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
 0 0 0 0 0 10 43 0
 0 0 5 0 15 0 0 0
 0 0 40 0 0 0 20 0
-출력 1
188

-예제입력 2
7 8 3
 0 0 0 0 0 0 0 9
 0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
 0 0 0 0 0 10 43 0
 0 0 5 0 15 0 0 0
 0 0 40 0 0 0 20 0
-출력2
186

-예제입력3
7 8 4
 0 0 0 0 0 0 0 9
 0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
 0 0 0 0 0 10 43 0
 0 0 5 0 15 0 0 0
 0 0 40 0 0 0 20 0

-출력3
178


샘플 테스트
3 3 2
0 0 0
0 25 0
0 0 0
 */
class dust{
	int r,c;
	int cnt;
	
	dust(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt = cnt;	
	}
}

//public class Main   //백준 제출용
public class dustCleaner {
	
	//map초기화 메서드
	public static void clearMap(int[][] map) {
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
					if(map[i][j] != -1) {map[i][j] = 0;}
				}
		}
	}
	
	public static void dustSpread(int[][] map,int T) {
		int answer = 0;
		Queue<dust> q = new LinkedList<dust>();
		int lftDust = 0;
		int sprdDust = 0;
		//청정기 위치 받기
		int R1 = 0;
		int C1 = 0;
	
		//T초동안 반복
		for(int time=0; time<T; time++) {
			//미세먼지 확산
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					
					//1. 공기청정기 설치구역이거나, 먼지양이 0인경우 진행 안함.
					if(map[i][j] != -1 && map[i][j] != 0) {
						lftDust = map[i][j];
						sprdDust = map[i][j]/5;
						
						//2. 상하좌우 퍼지기
						//위로 이동 
						//설치된곳과 map 범위 넘어가는곳 제외
						if(i-1>=0 && map[i-1][j] != -1) {
							q.add(new dust(i-1,j,sprdDust));
							lftDust -= sprdDust;
						}
						//오른쪽 이동
						if(j+1<map[i].length && map[i][j+1] != -1) {
							q.add(new dust(i,j+1,sprdDust));
							lftDust -= sprdDust;
						}
						//아래 이동
						if(i+1<map.length && map[i+1][j] != -1) {
							q.add(new dust(i+1,j,sprdDust));
							lftDust -= sprdDust;
						}
						//왼쪽 이동
						if(j-1>=0 && map[i][j-1] != -1) {
							q.add(new dust(i,j-1,sprdDust));
							lftDust -= sprdDust;
						}
						//남은양 계산
						q.add(new dust(i,j,lftDust));
					}else if(map[i][j] == -1) {
						R1 = i;
						C1 = j;
					}
				}
			}
			//2. 먼지 확산 값 map에 적용하기
			clearMap(map); //우선 값 초기화
			while(!q.isEmpty()) {
				map[q.peek().r][q.peek().c] += q.peek().cnt;
				q.poll();
			}
			
			//3. 공기청정기 발동 R1,C1
			cycle(map,R1);
		}
		
		//4. 전체 미세먼지량 구하기
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				//청정기 위치 제외 값 더하기
				if(map[i][j]!=-1) {
					answer += map[i][j];
				}
			}
		}
		System.out.println("answer : "+answer);
		//return answer;
	}
	
	public static void cycle(int[][] map,int r) {
		
		int R1 = r-1;
		int C1 = 0;
		int R2 = r;
		int C2 = 0;
		//공기청정기 발동 R1,C1
		int temp1=map[R1][C1+1];
		int temp2=0;
		
		//공기청정기 바로 앞은 항상0이된다.
		map[R1][C1+1] = 0;
		C1 += 1;
		//오른쪽 바람불기
		while(C1 != map[0].length-1) {
			temp2=map[R1][C1+1];
			map[R1][C1+1] = temp1;
			temp1 = temp2;
			C1++;
		}
		//위로 바람불기
		while(R1 != 0) {
			temp2=map[R1-1][C1];
			map[R1-1][C1] = temp1;
			temp1 = temp2;
			R1--;
		}
		//왼쪽으로 바람불기
		while(C1 != 0) {
			temp2=map[R1][C1-1];
			map[R1][C1-1] = temp1;
			temp1 = temp2;
			C1--;
		}
		//아래로 바람불기
		while(map[R1][C1] != -1) {
			if(map[R1+1][C1] != -1) {
				temp2=map[R1+1][C1];
				map[R1+1][C1] = temp1;
				temp1 = temp2;
				R1++;
			}else {
				break;
			}
		}
		
		//반시계방향으로 돌기
		temp1=map[R2][C2+1];
		temp2=0;
		//공기청정기 바로 앞은 항상0이된다.
		map[R2][C2+1] = 0;
		C2 += 1;
		//오른쪽 바람불기
		while(C2 != map[0].length-1) {
			temp2=map[R2][C2+1];
			map[R2][C2+1] = temp1;
			temp1 = temp2;
			C2++;
		}
		//아래 바람불기
		while(R2 != map.length-1) {
			temp2=map[R2+1][C2];
			map[R2+1][C2] = temp1;
			temp1 = temp2;
			R2++;
		}
		//왼쪽으로 바람불기
		while(C2 != 0) {
			temp2=map[R2][C2-1];
			map[R2][C2-1] = temp1;
			temp1 = temp2;
			C2--;
		}
		//위로 바람불기
		while(map[R2][C2] != -1) {
			if(map[R2-1][C2] != -1) {
				temp2=map[R2-1][C2];
				map[R2-1][C2] = temp1;
				temp1 = temp2;
				R2--;
			}else {
				break;
			}
		}
	}
	public static void main(String[] args) {
		// 입력값 설정
		int R,C,T;
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();  //R
		C = sc.nextInt();  //C
		T = sc.nextInt();  //T값
		int[][] map = new int[R][C];
		
		//미세먼지 입력
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//시작
		dustSpread(map,T);
	}
}
