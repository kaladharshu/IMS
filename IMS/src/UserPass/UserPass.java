/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPass;
import java.util.Scanner;

/**
 *
 * @author kalad
 */
public class UserPass {
       String user,pass;
    UserPass(String user,String pass)
    {
    Scanner scan =new Scanner(System.in);
   
    System.out.print("Enter the UserName");
   this.user=scan.nextLine();
    
    System.out.print("Enter the Password");
   this.pass=scan.nextLine();
    
    
  if(user.equals("Rama")&&(pass.equals("Seetha")))
  {
          System.out.println("Welcome to IMS");
  }
  else
  {
      System.out.println("SORRY!!!You are not able to access");
  }
         
    
    }
    
    
            
    
   
            
    
    
}
