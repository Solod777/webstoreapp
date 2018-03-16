package com.webstoreapp.services;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.webstoreapp.antity.Product;

public class ProductServiceImpl implements ProductService {
	 private Connection getConnection() {
	    	Connection connection = null;
	        try {
	        	Class.forName("org.postgresql.Driver");
	        	
	    
	        	
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/store", "postgres", "postgres");
	            System.out.println("GET");
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("select * from products order by id");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                int idProduct = rs.getInt(2);
                String productName = rs.getString(3);
                String productDescription = rs.getString(4);
                String supplier = rs.getString(5);
                Double price = rs.getDouble(6);
                String image = rs.getString(7);

                product.setId(id);
                product.setPruductName(productName);
                product.setProductDescription(productDescription);
                product.setSupplier(supplier);
                product.setPrice(price);
                product.setImage(image);
                products.add(product);
            

            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        Connection con = getConnection();
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement("insert into products (product_name, product_description, supplier, id_category) values(?, ?, ?, ?)");
            pr.setString(1, product.getPruductName());
            pr.setString(2, product.getProductDescription());
            pr.setString(3, product.getSupplier());
            pr.setInt(4, product.getCategory().getId());
            pr.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateProduct(Product product) {
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("update products set product_name=?, " + "category_description=?" + "supplier=? where id=?");
            pr.setString(1, product.getPruductName());
            pr.setString(2, product.getProductDescription());
            pr.setString(3, product.getSupplier());
            pr.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int deleteProductById(Integer id) {
        int result = 0;
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("delete from products where id=?");
            pr.setInt(1, id);
            result = pr.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public void deleteProductByName(String name) {
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("delete from products where product_name=?");
            pr.setString(1, name);
            pr.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

	@Override
	public ArrayList<Product> getAllByCategory(Integer categoryId) {
		ArrayList<Product> products = new ArrayList<>();
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("select * from products where id_category=? order by id");
            pr.setInt(1, categoryId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                int idProduct = rs.getInt(2);
                String productName = rs.getString(3);
                String productDescription = rs.getString(4);
                String supplier = rs.getString(5);
                Double price = rs.getDouble(6);
                String image = rs.getString(7);

                product.setId(id);
                product.setPruductName(productName);
                product.setProductDescription(productDescription);
                product.setSupplier(supplier);
                product.setPrice(price);
                product.setImage(image);
                products.add(product);
            

            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return products;
	}
}
