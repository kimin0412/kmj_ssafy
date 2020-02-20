package com.ssafy;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {

	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("person.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//읽을때도 순서 맞춰서 읽어와야함 (집어넣을때 순서대로)
		Person p1 = (Person) ois.readObject();
		Person p2 = (Person) ois.readObject();
		
		System.out.println("p1>>>" + p1);
		System.out.println("p2>>>" + p2);
		
		System.out.println(ois.readObject().toString());
		System.out.println(ois.readInt());
		
	}

}
