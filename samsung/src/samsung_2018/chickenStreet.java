package samsung_2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class node{
	int x;
	int y;
	int vote = 0;
	node(int y,int x){
		this.x = x+1;
		this.y = y+1;
	}
}

public class chickenStreet {
	static int[][] map;
	static int n;
	static int m;
	
	static int answer = 9999999;
	static Stack<node> select = new Stack<node>();
	static ArrayList<node> chicken  = new ArrayList<node>();
	static ArrayList<node> home  = new ArrayList<node>();
	
	public void dfs(int start) {
			
		if(select.size() == m) {
			int sum = 0;
			for(int i=0; i<select.size(); i++) {
				System.out.print(select.get(i).y +","+select.get(i).x +" ");
			}
			System.out.println(select.size());
			for(int i=0; i<home.size(); i++) {
				int min=999999;
				for(int j=0; j<select.size(); j++) {
					if(min > Math.abs((home.get(i).x - select.get(j).x))+Math.abs((home.get(i).y - select.get(j).y))) {
						min = Math.abs((home.get(i).x - select.get(j).x))+Math.abs((home.get(i).y - select.get(j).y));
						
					}
				}
				sum += min;
			}
			if(answer > sum) {
				answer = sum;
			}
			return ;
		}
		
		for(int i = start; i<chicken.size(); i++) {
			select.push(chicken.get(i));
			dfs(i + 1);
			select.pop();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		chickenStreet c = new chickenStreet();
		map = new int[n][n];
	
		//도시 정보 받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = s.nextInt();
				if(map[i][j] == 1){ home.add(new node(i,j));}
				if(map[i][j] == 2){ chicken.add(new node(i,j));}
			}
		}
		
		//치킨집 선택하기
		c.dfs(0);
		
		System.out.println(answer);

	}

}
