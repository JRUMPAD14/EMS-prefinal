package it2eemployees;

import java.util.Scanner;

public class Employee {
    
    public void eTransaction(){
    
        Scanner sc = new Scanner(System.in);
        String response;
        do{
            System.out.println("\n------------------------------------");
            System.out.println("EMPLOYEE DEPARTMENT PANEL");
            System.out.println("1. ADD EMPLOYEE");
            System.out.println("2. VIEW EMPLOYEE");
            System.out.println("3. UPADATE EMPLOYEE");
            System.out.println("4. DELETE EMPLOYEE");
            System.out.println("5. EXIT");

            System.out.print("Enter Selection: ");
            int act = sc.nextInt();
            Employee em = new Employee(); 
            switch(act){
                case 1:
                  em.addEmployee();
                  em.viewEmployee();
                   break;
                case 2:
                    viewEmployee();
                   break;
                case 3:
                  em.viewEmployee();
                  em.updateEmployee();
                  em.viewEmployee();
                    break;
                case 4:
                  em.viewEmployee();
                  em.deleteEmployee();
                  em.viewEmployee();
                    break;
                case 5:
                    
                    break;
                   
        }
        System.out.println("Do you want to continue? (yes/no):");
        response = sc.next();
        
    }while(response.equalsIgnoreCase("yes"));    
  }
    
  public void addEmployee(){
  
     Scanner sc = new Scanner(System.in);
     
      System.out.print("Employee First Name: ");
      String fname = sc.next();
      System.out.print("Employee Last Name: ");
      String lname = sc.next();
      System.out.print("Employee Email: ");
      String email = sc.next();
      System.out.print("Employee Position: ");
      String position = sc.next();
      System.out.print("Employee Status: ");
      String status = sc.next();
      
      
      String qry = "INSERT INTO tbl_employee(e_fname, e_lname, e_email, e_position, e_status)VALUES (?,?,?,?,?)";
      config conf = new config();
      conf.addRecord(qry, fname, lname, email, position, status);
  }
    
  public void viewEmployee(){
        String qry = "SELECT * FROM tbl_employees";
        String[] hrds = {"ID", "Firstname", "Lastname", "Email", "Position", "Status"};
        String[] clms = {"e_id", "e_fname", "e_lname", "e_email", "e_position", "e_status"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clms);
    }
  
  private void updateEmployee(){
      
      Scanner sc = new Scanner(System.in);
      config conf = new config();
      System.out.println("Enter ID to Update: ");
      int id = sc.nextInt();
      
      while(conf.getSingleValue("SELECT e_id FROM tbl_employee WHERE e_id = ?",id)==0){
          System.out.println("Selected ID doesn't exist!");
          System.out.println("Select Employee ID Again: ");
          id = sc.nextInt();
      
          
      }
      
        System.out.print("New Employee First Name: ");
        String fname = sc.next();
        System.out.print("New Employee Last Name: ");
        String lname = sc.next();
        System.out.print("New Employee Email: ");
        String email = sc.next();
        System.out.print("New Employee Position: ");
        String position = sc.next();
        System.out.print("New Employee Status: ");
        String status = sc.next();
      
          
         String qry = "UPDATE tbl_employee SET e_fname = ?, e_lname = ?, e_email = ?, e_position = ?, e_status = ? WHERE c_id ";
        conf.updateRecord (qry, fname, lname, email, position, status);
      }
  
  public void deleteEmployee(){
      Scanner sc = new Scanner(System.in);
      config conf = new config();
      System.out.println("Enter ID to Delete: ");
      int id = sc.nextInt();
      
      while(conf.getSingleValue("SELECT e_id FROM tbl_employee WHERE e_id = ?",id)==0){
          System.out.println("Selected ID doesn't exist!");
          System.out.println("Select Employee ID Again: ");
          id = sc.nextInt();
      
      String qry = "DELETE FROM tbl_employee WHERE c_id = ?";
      conf.deleteRecord(qry, id);
  
    }
  
  } 

}
 
