import java.util.ArrayList;
import java.util.Scanner;

public class make1_1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] num = new int[1000001];
		int n;
		n = sc.nextInt();
		num[1] = 0;
		num[2] = 1;
		num[3] = 1;
		for(int i=4; i<=n; i++) {
			num[i] = num[i-1]+1;
			if(i%2==0) {
				num[i] = (num[i]>(num[i/2]+1))?num[i/2]+1:num[i];
			}
			if(i%3==0) {
				num[i] = (num[i]>(num[i/3]+1))?num[i/3]+1:num[i];
			}
		}
		
		System.out.print(num[n]);

	}

}
