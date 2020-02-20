
import java.util.Arrays;

public class PermuCombiSubTest {
  static int[] numbers = { 1,2,3,4,5};
  static int[] ans;
  static boolean[] selected;
  static int N, R, total;
    
  public static void main(String[] args) {
	N = numbers.length;
	selected = new boolean[N];
	R = 3;
	ans = new int[R];
	permutation(0,0);
	System.out.println("total="+total);
	total=0;
	combination(0, 0);
	System.out.println("total="+total);
	total=0;
	subset(0);
	System.out.println("total="+total);
  }
  /*
   순열(nPr) - 순서있는 나열
	1. 대상: 서로다른 n개
	2. 갯수: r개
	3. 중복X
	4. 순서의 구분(O)
  */
  private static void permutation(int index, int cnt) {
	     if(cnt==R) {
	      total++;
	      System.out.println(Arrays.toString(ans));
	      return;
	     }
	     for (int i =index ; i < N; i++) {
	      ans[cnt]=numbers[i];
		   swap(i,index);
		   permutation(index+1, cnt+1);
		   swap(i,index);
	    }
  }
  
  private static void combination(int index, int cnt) {
      if(cnt==R) {
    	  total++;
       System.out.println(Arrays.toString(ans));
       return;
      }
   for (int i = index; i < N; i++) {
      ans[cnt]=numbers[i];
      combination(i+1, cnt+1);
   }
 }
  
  private static void subset(int index) {
	  if(index==N) {
	    total++;
	    for(int i=0; i<N; i++) {   
	      if(selected[i])System.out.print(numbers[i]+" ");
	    }
	    System.out.println();
	    return;
	  }
	     selected[index]=true;	    
	     subset(index+1);  
	     selected[index]=false;
	     subset(index+1);  
	 }
  
  private static void swap(int i, int j) {
	    int temp = numbers[i];
	    numbers[i]=numbers[j];
	    numbers[j]=temp;
  }
}
