package com.verint.demo.rest.catalog.web;

import com.verint.demo.rest.catalog.dto.BookCreateRequestDTO;
import com.verint.demo.rest.catalog.dto.BookDetailResponseDTO;
import com.verint.demo.rest.catalog.dto.BookListResponseDTO;
import com.verint.demo.rest.catalog.dto.BookUpdateRequestDTO;
import com.verint.demo.rest.catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDetailResponseDTO> findBookDetail(@PathVariable("bookId") String bookId){
        BookDetailResponseDTO bookDetailResponseDTO = bookService.findBookDetail(bookId);
        return ResponseEntity.ok(bookDetailResponseDTO);
    }

    @PostMapping("/book")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateRequestDTO bookCreateRequestDTO) throws URISyntaxException {
        bookService.createNewBook(bookCreateRequestDTO);
        return ResponseEntity.created(new URI("/book")).build();
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookListResponseDTO>> findBookAll(){
        List<BookListResponseDTO> bookListResponseDTOS = bookService.findBookAll();
        return ResponseEntity.ok(bookListResponseDTOS);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> updateBook(@RequestBody BookUpdateRequestDTO bookUpdateRequestDTO, @PathVariable("bookId") String bookId){
        bookService.updateBook(bookUpdateRequestDTO, bookId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") String bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

}
