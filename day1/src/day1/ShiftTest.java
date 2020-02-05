package day1;

public class ShiftTest {

	public static void main(String[] args) {
		int a = 15;
		System.out.println(Integer.toBinaryString(a));  //원래 32비트니까 앞에 0이 29개 붙어있어야함
		a = a<<3;  //3칸 밀고 0으로 채움. n칸 밀면 2^n을 곱하게됨
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a);
		
		a = 15;
		a = a<<8;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a);
		
		a = a+13;
		System.out.println(Integer.toBinaryString(a)); //앞에꺼 건드리지 않고 뒤에 1101이 추가됨
		System.out.println(a);
		
//		13 꺼내보기
		int mask = 255;  //8자리만 보이게
		System.out.println(Integer.toBinaryString(mask));
		System.out.println(Integer.toBinaryString(mask & a));  //둘다 1일때만 1이 나옴
		System.out.println(Integer.toBinaryString(mask & (a>>8)));
		
		
//		shift 쓰는 경우 : 메모리를 절약하고 싶을때 
//		비트 마스크는 IM에서는 안나오고 ad가야지 어느정도 나온다.
		
	}

}
