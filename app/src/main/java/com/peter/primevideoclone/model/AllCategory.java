package com.peter.primevideoclone.model;

import java.util.List;

public class AllCategory
{
    Integer categoryId;
    String categoryTitle;

    private List<CategoryItem> categoryItemList = null;

    public AllCategory(Integer categoryId, String categoryTitle, List<CategoryItem> categoryItemList)
    {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
