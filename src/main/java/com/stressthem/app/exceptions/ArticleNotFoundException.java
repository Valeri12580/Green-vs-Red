package com.stressthem.app.exceptions;

public class ArticleNotFoundException  extends RuntimeException{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
