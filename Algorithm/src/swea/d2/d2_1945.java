package swea.d2;

import java.util.Scanner;
import java.io.FileInputStream;
 
public class d2_1945
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n;
            n = sc.nextInt();
            int a=0, b=0, c=0, d=0, e=0, m;
            while(true) {
                if(n%11 != 0)
                    break;
                else { n/=11; e++;}
            }
            while(true) {
                if(n%7 != 0)
                    break;
                else { n/=7; d++;}
            }
            while(true) {
                if(n%5 != 0)
                    break;
                else { n/=5; c++;}
            }
            while(true) {
                if(n%3 != 0)
                    break;
                else { n/=3; b++;}
            }
            while(true) {
                if(n%2 != 0)
                    break;
                else { n/=2; a++;}
            }
            System.out.println("#" + test_case+ " " + a + " "+ b + " "+ c + " " + d + " " + e);
        }
    }
}