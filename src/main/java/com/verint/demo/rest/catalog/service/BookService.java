package com.verint.demo.rest.catalog.service;

import com.verint.demo.rest.catalog.dto.BookCreateRequestDTO;
import com.verint.demo.rest.catalog.dto.BookDetailResponseDTO;
import com.verint.demo.rest.catalog.dto.BookListResponseDTO;
import com.verint.demo.rest.catalog.dto.BookUpdateRequestDTO;
import com.verint.demo.rest.catalog.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public List<BookListResponseDTO> findBookAll();

    public void createNewBook(BookCreateRequestDTO bookCreateRequestDTO);

    public BookDetailResponseDTO findBookDetail(String bookId);

    public void updateBook(BookUpdateRequestDTO bookUpdateRequestDTO, String bookId);

    public void deleteBook(String bookId);

}
