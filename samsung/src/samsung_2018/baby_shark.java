package samsung_2018;

public class baby_shark {

	 private static int[] X = {-1,0,1,0};
	 private static int[] Y = {0,1,0,-1};
	 private static int[][] map;
	 private static int cnt=0;
	
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		baby_shark b = new baby_shark(); 
		int[][] map = {{1,1,1,0},
					   {1,1,0,0},
					   {1,0,1,1},
					   {0,0,1,1}};
		boolean[][] check = new boolean[4][4];
		cnt = 1;
		
		b.dfs(2,2,check,map);
		
		
		
		System.out.println("-------map--------");
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(cnt);
		
		System.out.println("-------ck--------");
		for(int i=0; i<check.length; i++) {
			for(int j=0; j<check[i].length; j++) {
				System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
	}
	 
	 public void dfs(int x, int y, boolean[][] ck,int[][] map) {
		 
		 System.out.println(x+","+y);
		 ck[x][y] = true;
		 map[x][y] = 0;
		 
		 for(int i=0; i<4; i++) {
			 int nextX = x + X[i];
			 int nextY = y + Y[i];
			//상,하,좌,우 이동 중 범위가 넘어서는 경우 continue
			if(nextX <0 || nextY<0 || nextX>=ck.length || nextY>=ck.length) {continue;}
			//방문한곳은 continue
			if(ck[nextX][nextY]){continue;}
			//0은 벽이라서 이동할 경로가 벽이면 continue
			if(map[nextX][nextY] == 0) {continue;}
			
			cnt++;
			dfs(nextX,nextY,ck,map);
		 }
		 //System.out.println("END");
		 System.out.println();
		 
	 }

}
