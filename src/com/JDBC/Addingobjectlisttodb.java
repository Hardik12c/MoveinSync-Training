package com.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class product{
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    product(int id, String name, float price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
public class Addingobjectlisttodb {

    String url = "jdbc:postgresql://localhost:5432/moveinsync";
    String username = "postgres";
    String password = "Hard123@c";
    Connection c =null;
    public List<product> getlist(){
        List<product> lp=new ArrayList<>();
        try{
            c= DriverManager.getConnection(url, username, password);
            Statement st= c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT * FROM product");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getInt("price");
                product p=new product(id,name,price);
                lp.add(p);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                c.close();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        return lp;
    }
    public void addlisttodb(List<product> lp){
        try {
            c= DriverManager.getConnection(url, username, password);


            PreparedStatement preparedStatement=c.prepareStatement("INSERT INTO product (id,name,price) VALUES (?,?,?)");


            for(int i=0;i<lp.size();i++){
                product p=lp.get(i);
                preparedStatement.setInt(1, p.getId());
                preparedStatement.setString(2, p.getName());
                preparedStatement.setFloat(3, p.getPrice());
                preparedStatement.addBatch();
            }

            int a[] = preparedStatement.executeBatch();

            System.out.println(a.length);
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try {
                c.close();
            }catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many products you want to add to the database");
        int num=sc.nextInt();
        List<product> lp=new ArrayList<>();
        while(num!=0){
            System.out.println("Specify the product id");
            int id=sc.nextInt();
            System.out.println("Specify the name of the product");
            String name=sc.next();
            System.out.println("Specify the price of the product");
            float price=sc.nextFloat();
            num--;
            product p1=new product(id,name,price);
            lp.add(p1);
        }
        Addingobjectlisttodb adddb=new Addingobjectlisttodb();
        adddb.addlisttodb(lp);

        List<product> lpout=adddb.getlist();

        lpout.stream().forEach(product -> System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice()));
    }
}
