/*to generate email accounts with the syntax for new hires in different company departments:
    firstname.lastname@department.company.com
*/

package com.EmailApp.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Email em1 = new Email("Smith", "Jacobs");

    
        System.out.print("\nDo you wish to change your password: YES[Y] or No[N]?");
        Scanner input = new Scanner(System.in);
        String change = input.next();
        if(change.equals("Y") || change.equals("y")) {            //note: using the '==' operator here will give unexpected results
            System.out.print("Please type in your new password: ");
            Scanner input1 = new Scanner(System.in);;
            String newPassword = input1.next();
            em1.changePassword(newPassword);
            System.out.println("Your password has been changed!\n");
        }else{
            System.out.println("Your password has not been changed!\n");
        }


        System.out.println("\nPlease enter an alternate email for our records: ");
        Scanner input2 = new Scanner(System.in);
        String anotherEmail = input2.next();
        em1.setAlternateEmail(anotherEmail);


        String information = em1.displayInfo();
        System.out.println(information);



    }
}