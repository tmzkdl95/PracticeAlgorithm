package kakao_codinfTest;

public class test {
	
	public void dfs(int start,String[] num, boolean[] visited,int cnt,String temp) {
		
	}
	
	public String solution(String number, int k) {
	        String answer = "";
	        String temp="";
	        String[] num = number.split("");
	        int cnt = k;
	       for(int i=0; i<num.length; i++) {
	    	   boolean[] visited = new boolean[number.length()];
	    	   dfs(i,num,visited,cnt,temp);
	       }
	        	
	        
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test t = new test();
		String number = "1924";
		int k = 3;
 		t.solution(number, k);

	}

}
