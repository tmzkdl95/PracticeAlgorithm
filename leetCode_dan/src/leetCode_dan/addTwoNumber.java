package leetCode_dan;


/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * 
 * parseInt 사용하면 범위 초과로 에러발생
 */



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class addTwoNumber {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = l1;
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		String num1;
		String num2;
		
		//l1값 추출
		while(l1.next != null) {
			sb1.append(l1.val);
			l1 = l1.next;
		}
		sb1.append(l1.val);
		num1 = sb1.reverse().toString();
		
		//l2 값 추출
		while(l2.next != null) {
			sb2.append(l2.val);
			l2 = l2.next;
		}
		sb2.append(l2.val);
		num2 = sb2.reverse().toString();
		
		//add Two num 
		
		double temp = Double.parseDouble(num1) + Double.parseDouble(num2);
		System.out.println("double : "+temp);
		/*
		System.out.println("str = "+str);
	    
	    ListNode node;
	    answer = new ListNode(Integer.parseInt(str.substring(0,1)));
	    node = answer;
	    for(int i=1; i<str.length(); i++) {
	    	answer = new ListNode(Integer.parseInt(str.substring(i,i+1)));
		    answer.next = node;
		    node = answer;
	    }*/
		return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addTwoNumber s1 = new addTwoNumber();
		String num="";
		StringBuffer sb = new StringBuffer();
		
		ListNode temp;
		
		//make l1
		ListNode l1 = new ListNode(2);
		temp = l1;
		
		l1 = new ListNode(4);
		l1.next = temp;
		temp = l1;
		
		l1 = new ListNode(3);
		l1.next = temp;
		temp = l1;
		
		//make l2
		ListNode l2 = new ListNode(5);
		temp = l2;
		
		l2 = new ListNode(6);
		l2.next = temp;
		temp = l2;
		
		l2 = new ListNode(4);
		l2.next = temp;
		temp = l2;
		
		ListNode answer = s1.addTwoNumbers(l1, l2);
		
		
		System.out.println("test : "+ Double.parseDouble("9999999991"));
		/*
		while(answer.next != null) {
			System.out.println(answer.val);
			answer = answer.next;
		}
		System.out.print(answer.val+" ");
		*/
		

	}

}
