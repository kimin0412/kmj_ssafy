package hw;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductMgrImpl {
	ArrayList<Product> products;
	public static int index;
	public static ProductMgrImpl instance;

	public ProductMgrImpl() {
		products = new ArrayList<>();
	}

	public static ProductMgrImpl getInstance() {
		if (instance == null) {
			instance = new ProductMgrImpl();
		}
		return instance;
	}

	private int searchIndex(int num) {
		if (num != 0) {
			int idx = 0;
			for (int i = 0; i < index; i++) {
				Product product = products.get(i);
				if (num == product.getNum()) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}

	public void add(Product m) {
		if (m != null) {
			int idx = searchIndex(m.getNum());
			if (idx == -1) {
				products.add(m);
				index++;
			} else {
				System.out.printf("%d번 제품은 이미 등록된 제품입니다.\n", m.getNum());
			}
		}
	}

	public Product[] search() {
		Product[] temp = new Product[index];
		for (int i = 0; i < index; i++) {
			temp[i] = products.get(i);
		}
		return temp;
	}

	public Product search(int num) {
		int idx = searchIndex(num);
		if (idx > -1) {
			return products.get(idx);
		} else {
			return null;
		}
	}

	public Product[] search(String title) {
		ArrayList<Product> temp = new ArrayList<>(products.size());
		for (int i = 0; i < index; i++) {
			Product product = products.get(i);
			if (product.getModel().contains(title)) {
				temp.add(product);
			}
		}
		Product[] p = new Product[temp.size()];
		return temp.toArray(p);
	}

	public void delete(int num) {
		int idx = searchIndex(num);
		if (idx > -1) {
			products.remove(idx);
			
		} else {
			System.out.printf("%d번 제품은 등록되지 않았습니다.\n", num);
		}
	}

	public int getSize() {
		return index;
	}

	public void print() {
		System.out.println("==============등록된 모든 제품 정보===========");
		for (int i = 0; i < index; i++) {
			System.out.println(products.get(i));
		}
	}

	public void printTV() {
		System.out.println("==============등록된 모든 TV 정보===========");
		for (int i = 0; i < index; i++) {
			if (products.get(i).getNum() / 10000 == 3)
				System.out.println(products.get(i));
//			if ((products[i].getInch())
		}
	}

	public void printRefrigerator() {
		System.out.println("==============등록된 모든 냉장고 정보===========");
		for (int i = 0; i < index; i++) {
			if (products.get(i).getNum() / 10000 == 5)
				System.out.println(products.get(i));
		}
	}

	public void Refrigerator400() {
		System.out.println("==============400L 이상 냉장고 정보===========");
		for (int i = 0; i < index; i++) {
			if (products.get(i).getNum() / 10000 == 5) {
				Product tmp = new Refrigerator();
				tmp = products.get(i);
				if ((((Refrigerator) tmp).getCapacity()) >= 400)
					System.out.println(tmp);
			}
		}
	}

	public void TV50() {
		System.out.println("==============50inch 이상 TV 정보===========");
		for (int i = 0; i < index; i++) {
			if (products.get(i).getNum() / 10000 == 3) {
				Product tmp = new TV();
				tmp = products.get(i);
				if ((((TV) tmp).getInch()) >= 50)
					System.out.println(tmp);
			}
		}
	}

	public void change(int num, int p) {
		int idx = searchIndex(num);
		if (idx > -1) {
			products.get(idx).setPrice(p);
		} else {
			System.out.printf("%d번 제품은 등록되지 않았습니다.\n", num);
		}
	}

	public void allStockPrice() {
		int hap = 0;
		System.out.println("==============전체 재고 상품 금액===========");
		for (int i = 0; i < index; i++) {
			hap += products.get(i).getPrice() * products.get(i).getStock();
		}
		System.out.println(hap);
	}
}
