
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static char[][] map;
	static int R, C;
	static int ans;
	static int[] di = { -1, 0, 1 }; // 다음열 ==> 위, 중간, 아래

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		//입력
//		String str;
//		for(int i=0; i<R; i++) {
//			str= br.readLine();
//		  for(int j=0; j<C; j++) {
//			 map[i][j]=str.charAt(j);
//		  }
//		}
		
		//입력 초기화
		for(int i=0; i<R; i++){
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R  ; i++) {//행수 만큼 반복!!
			if(dfs(i,0))ans++; 
		}
		
		System.out.println(ans);//연결 파이프 수		
	}//main

	private static boolean dfs(int i, int j) {//연결가능하면 true리턴
	   //int[] di = { -1, 0, 1 };
	   for(int d=0; d<3; d++) {//(방향)3번 반복
		  int ni= i+di[d];
		  int nj= j+1;
		 if(ni>-1 && ni<R && map[ni][nj]=='.') {//파이프를 놓을 수 있는 자리인지? 
		   if(nj == C-1)  //맨 마지막 열에 도착 했다면
		     return true;
		   map[ni][nj]='x';
		   if(dfs(ni,nj))
			   return true;
		 }
	   }//for
		return false;
	}
}






