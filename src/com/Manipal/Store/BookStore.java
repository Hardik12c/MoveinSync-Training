package com.Manipal.Store;

import com.Manipal.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore {
    List<Book> arr=new ArrayList<>();

    public void addBook(Book b){
        arr.add(b);
    }
    public void updateBook(String bookid){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getBookid().equals(bookid)){
                Scanner s=new Scanner(System.in);
                System.out.println("Enter the price you want to update");
                float newprice=s.nextFloat();
                arr.get(i).setPrice(newprice);
                break;
            }
        }
    }
    public void DeleteBook(String bookid){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getBookid().equals(bookid)){
                arr.remove(i);
                break;
            }
        }
    }
    public void searchbytitle(String title){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getTitle().equals(title)){
                System.out.println(arr.get(i).getAuthor());
                System.out.println(arr.get(i).getCategory());
                System.out.println(arr.get(i).getBookid());
                System.out.println(arr.get(i).getPrice());
                break;
            }
        }
    }
    public void searchbyauthor(String author){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getAuthor().equals(author)){
                System.out.println(arr.get(i).getTitle());
                System.out.println(arr.get(i).getCategory());
                System.out.println(arr.get(i).getBookid());
                System.out.println(arr.get(i).getPrice());
                break;
            }
        }
    }
    public void displayall(){
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).getAuthor());
            System.out.println(arr.get(i).getTitle());
            System.out.println(arr.get(i).getCategory());
            System.out.println(arr.get(i).getBookid());
            System.out.println(arr.get(i).getPrice());
        }
    }
}
