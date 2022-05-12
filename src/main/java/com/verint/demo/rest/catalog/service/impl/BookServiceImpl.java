package com.verint.demo.rest.catalog.service.impl;

import com.verint.demo.rest.catalog.dto.BookCreateRequestDTO;
import com.verint.demo.rest.catalog.dto.BookDetailResponseDTO;
import com.verint.demo.rest.catalog.dto.BookListResponseDTO;
import com.verint.demo.rest.catalog.dto.BookUpdateRequestDTO;
import com.verint.demo.rest.catalog.model.Book;
import com.verint.demo.rest.catalog.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private Map<String, Book> books = new HashMap<>();

    public BookServiceImpl() {
        Book book1 = new Book();
        book1.setId("1");
        book1.setTitle("MY book 1");
        book1.setAuthor("Sir Conan");
        book1.setDescription("Lorem ipsum sit amet dolor van van");

        Book book2 = new Book();
        book2.setId("2");
        book2.setTitle("MY book 2");
        book2.setAuthor("Sir Leblanc");
        book2.setDescription("Lorem ipsum sit amet dolor van van");

        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
    }

    @Override
    public List<BookListResponseDTO> findBookAll() {
        List<Book> bookList = new ArrayList<>(books.values());

        return bookList.stream().map((b) -> {
            BookListResponseDTO bookListResponseDTO = new BookListResponseDTO();
            bookListResponseDTO.setId(b.getId());
            bookListResponseDTO.setTitle(b.getTitle());
            bookListResponseDTO.setAuthor(b.getAuthor());
            bookListResponseDTO.setDescription((b.getDescription()));
            return bookListResponseDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateRequestDTO bookCreateRequestDTO) {
        Book book = new Book();
        book.setTitle(bookCreateRequestDTO.getTitle());
        book.setAuthor(bookCreateRequestDTO.getAuthor());
        book.setDescription(bookCreateRequestDTO.getDescription());
        book.setId(UUID.randomUUID().toString());
        books.put(book.getId(), book);
    }

    @Override
    public BookDetailResponseDTO findBookDetail(String bookId) {
        Book book = books.get(bookId);
        BookDetailResponseDTO bookDetailResponseDTO = new BookDetailResponseDTO();
        bookDetailResponseDTO.setTitle(book.getTitle());
        bookDetailResponseDTO.setAuthor(book.getAuthor());
        bookDetailResponseDTO.setDescription(book.getDescription());
        return bookDetailResponseDTO;
    }

    @Override
    public void updateBook(BookUpdateRequestDTO bookUpdateRequestDTO, String bookId) {
        Book book = books.get(bookId);
        book.setTitle(bookUpdateRequestDTO.getTitle());
        book.setAuthor(bookUpdateRequestDTO.getAuthor());
        books.put(book.getId(), book);
    }

    @Override
    public void deleteBook(String bookId) {
        books.remove(bookId);
    }

}
