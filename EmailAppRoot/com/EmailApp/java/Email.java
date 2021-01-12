package com.EmailApp.java;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength = 8;  //default, can change as needed
    private int mailboxCapacity = 500;      //default , can change as needed
    private String alternateEmail;
    private String generatedEmail;
    private String companySuffix = "company.com";

    //constructor to recieve the first name and the last name of the employee, and to set other details of the employee

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("\nUSER NAME: " + this.firstName + " " + this.lastName);
        //call a method to recieve the department
        this.department = setDepartment();
        //call a method to generate a random password for the email account
        this.password = randomPassword(defaultPasswordLength);
        //generate the email
        this.generatedEmail = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your generated password is: " + this.password);
    }


    /*ask for the department
    - private method because its meant to be called within this class only
    */

    private String setDepartment() {
        System.out.print("\nDepartment Codes:\n1 - for Sales \n2 - for Development \n3 - for Accounting\n0 - for none \nEnter the Department Code:");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1){
            return "sales";
        }else if (choice == 2) {
            return "development";
        }else if (choice == 3) {
            return "accounting";
        }else {
            return "";
        }
    }


    /*generate a random password -
    - private method because its  meant to be called within this class only
    - ALGORITHM: generate a random number between the length of the password set (in this case 0 to 26), and then access the character at that position int he string that has been defined
                 do the same for 'length' number of characters (length will be passed in as an argument)
                 this results in generating a random string as password that has the specified length
    */

    private String randomPassword(int passwordLength) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#@$*!";       //the random password will consist characters out of this set
        char[] password = new char[passwordLength];
        for(int i = 0; i < passwordLength; i++){
            int rand = (int) (Math.random() * passwordSet.length());            //need to cast since Math.random generates a random double number but we need an int
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //setter method for the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //setter method for the alternate email
    public void setAlternateEmail(String alternate) {
        this.alternateEmail = alternate;
    }
    //change the password, if user is interested in doing so
    public void changePassword(String password) {
        this.password = password;
    }

    //getter method for the mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    //getter method for the alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    //getter method for the password
    public String getPassword() {
        return password;
    }

    //display a record of all the important information regarding the user
    public String displayInfo() {
        return "\n\nDisplaying Information for: " + this.firstName + " " + this.lastName + "\n" +
                "Department                   : " + this.department + "\n" +
                "Company email                : " + this.generatedEmail + "\n" +
                "Password                     : " + this.getPassword() + "\n" + 
                "Mailbox Capacity             : " + this.getMailboxCapacity() + "mb" + "\n" +
                "Alternate Email              : " + this.getAlternateEmail();
    }


}
