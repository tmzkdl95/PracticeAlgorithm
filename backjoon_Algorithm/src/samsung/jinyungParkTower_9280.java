package samsung;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* [문제]
 * 부지런한 진용이는 정문 앞에서 유료 주차장 운영하고 있다. 이 주차장은 1 부터 n 까지 번호가 매겨진 n 개의 주차 공간을 가지고 있다.
 * 매일 아침 모든 주차 공간이 비어 있는 상태에서 영업을 시작하며, 다음과 같은 방식으로 운영된다.
 * 차가 주차장에 도착하면, 진용이는 비어있는 주차 공간이 있는지 검사한다.
 * 비어있는 공간이 없다면, 빈 공간이 생길 때까지 차량을 입구에서 기다리게 한다.
 * 빈 주차 공간이 있으면 진용이는 곧바로 주차를 시키며, 주차 가능한 공간 중 번호가 가장 작은 주차 공간에 주차하도록 한다.
 * 만약 주차를 기다리는 차량이 여러 대라면, 입구의 대기장소에서 자기 차례를 기다려야 한다. 운전자들은 예의가 바르기 때문에 새치기를 하지 않는다.
 * 주차요금은 차량의 무게와 주차 공간마다 따로 책정된 단위 무게당 금액을 곱한 가격이다. 진용이네 주차장에서는 종일 이용권만을 판매하기 때문에 이용시간은 고려하지 않는다.
 * 진용이는 오늘 주차장을 이용할 m 대의 차량들이 들어오고 나가는 순서를 알고 있다.
 * 진용이의 주차장이 오늘 하루 벌어들일 총 수입을 계산하는 프로그램을 작성하라.
 * 
 * 
 * [입력]
 * 첫번째 줄에 테스트 케이스 수 TC
 * 이후  TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.
 * 각 테스트케이스는 다음과 같이 주어진다
 * 첫 번째 줄에 자연수  n 과  m 이 주어진다. (1 ≤ n  ≤ 100, 1 ≤ m  ≤ 2000)
   n 개의 줄에 i 번째 주차 공간의 단위 무게당 요금 Ri 가 정수로 주어진다. (1 ≤ Ri  ≤ 100)
   m 개의 줄에 차량 i 의 무게 Wi 가 정수로 주어진다. 차량번호 i 와 차량의 도착 순서는 아무런 관계가 없다. (1 ≤ Wi  ≤ 10000)
      이후  2m 개의 줄에 차량들의 주차장 출입 순서가 하나의 정수  x 로 주어진다.
      주어진 정수 x 가 양수면, x 번 차가 주차장에 들어옴을 뜻한다.
   x 가 음수면, -x 번 차가 주차장을 나감을 뜻한다.
   
      주차장에 들어오지 않은 차량이 주차장에서 나가는 경우는 주어지지 않는다.
   1 번부터 m 번까지 모든 차량은 정확하게 한 번씩 주차장에 들어오고, 한 번씩 주차장에서 나간다.
      또한 입구에서 대기 중인 차량이 주차를 하지 못하고 그냥 돌아가는 경우는 없다.
      
 * [출력]
 * 각 테스트 케이스마다 ‘#t ’(t 는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 진용이가 오늘 하룻동안 벌어들일 수입을 출력하라.
 * 
 * 예시 
[입력]
2      // 테스트 케이스 개수 TC = 2
3 4    // 첫 번째 테스트 케이스 n = 3,  m = 4
2      // 단위 무게당 요금 R_i = {2, 3, 5}
3      
5
2      // 차량의 무게 W_i = {2, 1, 3, 8}
1
3
8
3      // i = 3 인 차량이 들어옴
2      // i = 2 인 차량이 들어옴
-3     // i = 3 인 차량이 나감
1      // i = 1 인 차량이 들어옴
4      // i = 4 인 차량이 들어옴
-4     // i = 4 인 차량이 나감
-2     // i = 2 인 차량이 나감
-1     // i = 1 인 차량이 나감
2 4    // 두 번째 테스트 케이스 n = 2,  m = 4
5      // 단위 무게당 요금 R_i = {5, 2}
2
100    // 차량의 무게 W_i = {100, 500, 1000, 2000}
500
1000
2000
3     // i = 3 인 차량이 들어옴
1     // i = 1 인 차량이 들어옴
2     // i = 2 인 차량이 들어옴
4     // i = 4 인 차량이 들어옴
-1     // i = 1 인 차량이 나감
-3     // i = 3 인 차량이 나감
-2     // i = 2 인 차량이 나감
-4     // i = 4 인 차량이 나감

[출력]

#1 53       // 첫 번째 테스트 케이스 결과
#2 16200	// 두 번째 테스트 케이스 결과
*/

public class jinyungParkTower_9280 {
	static boolean flag; //주차공간이 비었는지 여부를 확인하는 flag
	//주차장이 빈 위치 확인히는 메서드
	public static int parkCar(int[] ck_R) {
		int num = 101;
		for(int i=0; i<ck_R.length; i++) {
			if(ck_R[i] == 0) {
				num = i;
				flag = true;
				break;
			}else {
				flag = false;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		
		int TC = 0;
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt(); // TC 입력
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int k=0; k<TC; k++) {
			
			int n=0;
			int m=0;
			int x=0;
			int value = 0;
			int count = 0;
			int parkNum = 0;
			int[] R_i;
			int[] W_i;
			
			int[] ck_R;  //주차공간 체크하기 위한 배열
			int[] ck_W;  //주차위치 확인하기 위한 배열

			
			ArrayList<Integer> in_arr = new ArrayList<Integer>();
			flag = true; //flag 초기화, 최초 = true 
			n = sc.nextInt();  // n 값 입력
			m = sc.nextInt(); // m 값 입력
			R_i = new int[n];
			ck_R = new int[n];
			W_i = new int[m];
			ck_W = new int[m];
			
			// R_i 입력
			for(int i=0; i<n; i++) {
				R_i[i] = sc.nextInt();
			}
			// W_i 입력
			for(int i=0; i<m; i++) {
				W_i[i] = sc.nextInt();
			}
			
			//2m개의 x값 입력
			for(int i=0; i<2*m; i++) {
				x = sc.nextInt(); // x값 받기
				in_arr.add(x);
			}
		
		//in_x가 null이 될때까지 진행
		int arrNum=0;
		while(!in_arr.isEmpty()) {
			//주차공간 확인
			parkCar(ck_R);
			//주차공간 있는경우
			if(flag) {
					//차량 입장
					if(in_arr.get(arrNum)>0) {
						//빈자리 확인
						parkNum = parkCar(ck_R); //주차할 자리 부여
						//주차
						ck_R[parkNum] = in_arr.get(arrNum);
						ck_W[in_arr.get(arrNum)-1] = parkNum;
						value = W_i[ck_R[parkNum]-1]*R_i[parkNum];
						count += value;
						in_arr.remove(arrNum);
					}else {
						//주차 빠지기
						ck_R[ck_W[Math.abs(in_arr.get(arrNum))-1]] = 0;
						in_arr.remove(arrNum);
					}
				
			}//주차공간이 없는경우
			else {
				for(int j=0; j<in_arr.size(); j++) {
					if(in_arr.get(j)<0) {
						//주차 빼기
						ck_R[ck_W[Math.abs(in_arr.get(j))-1]] = 0;
						in_arr.remove(j);
						break;
					}
				}
			}
		}
			answer.add(count);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println("#"+(i+1)+" "+answer.get(i));
		}
	}
	
}
