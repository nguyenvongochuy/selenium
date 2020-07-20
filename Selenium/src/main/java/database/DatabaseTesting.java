package database;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Properties;

public class DatabaseTesting {
    //Connection object
    static Connection conn = null;
    //Statement object
    private static Statement stmt;
    //Result set
    private static ResultSet results = null;

    //Database url
    public static String DB_URL="jdbc:mysql://localhost:3306/users?serverTimezone=UTC";

    //Database username/password
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "adminadmin12";

    //Driver
    public static String driver = "com.mysql.cj.jdbc.Driver";


    @BeforeClass
    public void beforeClass(){
        Properties property = new Properties();
        property.setProperty("username", "root");
        property.setProperty("password", "adminadmin12");

        try {
            //Register JDBC driver
            Class.forName(driver).newInstance();
            //Get DB connection
            System.out.println("Connected database");
            conn= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //conn= DriverManager.getConnection(DB_URL, property);

            System.out.println("Connected database successfully");

            //statement object to send the SQL statement
            System.out.println("created statement...");
            stmt = conn.createStatement();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void afterClass() throws SQLException {
        if (results!=null)
            results.close();
        if (stmt!=null)
            stmt.close();
        if (conn!=null)
            conn.close();

    }

    @Test
    public void test() {
        try {
            results = stmt.executeQuery("SELECT * from user_info");
            while (results.next()) {
                int id = results.getInt("id");
                String firstName = results.getString("firstname");
                String lastName = results.getString("lastname");
                int age = results.getInt("age");

                System.out.println("id=" + id);
                System.out.println("firstName=" + firstName);
                System.out.println("lastName=" + lastName);
                System.out.println("age=" + age);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
