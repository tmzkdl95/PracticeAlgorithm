import java.util.Scanner;

public class ACMCraft_1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//Test Case �Է�
		int T = sc.nextInt();
		//�ǹ����� N , �ǹ� ���� ��Ģ K �Է�
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//�ǹ��� �ɸ��� �ð� (���� ���� �Է�)
		int[] D = new int[N];
		for(int i=0; i<N; i++) {
			D[i] = sc.nextInt();
		}
		
		//�ǹ� ���� X,Y
		int[][] X = new int[K][2];
		for(int i=0; i<K; i++) {
			X[i][0] = sc.nextInt();
			X[i][1] = sc.nextInt();
		}
		//�Ǽ��ؾ� �� �ǹ� W
		int W = sc.nextInt();
		
		//�ð� ���� ������ �迭 time ����
		int[] time = new int[100];
		
		time[0] = D[0];
		for(int i=0; i<X.length; i++) {
			//time = ���� ��� �� + ���� ����� D��
			time[X[i][1]] = time[X[i][0]]+D[X[i][1]];
		}
		
		for(int i:time) {
			System.out.println(" "+i);
		}
		
		
	}

}
