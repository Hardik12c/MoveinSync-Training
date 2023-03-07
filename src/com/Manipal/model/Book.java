package com.Manipal.model;

import com.Manipal.Exception.*;
public class Book {
    String Bookid;
    String title;
    String Author;
    String Category;
    float price;

    public String getBookid() {
        return Bookid;
    }

    public void setBookid(String bookid) {
        Bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public Book(String Bookid, String title, String Author, String Category, float price) throws InvalidBookException{
        if(price<0){
            throw new InvalidBookException("Price cannot be negative");
        }
        if(Category!="Science" && Category!="Technology" && Category!= "Fiction" && Category!="Others"){
            throw new InvalidBookException("Catgory must be Science or Technology or Fiction or Others");
        }
        if(Bookid.charAt(0)!='B' || Bookid.length()!=4){
            throw new InvalidBookException("BookId must be start with B and length must be 4");
        }
        this.Bookid=Bookid;
        this.title=title;
        this.Author=Author;
        this.Category=Category;
        this.price=price;
    }
}
