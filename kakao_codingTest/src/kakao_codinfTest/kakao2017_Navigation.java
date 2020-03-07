package kakao_codinfTest;


public class kakao2017_Navigation {

	int MOD = 20170805;
	int[] W = {0,1,-1}; //위로 가는거 제외
	int[] H = {1,0,0};
	public int dfs(int start_h, int start_w, int[][] cityMap,boolean[][] ck) {
		
		//범위가 넘어가면 return
		if(start_h <0 || start_w<0 || start_h>=cityMap.length || start_w>=cityMap[start_h].length) {
			return 0;
		}
		//방문한곳이면 return
		if(ck[start_h][start_w]) {
			return 0;
		}
		
		if(start_h == cityMap.length-1 && start_w == cityMap[start_w].length-1) {
			return 1;
		}
		ck[start_h][start_w] = true;
		//상하좌우 이동
		for(int i=0; i<3; i++) {
			int next_w = start_w+W[i];
			int next_h = start_h+H[i];
			
			dfs(next_h,next_w,cityMap,ck);
		}
		
		return 0;
	}
	
	public int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;
	      boolean[][] ck = new boolean[m][n];
	    
	      //길찾기 시작 = dfs
	      
	    
	      System.out.println(dfs(0,0,cityMap,ck)); 
	      
	      
	      return answer;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		kakao2017_Navigation k = new kakao2017_Navigation();
		int m = 3;
		int n = 3;
		int[][] cityMap = {{0,0,0},{0,0,0},{0,0,0}};
		
		k.solution(m, n, cityMap);

	}

}
