package hw;

import java.util.Scanner;

public class prac_2072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		int t = sc.nextInt();
		int sum=0;
		int i;
		for(i=0;i<=10;i++) {
			if(t%2!=0) {
				sum+=t;
			}
		}
	System.out.println(sum);
	}

}
