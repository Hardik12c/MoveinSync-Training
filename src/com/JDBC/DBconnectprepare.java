
package JDBC;
import java.sql.*;
import java.util.Scanner;

public class DBconnectprepare {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/moveinsync";
        String username = "postgres";
        String password = "Hard123@c";

        Connection c =null;
        try {
            Class.forName("org.postgresql.Driver");

            c=DriverManager.getConnection(url, username, password);
            Statement st= c.createStatement();

            PreparedStatement preparedStatement=c.prepareStatement("INSERT INTO temp (id,name,salary) VALUES (?,?,?)");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter User Id: ");
            int user_Id = sc.nextInt();
            System.out.println("Enter User Name: ");
            String user_Name = sc.next();
            System.out.println("Enter User Salary: ");
            int user_Salary = sc.nextInt();

            preparedStatement.setInt(1, user_Id);
            preparedStatement.setString(2, user_Name);
            preparedStatement.setInt(3, user_Salary);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected);
            preparedStatement.close();

            ResultSet resultSet = st.executeQuery("SELECT * FROM temp");


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + salary);
            }


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
}

//        try {
//                Connection connection = DriverManager.getConnection(url, username, password);
//
//                // Create a statement object to send SQL queries to the database
//                Statement statement = connection.createStatement();
//
//                // Create a PreparedStatement object to execute the SQL INSERT statement
//                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ? (id, name, email) VALUES (?, ?, ?)");
//
//                Scanner sc = new Scanner(System.in);
//
//                System.out.println("Enter Table Name: ");
//                String table_name = sc.next();
//                System.out.println("Enter User Id: ");
//                int user_Id = sc.nextInt();
//                System.out.println("Enter User Name: ");
//                String user_Name = sc.next();
//                System.out.println("Enter User Email: ");
//                String user_Email = sc.next();
//
//                preparedStatement.setString(1,table_name);
//                preparedStatement.setInt(2, user_Id);
//                preparedStatement.setString(3, user_Name);
//                preparedStatement.setString(4, user_Email);
//
//                // Execute the SQL INSERT statement
//                int rowsAffected = preparedStatement.executeUpdate();
//
//                // Print out the number of rows affected
//                System.out.println(rowsAffected + " rows inserted.");
//
//                // Close the PreparedStatement and Connection objects
//                preparedStatement.close();
//
//                // Execute a query and get the results
//
//            // Print out the results
//
//
//            // Close the connection
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Error connecting to database: " + e.getMessage());
//        }
//    }
//}

