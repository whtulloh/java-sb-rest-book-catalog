package com.verint.demo.rest.catalog.dto;

import lombok.Data;

@Data
public class BookCreateRequestDTO {

    private String title;

    private String author;

    private String description;

}
