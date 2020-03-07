package kakao_codinfTest;

public class kakao2017_coloringBook {
	 int cnt;
	 public void dfs(int start_m, int start_n,int[][] picture,boolean[][] visited,int color) {
		 //범위 넘어가면 return
		 if(start_m < 0 || start_n < 0 || start_m >= picture.length || start_n >= picture[start_n].length) { return ;}
		 //방문 했으면 return
		 if(visited[start_m][start_n]) { return ;}
		 //색이 없으면 방문처리 후 return
		 if(color == 0) { visited[start_m][start_n] = true; return ;}
		 //색이 다르면 return
		 if(picture[start_m][start_n] != color) { return ; }
		 
		 //방문 체크
		 visited[start_m][start_n] = true;
		 cnt++;
	
		 dfs(start_m+1,start_n,picture,visited,color);
		 dfs(start_m-1,start_n,picture,visited,color);
		 dfs(start_m,start_n+1,picture,visited,color);
		 dfs(start_m,start_n-1,picture,visited,color);
		 
	 }
	 
	
	 public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	 	  boolean[][] visited = new boolean[m][n];
	
	      for(int i =0; i<m; i++) {
	    	  cnt = 0;
	      		for(int j=0; j<n; j++) {
	      			if(visited[i][j] == false && picture[i][j] != 0) {
	      				dfs(i,j,picture,visited,picture[i][j]);
	      				if(maxSizeOfOneArea < cnt) { maxSizeOfOneArea = cnt;}
	      				numberOfArea++;
	      			}
	      		}
	      	}   
	      System.out.println("numberOfArea : " + numberOfArea + " maxSizeOfOneArea : "+ maxSizeOfOneArea);
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		kakao2017_coloringBook k = new kakao2017_coloringBook();
		
		int m,n;
		m = 6;
		n = 4;
		
		int[][] picture  = {{1,1,1,0},
							{1,2,2,0},
							{1,0,0,1},
							{0,0,0,1},
							{0,0,0,3},
							{0,0,0,3}};
		
		k.solution(m, n, picture);
		//System.out.println(k.solution(m, n, picture));
		
	}

}
