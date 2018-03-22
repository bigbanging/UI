package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/22.
 */

public class Book {
    //书名
    private String book_name;
    //作者
    private String book_author;

    public Book() {
    }

    public Book(String book_name, String book_author) {
        this.book_name = book_name;
        this.book_author = book_author;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                '}';
    }
}
