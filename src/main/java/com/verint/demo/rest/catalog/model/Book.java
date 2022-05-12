package com.verint.demo.rest.catalog.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private String id;

    private String title;

    private String author;

    private String description;
}
