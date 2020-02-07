package com.ssafy.model.dao;

import java.util.ArrayList;
import java.util.Arrays;

import com.ssafy.model.dto.Car;
/**
 * DAO (Data Access Object)
 * - Data가 저장된 공간에 접근해서 insert, delete, update, select를 하는 클래스
 * (DB에 접근하는 클래스)
 */

/** Singleton */
public class CarMgr {
	private Car[] cars;
	/** 데이터를 저장할 위치, 현재 저장된 데이터 개수 */
	private int index; // 0으로 초기화, 저장된 개수를 표현한다.
	private static CarMgr instance;

	public CarMgr() {
		cars = new Car[10];
	}

	public static CarMgr getInstance() {
		if (instance == null) {
			instance = new CarMgr();
		}
		return instance;
	}

	private int searchIndex(String num) {
		if (num != null) {
			int idx = 0;
			for (int i = 0; i < index; i++) {
				Car car = cars[i];
				if (num.equals(car.getNum())) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}

	public void add(Car c) {
		if (c != null) {
			int idx = searchIndex(c.getNum());
			if (idx == -1) {
				int n = cars.length;
				if (index >= n) { // full인 상태
					Car[] temp = Arrays.copyOf(cars, n + n >> 1);

				}
				cars[index++] = c;
			} else {
				System.out.printf("%s번 차량은 이미 등록된 차량입니다.\n", c.getNum());
			}
		}
	}

	/**
	 * 등록된 모든 차량을 리턴하는 기능
	 * 
	 * @return 등록된 모든 차량
	 */
	public Car[] search() {
		Car[] temp = new Car[index];
		for (int i = 0; i < index; i++) {
			temp[i] = cars[i];
		}
		return temp;
	}

	/**
	 * 차량번호에 해당하는 차를 검색해서 리턴
	 * 
	 * @param num 찾을 차량 번호
	 * @return 차량번호에 해당하는 차가 있으면 리턴, 없으면 null을 리턴
	 */
	public Car search(String num) {
		int idx = searchIndex(num);
		if (idx > -1) {
			return cars[idx];
		} else {
			return null;
		}
	}

	public Car[] search(int price) {
		ArrayList<Car> temp = new ArrayList<>(cars.length);
		for (int i = 0; i < index; i++) {
			Car car = cars[i];
			if (car.getPrice() < price) {
				temp.add(car);
			}
		}
		Car[] c = new Car[temp.size()];
		return temp.toArray(c);
	}

	/**
	 * 차량 번호에 해당하는 차량 가격을 변경해주는 기능
	 * 
	 * @param num   차량번호
	 * @param price 변경할 가격
	 */
	public void update(String num, int price) {
		int idx = searchIndex(num);
		if (idx > -1) {
			cars[idx].setPrice(price);
		} else {
			System.out.printf("%s번의 차량을 등록되지 않았습니다.\n", num);
		}
	}

	/**
	 * 차량번호에 해당하는 차량을 제거하는 기능
	 * 
	 * @param num 제거할 차량 번호
	 */
	public void delete(String num) {
		int idx = searchIndex(num);
		if (idx > -1) {
			cars[idx] = cars[--index];
		} else {
			System.out.printf("%s번의 차량을 등록되지 않았습니다.\n", num);
		}
	}

	public int size() {
		return index;
	}

	public int totalPrice() {
		int total = 0;
		for (int i = 0; i<index; i++) {
			total += cars[i].getPrice();
		}
		return total;
	}
	/**
	 * 등록된 모든 차량 정보를 출력
	 */
	public void print() {
		System.out.println("==============등록된 모든 차량 정보===========");
		for (int i = 0; i < index; i++) {
			System.out.println(cars[i]);
		}
	}
}
