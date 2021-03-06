package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 11;
    private String companySuffix = "companyName.com";
    private int mailboxCapacity = 500;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Call a method ask for the department return the department
        this.department = setDepartment();
        // Call a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    // ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "Sales"; }
        else if (depChoice == 2) { return "dev";}
        else if (depChoice == 3) { return "acct";}
        else { return "";}
    }
    // generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char password[] = new char[length];
        for (int i = 0; i < length; i++) {
            int rand =(int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) { this.mailboxCapacity = mailboxCapacity; }
    // set the alternate email
    public void setAlternateEmailEmail(String alternateEmail) { this.alternateEmail = alternateEmail; }
    // change the password
    private void changePassword(String password) { this.password = password; }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public  String getAlternateEmail() {return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName + "\n" +
                "Company Email: " + email + "\n" +
                "Mailbox Capacity: " + mailboxCapacity + "mb";
    }
}