package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Books;
import com.example.service.BooksService;

//marking class as controller
@RestController
public class BooksController
{
    //autowire the BooksService class
    @Autowired
    BooksService booksService;

    //creating a getMapping that retrives all the books detail from the database
    @GetMapping("/book")
    private List<Books> getALlBooks(){
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrives the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid){
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specific book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid){
        booksService.delete(bookid);
    }

    //creating post mapping that post the details in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books;
    }

}