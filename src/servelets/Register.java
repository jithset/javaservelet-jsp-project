package servelets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseUtils;
import services.Account;
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Register get");
		request.getRequestDispatcher("./pages/Register.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("Register post");
		String username = request.getParameter("username");		
		String password = request.getParameter("password");
		// create 
		Account account = new Account();
		// i > 0 user created successfully
		int i = account.createAccount(username, password);
		String msg = "Account creation failed";
		if (i>0) {
			msg = "Account Created Successfully!";
		}
		request.setAttribute("message", msg);
		//request.getRequestDispatcher("./Login").forward(request, response);
		response.sendRedirect("Login");
	}
}
