package com.webstoreapp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.webstoreapp.antity.Category;

public class CategoryServiceImpl implements CategoryService {
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
	public ArrayList<Category> getAll() {
		ArrayList<Category> categories = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("select * from categories order by id");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				int id = rs.getInt(1);
				String categoryName = rs.getString(2);
				String description = rs.getString(3);
				Date creationDate = rs.getDate(4);
				category.setId(id);
				category.setCategoryName(categoryName);
				category.setDescription(description);
				category.setCreationDate(creationDate);
				categories.add(category);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void saveCategory(Category category) {
		Connection con = getConnection();
		try {
			PreparedStatement pr = con
					.prepareStatement("insert into categories (category_name, category_description) values(?, ?)");
			pr.setString(1, category.getCategoryName());
			pr.setString(2, category.getDescription());
			// pr.setString(3, String.valueOf(category.getCreationDate())); //???????
			pr.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCategory(Category category) {
		Connection con = getConnection();
		try {
			PreparedStatement pr = con
					.prepareStatement("update categories set category_name=?, " + "category_description=? where id=?");
			pr.setString(1, category.getCategoryName());
			pr.setString(2, category.getDescription());
			pr.setInt(3, category.getId());
			pr.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int deleteCategory(Integer id) {
		int result = 0;
		Connection con = getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("delete from categories where id=?");
			pr.setInt(1, id);
			result = pr.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void deleteCategoryByName(String name) {
		Connection con = getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("delete from categories where category_name=?");
			pr.setString(1, name);
			pr.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Category getCategoryBuyId(Integer id) {
		Category category = null;
		Connection con = getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("select * from categories where id=?");
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				category = new Category();
				String categoryName = rs.getString(2);
				String description = rs.getString(3);
				Date creationDate = rs.getDate(4);
				category.setId(id);
				category.setCategoryName(categoryName);
				category.setDescription(description);
				category.setCreationDate(creationDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return category;
	}
}
