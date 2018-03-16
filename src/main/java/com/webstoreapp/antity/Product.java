package com.webstoreapp.antity;


public class Product {
    private Integer id;
    private String pruductName;
    private String productDescription;
    private String supplier;
    private String categoryId;
    private Double price;
    private String image;
    Category category;
    
    
    

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPruductName() {
        return pruductName;
    }

    public void setPruductName(String pruductName) {
        this.pruductName = pruductName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!pruductName.equals(product.pruductName)) return false;
        if (!productDescription.equals(product.productDescription)) return false;
        return supplier.equals(product.supplier);
    }

    @Override
    public int hashCode() {
        int result = pruductName.hashCode();
        result = 31 * result + productDescription.hashCode();
        result = 31 * result + supplier.hashCode();
        return result;
    }

}
