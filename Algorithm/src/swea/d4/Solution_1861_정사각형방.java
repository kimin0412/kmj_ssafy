package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
   static int[][] map;	
   static Ans result;
   
   public static void main(String[] args) throws Exception {
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   int T = Integer.parseInt(in.readLine());
	   int N;
	   StringTokenizer st;
	   for (int tc = 1; tc <= T; tc++) {
		   N = Integer.parseInt(in.readLine());
		   map = new int[N + 2][N + 2];//상하좌우 경계선(테두리)으로 활용
		   
		   for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j < N + 1; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		   
//			for (int i =0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++)
//				  System.out.print(map[i][j]+" ");
//				System.out.println();
//			}
		   
		    result = new Ans(0,0);//정답객체 사용!!
		   
		   //dfs출발
		   for(int i=1; i<N+1; i++) {
			   for(int j=1; j<=N; j++) {
				   dfs(i,j, map[i][j], 1);
			   }
		   }
		   
//		  System.out.println("#"+tc+" "+ result.toString());
		  System.out.println("#"+tc+" "+ result);
		   
	   }//tc
   }//main
   
   static int[] dr = { -1, 1, 0,   0 };
   static int[] dc = { 0, 0, -1,   1 };
                  //  위   아래   왼쪽  오른쪽
   /*
    public int compareTo(Ans o) {
	  if(this.cnt == o.cnt)
		  return this.pos - o.pos;
	  return o.cnt - this.cnt;  //카운트 된 횟수정보를 리턴	
	}
    */
   static void dfs(int r, int c, int pos, int cnt) {
	  Ans ans = new Ans(pos, cnt);
	  if(result.compareTo(ans)>0) {
		  result = ans;
	  }
	  for(int i=0; i<4; i++) {//4: 좌우상하
		  int nr = r+dr[i];
		  int nc = c+dc[i];
		  if(map[nr][nc]  == map[r][c] +1) {
			  dfs(nr, nc, pos, cnt+1);
		  }
	  }
	   
   }
   
   static class Ans{//2개이상의 속성(시작번호, 이동횟수)을 저장, 독립객체
	   int pos;//시작점의 값
	   int cnt;//내가 밟아온 칸의 갯수
	   
	public Ans(int pos, int cnt) {
		this.pos = pos;
		this.cnt = cnt;
	}
	   
	//사용자 정의 비교 메소드
	public int compareTo(Ans o) {
	  if(this.cnt == o.cnt)
		  return this.pos - o.pos;
	  return o.cnt - this.cnt;  //카운트 된 횟수정보를 리턴	
	}
	
	public String toString() {
		return this.pos+" "+this.cnt;
	}
   }//Ans
}





