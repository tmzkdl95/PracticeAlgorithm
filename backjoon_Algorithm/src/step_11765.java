
import java.util.Scanner;

public class step_11765 {
	public static int MAX(int a, int b) {
		return a>b?a:b;
	}
	

	public static int solution(int[] stair){
		int answer = 0;
		int[] dp = new int[stair.length];
		// 연속 3계단 확인 (현재 계단 층, 다음 계단 값 비교 3이면 2칸)
		int cnt = 0;
		// 비교해서 1칸 혹은 2칸 중 큰 값 입력
		//첫번째 칸
		dp[0] = stair[0];
		//두번째 칸 = 한칸씩 밟는 경우 vs 한번에 2칸 밟는 경우 
		dp[1] = MAX(stair[0]+stair[1],stair[1]);
		//세번째 칸 =
		dp[2] = MAX(stair[1]+stair[2],stair[0]+stair[2]);
		
		//n칸까지 반복
		for(int i=3; i<stair.length; i++) {
			//2칸 올라가는 경우 vs 1칸씩 올라가는 경우(단, 연속 3은 안되기때문에 3번째 전칸 값 포함)
			dp[i] = MAX(dp[i-3]+stair[i]+stair[i-1],dp[i-2]+stair[i]);
		}
		
		for(int i=0; i<stair.length; i++) {
			System.out.print(dp[i]+" ");
		}
		
		return dp[stair.length-1];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = 0;
		n = sc.nextInt();
		int[] stair = new int[n];
		
		for(int i=0; i<n; i++) {
			stair[i] = sc.nextInt();
		}

		System.out.println(solution(stair));
	}

}
