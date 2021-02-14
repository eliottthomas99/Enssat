package org.tutorial;

import java.util.List;

public interface BookDAO {
	public List<Book>  findByAll();
	
	List<Book> findByTitle(String searchText);
}
