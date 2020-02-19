package hw;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductMgr {
	private Product[] products = new Product[100];
	private int index;
	private static ProductMgr instance;

	public ProductMgr() {
		products = new Product[10];
	}

	public static ProductMgr getInstance() {
		if (instance == null) {
			instance = new ProductMgr();
		}
		return instance;
	}

	private int searchIndex(int num) {
		if (num != 0) {
			int idx = 0;
			for (int i = 0; i < index; i++) {
				Product product = products[i];
				if (num == product.getNum()) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}

	/** 파라메터로 전달된 영화 정보를 전달받아 배열에 저장한다. */
	public void add(Product m) {
		if (m != null) {
			int idx = searchIndex(m.getNum());
			if (idx == -1) {
				int n = products.length;
				if (index >= n) { // full인 상태
					Product[] temp = Arrays.copyOf(products, n + n >> 1);
				}
				products[index++] = m;
			} else {
				System.out.printf("%d번 제품은 이미 등록된 제품입니다.\n", m.getNum());
			}
		}
	}

	/** 배열에 저장된 모든 영화정보를 리턴한다. */
	public Product[] search() {
		Product[] temp = new Product[index];
		for (int i = 0; i < index; i++) {
			temp[i] = products[i];
		}
		return temp;
	}

	/** 차량번호에 해당하는 차를 검색해서 리턴 */
	public Product search(int num) {
		int idx = searchIndex(num);
		if (idx > -1) {
			return products[idx];
		} else {
			return null;
		}
	}

	/** 파라메터로 전달된 타이틀을 포함하고 있는 모든 영화 정보를 검색하여 리턴 한다 */
	public Product[] search(String title) {
		ArrayList<Product> temp = new ArrayList<>(products.length);
		for (int i = 0; i < index; i++) {
			Product product = products[i];
			if (product.getModel().contains(title)) {
				temp.add(product);
			}
		}
		Product[] p = new Product[temp.size()];
		return temp.toArray(p);
	}

	/** 파라메터로 전달된 제목의 영화를 삭제한다. */
	public void delete(int num) {
		int idx = searchIndex(num);
		if (idx > -1) {
			products[idx] = products[--index];
		} else {
			System.out.printf("%d번 제품은 등록되지 않았습니다.\n", num);
		}
	}

	/** 저장된 영화 정보의 갯수를 리턴한다. */
	public int getSize() {
		return index;
	}

	public void print() {
		System.out.println("==============등록된 모든 제품 정보===========");
		for (int i = 0; i < index; i++) {
			System.out.println(products[i]);
		}
	}

	public void printTV() {
		System.out.println("==============등록된 모든 TV 정보===========");
		for (int i = 0; i < index; i++) {
			if (products[i].getNum() / 10000 == 3)
				System.out.println(products[i]);
//			if ((products[i].getInch())
		}
	}

	public void printRefrigerator() {
		System.out.println("==============등록된 모든 냉장고 정보===========");
		for (int i = 0; i < index; i++) {
			if (products[i].getNum() / 10000 == 5)
				System.out.println(products[i]);
		}
	}

	public void allStockPrice() {
		int hap = 0;
		System.out.println("==============전체 재고 상품 금액===========");
		for (int i = 0; i < index; i++) {
			hap += products[i].getPrice() * products[i].getStock();
		}
		System.out.println(hap);
	}

}
