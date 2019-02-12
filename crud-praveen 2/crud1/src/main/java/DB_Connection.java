import java.sql.Connection;
import java.sql.DriverManager;

class DB_Connection  {
   // public static void main(String[] args) {
       // DB_Connection obj_DB_Connection=new DB_Connection();
    //    System.out.println(obj_DB_Connection.get_connection());
  //  }
    Connection get_connection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root", "Activeai@123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
