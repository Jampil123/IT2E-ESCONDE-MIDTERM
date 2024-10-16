
package esconde_it2e_lab_test;

import java.util.Scanner;


public class Esconde_IT2E_Lab_test {
    
     public void addSLabtest(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Name: ");
        String name = sc.nextLine(); 
        System.out.print("Enter the test date (YYYY-MM-DD): ");
        String date = sc.nextLine(); 
        System.out.print("Enter the test result: ");
        String result = sc.nextLine(); 
        
        String sql = "INSERT INTO labtest (test_name, test_date, test_result) VALUES (?, ?, ?)";


        conf.addRecord(sql, name, date, result);
    }
     
    private void viewLabtest() {
        String votersQuery = "SELECT * FROM labtest";
        String[] votersHeaders = {"ID", "Name", "Date", "Result"};
        String[] votersColumns = {"test_id", "test_name", "test_date", "test_result"};

        config conf = new config();
        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
   private void updateLabtest() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID of the lab test to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter the new test name: ");
        String name = sc.nextLine();
        System.out.print("Enter the new test date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Enter the new test result: ");
        String result = sc.nextLine();

        config conf = new config();
        conf.updateRecord( name, date, result);
}
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int action;
        Esconde_IT2E_Lab_test test = new Esconde_IT2E_Lab_test();
        
         do {
            System.out.println("Choose an option:");
            System.out.println("1. Create Lab Test");
            System.out.println("2. Read Lab Tests");
            System.out.println("3. Update Lab Test");
            System.out.println("4. Delete Lab Test");
            System.out.println("5. Exit");

            System.out.print("Enter Action: ");
            action = sc.nextInt();
            sc.nextLine(); 

            switch (action) {
                case 1:
                  test.addSLabtest();
                    break;

                case 2:
                 test.viewLabtest();
                    break;

                case 3:
                    test.updateLabtest();
                    break;

                case 4:
                    
                    break;

                case 5:
                    System.out.println("Exiting.....");
                    break;

                default:
                    System.out.println("Invalid action! Please select again.");
                    break;
            }

        } while (action != 5);
        
        sc.close();
     
    }
    
}
