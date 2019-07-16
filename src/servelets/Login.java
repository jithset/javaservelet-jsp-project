package servelets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseUtils;
import domain.Book;
import services.Account;
import services.BookService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login get");
		request.getRequestDispatcher("./pages/Login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login post"+request.getAttribute("error"));
		String username = request.getParameter("username");		
		String password = request.getParameter("password");
		// create 
		Account account = new Account();
		// i > 0 user created successfully
		boolean isLoggedIn = account.loginUser(username, password);
		if (isLoggedIn) {
			System.out.println("Logged in successfully");
			
//			BookService bookService = new BookService();
//			ArrayList<Book> bookList = bookService.getBookList();
//			System.out.println("Book List" + bookList);
//			request.setAttribute("books", bookList);
//			request.getRequestDispatcher("./pages/Home.jsp").forward(request, response);
			//request.getRequestDispatcher("Home").forward(request, response);
			response.sendRedirect("Home");
		} else {
			request.setAttribute("error", "Login Failed");
			request.getRequestDispatcher("./pages/Login.jsp").forward(request, response);
		}
	}
}
