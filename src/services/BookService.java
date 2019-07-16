package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseUtils;
import domain.Book;

public class BookService {
	public ArrayList<Book> getBookList() {
		String query = "SELECT * FROM book";
		DatabaseUtils dbUtils = new DatabaseUtils();
		Connection connection = dbUtils.createConnection();
		try {
			PreparedStatement getBooks = connection.prepareStatement(query);
			ResultSet resultSet = getBooks.executeQuery();
			
			ArrayList<Book> bookList = new ArrayList<Book>();
			int count=0;
			while (resultSet.next()) {
				Book book = new Book();
				count++;
				book.setIndex(count);
				book.setBook_id(resultSet.getInt(1));
				book.setName(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}		
		return null;
	}
	
	public Book getBook(int id) {
		String query = "SELECT * FROM book WHERE book_id=?";
		DatabaseUtils dbUtils = new DatabaseUtils();
		Connection connection = dbUtils.createConnection();
		try {
			PreparedStatement getBook = connection.prepareStatement(query);
			getBook.setInt(1, id);
			ResultSet resultSet = getBook.executeQuery();
			
			if (resultSet.next()) {
				Book book = new Book();
				book.setBook_id(resultSet.getInt(1));
				book.setName(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}		
		return null;
	}
	
	public void addBook(String bookName, String authorName) {
		DatabaseUtils dbUtils = new DatabaseUtils();
		Connection connection = dbUtils.createConnection();
		String query = "INSERT INTO book(book_name, book_author) VALUES(?,?)";
		try {
			PreparedStatement insertBook = connection.prepareStatement(query);
			insertBook.setString(1, bookName);
			insertBook.setString(2, authorName);
			System.out.println("Inserting data");
			int i = insertBook.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
	}
	

	public void deleteBook(int id) {
		DatabaseUtils dbUtils = new DatabaseUtils();
		Connection connection = dbUtils.createConnection();
		
		String query = "DELETE FROM book WHERE book_id=?";
		try {
			PreparedStatement deleteBook = connection.prepareStatement(query);
			deleteBook.setInt(1, id);
			System.out.println("Deleting data");
			int i = deleteBook.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
	}
	

	public void updateBook(int id, String bookName, String bookAuthor) {
		DatabaseUtils dbUtils = new DatabaseUtils();
		Connection connection = dbUtils.createConnection();
		
		String query = "UPDATE book SET book_name = ?, book_author=?  WHERE book_id=?";
		try {
			PreparedStatement updateBook = connection.prepareStatement(query);
			updateBook.setString(1, bookName);
			updateBook.setString(2, bookAuthor);
			updateBook.setInt(3, id);
			System.out.println("Updating data");
			int i = updateBook.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	
}
