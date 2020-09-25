package com.capgemini.go.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {
	
	@Id
    @Column(name="product_id")
    private String productId;
    
    @Column(name="product_name",nullable=false)
    private String productName;
    
    @Column(name="product_price",nullable=false)
    private Double productPrice;
    
    @Column(name="product_color",nullable=false)
    private String productColor;
    
    
    @Column(name="product_category",nullable=false)
    private Integer productCategory;
    
    @Column(name="product_quantiy",nullable=false)
    private Integer productQuantity;
    
    @Column(name="product_specification")
    private String productSpecification;
    	
    @Column(name="product_dimension")
    private String productDimension;
    
    @Column(name="product_manufacturer")
	private String productManufacturer;
	    
	    
	    
		public Product() {
			super();
		}
		
				
		public Product(String productId, String productName, Double productPrice, String productColor,
				Integer productCategory, Integer productQuantity, String productSpecification, String productDimension,
				String productManufacturer) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productPrice = productPrice;
			this.productColor = productColor;
			this.productCategory = productCategory;
			this.productQuantity = productQuantity;
			this.productSpecification = productSpecification;
			this.productDimension = productDimension;
			this.productManufacturer = productManufacturer;
		}



		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(Double productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductColor() {
			return productColor;
		}
		public void setProductColor(String productColor) {
			this.productColor = productColor;
		}
		public Integer getProductCategory() {
			return productCategory;
		}
		public void setProductCategory(Integer productCategory) {
			this.productCategory = productCategory;
		}  
		public Integer getProductQuantity() {
			return productQuantity;
		}
		public void setProductQuantity(Integer productQuantity) {
			this.productQuantity = productQuantity;
		}
		public String getProductSpecification() {
			return productSpecification;
		}
		public void setProductSpecification(String productSpecification) {
			this.productSpecification = productSpecification;
		}
		public String getProductDimension() {
			return productDimension;
		}
		public void setProductDimension(String productDimension) {
			this.productDimension = productDimension;
		}
		public String getProductManufacturer() {
			return productManufacturer;
		}
		public void setProductManufacturer(String productManufacturer) {
			this.productManufacturer = productManufacturer;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
			result = prime * result + ((productColor == null) ? 0 : productColor.hashCode());
			result = prime * result + ((productDimension == null) ? 0 : productDimension.hashCode());
			result = prime * result + ((productId == null) ? 0 : productId.hashCode());
			result = prime * result + ((productManufacturer == null) ? 0 : productManufacturer.hashCode());
			result = prime * result + ((productName == null) ? 0 : productName.hashCode());
			result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
			result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
			result = prime * result + ((productSpecification == null) ? 0 : productSpecification.hashCode());
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
			Product other = (Product) obj;
			if (productCategory == null) {
				if (other.productCategory != null)
					return false;
			} else if (!productCategory.equals(other.productCategory))
				return false;
			if (productColor == null) {
				if (other.productColor != null)
					return false;
			} else if (!productColor.equals(other.productColor))
				return false;
			if (productDimension == null) {
				if (other.productDimension != null)
					return false;
			} else if (!productDimension.equals(other.productDimension))
				return false;
			if (productId == null) {
				if (other.productId != null)
					return false;
			} else if (!productId.equals(other.productId))
				return false;
			if (productManufacturer == null) {
				if (other.productManufacturer != null)
					return false;
			} else if (!productManufacturer.equals(other.productManufacturer))
				return false;
			if (productName == null) {
				if (other.productName != null)
					return false;
			} else if (!productName.equals(other.productName))
				return false;
			if (productPrice == null) {
				if (other.productPrice != null)
					return false;
			} else if (!productPrice.equals(other.productPrice))
				return false;
			if (productQuantity == null) {
				if (other.productQuantity != null)
					return false;
			} else if (!productQuantity.equals(other.productQuantity))
				return false;
			if (productSpecification == null) {
				if (other.productSpecification != null)
					return false;
			} else if (!productSpecification.equals(other.productSpecification))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
					+ ", productColor=" + productColor + ", productCategory=" + productCategory + ", productQuantity="
					+ productQuantity + ", productSpecification=" + productSpecification + ", productDimension="
					+ productDimension + ", productManufacturer=" + productManufacturer + "]";
		}
	    
	 
		
}
