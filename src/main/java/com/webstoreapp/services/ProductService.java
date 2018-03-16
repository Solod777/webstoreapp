package com.webstoreapp.services;




import java.util.ArrayList;

import com.webstoreapp.antity.Product;

public interface ProductService {
    ArrayList<Product> getAll();
    void saveProduct (Product product);
    void updateProduct (Product product);
    int deleteProductById (Integer id);
    void deleteProductByName (String name);
    ArrayList<Product> getAllByCategory(Integer caegoryID);

}
