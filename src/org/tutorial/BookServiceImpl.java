package org.tutorial;

import java.util.List;

public class BookServiceImpl implements BookService{

	//private BookDAO bookDao = new BookDAOMockImpl();
	private BookDAO bookDao = new BookDAOImpl();
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.findByAll();
	}

	@Override
	public List<Book> getBooksByTitle(String searchText) {
		// TODO Auto-generated method stub
		return bookDao.findByTitle(searchText);
	}

}
