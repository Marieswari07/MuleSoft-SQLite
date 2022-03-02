import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class Insert {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/movie.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert(String movie_name, String actor,String actress,String director,String year_of_release ) {  
        String sql = "INSERT INTO movielist(movie_name,actor,actress,director,year_of_release) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, movie_name);  
            pstmt.setString(2, actor);  
            pstmt.setString(3, actress);
            pstmt.setString(4, director);  
            pstmt.setString(5, year_of_release);    
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        Insert app = new Insert();  
        // insert three new rows  
        app.insert("Goodfellas","Joe Pesci","Lorraine","Martin Scorsese","1990");
        app.insert("Red Notice","Dwayne Johnson","Gal Gadot","Rawson Marshall","2021");
        app.insert("Gone Girl","Ben Affleck","Roseamund Pike","David Fincher","2014");
        app.insert("Ittefaq","Sidharth Malhotra","Sonakshi Sinha","Yash Chopra","2017");
        app.insert("Badla","Amitabh Bachchan","Taapsee Pannu","Sujoy Ghosh","2019");
        app.insert("Shershaah","Sidharth Malhotra","Kiara Advani","Vishnuvardhan","2021");
        
        
         
    }  
   
}  