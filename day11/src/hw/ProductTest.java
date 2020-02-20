package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductTest {
	public static void main(String[] args) throws IOException {
		ProductMgrImpl mgr = ProductMgrImpl.getInstance();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		mgr.add(new Product(12034, "건조기", 500000, 5));
		mgr.add(new Product(15609, "공기청정기", 1500000, 2));
		mgr.add(new TV(30334, "삼성 LED TV", 1000000, 3, 50));
		mgr.add(new TV(30335, "삼성 LED TV2", 1000000, 3, 70));
		mgr.add(new TV(30336, "삼성 LED TV3", 1000000, 3, 30));
		mgr.add(new Refrigerator(55990, "삼성 스마트 냉장고", 3000000, 1, 400));
		mgr.add(new Refrigerator(55991, "삼성 스마트 냉동고", 3500000, 1, 600));
		mgr.add(new Refrigerator(55992, "삼성 스마트 냉동고2", 3500000, 1, 200));
		
		while (true) {
			System.out.println("<<<  영화 관리 프로그램 >>> ");
			System.out.println("1. 상품 정보 전체 검색 ");
			System.out.println("2. 상품 번호 검색 ");
			System.out.println("3. 상품명 검색  ");
			System.out.println("4. TV 정보 검색 ");
			System.out.println("5. 냉장고 정보 검색 ");
			System.out.println("6. 400L 이상의 냉장고 ");
			System.out.println("7. 50inch TV ");
			System.out.println("8. 상품 가격 변경 ");
			System.out.println("9. 상품 번호로 삭제 ");
			System.out.println("10. 전체 재고 상품 가격 출력 ");
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
				mgr.Refrigerator400();
				System.out.println();
				break;
			case 7:
				mgr.TV50();
				System.out.println();
				break;
			case 8:
				System.out.println("가격을 변경할 상품 번호를 입력하세요.");
				num = Integer.parseInt(in.readLine());
				System.out.println("변경할 가격을 입력하세요.");
				int price = Integer.parseInt(in.readLine());
				mgr.change(num, price);
				System.out.println();
				break;
			case 9:
				System.out.println("삭제할 상품 번호를 입력하세요.");
				num = Integer.parseInt(in.readLine());
				mgr.delete(num);
				mgr.print();
				System.out.println();
				break;
			case 10:
				mgr.allStockPrice();
				System.out.println();
				break;
				
				
			}

		}

	}

}
