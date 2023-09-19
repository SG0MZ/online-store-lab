package com.online.store.model.wrappers;

import com.online.store.model.Product;

import java.util.Collections;
import java.util.List;

public class ProductsWrapper {

	private List<Product> products = Collections.emptyList();
	 
    public ProductsWrapper(List<Product> products) {
        this.products = Collections.unmodifiableList(products);
    }
 
    public List<Product> getProducts() {
        return products;
    }
}
