package level2;


/*
 * 백준 문제는 아님
 * 모든 숫자 조합 알고리즘 만들기 
 */
public class Permutation {
	
	public void dfs(int start, int[] num, boolean[] visited) {
		//범위 넘어가면 return
		if(start>visited.length) {return;}
		//방문한곳이면 return
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
