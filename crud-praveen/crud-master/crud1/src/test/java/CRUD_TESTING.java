//import org.junit.Before;
import org.junit.Test;

//import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class CRUD_TESTING {

    @Test
    public void testit() {
        CRUD_Test objTest=new CRUD_Test();
        getsetvalues s=new getsetvalues();
       // Scanner ss=new Scanner(System.in);
        try {
//            s.setNo(1);
//            s.setName("Praveendante");
//            s.setEmail("bbb.pravceen001@gmail.com");
//            objTest.create_data(s);
//            objTest.create_data(30, "lucky", "jinu@gmail.com");
        //    objTest.update_data(1, 22, "jawad2", "jawad2@gmail");
            //objTest.create_data();
      //      objTest.read_data(s);

//assertEquals(objTest.create_data(s),objTest.read_data(2));          // objTest.create_data(2, "jawad", "jawad@gmail.com");
          //  assertEquals("25jawad2jawad2@gmail",objTest.read_data(22));

          assertEquals("40luckybbb.ppp.zzz",objTest.read_data(40));
            s.setNo(40);
            s.setNewno(41);
            s.setName("baby");
            s.setEmail("babe@5");
            objTest.update_data(s);
            assertEquals("41babybabe@5",objTest.read_data(41));
            assertEquals("",objTest.read_data(40));
            //read data
         //   objTest.read_data(2);
            //update data
     //      objTest.update_data(2, 22, "jawad2", "jawad2@gmail");
            //delete data
           // objTest.delete_data(1);
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
