package day2;
//주어진 배열의 합계, 평균, 최대값, 최소값, 최소값위치 를 구해보자.
public class ArrayTest2 {
	public static void main(String[] args) {
		int[] su = {43,56,56,6,5,5,7,67};
		int result = sum(su);
		System.out.println(result);
		System.out.println((double)result/su.length);
		max(su);
//		System.out.println("합계 : "+sum);
		minPosition(su);
		selectionSort(su);
	}
	//public:외부에서도 다른곳에서도 쓸수 있게 하겠다, static:객체의 개념없이 쓸수있도록 하는것
	public static void selectionSort(int[] a) {
//		int min = a[0];
		for (int n = 0; n < a.length-1; n++) {
			int min = a[n]; //돌면서 기준이 계속 바뀌니까 n번째로
			int minp = n;
			for (int i = n+1; i < a.length; i++) {
				if(min > a[i]) {
					min = a[i];
					minp = i;
				}
				
			}
			//값 swap
			a[minp] = a[n];
			a[n] = min;
//			for (int i = 0; i < a.length-1; i++) {				
//				if(a[n]>a[n+1]) {//최소값과 위치를 찾기
//					int tmp = a[n];
//					a[n] = a[n+1];
//					a[n+1] = tmp;
////				swap(a[n], a[n+1]);
//					//값 swap
//				}
//			}
//		}	
		}
		for (int aa : a) {
			System.out.print(aa+" ");
		}
	}
	public static int sum(int[] a) {  //옛날엔 이걸 함수/메서드/function 라고 불렀다.
		int tot = 0;
		for (int aa : a) {
			tot+=aa;
		}
		//필요한 데이터를 괄호 안에 매개변수로 받는다.
		//데이터를 반환하지 않으면 void로 둔다.
		return tot;//값이 없으면 return만 써도 된다. -> 되돌아가라는 뜻
	}
	public static void max(int[] a) {
		int max= a[0]; //비교할만할 비교대상이 확실하지 않다면 그냥 배열의 첫번째값 줘버림
		for (int i = 1; i < a.length; i++) {
			if(max<a[i]) {
				max= a[i];
			}
		}
		System.out.println(max);
	}
	public static void minPosition(int[] a) {
		int min= a[0]; //비교할만할 비교대상이 확실하지 않다면 그냥 배열의 첫번째값 줘버림
		int minPosition = 0;
		for (int i = 1; i < a.length; i++) {
			if(min>a[i]) {
				min = a[i];
				minPosition = i;
			}
		} //
		System.out.println("최소값 : "+ min+"  위치:"+minPosition);
	}
	
}
