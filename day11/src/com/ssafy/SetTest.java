package com.ssafy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
//Set : 중복데이터 제거(유일한 데이터만 저장), (저장되는)순서가 일정치 않다.   null허용? => O
//		Set<String> set = new HashSet<>();
		
		
		
		
		SortedSet<String> set = new TreeSet<>();
		//정렬된 Set : null허용? => X
		
		// 데이터 추가
		set.add("홍길동");
		set.add("길라임");
		set.add("김주원");
		set.add("홍길동");
		set.add("이순신");
		set.add("홍길동");
//		set.add(null);
//		set.add(null); // null도 중복으로 취급

		System.out.println("Set에 저장된 요소 갯수 : " + set.size());

		// 모든 요소 출력
		Iterator<String> it = set.iterator();
		// 열거형 인터페이스
//		it.next(); //데이터 뽑아오기
//		it.next(); //데이터 뽑아오기
//		it.next(); //데이터 뽑아오기
//		it.next(); //데이터 뽑아오기
//		it.next(); //데이터 뽑아오기
//		it.next(); //데이터 뽑아오기  -> 6번째로 뽑을때는 오류가 생긴다.

		while (it.hasNext()) {
			System.out.println(it.next()); // 데이터 뽑아오기
		}
		/*
		 * 출력결과)
		 * null
		 * 김주원
		 * 홍길동
		 * 길라임
		 * 이순신
		 */
		
//		문제) 로또 번호 발생기 작성!!  숫자 1~45 사이의 중복되지 않은 6개의 숫자를 오름차순 정렬 출력.
		SortedSet<Integer> lotto = new TreeSet<>();
		Random ran  = new Random();
		while(lotto.size() != 6) {
			lotto.add(ran.nextInt(45)+1);
		}
		System.out.println(lotto.toString());
		
		Iterator<Integer> itt = lotto.iterator();
		while (itt.hasNext()) {
			System.out.println(itt.next()); // 데이터 뽑아오기
		}
		
		
		
	}// main
}
