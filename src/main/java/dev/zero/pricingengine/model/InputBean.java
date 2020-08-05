package dev.zero.pricingengine.model;

import java.util.List;

/**
 * InputBean - Class holding all data received from the user
 * @author ppalit
 *
 */
public class InputBean {

	int numberOfProducts;
	List<ProductSpecs> productList;


	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public List<ProductSpecs> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductSpecs> productList) {
		this.productList = productList;
	}

}
