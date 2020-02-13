package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

//상속 키워드는 두개가 들어갈수있다. extends와 implement
/**
 * interface 인터페이스명 {
 * 	void 메소드명1(); -> 인터페이스에는 바디 괄호가 없다. 보통 연결매체로 사용한다. 선언만 하기. 구현은 없다.
 *  -> 하지만 이 이름으로 어디선가는 반드시 구현이 된다. (자식클래스에서)
 *  void 메소드명2(); 
 * }
 * 
 * <자바 상속>
 * class 클래스명 extends 부모클래스명{}
 * 			   -------
 * 			   ==>확장   (자식클래스=>확장클래스)
 * class 클래스명 implements 부모인터페이스명{}
 * 			   ----------
 * 			   =>구현     (자식클래스에서 바디괄호 채워줌) (구현의 약속 느낌!)
 *
 *
 */
class Point implements Comparator<Point>{  //특정 속성을 기준으로 정렬하고 싶다!
	int x;
	int y;
	
	public Point() {
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compare(Point o1, Point o2) {  //나만의 정렬기준 설정
//		return -1;   //리턴 음수=>자리변경, 리턴0또는 양수 => 변화없음
//		return o1.y - o2.y;  //y값을 기준으로 오름차순 정렬
//		return o2.y - o1.y;  //y값을 기준으로  내림차순 정렬
		
//		문제) y값을 기준으로 내림차순 정렬하고 만약 y값이 같다면 x값으로 오름차순 정렬하시오.
		if(o2.y - o1.y < 0) return -1;
		else if(o2.y == o1.y) {
			return o1.x - o2.x;
		}
		return 1;  //변환되는값 없습니다.
	}
}//Point
//collections 

class Point2 implements Comparable<Point2> {
	int x;
	int y;
	
	public Point2() {
	}
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	@Override
	public int compareTo(Point2 o) {
		//return -1; //역순
		//return y-o.y; //오름차순
		return o.y-y; //내림차순
	}
}//Point2

public class CompareTest_me {

	public static void main(String[] args) {
		//객체의 정렬
		Point p1 = new Point(10, 2);
		Point p2 = new Point(20, 9);
		Point p3 = new Point(30, 2);
		Point p4 = new Point(41, 1);
		
		Point points[] = { p1, p2, p3, p4};
		
		for (Point p : points) {
			System.out.println(p);
		}
		
		
		System.out.println("=====================");
//		Arrays.sort(배열, Comparator 객체);
//		Arrays.sort(배열, Comparator 메소드가 구현됟 위치);
		Arrays.sort(points, new Point());
		for (Point P : points) {
			System.out.println(points);
		}
		
		System.out.println("#######################");
		Point2 p5 = new Point2(10, 3);
		Point2 p6 = new Point2(20, 9);
		Point2 p7 = new Point2(30, 2);
		Point2 p8 = new Point2(40, 1);
		
		Point2 points2[]= {p5,p6,p7,p8};
		
		for(Point2 p :points2) {
			System.out.println(p);
		}
		System.out.println("====================");
		Arrays.sort(points2);  //Comparable사용시
		for(Point2 p :points2) {
			System.out.println(p);
		}
		
//		//배열의 정렬
//		int[] su = {22, 5, 19, 28, 7};
//		String[] str = {"java", "algo", "programming", "python", "Algo"};
//		//'A' --> 65
//		
//		//Arrays.sort(정렬할 배열명);
//		Arrays.sort(su);
//		for (int i : su) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n==================================");
//		
//		Arrays.sort(str);
//		for (String s : str) {
//			System.out.print(s + " ");
//		}
		
	}

}
