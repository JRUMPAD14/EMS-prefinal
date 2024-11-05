package it2eemployees;

import java.util.Scanner;

public class IT2EEMPLOYEES {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        do{
            System.out.println("\n------------------------------------");
            System.out.println("WELCOME TO EMS");
            System.out.println("PLEASE CHOOSE YOUR DEPARTMENT");
            System.out.println("1. DEVELOPERS DEPARTMENT");
            System.out.println("2. PROJECT MANAGEMENT DEPARTMENT");
            System.out.println("3. SECURITY DEPARTMENT");
            System.out.println("4. MANAGEMENT DEPARTMENT");
            System.out.println("5. EXIT");

            System.out.println("Enter Action:");
            int action = sc.nextInt();

            switch(action){
                case 1: 
                    Employee em = new Employee();
                    em.eTransaction();
                    break;
                    
                case 5:
                    System.out.println("Exit Selected...type 'yes' to continue:");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                    exit=false;
                    }
                    break;
            }
        }while(exit);
    }

}
