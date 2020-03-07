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
				// 1�� �A ���
				num[i] = num[i - 1] + 1;
				// 2�� ������ �������� ��� ���� ���� ���ؼ� ���� �� ����
				if (i % 2 == 0) {
					num[i] = min(num[i], num[i / 2] + 1);
				}
				// 3���� ������ �������� ��� ���� ���� ���ؼ� ���� �� ����
				if (i % 3 == 0) {
					num[i] = min(num[i], num[i / 3] + 1);
				}
			}
			System.out.println("�� : "+ num[n]);
		}
		else {
			System.out.println("�� : "+ num[n]);
		}
	}

}
