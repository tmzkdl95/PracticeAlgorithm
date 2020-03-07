package level2;

import java.util.LinkedList;
import java.util.Queue;

public class bridge_truck {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer>  q = new LinkedList<Integer>();
        
        if(bridge_length>=truck_weights[0]) {
        	q.add(truck_weights[0]);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bridge_truck b = new bridge_truck();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		b.solution(bridge_length, weight, truck_weights);
	}

}
