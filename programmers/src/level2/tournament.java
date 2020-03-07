package level2;

public class tournament {
	  public int solution(int n, int a, int b)
	    {
	        int answer = 1;
	        int next_a = 0;
	        int next_b = 0;
	        while(n/2>0){
	       
	            if(a%2==1) {next_a = (a+1)/2;}
	            else next_a = a/2;
	            if(b%2==1) {next_b = (b+1)/2;}
	            else next_b = b/2;
	        
	            if(next_a ==1 && next_b == 2 || next_a==2 && next_b==1){
	            	System.out.println("next_a = "+next_a +", next_b = " +next_b);
	                answer ++;
	                break;
	           }else if(next_a==next_b) {
	        	    break;
	           }
	            else{
	                 answer++;
	                 a = next_a; b = next_b;
	            }
	        }
	        System.out.println(answer);
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		tournament t = new tournament();
		t.solution(8, 1, 2);

	}

}
