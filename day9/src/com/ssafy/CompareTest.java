//package com.ssafy;
//
//import java.util.Arrays;
//import java.util.Comparator;
///*
//  interface 인터페이스명{
//    void 메소드명1();  //선언된 메소드
//    void 메소드명2();
//  } 
// 
//  <자바상속>
//  class 클래스명 extends 부모클래스명{}
//              --------
//              ==>확장
//  
//  class 클래스명 implements 부모인터페이스명{}
//              -----------
//              ==>구현 약속!!
// 
// */
//
//
//class Point  implements Comparator<Point>{//특정 속성을 기준으로 정렬하고 싶다!!
//	int x;
//	int y;
//
//	public Point() {
//	}
//
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Point [x=").append(x).append(", y=").append(y).append("]");
//		return builder.toString();
//	}
//	@Override
//	public int compare(Point o1, Point o2) {//나만의 정렬기준 설정
////		return -1;  //리턴 음수 ---> 자리변경,  리턴0 또는 양수 ---> 변화없음
////		return o1.y - o2.y;   //y값을 기준으로 오름차순 정렬
////		return o2.y - o1.y;   //y값을 기준으로 내림차순 정렬
//		
////		문제) y값을 기준으로 내림차순 정렬하고  만약 y값이 같다면 x값으로 오름차순 정렬하시오.
//		if(o2.y - o1.y<0) return -1;
//		else if(o2.y == o1.y) {
//			return o1.x - o2.x;
//		}
//		return 1;
//	}
//}//Point
//
//class Point2 implements Comparable<Point2> {
//	int x;
//	int y;
//	
//	public Point2() {
//	}
//	
//	public Point2(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	@Override
//	public String toString() {
//		return "Point [x=" + x + ", y=" + y + "]";
//	}
//	
//	
//	@Override
//	public int compareTo(Point2 o) {
//		//return -1; //역순
//		//return y-o.y; //오름차순
//		return o.y-y; //내림차순
//	}
//}//Point2
//
//public class CompareTest {
//	public static void main(String[] args) {
//		//객체의 정렬
//		Point p1 = new Point(10, 3);
//		Point p2 = new Point(20, 9);
//		Point p3 = new Point(30, 2);
//		Point p4 = new Point(40, 2);
//		
//		Point points[] = {p1,p2,p3,p4};
//		
//		for(Point p :points) {
//			System.out.println(p);
//		}
//		System.out.println("============================");
////		Arrays.sort(배열, Comparator객체);
////		Arrays.sort(배열, compare메소드가 구현된 위치);
//		Arrays.sort(points, new Point());
//		for(Point p :points) {
//			System.out.println(p);
//		}
//		
//		
//		System.out.println("#######################");
//		Point2 p5 = new Point2(10, 3);
//		Point2 p6 = new Point2(20, 9);
//		Point2 p7 = new Point2(30, 2);
//		Point2 p8 = new Point2(40, 1);
//		
//		Point2 points2[]= {p5,p6,p7,p8};
//		
//		for(Point2 p :points2) {
//			System.out.println(p);
//		}
//		System.out.println("====================");
//		Arrays.sort(points2);  //Comparable사용시
//		for(Point2 p :points2) {
//			System.out.println(p);
//		}
//		
////		// 배열의 정렬
////		int[] su = { 22, 5, 19, 28, 7 };
////		String[] str = { "java", "algo", "programming", "python", "Algo" };
////		// 'A' --> 65 'a' --> 97
////
////		// Arrays.sort(정렬할배열명);
////		Arrays.sort(su);
////		for (int i : su) {
////			System.out.print(i + " ");
////		}
////		System.out.println("\n=================================");
////		Arrays.sort(str);
////		for (String s : str) {
////			System.out.print(s + " ");
////		}
//
//	}
//}
