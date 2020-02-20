package com.ssafy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
		 * Map ==> 저장데이터(키값, 데이터값)
		 * 
		 * Map<K, V>
		 * - 사물함 클래스 (책:데이터, 열쇠:키)
		 * - K:Key의 자료형, V:Value의 자료형
		 * - Key는 보통 문자열 사용, Value(저장 데이터)는 Object
		 * - Key값은 중복X(유일한 값을 갖는다.)
		 *
		 * 	★기억
		 * 	 - 저장: map.put(키값, 저장데이터);
		 * 	 - 조회: 자료형 변수명 = map.get(키값);
		 */
		
		Map<String, Object> map = new HashMap<>();
		//데이터 입력("홍길동", 13, "학생");
		//map.put(String key, Object value);
		map.put("name", "홍길동");
		map.put("age", 13);
		map.put("job", "학생");
		
		System.out.println(map.toString());
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("k1", "홍길동");
		map2.put("k2", "길라임");
		map2.put("k3", "김주원");
		map2.put("k4", "김유신");
		map2.put("k3", "이순신"); //컴파일, 런타임 에러는 없지만 중복이므로 새로 들어온 데이터로 덮어씌워진다.
		map2.put("k5", "이순신"); //중복 키값 존재 : 덮어쓰기(수정)
//		map2.replace(String key, String value); => 수정
		map2.replace("k3", "하순신"); //이것도 수정
		
		//전체 데이터 출력
		System.out.println(map2.toString());
		
		//특정 데이터 출력(k2 키에 저장된 데이터를 출력!)
		System.out.println("k2 키에 저장된 값 : " + map2.get("k2"));
		
		//특정 데이터 삭제(k3키)
		map2.remove("k3");
		System.out.println(map2.toString());
		
		System.out.println("=====================================");
		//전체 데이터(만) 출력
		Collection<String> col = map2.values();
		Iterator<String> it = col.iterator();
		System.out.println("<<전체 map2 데이터>>");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//map2에서 key값들만 따로 얻어오기 (프로그램 내에서 key값을 모르는 경우)
		Set<String> set = map2.keySet();
		Iterator<String> keyset = set.iterator();
		while(keyset.hasNext()) {
			String key = keyset.next();
			System.out.println(key + "에 저장된 데이터 : " + map2.get(key));
		}
		
		//문제) Map m3;에 오버로딩된 생성자를 사용하여 Person 클래스(5, "길동", 13, "학생")
		//	   거리데이터 ("10km") 를 저장하시오.
		
		//문제) m3에 저장된 거리를 출력하시오.
		
		//문제) m3에 저장된 이름과 나이를 따로 출력하시오.
		
		System.out.println("=====================================");
//		Map<Person, String> m3 = new HashMap<>();
		Map<String, Object> m3 = new HashMap<>();
		Person p = new Person(5, "길동", 13, "학생");
//		m3.put(p, "10km");
		m3.put("person", p);
		m3.put("distance", "10km");
		
//		System.out.println(m3.get(p));
		System.out.println("거리 : " + m3.get("anykey")); //일치하는 key없을때는 리턴 null
		System.out.println(m3.get("distance"));
		
		
//		Set<String> set3 = m3.keySet();
//		Iterator<Person> keyset3 = set3.iterator();
//		while(keyset3.hasNext()) {
//			Person key = keyset3.next();
//			System.out.println("이름 : " + key.getName() + "\n나이 : " + key.getAge());
//		}
		System.out.println("거리 : " + m3.get("distance"));
		System.out.println("이름, 나이 : " + ((Person) m3.get("person")).getName() + "  " + ((Person) m3.get("person")).getAge());
		
	}
}
