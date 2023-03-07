package com.Manipal.Util;

import com.Manipal.Exception.InvalidBookException;
import com.Manipal.Store.BookStore;
import com.Manipal.model.Book;

import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) throws Exception{

            BookStore newBookstore = new BookStore();
            System.out.println("Enter three Book objects");
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter the " + (i + 1) + " book details");
                System.out.println("Enter the bookid");
                String id = sc.next();
                System.out.println("Enter the title");
                String title = sc.next();
                System.out.println("Enter the Author name");
                String Author = sc.next();
                System.out.println("Enter the Category");
                String categ = sc.next();
                System.out.println("Enter the price");
                float price = sc.nextFloat();
                Book bk = new Book(id, title, Author, categ, price);
                newBookstore.addBook(bk);
            }
        System.out.println("Enter the author name u want to search");
            String author= sc.next();
            newBookstore.searchbyauthor(author);

        System.out.println("Enter the title u want tot search");
        String title=sc.next();
        newBookstore.searchbytitle(title);
        newBookstore.displayall();
        System.out.println("Enter the id of the book u want to change");
        String bookid=sc.next();
        newBookstore.updateBook(bookid);
        System.out.println("Enter the bookid u want to delete");
        String delid=sc.next();
        newBookstore.DeleteBook(delid);


    }

}
