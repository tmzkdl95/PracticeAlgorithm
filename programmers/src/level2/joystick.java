package level2;

import java.util.HashMap;

public class joystick {
    public int solution(String name) {
    	int answer = 0;
    	//A=0 B=1 c=2 d=3 e=4 f=5 g=6 h=7 i=8 j=9 k=10 l=11 m=12 n=13
    	//    Z=1 y=2 x=3 w=4 v=5 u=6 t=7 s=8 r=9 q=10 p=11 o=12 
    	//상하 이동 계산
    	HashMap<Integer,Integer> AtoN = new HashMap<>();
    	HashMap<Integer,Integer> OtoZ = new HashMap<>();
    	AtoN.put('A'+0, 0);
    	AtoN.put('N'+0, 13);
    	for(int i=0; i<12; i++) {
    		AtoN.put('B'+i,i+1);
    		OtoZ.put('Z'-i,i+1);
    	}
    	for(int i=0; i<name.length(); i++) {
    		int temp = name.charAt(i);
    		if(AtoN.get(temp) == null) {answer += OtoZ.get(temp);}
    		else
    		   answer += AtoN.get(temp);
    	}
    	//좌우 계산 JAP if(J+A < J+P) <방향
    	int l = 0;
    	int r = name.length()-1;
    	System.out.println(answer);
    	 
    	
    	return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		joystick j = new joystick();
		String name = "JAN";
		j.solution(name);

	}

}
