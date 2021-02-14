package org.tutorial;

import java.util.ArrayList;
import java.util.List;

public class BookDAOMockImpl implements BookDAO{

	@Override
	public List<Book>  findByAll() {
		// TODO Auto-generated method stub
		
		List<Book> books = new ArrayList<>();
		books.add(new Book(1,"Harry Potter","JK Rowling"));
		books.add(new Book(2,"Le seigneur des anneaux","JRR Tolkien"));
		books.add(new Book(3,"Le Hobbit","JRR Tolkien"));
		return books;
	}

	@Override
	public List<Book> findByTitle(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

}
