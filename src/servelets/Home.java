package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Book;
import services.BookService;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Home() {
        super();
        System.out.println("Home servelet constructor");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Home get");
		BookService bookService = new BookService();
		ArrayList<Book> bookList = bookService.getBookList();
		System.out.println("Book List" + bookList);
		request.setAttribute("books", bookList);
		request.getRequestDispatcher("./pages/Home.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Home post");

		BookService bookService = new BookService();
		if (request.getParameter("addbook") != null) {
			String bookName = request.getParameter("book-name");		
			String authorName = request.getParameter("author-name");
			
			bookService.addBook(bookName, authorName);
			doGet(request, response);
		} else if (request.getParameter("deletebook") != null) {

			String bookid = request.getParameter("bookid");
			bookService.deleteBook(Integer.parseInt(bookid)); 
			doGet(request, response);
		}
	}

}
