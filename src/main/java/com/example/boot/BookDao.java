package com.example.boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> getBooksByAuthorStartingWith(String author);

    List<Book> getBooksByPriceGreaterThan(Float price);

    @Query(value = "SELECT * FROM t_book WHERE id=(SELECT MAX(id) FROM t_book )", nativeQuery = true)
    Book getMaxIdBook();

    @Query("SELECT b FROM t_book b WHERE b.id>:id AND b.author=:author")
    List<Book> getBookByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

    @Query("SELECT b FROM t_book b WHERE b.id<?2 AND b.name LIKE %?1%")
    List<Book> getBooksByIdAndName(String name, Integer id);
}
