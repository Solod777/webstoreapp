package com.webstoreapp.services;





import java.util.ArrayList;

import com.webstoreapp.antity.Category;

public interface CategoryService {
    ArrayList<Category> getAll();
    void saveCategory (Category category);
    void updateCategory (Category category);
    int deleteCategory (Integer id);
    void deleteCategoryByName (String name);
    Category getCategoryBuyId (Integer id);

}
