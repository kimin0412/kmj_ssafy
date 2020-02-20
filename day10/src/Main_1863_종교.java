
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
   
   static int[] parents;
   
   public static void main(String[] args) throws Exception{
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       StringTokenizer st = new StringTokenizer(str);
       int N = Integer.parseInt(st.nextToken()); // 사람 수
       int M = Integer.parseInt(st.nextToken()); // 쌍의 수
       
       parents = new int[N+1];
       //{000000}
       
       //makeSet
       for(int i = 1; i < N+1; i++)
           parents[i] = i;
       //{1234567}
       
       //만약 1번학생과 5번학생이 같은 종교!!//{1,2,3,4,1,6,7}
       for(int i = 0; i < M; i++) {
       	   str = br.readLine();
           st = new StringTokenizer(str);
           int x = Integer.parseInt(st.nextToken()); 
           int y = Integer.parseInt(st.nextToken()); 
           union(x,y);
       }
       
       //루트노드의 수를 세자!!
       int cnt=0;
       for(int i=1; i<=N; i++) {
    	   //if(i==find(i))
    	   if(i==parents[i])
    		   cnt++;
       }
       System.out.println(cnt);
       
   }//main
   static int find(int x) {
       if( x == parents[x] )//1 = 1 ,5 = 5 , 5 = 1,  
           return x;
       else
           return parents[x] = find(parents[x]);  
   }
   
     static void union(int x, int y) {//x=1,y=5   x=5,y=7 
       int px = find(x);//1   5
       int py = find(y);//5   7
       parents[py] = px;//parents[5]=1   parents[7]=1
     }
}








