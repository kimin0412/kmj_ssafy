package hw;

import java.util.ArrayList;
import java.util.Arrays;

public interface IProductMgr {
	ArrayList<Product> products = new ArrayList<>();
	static IProductMgr instance = null;

	public IProductMgr getInstance();

	int searchIndex(int num);

	public void add(Product m);

	public Product[] search();

	public Product search(int num);

	public Product[] search(String title);

	public void delete(int num);

	public int getSize();

	public void print();

	public void printTV();

	public void printRefrigerator();

	public void allStockPrice();

}
