package day2;

public class ArrayTest1 {

	public static void main(String[] args) {
		int[] su = {34, 5, 2, 6, 3, 5, 76, 8};
		int sum = 0;
		for (int s : su) {
			sum+=s;  //sum=sum+s;
		}
		System.out.println(sum);
	}

}
