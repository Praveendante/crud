import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 class CRUD_Test extends DB_Connection {
     /***
      *
      * @param s -values setted on getters and setters for name,no and email and passed as a single argument.
      */


    void create_data( getsetvalues s)  {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps;
        try {

            File file = new File("/Users/admin/Downloads/bookeh.jpeg");
            FileInputStream fis = new FileInputStream(file);


            String query = "insert into user(sl_no,name,email,image) values (?,?,?,?)";
            ps =connection.prepareStatement(query);
            ps.setInt(1,s.getNo());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setBinaryStream(4, fis, (int) file.length());
            ps.executeUpdate();
            System.out.println(ps);
            // ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /***
      *
      * @param sl_no number of the row to read.
      * @return returning the values of the row by single variable n.
      */

     String read_data(int sl_no) {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps;
        ResultSet rs;
        String n="";
        try {
            String query = "select * from user WHERE sl_no = " + sl_no;
            ps = connection.prepareStatement(query);

            File file = new File("/Users/admin/Downloads/bookeh1.jpeg ");
            FileOutputStream fos = new FileOutputStream(file);
           // byte b[];
            Blob blob;
            //ps.setString(1, sl_no);
            System.out.println(ps);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Sl no -" + rs.getInt("sl_no"));
                System.out.println("name -" + rs.getString("name"));
                System.out.println("email -" + rs.getString("email"));
                blob = rs.getBlob("image");
                System.out.println("image stored" + blob);
                byte b[] = blob.getBytes(1, (int) blob.length());
                fos.write(b);
                System.out.println("---------------");
               n=rs.getInt("sl_no")+rs.getString("name")+rs.getString("email");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;

    }

     /***
      *
      * @param s values of name,no,new no,email from getters and setters by passing single object
      */

     void update_data(getsetvalues s) {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps;
        try {
            String query = "update user set sl_no=?,name=?,email=? where sl_no=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, s.getNewno());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setInt(4, s.getNo());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /***
      *
      * @param sl_no number of the row to perform delete operation
      */

    void delete_data(int sl_no) {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps;
        try {
            String query = "delete from user where sl_no=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, sl_no);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
