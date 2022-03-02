import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class Table {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/movie.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS movielist (\n"  
                + " movie_name text PRIMARY KEY,\n"  
                + " actor text NOT NULL,\n"  
                + " actress text NOT NULL,\n"  
                 + " director text NOT NULL,\n"  
                 + " year_of_release text NOT NULL\n"  
                + ");"; 
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        createNewTable();  
    }  
   
}  