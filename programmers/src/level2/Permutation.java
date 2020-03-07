package level2;


/*
 * ���� ������ �ƴ�
 * ��� ���� ���� �˰��� ����� 
 */
public class Permutation {
	
	public void dfs(int start, int[] num, boolean[] visited) {
		//���� �Ѿ�� return
		if(start>visited.length) {return;}
		//�湮�Ѱ��̸� return
		if(visited[start]) {return;}
		
		System.out.print(num[start]);
		visited[start] = true;
		for(int i=0; i<num.length; i++) {
			dfs(i,num,visited);
		}
		
		
	}
	
	public void solution(int[] num) {
		
		//for(int i=0; i<num.length; i++) {
			boolean[] visited = new boolean[num.length];
			dfs(0,num,visited);
			System.out.println();
		//}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Permutation p = new Permutation();
		
		int[] num = {1,2,3};		
		p.solution(num);
		

	}

}
