package swea.d2;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;
 
public class d2_1288

{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[10];
            Arrays.fill(arr, 0);
            int nn = n;
            while(true) {
                int tmp = nn;
                while(true) {
                    arr[tmp%10] = 1;
                    tmp/=10;
                    if(tmp<=0)
                        break;
                }
                boolean flag = true;
                for (int j = 0; j < arr.length; j++) {
                    if(arr[j] == 0)
                        flag = false;
                }
                if(flag == true) {
                    System.out.println("#" + test_case+" " +nn);
                    break;}
                nn+=n;
            }
        }
    }
}