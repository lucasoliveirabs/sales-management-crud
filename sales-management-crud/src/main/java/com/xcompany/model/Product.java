package com.xcompany.model;

public class Product {

	int productId;
	String productDepartment, productClass, productName;

	public Product() {
	}

	public Product(int productId, String productClass, String productName, String productDepartment) {
		this.productId = productId;
		this.productClass = productClass;
		this.productName = productName;
		this.productDepartment = productDepartment;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDepartment() {
		return productDepartment;
	}

	public void setProductDepartment(String productDepartment) {
		this.productDepartment = productDepartment;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDepartment=" + productDepartment + ", productClass="
				+ productClass + ", productName=" + productName + "]";
	}
}
