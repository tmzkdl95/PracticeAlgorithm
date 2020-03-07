package level2;

import java.util.ArrayList;

public class String_min_max {
	public String solution(String s) {
		String answer ="";
		ArrayList<String> arr = new ArrayList<>();
		int i=0;
		while(true) {
			if(i>=s.length()-1) {answer += s.charAt(i); arr.add(answer); break;}
			
			answer += s.charAt(i);
			++i;
				
			if(s.charAt(i)==' ') {
					i++;
					arr.add(answer);
					answer = "";
				}
		}
		System.out.println(arr);
			
			int min = Integer.parseInt(arr.get(0));
			int max = Integer.parseInt(arr.get(0));
			for(int j=0; j<arr.size(); j++) {
				if(min > Integer.parseInt(arr.get(j))) {min =Integer.parseInt(arr.get(j));}
				if(max < Integer.parseInt(arr.get(j))) {max =Integer.parseInt(arr.get(j));}
			}
		
		return min+" "+max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String_min_max smm = new String_min_max();
		
		String s = "1 2 3 4";
		smm.solution(s);
	}

}
