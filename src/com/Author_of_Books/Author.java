package com.Author_of_Books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Author {
    String firstName;
    String LastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    Author(String firstname,String lastName){
        this.firstName=firstname;
        this.LastName=lastName;
    }

    @Override
    public String toString() {
        return "Books{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}

class Book{
    String title;
    Author author;

    Book(Author author,String title){
        this.title=title;
        this.author=author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

class BookImplementation{
    public List<String> firstNameofAuthors(Author... authors){
        return Arrays.stream(authors).map(a->a.getFirstName()).collect(Collectors.toList());
    }
    public List<String> titlesOf(Book... books){
        return Arrays.stream(books).map(book->book.getTitle()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Author author1=new Author("Hardik","Garg");
        Author author2=new Author("Hello","World");
        Author author3=new Author("Jai","jain");
        Author author4=new Author("Jubraj","Dev");
        Book bk1=new Book(author1,"good");
        Book bk2=new Book(author2,"kick");
        Book bk3=new Book(author3,"Easy");
        Book bk4=new Book(author4,"Simple");
        BookImplementation bki=new BookImplementation();
        System.out.println(bki.firstNameofAuthors( author1,author2,author3,author4));
        System.out.println(bki.titlesOf( bk1,bk2,bk3,bk4));
    }
}