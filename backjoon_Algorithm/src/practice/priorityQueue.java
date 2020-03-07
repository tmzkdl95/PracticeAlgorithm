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
 * �켱���� ť �����
 * �Է°��� �󵵼��� ���� ��µǴ� ť �����
 * ����
 * �Է°� : enqueue 1,2,3,1,2,2,3 dequeue, dequeue, dequeue
 * ��°� : 2 1 3
 * ť ���� : {1,2,2,3}
 * Ǯ�� :
 * 1) q : {1,2,3,1,2,2,3} -> 2�� 3���� ���� ����, ���� ���� ���Ե� 2 dequeue -> ��� : 2
 * 2) q : {1,3,1,2,2,3} -> 1 2��, 2 2��, 1�� �켱 ���ԵƱ⶧���� ���� �� 1 dequeue -> ��� : 1
 * 3) q : {3,1,2,2,3} -> 2 2��, 3 2��, 3�� �켱 ���ԵƱ⶧���� ���� �� 3 dequeue -> ��� : 3
 * 4) ť ���� ��� -> q : {1,2,2,3} 
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
		 * q�� �����ϱ� �� ���� �󵵼��� ���ϴ� �迭�� ������
		 */
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); // �󵵼� max�� ã�� ���� pq
		ArrayList<Integer> arr = new ArrayList<Integer>(); // �Է°��� ������ �迭 arr

		//enqueue = add
		//dequeue = remove�� �д� �Լ��� ����� ��
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(3);


		// dequeue �Էµȸ�ŭ �ݺ�
		for (int n = 0; n < 3; n++) {
			Map<Integer, Integer> h = new HashMap<Integer, Integer>(); // �Է°��� �󵵼��� ������ Map h
			System.out.println(n+1+"��° start");
			System.out.println("arr : " + arr);
			// 1. �� ���� �󵵼� �ľ�
			for (int i = 0; i < arr.size(); i++) {
				// �����ϰ� �ִٸ� �ش� �� value + 1
				if (h.containsKey(arr.get(i))) {
					h.put(arr.get(i), h.get(arr.get(i)) + 1);
				} else {
					h.put(arr.get(i), 1);
				}
			}
			System.out.println("h : "+h);
			
			// 2. hash�� �ִ� key,value pq�� ����
			Iterator<Integer> itr = h.keySet().iterator();
			ArrayList<Integer> arr_frq = new ArrayList<Integer>();
			int temp;
			while (itr.hasNext()) {
				temp = itr.next();
				pq.add(new Node(temp, h.get(temp)));
			}
			
			
			// 3. pq���� �󵵼��� ���� �������� ������ Map ����
			// hash���� ó������ ����������, hash���� max���� �̾Ƴ��� ����� ����
			int max = pq.peek().v;
			while (!pq.isEmpty()) {
				if (max == pq.peek().v) {
					arr_frq.add(pq.peek().k);
				}
				pq.poll();
			}

			System.out.println("frq : " + arr_frq);
			// 4. arr���� 1���� Ž���ϸ� �켱������ ���� ���� ���� ����� map�� contain �Ǿ������� �װ� ����
			loop:
			for (int i = 0; i < arr.size(); i++) {
				for (int j = 0; j < arr_frq.size(); j++) {
					if (arr.get(i) == arr_frq.get(j)) {
						arr.remove(i);
						break loop;
					}
				}
			}
			System.out.println("����� arr: " + arr);
			//1��ƾ ��
		}
	}

}
