import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] t = new int[n];
		
		for(int i=0; i<n; i++) {
			t[i] = sc.nextInt();
		}
		
		Arrays.sort(t);
		int[] delay = new int[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				delay[i] += t[j];
			}
		}
		int sum = 0;
		for(int i : delay) {
			sum +=i;
		}
		System.out.println(sum);

	}

}
