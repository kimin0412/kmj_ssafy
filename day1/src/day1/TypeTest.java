package day1;

public class TypeTest {

	public static void main(String[] args) {
		int a = 30;
		double b = 4.5;
//		int result = a+b;  
//		double이 더 큰타입이라 연산 결과가 double타입으로 되는데 int에 넣으려고해서 오류
		int result = (int) (a+b);  
		System.out.println(result);
		
		char c = 'A';
		System.out.println(c+1);
//		char + int = int 이기 때문에 66이 나옴
		System.out.println((char)(c+1));
//		명시적 형변환
		System.out.println(++c);
//		증감은 ㄱㅊ
		
		System.out.println(c++);
		
	}

}
