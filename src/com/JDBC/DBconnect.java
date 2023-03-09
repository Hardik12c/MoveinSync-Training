package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnect {
    public static void main(String[] args) {
        Connection c=null;
        try{
            Class.forName("org.postgresql.Driver");
            c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/moveinsync","postgres","Hard123@c");
            if(c!=null){
                System.out.println("Connection Established");
            }else{
                System.out.println("Connection Failed");
            }
            Statement stmt=c.createStatement();
            String sql="select * from temp";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                c.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
