package com.ssafy;

import com.ssafy.model.dao.CarMgr;
import com.ssafy.model.dto.Bus;
import com.ssafy.model.dto.Car;

public class CarTest {

	public static void main(String[] args) {
//		Car c = null;
//		c.getModel();
		
		CarMgr mgr = CarMgr.getInstance();
		mgr.add(new Car("1", "벤츠S", 250000000));
//		mgr.add(new Car("1", "벤츠S", 250000000));
		mgr.add(new Car("2", "모닝", 250000000));
		mgr.add(new Car("3", "소나타", 350000000));
		mgr.add(new Bus("4", "타요", 600000000, 40));
		mgr.print();
		System.out.println();
		
		mgr.update("3", 380000000);
		mgr.print();
		System.out.println();
		
		System.out.println("=================차량검색=================");
		System.out.println(mgr.search("2"));
		Car[] cars = mgr.search(400000000);
		System.out.println();
		for (Car car : cars) {
			System.out.println(car);
		}
		System.out.println();
		
		cars = mgr.search();
		for (Car car : cars) {
			System.out.println(car);
		}
		System.out.println();
		
		mgr.delete("3");
		mgr.print();
		System.out.println();
		
		
		
		
	}

}
