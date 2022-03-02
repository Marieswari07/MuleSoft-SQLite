import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class UpdateRecord {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
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

    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public void update(String actor,String actress,String movie_name) {
        String sql = "UPDATE movielist SET actor = ? , "
                + "actress = ? "
                + "WHERE movie_name= ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
               
            pstmt.setString(1, actor);  
            pstmt.setString(2, actress);
            pstmt.setString(3, movie_name);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UpdateRecord app = new UpdateRecord();
        // update the warehouse with id 3
        app.update( "Ryan Reynolds", "Ritu Arya","Red Notice");
    }

}