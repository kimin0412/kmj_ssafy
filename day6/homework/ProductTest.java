package Abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductTest {
	public static void main(String[] args) throws IOException {
		ProductMgr mgr = ProductMgr.getInstance();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		mgr.add(new Product(12034, "건조기", 500000, 5));
		mgr.add(new Product(15609, "공기청정기", 1500000, 2));
		mgr.add(new TV(30334, "삼성 LED TV", 1000000, 3, 50));
		mgr.add(new Refrigerator(55990, "삼성 스마트 냉장고", 3000000, 1, 100));
		
		while (true) {
			System.out.println("<<<  영화 관리 프로그램 >>> ");
			System.out.println("1. 상품 정보 전체 검색 ");
			System.out.println("2. 상품 번호 검색 ");
			System.out.println("3. 상품명 검색  ");
			System.out.println("4. TV 정보 검색 ");
			System.out.println("5. 냉장고 정보 검색 ");
			System.out.println("6. 상품 번호로 삭제 ");
			System.out.println("7. 전체 재고 상품 가격 출력 ");
			System.out.println("0.   종료");
			System.out.print("원하는 번호를 선택하세요. : ");
			int N = Integer.parseInt(in.readLine());
			
			if(N == 0)
				break;
			switch (N) {
			case 1:
				mgr.print();
				System.out.println();
				break;
			case 2:
				System.out.println("검색할 상품 번호를 입력하세요.");
				int num = Integer.parseInt(in.readLine());
				Product producti = mgr.search(num);
				System.out.println(producti);
				System.out.println();
				break;
			case 3:
				System.out.println("검색할 상품명을 입력하세요.");
				String title = in.readLine();
				Product[] products = mgr.search(title);
				for (Product product : products) {
					System.out.println(product);
				}
				System.out.println();
				break;
			case 4:
				mgr.printTV();
				System.out.println();
				break;
			case 5:
				mgr.printRefrigerator();
				System.out.println();
				break;
			case 6:
				System.out.println("삭제할 상품 번호를 입력하세요.");
				num = Integer.parseInt(in.readLine());
				mgr.delete(num);
				mgr.print();
				System.out.println();
				break;
			case 7:
				mgr.allStockPrice();
				System.out.println();
				break;
				
				
			}

		}

	}

}
