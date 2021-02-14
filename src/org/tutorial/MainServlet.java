package org.tutorial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends javax.servlet.http.HttpServlet {

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		BookService bookService = new BookServiceImpl();

		String pageName = "/accueil.jsp";

		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);

		// Dans la méthode doProcess, récupérer la valeur du paramètre de recherche :
		String searchText = request.getParameter("searchText");

		if (searchText=="") {
			//System.out.println("null"+searchText+"haut");
			List<Book> listBooks = bookService.getAllBooks();

			request.setAttribute("listBooks", listBooks);
		} else {
			//System.out.println("not vide"+searchText+"etvoila");
			//System.out.println(searchText);
			List<Book> listBooks = bookService.getBooksByTitle(searchText);

			request.setAttribute("listBooks", listBooks);
		}

		try {

			rd.forward(request, response);

		} catch (ServletException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doProcess(request, response);
	}

}
