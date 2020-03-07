import java.util.Scanner;

/* # ���� - �κ�û�ұ�
 * N x M map ����
 * û�ұ�� �ٶ󺸴� ������ ������, �� ������ ��, ��, ��, ���� �ϳ��̴�. ���� ĭ�� (r=h,c=w)�� ǥ��
 * 
 * 1. ���� ��ġ�� û���Ѵ�.
 * 2. ���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
 * 	a. ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
 *  b. ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
 *  c. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���. 
 *  d. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
 * �κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
 * 
 * # �Է� ���
 * 1. ù �ٿ� ���� N, ���� M �Է� (3 <= N,m <=50)
 * 2. �κ� û�ұⰡ �ִ� ĭ�� ��ǥ (r, c)�� �ٶ󺸴� ���� d�� �־�����. d�� 0�� ��쿡�� ������, 1�� ��쿡�� ������, 2�� ��쿡�� ������, 3�� ��쿡�� ������ �ٶ󺸰� �ִ� ���̴�.
 * 3. Map ���� �Է� ��ĭ�� 0, ���� 1�� �־���. ����� ��� �ܰ��� ��. �κ�û�ұⰡ �ִ� ĭ�� ���´� �׻� ��ĭ
 * 
 * # ���
 * 1. �κ� û�ұⰡ û���� ĭ�� ���� ���
 * 
 */

//�κ� ������ ����ִ� Ŭ����
class robotLocation{
	int h;
	int w;
	int d;
	robotLocation(int r,int c, int d){
		h = r;
		w = c;
		this.d = d;
	}
	
}
public class robotCleaner {
	
	//û�ұ� �˰���
	public void robotAlgo(int[][] map,robotLocation rb) {
		//û�ҿ��� üũ ����
		boolean[][] mapCk = new boolean[map.length][map[0].length];
		int cnt = 0; //û���� ĭ ���� ī����
		
		
		//û�� �˰��� ����
		loop:
		while(true) {
			//1.���� ��� û��
			mapCk[rb.h][rb.w] = true;
			cnt ++;
			
			//2. ���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
			// c. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���. 
			// d. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
			if(mapCk[rb.h-1][rb.w]&&mapCk[rb.h+1][rb.w]&&mapCk[rb.h][rb.w+1]&&mapCk[rb.h][rb.w-1] ||
				map[rb.h-1][rb.w] == 1 && map[rb.h+1][rb.w] == 1 && map[rb.h][rb.w-1] == 1 && map[rb.h][rb.w+1] == 1) {
				//�ڷ� ��ĭ ����
				// ���� ������ �����ΰ�� �������� ��ĭ�̵�
				if(rb.d == 0) {
					//���ʹ����� ���ΰ�� break
					if(map[rb.h+1][rb.w]==1 || rb.h+1>map.length) {
						break loop;
					}else {
						rb.h = rb.h+1;
					}
				}
				// ���� ������ ������ ��� �������� ��ĭ �̵�
				else if(rb.d == 1) {
					if(map[rb.h][rb.w-1]==1 || rb.w-1<0) {
						break loop;
					}else {
						rb.w = rb.w-1;
					}
				}
				// ���� ������ ������ ���
				else if(rb.d == 2) {
					if(map[rb.h-1][rb.w]==1 || rb.h-1<0) {
						break loop;
					}else {
						rb.h = rb.h-1;
					}
				}
				// ���� ������ ������ ���
				else if(rb.d == 3) {
					if(map[rb.h][rb.w+1]==1 || rb.w+1<map.length) {
						break loop;
					}else {
						rb.w = rb.w+1;
					}
				}
			}
			//���ʹ������� û���� ���� �����ִ� ���
			//a. ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
			//b. ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
			else {
				if(rb.d==0) {
					//a.���ʹ������ ����. ���� û���� ������ �ִ°�� ���� ȸ�� �� ��ĭ û��
					if(mapCk[rb.h][rb.w-1] == false && map[rb.h][rb.w-1] != 1) {
						mapCk[rb.h][rb.w-1] = true;
						rb.d = 1;
						rb.w = rb.w-1;
						//1�� �̵�
					}
					//b.�� �������� ȸ�� �� �ٽ� 2��
					else if(mapCk[rb.h][rb.w-1] == true && map[rb.h][rb.w-1] != 1){
						rb.d = 1;
						//2�� �̵�
					}
				}
				else if(rb.d==1) {
					if(mapCk[rb.h-1][rb.w] == false && map[rb.h-1][rb.w] != 1) {
						mapCk[rb.h-1][rb.w] = true;
						rb.d = 2;
						rb.h = rb.h-1;
						//1�� �̵�
					}
					else if(mapCk[rb.h-1][rb.w] == true && map[rb.h-1][rb.w] != 1){
						rb.d = 2;
						//2�� �̵�
					}
					
				}
				else if(rb.d==2) {
					if(mapCk[rb.h][rb.w+1] == false && map[rb.h][rb.w+1] != 1) {
						mapCk[rb.h][rb.w+1] = true;
						rb.d = 3;
						rb.w = rb.w+1;
						//1�� �̵�
					}
					else if(mapCk[rb.h][rb.w+1] == true && map[rb.h][rb.w+1] != 1){
						rb.d = 3;
						//2�� �̵�
					}
					
				}
				else if(rb.d==3) {
					if(mapCk[rb.h+1][rb.w] == false && map[rb.h+1][rb.w] != 1) {
						mapCk[rb.h][rb.w+1] = true;
						rb.d = 0;
						rb.w = rb.w+1;
						//1�� �̵�
					}
					else if(mapCk[rb.h][rb.w-1] == true && map[rb.h+1][rb.w] != 1){
						rb.d = 0;
						//2�� �̵�
					}
				}
				
			}
		}
		
		System.out.println("û����  ĭ�� ���� : "+cnt);
		
	}
	
	
	//map Print
	public static void printMap(int[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		robotCleaner rbc = new robotCleaner();
		Scanner sc = new Scanner(System.in);
		// # �Է°� �ۼ�
		// 1. ù �ٿ� ���� N, ���� M �Է� (3 <= N,m <=50)
		int N,M;
		N = sc.nextInt();
		M = sc.nextInt();
		// 2. �κ� û�ұⰡ �ִ� ĭ�� ��ǥ (r, c)�� �ٶ󺸴� ���� d�� �־�����.
		int r,c,d;
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		robotLocation rb = new robotLocation(r,c,d);
		
		//3. Map ���� �Է� ��ĭ�� 0, ���� 1�� �־���. ����� ��� �ܰ��� ��. �κ�û�ұⰡ �ִ� ĭ�� ���´� �׻� ��ĭ
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//û�� �˰��� ����
		rbc.robotAlgo(map,rb);

	}

}
