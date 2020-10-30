package level2;

import java.util.Scanner;

public class nhn02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int day=2;
		int width=6;
//		int[][] block = new int[day][width];
		//day = 2;
		//width = 6;
		
		int[][] block = {{6,2,11,0,3,5},{6,3,0,9,0,5}};
		/*
		day = sc.nextInt();
		width = sc.nextInt();
		for(int i=0; i<day; i++) {
			for(int j=0; j<width; j++) {
				block[i][j] = sc.nextInt();
			}
		}*/
		int start = 0;
		int next_s = 0;
		int max = 0;
		int count = 0;
		int cal = 0;
		boolean right = false;
		int[] cur = new int[width];
		
		for(int i=0; i<width; i++) {
			cur[i] = 0;
		}
		//1일차
		for(int k=0; k<day; k++) {
			//1. 벽돌 쌓기
			for(int n=0; n<width; n++) {
				cur[n] = cur[n]+block[k][n];
			}
			for(int q:cur) {
				System.out.println(q);
			}
		
			//2. 시멘트 빈 공간 탐색
			for(start=1; start<width-1; start++) {
				//오른쪽이 큰 경우 다음으로 큰 벽 찾기
				for(int i=start; i<width; i++) {
					if(max<cur[i] && start-i>1) {
						max=cur[i];
						next_s = i;
						right = true;
						System.out.println("i = "+i);
						break;
					}
				}
				if(right) {
					//시멘트 계산
					for(int j=start; j<next_s; j++) {
						cal = cur[start]-cur[j];
						count += cal;
						cur[j] = cur[j]+cal;
					}
					start = next_s;
				}
				
			}
		}
		
		System.out.println("cnt : "+count);

	}

}
