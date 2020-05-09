package samsung_swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * �̼������� �����ϱ� ���� ������� ����û���⸦ ��ġ�Ϸ��� �Ѵ�.
 * ����û������ ������ �׽�Ʈ�ϱ� ���� ������� ���� ũ�Ⱑ R��C�� ���������� ��Ÿ�°�, 1��1 ũ���� ĭ���� ������. 
 * ������� �پ �ڵ� �Ƿ��� �̿��� �� ĭ (r, c)�� �ִ� �̼������� ���� �ǽð����� ����͸��ϴ� �ý����� �����ߴ�.
 * (r, c)�� r�� c���� �ǹ��Ѵ�.
 *
����û����� �׻� 1�� ���� ��ġ�Ǿ� �ְ�, ũ��� �� ���� �����Ѵ�. ����û���Ⱑ ��ġ�Ǿ� ���� ���� ĭ���� �̼������� �ְ�, (r, c)�� �ִ� �̼������� ���� A(r,c)�̴�.

1�� ���� �Ʒ� ���� ���� ������� �Ͼ��.

1. �̼������� Ȯ��ȴ�. Ȯ���� �̼������� �ִ� ��� ĭ���� ���ÿ� �Ͼ��.
 -(r, c)�� �ִ� �̼������� ������ �� �������� Ȯ��ȴ�.
 -������ ���⿡ ����û���Ⱑ �ְų�, ĭ�� ������ �� �������δ� Ȯ���� �Ͼ�� �ʴ´�.
 -Ȯ��Ǵ� ���� Ar,c/5�̰� �Ҽ����� ������.
 -(r, c)�� ���� �̼������� ���� A(r,c) - (A(r,c)/5)��(Ȯ��� ������ ����) �̴�.
2. ����û���Ⱑ �۵��Ѵ�.
 -����û���⿡���� �ٶ��� ���´�.
 -���� ����û������ �ٶ��� �ݽð�������� ��ȯ�ϰ�, �Ʒ��� ����û������ �ٶ��� �ð�������� ��ȯ�Ѵ�.
 -�ٶ��� �Ҹ� �̼������� �ٶ��� ������ ��� �� ĭ�� �̵��Ѵ�.
 -����û���⿡�� �δ� �ٶ��� �̼������� ���� �ٶ��̰�, ����û����� �� �̼������� ��� ��ȭ�ȴ�.
Ȯ�꿹��
 0��            1��     
000     010    
050  -> 111
000     010

 0��            1��             
500     310    
000  -> 100
000     000

[�Է�]
ù° �ٿ� R, C, T (6 �� R, C �� 50, 1 �� T �� 1,000) �� �־�����.
��° �ٺ��� R���� �ٿ� Ar,c (-1 �� Ar,c �� 1,000)�� �־�����.
����û���Ⱑ ��ġ�� ���� Ar,c�� -1�̰�, ������ ���� �̼������� ���̴�.
-1�� 2�� ���Ʒ��� �پ��� �ְ�, ���� �� ��, �Ʒ� ��� �� ĭ�̻� ������ �ִ�.

[���]
ù° �ٿ� T�ʰ� ���� �� ����� �濡 �����ִ� �̼������� ���� ����Ѵ�.

-�����Է� 1
7 8 1
 0 0 0 0 0 0 0 9
 0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
 0 0 0 0 0 10 43 0
 0 0 5 0 15 0 0 0
 0 0 40 0 0 0 20 0
-��� 1
188

-�����Է� 2
7 8 3
 0 0 0 0 0 0 0 9
 0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
 0 0 0 0 0 10 43 0
 0 0 5 0 15 0 0 0
 0 0 40 0 0 0 20 0
-���2
186

-�����Է�3
7 8 4
 0 0 0 0 0 0 0 9
 0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
 0 0 0 0 0 10 43 0
 0 0 5 0 15 0 0 0
 0 0 40 0 0 0 20 0

-���3
178


���� �׽�Ʈ
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

//public class Main   //���� �����
public class dustCleaner {
	
	//map�ʱ�ȭ �޼���
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
		//û���� ��ġ �ޱ�
		int R1 = 0;
		int C1 = 0;
	
		//T�ʵ��� �ݺ�
		for(int time=0; time<T; time++) {
			//�̼����� Ȯ��
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					
					//1. ����û���� ��ġ�����̰ų�, �������� 0�ΰ�� ���� ����.
					if(map[i][j] != -1 && map[i][j] != 0) {
						lftDust = map[i][j];
						sprdDust = map[i][j]/5;
						
						//2. �����¿� ������
						//���� �̵� 
						//��ġ�Ȱ��� map ���� �Ѿ�°� ����
						if(i-1>=0 && map[i-1][j] != -1) {
							q.add(new dust(i-1,j,sprdDust));
							lftDust -= sprdDust;
						}
						//������ �̵�
						if(j+1<map[i].length && map[i][j+1] != -1) {
							q.add(new dust(i,j+1,sprdDust));
							lftDust -= sprdDust;
						}
						//�Ʒ� �̵�
						if(i+1<map.length && map[i+1][j] != -1) {
							q.add(new dust(i+1,j,sprdDust));
							lftDust -= sprdDust;
						}
						//���� �̵�
						if(j-1>=0 && map[i][j-1] != -1) {
							q.add(new dust(i,j-1,sprdDust));
							lftDust -= sprdDust;
						}
						//������ ���
						q.add(new dust(i,j,lftDust));
					}else if(map[i][j] == -1) {
						R1 = i;
						C1 = j;
					}
				}
			}
			//2. ���� Ȯ�� �� map�� �����ϱ�
			clearMap(map); //�켱 �� �ʱ�ȭ
			while(!q.isEmpty()) {
				map[q.peek().r][q.peek().c] += q.peek().cnt;
				q.poll();
			}
			
			//3. ����û���� �ߵ� R1,C1
			cycle(map,R1);
		}
		
		//4. ��ü �̼������� ���ϱ�
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				//û���� ��ġ ���� �� ���ϱ�
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
		//����û���� �ߵ� R1,C1
		int temp1=map[R1][C1+1];
		int temp2=0;
		
		//����û���� �ٷ� ���� �׻�0�̵ȴ�.
		map[R1][C1+1] = 0;
		C1 += 1;
		//������ �ٶ��ұ�
		while(C1 != map[0].length-1) {
			temp2=map[R1][C1+1];
			map[R1][C1+1] = temp1;
			temp1 = temp2;
			C1++;
		}
		//���� �ٶ��ұ�
		while(R1 != 0) {
			temp2=map[R1-1][C1];
			map[R1-1][C1] = temp1;
			temp1 = temp2;
			R1--;
		}
		//�������� �ٶ��ұ�
		while(C1 != 0) {
			temp2=map[R1][C1-1];
			map[R1][C1-1] = temp1;
			temp1 = temp2;
			C1--;
		}
		//�Ʒ��� �ٶ��ұ�
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
		
		//�ݽð�������� ����
		temp1=map[R2][C2+1];
		temp2=0;
		//����û���� �ٷ� ���� �׻�0�̵ȴ�.
		map[R2][C2+1] = 0;
		C2 += 1;
		//������ �ٶ��ұ�
		while(C2 != map[0].length-1) {
			temp2=map[R2][C2+1];
			map[R2][C2+1] = temp1;
			temp1 = temp2;
			C2++;
		}
		//�Ʒ� �ٶ��ұ�
		while(R2 != map.length-1) {
			temp2=map[R2+1][C2];
			map[R2+1][C2] = temp1;
			temp1 = temp2;
			R2++;
		}
		//�������� �ٶ��ұ�
		while(C2 != 0) {
			temp2=map[R2][C2-1];
			map[R2][C2-1] = temp1;
			temp1 = temp2;
			C2--;
		}
		//���� �ٶ��ұ�
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
		// �Է°� ����
		int R,C,T;
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();  //R
		C = sc.nextInt();  //C
		T = sc.nextInt();  //T��
		int[][] map = new int[R][C];
		
		//�̼����� �Է�
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//����
		dustSpread(map,T);
	}
}
