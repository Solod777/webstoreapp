package com.webstoreapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webstoreapp.antity.Category;
import com.webstoreapp.antity.Product;
import com.webstoreapp.antity.User;
import com.webstoreapp.services.CategoryService;
import com.webstoreapp.services.CategoryServiceImpl;
import com.webstoreapp.services.ProductService;
import com.webstoreapp.services.ProductServiceImpl;
import com.webstoreapp.services.UserService;
import com.webstoreapp.services.UserServiceImpl;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService categoryService = new CategoryServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserService userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		System.out.println("url is " + url);
		if(url.equals("/")) {
			ArrayList<Product> products = productService.getAll();
			request.setAttribute("products", products);
			request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
		} else if (url.equals("/all-products"))  {
			String idCategory = request.getParameter("id");
			String categoryValue = "All Products";
			ArrayList<Category> categories = categoryService.getAll();
			ArrayList<Product> products = new ArrayList<>();
			if(idCategory == null) {
				products = productService.getAll();
			} else {
				Category c = categoryService.getCategoryBuyId(Integer.parseInt(idCategory));
				if (c!= null) {
					products = productService.getAllByCategory(Integer.parseInt(idCategory));
					categoryValue = c.getCategoryName();
				}				
			}
			request.setAttribute("categoryName", categoryValue);
			request.setAttribute("products", products);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/pages/all-products.jsp").forward(request, response);
		}else if (url.equals("/about"))  {
			String idCategory = request.getParameter("id");
			ArrayList<Category> categories = categoryService.getAll();
			ArrayList<Product> products = new ArrayList<>();
			if(idCategory == null) {
				products = productService.getAll();
			} else {
				products = productService.getAllByCategory(Integer.parseInt(idCategory));
			}
			request.setAttribute("products", products);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/pages/about.jsp").forward(request, response);
		}else if (url.equals("/contact"))  {
			String idCategory = request.getParameter("id");
			ArrayList<Category> categories = categoryService.getAll();
			ArrayList<Product> products = new ArrayList<>();
			if(idCategory == null) {
				products = productService.getAll();
			} else {
				products = productService.getAllByCategory(Integer.parseInt(idCategory));
			}
			request.setAttribute("products", products);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/pages/contact.jsp").forward(request, response);
		}
		else if(url.equals("/get-all")) {
			ArrayList<Category> categories = categoryService.getAll();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
		}else if(url.equals("/delete")) {
			String id = request.getParameter("id");
			categoryService.deleteCategory(Integer.parseInt(id));
			ArrayList<Category> categories = categoryService.getAll();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
		} else if (url.equals("/update")) {
			Integer id = Integer.parseInt(request.getParameter("categoryId"));
			String categoryName = request.getParameter("categoryName");
			String categoryDescription = request.getParameter("categoryDescription");
			Category category = new Category();
	        category.setId(id);
			category.setCategoryName(categoryName);
	        category.setDescription(categoryDescription);
	        categoryService.updateCategory(category);
	        ArrayList<Category> categories = categoryService.getAll();
			request.setAttribute("categories", categories);
	        request.setAttribute("result", "Category with id " + id + " updated successfuly");
			request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
		}else if(url.equals("/create")) {
			String categoryName = request.getParameter("categoryName");
			String categoryDescription = request.getParameter("categoryDescription");
			Category category = new Category();
			category.setCategoryName(categoryName);
			category.setDescription(categoryDescription);
			CategoryServiceImpl serviceImpl = new CategoryServiceImpl();
			serviceImpl.saveCategory(category);
			request.setAttribute("result", "Category " + categoryName + " created successfuly");
			request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
		}else if (url.equals("/login")) {
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
		}
		else if(url.equals("/admin")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
			request.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(request, response);
			}else {
				response.sendRedirect("login");
			}
		}else if (url.equals("/logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login");
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String url = request.getServletPath();
		System.out.println(url);
		if (url.equals("/create-category")) {
			String categoryName = request.getParameter("categoryName");
			String categoryDescription = request.getParameter("categoryDescription");
			Category category = new Category();
			category.setCategoryName(categoryName);
			category.setDescription(categoryDescription);
			CategoryServiceImpl serviceImpl = new CategoryServiceImpl();
			serviceImpl.saveCategory(category);
			request.setAttribute("result", "Category " + categoryName + " created successfuly");
			response.sendRedirect("all-products");
			return;
		}else if (url.equals("/login-user")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			User u = userService.loginUser(login, password);
			if (u != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				response.sendRedirect("admin");
			}else {
				request.setAttribute("error", "Wrong login or password");
				request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			}
		}
	}

}
