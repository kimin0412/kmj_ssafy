import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWmaestro_test1 {
	
  public static void main(String args[]) throws Exception { 
  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int cntA = 0;
    int cntB = 0;
    char[] c = s.toCharArray();
    
    for (int i = 0; i < s.length(); i++) {
        if(c[i] == '(')
            cntA++;
        else
            cntB++;
    }
    
    if(cntA == cntB)
        System.out.println("YES");
    else
        System.out.println("NO");
    
  }
}
