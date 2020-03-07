
import java.util.Scanner;

public class RGB_load {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=0;
		n = sc.nextInt();
		//red green blue ют╥б
		int[][] paint = new int[n][3];
		int[][] sum = new int[n][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				paint[i][j] = sc.nextInt();
			}
		}
		
		sum[0][0] = paint[0][0];
		sum[0][1] = paint[0][1];
		sum[0][2] = paint[0][2];
		
		
		for(int i=1; i<n; i++) {
				sum[i][0] = ((sum[i-1][1]>sum[i-1][2])?sum[i-1][2]:sum[i-1][1]) + paint[i][0];
				sum[i][1] = ((sum[i-1][0]>sum[i-1][2])?sum[i-1][2]:sum[i-1][0]) + paint[i][1];
				sum[i][2] = ((sum[i-1][0]>sum[i-1][1])?sum[i-1][1]:sum[i-1][0]) + paint[i][2];
		}
		
		//System.out.println(sum[n-1][0]+" "+sum[n-1][1]+" "+sum[n-1][2]);
		int min = sum[n-1][0];
		if(min>sum[n-1][1]) { min = sum[n-1][1];}
		if(min>sum[n-1][2]) { min = sum[n-1][2];}
		System.out.println(min);

	}

}
