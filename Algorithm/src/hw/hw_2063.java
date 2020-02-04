package hw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class hw_2063 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/swea/d3/input.txt"));
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
	
		int[] x= new int[N];
		
		if(N>199||N<9||N%2==0) {
			System.out.println("N은 9이상 199이하의 홀수");
		}

		for(int i = 0;i<N; i++) {
		
			x[i]=sc.nextInt();

		

		}
		Arrays.sort(x);
		System.out.println(x[(N-1)/2]);
		}
	}


