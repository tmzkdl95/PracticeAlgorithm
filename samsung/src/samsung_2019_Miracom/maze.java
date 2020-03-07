package samsung_2019_Miracom;

/*
 * 1. 1(up),2(down),3(left),4(rigth)
 * 2. ���� �� - 5, �ո� �� - 6
 * 3. ���� 1�ð��� �ð�������� 1ĭ�� �̵�
 * 4. �� ��ġ���� �־��� �������� 1�ð��� 1ĭ�� �̵�
 * 5. ������ ���ٰ� ���� ������ �ո� ���� �ö����� ���
 * 6. �ո� ���� ������ ���� ���� 2ĭ ������
 * 7. ���� �� ���̿� ������ 1ĭ�� ���� ������ ����
 * 8. ��� ���� �������� map ���� �ٴٸ������� �ɸ��� �ð� return
 */
public class maze {
	
	public static void move(int start_h,int start_w,int[][] maze) {
		
		int temp_1 = maze[start_h][start_w];
		int temp_2 = 0;
		
		//������ �̵�
		while(maze[start_h][start_w+1] != 0) {
			temp_2 = maze[start_h][start_w+1];
			maze[start_h][start_w+1] = temp_1;
			temp_1 = temp_2;
			start_w = start_w+1;
		}
		//�Ʒ��� �̵�
		while(maze[start_h+1][start_w] != 0) {
			temp_2 = maze[start_h+1][start_w];
			maze[start_h+1][start_w] = temp_1;
			temp_1 = temp_2;
			start_h = start_h+1;
		}
		//�������� �̵�
		while(maze[start_h][start_w-1] != 0) {
			temp_2 = maze[start_h][start_w-1];
			maze[start_h][start_w-1] = temp_1;
			temp_1 = temp_2;
			start_w = start_w-1;
		}
		//���� �̵�
		while(maze[start_h-1][start_w] != 0) {
			temp_2 = maze[start_h-1][start_w];
			maze[start_h-1][start_w] = temp_1;
			temp_1 = temp_2;
			start_h = start_h-1;
		}
	}
	
	static void dfs(int start_h,int start_w,int maze[][],boolean[][] visited) {
		if(start_h<0 || start_w<0 || start_h>maze.length-1 || start_w>maze[0].length-1) {return;}
		if(visited[start_h][start_w]) {return ;}
		
		visited[start_h][start_w] = true;		
		//���� �����̴� �� start �����̸� ȸ��
		if(maze[start_h][start_w] > 4 && maze[start_h+1][start_w] > 4 && maze[start_h][start_w+1]> 4) {
			move(start_h,start_w,maze);
		}
		
		//�����¿� �̵�
		dfs(start_h+1,start_w,maze,visited);
		dfs(start_h-1,start_w,maze,visited);
		dfs(start_h,start_w+1,maze,visited);
		dfs(start_h,start_w-1,maze,visited);
	}
	public static void maze_print(int[][] maze) {
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int solution(int[][] maze) {
		
		int answer = 0;
		int p = 0;
		int p_h = 0;
		int p_w = 0;
		
		//maze_print(maze);
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++)
				if(maze[i][j]==1 ||maze[i][j]==2||maze[i][j]==3||maze[i][j]==4) {
					p = maze[i][j];
					p_h = i;
					p_w = j;
					break;
				}
		}
		//���� �� ���
		maze_print(maze);
		
		if(p == 1) {
			while (p_h != 0) {
				boolean[][] visited = new boolean[maze.length][maze[0].length];
				dfs(0,0,maze,visited);
				
				if (maze[p_h - 1][p_w] == 0) {
					maze[p_h][p_w] = 0;
					p_h = p_h - 1;
					maze[p_h][p_w] = p;
					answer++;
				} else if (maze[p_h - 1][p_w] == 5) {
					answer++;
				} else if (maze[p_h - 1][p_w] == 6) {
					maze[p_h][p_w] = 0;
					p_h = p_h - 2;
					maze[p_h][p_w] = p;
					answer++;
				}
			}
		}else if(p == 2) {
			while (p_h != maze.length-1) {
				boolean[][] visited = new boolean[maze.length][maze[0].length];
				dfs(0,0,maze,visited);
				
				if (maze[p_h + 1][p_w] == 0) {
					maze[p_h][p_w] = 0;
					p_h = p_h + 1;
					maze[p_h][p_w] = p;
					answer++;
				} else if (maze[p_h + 1][p_w] == 5) {
					answer++;
				} else if (maze[p_h + 1][p_w] == 6) {
					maze[p_h][p_w] = 0;
					p_h = p_h + 2;
					maze[p_h][p_w] = p;
					answer++;
				}
			}
		}else if(p == 3) {
			//left
			while (p_w != 0) {
				boolean[][] visited = new boolean[maze.length][maze[0].length];
				dfs(0,0,maze,visited);
				
				if (maze[p_h][p_w-1] == 0) {
					maze[p_h][p_w] = 0;
					p_w = p_w - 1;
					maze[p_h][p_w] = p;
					answer++;
				} else if (maze[p_h][p_w-1] == 5) {
					answer++;
				} else if (maze[p_h][p_w-1] == 6) {
					maze[p_h][p_w] = 0;
					p_w = p_w - 2;
					maze[p_h][p_w] = p;
					answer++;
				}
			}
		}else if(p == 4) {
			//left
			while (p_w != maze[0].length-1) {
				boolean[][] visited = new boolean[maze.length][maze[0].length];
				dfs(0,0,maze,visited);
				
				if (maze[p_h][p_w+1] == 0) {
					maze[p_h][p_w] = 0;
					p_w = p_w + 1;
					maze[p_h][p_w] = p;
					answer++;
				} else if (maze[p_h][p_w+1] == 5) {
					answer++;
				} else if (maze[p_h][p_w+1] == 6) {
					maze[p_h][p_w] = 0;
					p_w = p_w + 2;
					maze[p_h][p_w] = p;
					answer++;
				}
			}
		}
		
		maze_print(maze);
		
		System.out.println(answer);
		return answer;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maze m = new maze();
		/*
		int[][] maze = {{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,5,5,5,5,5,5,5,0},
						{0,5,0,0,0,0,0,5,0},
						{0,5,0,5,6,5,0,5,0},
						{0,5,0,5,1,5,0,5,0},
						{0,5,0,6,5,5,0,5,0},
						{0,5,0,0,0,0,0,5,0},
						{0,6,5,5,5,5,5,6,0},
						{0,0,0,0,0,0,0,0,0}};*/
		int[][] maze = {{0,0,0,0,0,0,0},
						{0,5,5,5,5,5,0},
						{0,5,4,0,0,6,0},
						{0,5,0,0,0,5,0},
						{0,5,5,6,5,5,0},
						{0,0,0,0,0,0,0}};
		m.solution(maze);
	}

}
