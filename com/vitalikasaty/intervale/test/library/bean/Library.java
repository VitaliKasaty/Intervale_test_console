package com.vitalikasaty.intervale.test.library.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {

	private static final long serialVersionUID = -8216546877682375934L;

	private List<Product> products = new ArrayList<>();

	public Library() {
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Library [products=" + products + "]";
	}

}
