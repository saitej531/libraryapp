package com.dxctraining.ui;


import com.dxctraining.authormgt.entities.*;
import com.dxctraining.authormgt.exception.*;
import com.dxctraining.authormgt.service.*;
import com.dxctraining.bookmgt.entities.*;
import com.dxctraining.bookmgt.exception.*;
import com.dxctraining.bookmgt.exception.InvalidArgumentException;
import com.dxctraining.bookmgt.service.*;
import java.util.*;
@Component
public class LibraryUi {
	
	@Autowierd
	private IAuthorService authorService;
	private IBookService bookService ;

	
	
@PostConstruct
	public void runUi() {
		try {
			Author author1 = new Author("sai", "er1");
			Author author2 = new Author("teja", "dr4");
			Author author3 = new Author("ashok", "fr4");
			Author author4 = new Author("naveen", "cf5");
			authorService.add(author1);
			authorService.add(author2);
			authorService.add(author3);
			authorService.add(author4);

			Book book1 = new Book("Ramayanam", "Efrrjj133", author1);
			bookService.add(book1);
			String id1 = book1.getId();
			Book book2 = new Book("Mahabharatam", "dedede78", author2);
			bookService.add(book2);
			String id2 = book2.getId();
			
			EngineeringBook engineerBook = new EngineeringBook("Eng.Book", "rh3", author3, "circutbook",
					"signals and systems");
			ItBook programBook = new ItBook("IT book", "java", author4, "Complete reference", 8.0);
			bookService.add(engineerBook);
			bookService.add(programBook);
			
			

		} catch (InvalidArgumentException e) {
			e.printStackTrace();
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		} catch (AuthorNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void displayAll() {
		List<Book> bookList = bookService.findAll();
		for (Book book : bookList) {
			display(book);
		}
		List<Author> authorList = authorService.findAll();
		for (Author author : authorList) {
			display(author);
		}
	}

	public void display(Book book) {
		System.out.println("-----Book Details------");
		System.out.println("Name of the book : " + book.getName() + ". Book id: " + book.getId());

		Author author = book.getAuthor();
		System.out.println("Author of the book is " + author.getName() + ". Author Id: " + author.getId());
		
		
		if (book instanceof EngineeringBook) {
			EngineeringBook engBook = (EngineeringBook) book;
			System.out.println("IC Engine is an Automobile book " + engBook.getAutoBook()
					+ "Fluid Mechanics is a Mechanical book " + engBook.getMechBook());
		}
		if (book instanceof ItBook) {
		ItBook progBook = (ItBook) book;
			System.out.println(
					"Complete refernce is Java" + progBook.getLanguage() + "Version is " + progBook.getVersion());
		}
	}
		

		public void display(Author author) {
			System.out.println("-----Author Details------");
			System.out.println("Name of the Author : " + author.getName() + ". Author id: " + author.getId());

		}
	
	
	

}
