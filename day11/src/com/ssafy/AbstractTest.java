package com.ssafy;

import java.util.Collection;
import java.util.LinkedList;

public class AbstractTest {

	static void feel(Shape s) {
		s.draw();
	}
	static void feel2(MenuPan menuPan) {
		
	}

	public static void main(String[] args) {
//		feel(new Shape()); //오류
//		feel(new Triangle()); // 모양은 부모지만 속은 자식이다.
//		feel(new Rectangle());
//		feel(new Circle());
//		Collection<Integer> c = new LinkedList<>();
		feel(new Shape() { // extends Shape (Shape가 인터페이스였다면 implement가 됨)
			void draw() {
				System.out.println("별그리기~~");
			}
		});
		
		feel2(new MenuPan() {  //implements MenuPan (comparator=>인터페이스 타입)
			
			@Override
			public void 짬뽕() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void 짜장면() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void 볶음밥() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
