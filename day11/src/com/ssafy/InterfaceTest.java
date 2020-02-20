package com.ssafy;

public class InterfaceTest {
	public static void main(String[] args) {
		MenuPan menu = new HongKong(); //new MenuPan(); 은 안됨
		//부모				//자식
		menu.짬뽕();
		menu.짜장면();
		
		//인터페이스 안에 있는 필드 접근!
		System.out.println("코인값 : " + MenuPan.coin);
	}
}
