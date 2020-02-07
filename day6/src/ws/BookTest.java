package ws;

import java.util.Scanner;

public class BookTest {
	
	public void insertBook() {
		Book b1 = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("35355", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
		Book b3 = new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음", 2018, 2);
		
	}

	public static void main(String[] args) {
//		Book b1 = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
//		Book b2 = new Book("35355", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
//		Magazine m1 = new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음", 2018, 2);
//
//		System.out.println(b1.toString());
//		System.out.println(b2.toString());
//		System.out.println(m1.toString());

		Scanner sc = new Scanner(System.in);
		while (true) {
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("책의 정보를 입력해주세요. 입력종료는 -1");
//					insert(sc.next();
//				}
//				
//				
//				break;
//			case 2:
//
//				break;
//
//			case 3:
//
//				break;
//			case 4:
//
//				break;
//			case 5:
//
//				break;
//			case 6:
//
//				break;
//			case 7:
//
//				break;
//			case 8:
//
//				break;
//			case 9:
//
//				break;
//			case 10:
//
//				break;
//			case 11:
//
//				break;

			}

		}
	}

}
