package swea.d3;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution_D3_8658_Summation
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max = 0;
            int min = 0;
             
            int num = sc.nextInt();
            int sum = 0;
            while(num != 0) {
                sum += num%10;
                num /= 10;
            }
            max = sum;
            min = sum;
             
            for(int i=1; i<10; i++) {
                num = sc.nextInt();
                sum = 0;
                while(num != 0) {
                    sum += num%10;
                    num /= 10;
                }
                if(max < sum) max = sum;
                if(min > sum) min = sum;
            }
             
            System.out.println("#" + test_case + " " + max + " " + min);
        }
    }
}