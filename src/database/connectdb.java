package database;
  import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class connectdb 
{

    public static String userName = "root";
    public static String password = "";
    public static String url = "jdbc:mysql://localhost/gui_kbc";    // gui_kbc is database name
    public static String driver = "com.mysql.jdbc.Driver";
    public static Connection conn=null;    // conn is object
    
    static
    {
        try
        {
            Class.forName(driver);   // forname imports driver
            conn= DriverManager.getConnection(url, userName, password);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
}
