package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * 우선순위 큐 만들기
 * 입력값의 빈도수에 따라 출력되는 큐 만들기
 * 예제
 * 입력값 : enqueue 1,2,3,1,2,2,3 dequeue, dequeue, dequeue
 * 출력값 : 2 1 3
 * 큐 상태 : {1,2,2,3}
 * 풀이 :
 * 1) q : {1,2,3,1,2,2,3} -> 2가 3개로 제일 많음, 가장 먼저 삽입된 2 dequeue -> 출력 : 2
 * 2) q : {1,3,1,2,2,3} -> 1 2개, 2 2개, 1이 우선 삽입됐기때문에 가장 앞 1 dequeue -> 출력 : 1
 * 3) q : {3,1,2,2,3} -> 2 2개, 3 2개, 3이 우선 삽입됐기때문에 가장 앞 3 dequeue -> 출력 : 3
 * 4) 큐 상태 출력 -> q : {1,2,2,3} 
 */

class Node implements Comparable<Node> {
	int k;
	int v;

	public Node(int k, int v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public int compareTo(Node target) {
		// TODO Auto-generated method stub
		if (this.v > target.v) {
			return -1;
		} else
			return 1;
	}

}

public class priorityQueue {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String result = new String();
		Queue<String> q = new LinkedList<String>();

		/*
		 * q를 구현하기 전 현재 빈도수를 구하는 배열을 만들어보기
		 */
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); // 빈도수 max를 찾기 위한 pq
		ArrayList<Integer> arr = new ArrayList<Integer>(); // 입력값을 저장할 배열 arr

		//enqueue = add
		//dequeue = remove를 읽는 함수만 만들면 끝
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(3);


		// dequeue 입력된만큼 반복
		for (int n = 0; n < 3; n++) {
			Map<Integer, Integer> h = new HashMap<Integer, Integer>(); // 입력값의 빈도수를 저장할 Map h
			System.out.println(n+1+"번째 start");
			System.out.println("arr : " + arr);
			// 1. 각 값의 빈도수 파악
			for (int i = 0; i < arr.size(); i++) {
				// 포함하고 있다면 해당 값 value + 1
				if (h.containsKey(arr.get(i))) {
					h.put(arr.get(i), h.get(arr.get(i)) + 1);
				} else {
					h.put(arr.get(i), 1);
				}
			}
			System.out.println("h : "+h);
			
			// 2. hash에 있는 key,value pq에 삽입
			Iterator<Integer> itr = h.keySet().iterator();
			ArrayList<Integer> arr_frq = new ArrayList<Integer>();
			int temp;
			while (itr.hasNext()) {
				temp = itr.next();
				pq.add(new Node(temp, h.get(temp)));
			}
			
			
			// 3. pq에서 빈도수가 가장 많은값을 보관할 Map 생성
			// hash에서 처리하지 않은이유는, hash에선 max값을 뽑아내기 힘들기 때문
			int max = pq.peek().v;
			while (!pq.isEmpty()) {
				if (max == pq.peek().v) {
					arr_frq.add(pq.peek().k);
				}
				pq.poll();
			}

			System.out.println("frq : " + arr_frq);
			// 4. arr값을 1개씩 탐색하며 우선순위가 가장 높은 값이 저장된 map에 contain 되어있으면 그거 삭제
			loop:
			for (int i = 0; i < arr.size(); i++) {
				for (int j = 0; j < arr_frq.size(); j++) {
					if (arr.get(i) == arr_frq.get(j)) {
						arr.remove(i);
						break loop;
					}
				}
			}
			System.out.println("결과값 arr: " + arr);
			//1루틴 끝
		}
	}

}
