package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* [����]
 * �������� �����̴� ���� �տ��� ���� ������ ��ϰ� �ִ�. �� �������� 1 ���� n ���� ��ȣ�� �Ű��� n ���� ���� ������ ������ �ִ�.
 * ���� ��ħ ��� ���� ������ ��� �ִ� ���¿��� ������ �����ϸ�, ������ ���� ������� ��ȴ�.
 * ���� �����忡 �����ϸ�, �����̴� ����ִ� ���� ������ �ִ��� �˻��Ѵ�.
 * ����ִ� ������ ���ٸ�, �� ������ ���� ������ ������ �Ա����� ��ٸ��� �Ѵ�.
 * �� ���� ������ ������ �����̴� ��ٷ� ������ ��Ű��, ���� ������ ���� �� ��ȣ�� ���� ���� ���� ������ �����ϵ��� �Ѵ�.
 * ���� ������ ��ٸ��� ������ ���� ����, �Ա��� �����ҿ��� �ڱ� ���ʸ� ��ٷ��� �Ѵ�. �����ڵ��� ���ǰ� �ٸ��� ������ ��ġ�⸦ ���� �ʴ´�.
 * ��������� ������ ���Կ� ���� �������� ���� å���� ���� ���Դ� �ݾ��� ���� �����̴�. �����̳� �����忡���� ���� �̿�Ǹ��� �Ǹ��ϱ� ������ �̿�ð��� �������� �ʴ´�.
 * �����̴� ���� �������� �̿��� m ���� �������� ������ ������ ������ �˰� �ִ�.
 * �������� �������� ���� �Ϸ� ������� �� ������ ����ϴ� ���α׷��� �ۼ��϶�.
 * 
 * 
 * [�Է�]
 * ù��° �ٿ� �׽�Ʈ ���̽� �� TC
 * ����  TC���� �׽�Ʈ ���̽��� �� �ٷ� ���еǾ� �־�����.
 * �� �׽�Ʈ���̽��� ������ ���� �־�����
 * ù ��° �ٿ� �ڿ���  n ��  m �� �־�����. (1 �� n  �� 100, 1 �� m  �� 2000)
   n ���� �ٿ� i ��° ���� ������ ���� ���Դ� ��� Ri �� ������ �־�����. (1 �� Ri  �� 100)
   m ���� �ٿ� ���� i �� ���� Wi �� ������ �־�����. ������ȣ i �� ������ ���� ������ �ƹ��� ���谡 ����. (1 �� Wi  �� 10000)
      ����  2m ���� �ٿ� �������� ������ ���� ������ �ϳ��� ����  x �� �־�����.
      �־��� ���� x �� �����, x �� ���� �����忡 ������ ���Ѵ�.
   x �� ������, -x �� ���� �������� ������ ���Ѵ�.
   
      �����忡 ������ ���� ������ �����忡�� ������ ���� �־����� �ʴ´�.
   1 ������ m ������ ��� ������ ��Ȯ�ϰ� �� ���� �����忡 ������, �� ���� �����忡�� ������.
      ���� �Ա����� ��� ���� ������ ������ ���� ���ϰ� �׳� ���ư��� ���� ����.
      
 * [���]
 * �� �׽�Ʈ ���̽����� ��#t ��(t �� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ�, �����̰� ���� �Ϸ����� ������� ������ ����϶�.
 * 
 * ���� 
[�Է�]
2      // �׽�Ʈ ���̽� ���� TC = 2
3 4    // ù ��° �׽�Ʈ ���̽� n = 3,  m = 4
2      // ���� ���Դ� ��� R_i = {2, 3, 5}
3      
5
2      // ������ ���� W_i = {2, 1, 3, 8}
1
3
8
3      // i = 3 �� ������ ����
2      // i = 2 �� ������ ����
-3     // i = 3 �� ������ ����
1      // i = 1 �� ������ ����
4      // i = 4 �� ������ ����
-4     // i = 4 �� ������ ����
-2     // i = 2 �� ������ ����
-1     // i = 1 �� ������ ����
2 4    // �� ��° �׽�Ʈ ���̽� n = 2,  m = 4
5      // ���� ���Դ� ��� R_i = {5, 2}
2
100    // ������ ���� W_i = {100, 500, 1000, 2000}
500
1000
2000
3     // i = 3 �� ������ ����
1     // i = 1 �� ������ ����
2     // i = 2 �� ������ ����
4     // i = 4 �� ������ ����
-1     // i = 1 �� ������ ����
-3     // i = 3 �� ������ ����
-2     // i = 2 �� ������ ����
-4     // i = 4 �� ������ ����

[���]

#1 53       // ù ��° �׽�Ʈ ���̽� ���
#2 16200	// �� ��° �׽�Ʈ ���̽� ���
*/

public class jinyungParkTower_9280 {
	
	//�������� ������� Ȯ������ �޼���
	public static int ck_Ri(int[] R_i,boolean flag) {
		if()
		
		return flag;
	}

	public static void main(String[] args) {
		
		int TC = 0;
		int n=0;
		int m=0;
		int x=0;
		int count = 0;
		int[] R_i;
		int[] W_i;
		boolean flag = true; //���������� ������� ���θ� Ȯ���ϴ� flag
		int[] ck_R;  //�������� üũ�ϱ� ���� �迭
		
		Queue<Integer> in_x = new LinkedList<Integer>();
		Queue<Integer> out_x = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt(); // TC �Է�
		n = sc.nextInt();  // n �� �Է�
		m = sc.nextInt(); // m �� �Է�
		R_i = new int[n];
		ck_R = new int[n];
		W_i = new int[m];
		
		// R_i �Է�
		for(int i=0; i<n; i++) {
			R_i[i] = sc.nextInt();
		}
		// W_i �Է�
		for(int i=0; i<m; i++) {
			W_i[i] = sc.nextInt();
		}
		
		//2m���� x�� �Է�
		for(int i=0; i<2*m; i++) {
			x = sc.nextInt(); // x�� �ޱ�
			
			if(x>0) {
				in_x.add(x);
			}else {
				out_x.add(Math.abs(x));
			}
		}
		
		//in_x�� null�� �ɶ����� ����
		while(!in_x.isEmpty()) {
			//�������� �ִ°��
			if(flag) {
				//��ȣ�� ������ ����� ����
				for(int i=0; i<R_i.length; i++) {
					if(ck_R[i] == 0) {
						ck_R[i] = in_x.peek();
						in_x.poll();
						break;
					}
				}
			}
			//���������� ���� ���
			else {
				//in_x���� out_x.peek�� ã�Ƽ� poll
				
				out_x.poll();
				flag = true;
			}
		}

	}

}