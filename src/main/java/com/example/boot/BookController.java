package com.example.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageable = PageRequest.of(2,3);
        Page<Book> page = bookService.getBookByPage(pageable);
        System.out.println("Total number of Pages: " + page.getTotalPages());
        System.out.println("Total number of Records: " + page.getTotalElements());
        System.out.println("Results: " + page.getContent());
        System.out.println("Current Page: " + (page.getNumber() + 1));
        System.out.println("Number of records in current page: " + page.getNumberOfElements());
        System.out.println("Number of records in each page:" + page.getSize());
    }

    @GetMapping("/search")
    public void search() {
        List<Book> bs1 = bookService.getBookByIdAndAuthor("Cauthor", 3);
        List<Book> bs2 = bookService.getBooksByAuthorStartingWith("D");
        List<Book> bs3 = bookService.getBooksByIdAndName("E",5);
        List<Book> bs4 = bookService.getBooksByPriceGreaterThan(30F);
        Book b = bookService.getMaxIdBook();
        System.out.println("bs1: " + bs1);
        System.out.println("bs2: " + bs2);
        System.out.println("bs3: " + bs3);
        System.out.println("bs4: " + bs4);
        System.out.println("b: " + b);
    }

    @GetMapping("/save")
    public void save() {
        Book book = new Book();
        book.setAuthor("Fauthor2");
        book.setName("Fbook2");
        book.setPrice(23F);
        bookService.addBook(book);
    }
}
