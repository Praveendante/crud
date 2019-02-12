import java.util.Scanner;
import java.util.logging.Logger;

public class maincrud {
    private static final Logger LOGGER = Logger.getLogger(maincrud.class.getName());

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        CRUD_Test objTest = new CRUD_Test();
        getsetvalues s = new getsetvalues();

        LOGGER.info("Logger Name: "+LOGGER.getName());


        int c = 0;
        while (c != 5) {
            System.out.println("1.Insert..2.Delete..3.Update..4.Display..5.Exit");
            c = ss.nextInt();
            switch (c) {
                case 1://inserting
                    LOGGER.info("Performing Inserting Operaion");

                    System.out.println("Enter no of details to be entered?");
                    LOGGER.warning("Can cause integer limit crossing problem");
                    int n = ss.nextInt();
                    for (int i = 1; i < n + 1; i++) {
                        s.setNo(ss.nextInt());
                        s.setName(ss.next());
                        s.setEmail(ss.next());
                        objTest.create_data(s);
                    }
                    System.out.println("Successfully inserted..");
                    LOGGER.fine("Data Stored in the DB");
                    break;
                case 2://Deleting
                    LOGGER.info("Deleting operation is performed");
                    LOGGER.warning("Can cause problem due to entering row no doesnot exist!");
                    System.out.println("Enter the rows to be Deleted");
                    objTest.delete_data(ss.nextInt());
                    System.out.println("Successfully deleted..");
                    LOGGER.info("Deleting operation successfull");
                    break;
                case 3://updating
                    LOGGER.info("Updating fuction running");
                    LOGGER.severe("Can cause problem due to typing different data type value!!");
                    System.out.println("Enter the values for no,newno,name,email?");
                    s.setNo(ss.nextInt());
                    s.setNewno(ss.nextInt());
                    s.setName(ss.next());
                    s.setEmail(ss.next());
                    objTest.update_data(s);
                    System.out.println("Successfully updated..");
                    LOGGER.info("updating process over without problem");
                    break;
                case 4://Displaying
                    LOGGER.info("Displaying fuction started!!");
                    LOGGER.warning("Number should be given which is already in db");
                    System.out.println("Enter the row to display its details");
                    objTest.read_data(ss.nextInt());
                    System.out.println("Successfully Displayed..");
                    LOGGER.info("Everything performed");
                    break;

            }
        }
    }
}

        //insert data
//        objTest.create_data(1, "jinu", "jinu@gmail.com");
//        objTest.create_data(2, "jawad", "jawad@gmail.com");
        //read data
//            objTest.read_data(2);
//            //update data
//            //objTest.update_data(100, 24, "jawad2", "jawad2@gmail");
//            //delete data
//            objTest.delete_data(ss.nextInt());



