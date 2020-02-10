package swea.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Solution_D3_3431_준환이의운동관리 {
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T =sc.nextInt();
        List arr= new ArrayList();
        for (int i = 0; i < T; i++) {
            int L=sc.nextInt();
            int U=sc.nextInt();
            int X=sc.nextInt();
             
            int result=gym(L,U,X);
            arr.add(result);
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("#"+(i+1)+" "+arr.get(i));
        }
         
    }
    public static int gym(int L,int U,int X){
        int time=0;
        if(X<L){
            time=L-X;
        }else if(X>U){
            time=-1;
        }
        return time;
    }
     
}  