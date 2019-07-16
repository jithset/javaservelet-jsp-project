package domain;

public class Book {
	private int index;
	private int book_id;
	private String name;
	private String author;
	
	public Book() {
		super();
	}

	public Book(int index, int book_id, String name, String author) {
		super();
		this.index = index;
		this.book_id = book_id;
		this.name = name;
		this.author = author;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [index=" + index + ", book_id=" + book_id + ", name=" + name + ", author=" + author + "]";
	}

	
}
