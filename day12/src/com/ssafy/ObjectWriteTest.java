package com.ssafy;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriteTest { //객체 쓰기 테스트

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("person.ser"); //.ser은 직렬화된 클래스는 의미한것. 크게 의미는 없음
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person p = new Person();
		
		Person p2 = new Person(2, "길라임", 15, "학생");
		
		oos.writeObject(p);
		oos.writeObject(p2);
		oos.writeObject("직렬화 안녕~!!");
		oos.writeInt(300);
		
		oos.close();
		fos.close(); //안해도 ㄱㅊ
		System.out.println("객체쓰기 성공!");
	}

}
