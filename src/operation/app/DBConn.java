package operation.app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConn {

    static Connection conn;
    public static Connection connect() {
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/todo", "postgres", "admin");
            System.out.println("Connection established......");
            //Creating the Statement
            Statement stmt = conn.createStatement();
            //Query to create a table
            String query = "CREATE TABLE IF NOT EXISTS todotable("
                + "ID SERIAL PRIMARY KEY, "
                + "TODO VARCHAR (200) NOT NULL)";
            stmt.execute(query);
            System.out.println("Table Created......");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error during db connection:"+e);
        }
        return conn;
    }
}
