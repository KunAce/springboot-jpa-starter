package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookDao bookDao;
    @GetMapping("/test1")
    public void test1() {
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("MongoBook");
        b1.setAuthor("MongoAuthor");
        books.add(b1);

        Book b2 = new Book();
        b2.setId(2);
        b2.setName("JavaBook");
        b2.setAuthor("JavaAuthor");
        books.add(b2);

        bookDao.insert(books);
        List<Book> books1 = bookDao.findByAuthorContains("Java");
        System.out.println(books1);
        Book book = bookDao.findByNameEquals("MongoBook");
        System.out.println(book);
    }

    @Autowired
    MongoTemplate mongoTemplate;
    @GetMapping("/test2")
    public void test2() {
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(3);
        b1.setName("C++Book");
        b1.setAuthor("C++Author");
        books.add(b1);

        Book b2 = new Book();
        b2.setId(4);
        b2.setName("GolangBook");
        b2.setAuthor("GolangAuthor");
        books.add(b2);
        mongoTemplate.insertAll(books);

        List<Book> list = mongoTemplate.findAll(Book.class);
        System.out.println(list);
        Book book = mongoTemplate.findById(4, Book.class);
        System.out.println(book);
    }
}
