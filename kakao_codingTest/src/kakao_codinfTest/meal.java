package kakao_codinfTest;

import java.util.ArrayList;

public class meal {
	
	public String solution(String s) {
	      String answer = "";
	      ArrayList<String> arr = new ArrayList<>();
	      String temp="";
	    	for(int i=0; i<s.length(); i++) {
	    	   if(s.charAt(i)==' ') { continue;}
	    	   else{
	    		   while(s.charAt(i)!=' ') {
		    		  temp +=s.charAt(i);
		    		  ++i;
		    		  if(i>=s.length()) {break;}
		    		}
	 	    	  arr.add(temp);
	 	    	  temp = "";
	    	   }
	    	}
	    	 int min=Integer.parseInt(arr.get(0));
		     int max=Integer.parseInt(arr.get(0));
		      for(int i=1; i<arr.size(); i++) {
		    	 if(Integer.parseInt(arr.get(i)) < min){ min = Integer.parseInt(arr.get(i));}
		    	 if(Integer.parseInt(arr.get(i)) > max){ max = Integer.parseInt(arr.get(i));}
		      }
	      
		  System.out.println(min+" "+max);
	      return min+" "+max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		meal m = new meal();
		String s = "-102 113";
	
		m.solution(s);

	}

}
