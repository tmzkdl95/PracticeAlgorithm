import java.util.Scanner;

public class make1 {
	static int[] num = new int[1000001];
	
	public static int min(int a,int b) {
		return a<b?a:b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		num[1] = 0; 
		if (num[n] == 0) {
			for (int i = 2; i <= n; i++) {
				// 1을 뺸 경우
				num[i] = num[i - 1] + 1;
				// 2로 나누어 떨어지는 경우 현재 값과 비교해서 작은 값 저장
				if (i % 2 == 0) {
					num[i] = min(num[i], num[i / 2] + 1);
				}
				// 3으로 나누어 떨어지는 경우 현재 값과 비교해서 작은 값 저장
				if (i % 3 == 0) {
					num[i] = min(num[i], num[i / 3] + 1);
				}
			}
			System.out.println("답 : "+ num[n]);
		}
		else {
			System.out.println("답 : "+ num[n]);
		}
	}

}
