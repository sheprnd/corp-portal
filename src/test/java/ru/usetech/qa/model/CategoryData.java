package ru.usetech.qa.model;

public class CategoryData {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryData withName(String categoryName) {

        this.categoryName = categoryName;
        return this;

    }
}
