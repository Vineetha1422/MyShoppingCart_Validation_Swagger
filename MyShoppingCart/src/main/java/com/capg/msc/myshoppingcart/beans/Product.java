package com.capg.msc.myshoppingcart.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.stereotype.Component;

@Entity
@ApiModel(value = "Product Bean")
public class Product {
	
	//--------------Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
    
    @ApiModelProperty(name = "ProductName",value = "Hold the min 3 char product name",required = true)
    @NotEmpty(message = "Product name cannot be null or blank")
    @Size(min = 3,max = 15,message = "Invalid Product Name")
	private String productName;
    
    @ApiModelProperty(name = "Product cost",value = "Holds Product cost min cost 1000 allowed")
    @Min(value = 1000,message="Cannot be less than 1000")
	private int productCost;
    
    @ApiModelProperty(name = "Product rating",value = "Rating must be in range 1-5")
    @Min(value = 1,message="Must be in Range 1-5")
    @Max(value = 5,message="Must be in Range 1-5")
	private int starRating;
    
    @ApiModelProperty(name = "Product Category",value = "Must not be Null or Blank",required = true)
    @NotEmpty(message = "Category cannot be null or blank")
	private String category;
	
    //-----------------Constructors
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//----------------Getters and Setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//-------------------HashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + productCost;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + starRating;
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productCost != other.productCost)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (starRating != other.starRating)
			return false;
		return true;
	}

	//-----------------ToString
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", starRating=" + starRating + ", category=" + category + "]";
	}
	
	
	
	
}

