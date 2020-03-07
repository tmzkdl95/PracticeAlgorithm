package level2;
//피보나치 수열...
public class long_jump {

	public long fibo(int n) {
		if (n==1) {return 1;}
		else if(n==2) {return 2;}
		else if(n>2) {return fibo(n-2) + fibo(n-1);}
		
		return 0;
	}
	public long solution(int n) {
		long answer = 0;
		long n1 = 1;
		long n2 = 2;
		long next = n1+n2;
		//answer = fibo(n-1)+fibo(n-2);
		if(n == 1) { answer = 1;}
		else if (n==2) {answer = 2;}
		else {
			for(int i=1; i<=n-2; i++) {
				next = n1 + n2;
				next = next%1234567;
				n1 = n2;
				n2 = next;
			}
			answer = next;
		}
		//System.out.println(answer%1234567);
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long_jump l = new long_jump();
		
		l.solution(2000);

	}

}
