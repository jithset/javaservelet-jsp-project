package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;
import services.BookService;

@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("itemid"));
		BookService bookService = new BookService();
		Book book = bookService.getBook(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("./pages/Edit.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookid"));	
		String bookName = request.getParameter("bookname");
		String authorName = request.getParameter("authorname");
		
		BookService bookService = new BookService();
		bookService.updateBook(bookId, bookName, authorName);
		
		response.sendRedirect("Home");
	}

}
