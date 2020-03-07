import java.util.Scanner;

public class ACMCraft_1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//Test Case 입력
		int T = sc.nextInt();
		//건물개수 N , 건물 순서 규칙 K 입력
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//건물당 걸리는 시간 (공백 기준 입력)
		int[] D = new int[N];
		for(int i=0; i<N; i++) {
			D[i] = sc.nextInt();
		}
		
		//건물 순서 X,Y
		int[][] X = new int[K][2];
		for(int i=0; i<K; i++) {
			X[i][0] = sc.nextInt();
			X[i][1] = sc.nextInt();
		}
		//건설해야 할 건물 W
		int W = sc.nextInt();
		
		//시간 합을 저장할 배열 time 생성
		int[] time = new int[100];
		
		time[0] = D[0];
		for(int i=0; i<X.length; i++) {
			//time = 이전 노드 값 + 현재 노드의 D값
			time[X[i][1]] = time[X[i][0]]+D[X[i][1]];
		}
		
		for(int i:time) {
			System.out.println(" "+i);
		}
		
		
	}

}
