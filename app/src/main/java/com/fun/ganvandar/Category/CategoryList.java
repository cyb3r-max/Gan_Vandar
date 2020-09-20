package com.fun.ganvandar.Category;

public class CategoryList {
    String image;
    String CategoryName;


    public CategoryList( String CategoryName, String image) {

        this.CategoryName = CategoryName;
        this.image= image;
    }

    public CategoryList() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
