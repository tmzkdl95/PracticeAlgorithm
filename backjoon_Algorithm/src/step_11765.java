
import java.util.Scanner;

public class step_11765 {
	public static int MAX(int a, int b) {
		return a>b?a:b;
	}
	

	public static int solution(int[] stair){
		int answer = 0;
		int[] dp = new int[stair.length];
		// ���� 3��� Ȯ�� (���� ��� ��, ���� ��� �� �� 3�̸� 2ĭ)
		int cnt = 0;
		// ���ؼ� 1ĭ Ȥ�� 2ĭ �� ū �� �Է�
		//ù��° ĭ
		dp[0] = stair[0];
		//�ι�° ĭ = ��ĭ�� ��� ��� vs �ѹ��� 2ĭ ��� ��� 
		dp[1] = MAX(stair[0]+stair[1],stair[1]);
		//����° ĭ =
		dp[2] = MAX(stair[1]+stair[2],stair[0]+stair[2]);
		
		//nĭ���� �ݺ�
		for(int i=3; i<stair.length; i++) {
			//2ĭ �ö󰡴� ��� vs 1ĭ�� �ö󰡴� ���(��, ���� 3�� �ȵǱ⶧���� 3��° ��ĭ �� ����)
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
