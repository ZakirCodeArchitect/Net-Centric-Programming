import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountReader {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        try {
            Scanner inFile = new Scanner(new File("in.txt")); // Open the file

            // Read each line, create an Account object, and add it to the list
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                Account account = new Account(line);
                accounts.add(account);
            }
            inFile.close();

            // Display account information
            for (Account account : accounts) {
                System.out.println(account);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}

// Account class with a constructor that parses a line
class Account {
    private String name;
    private int id;
    private float balance;

    public Account(String line) {
        Scanner accountLine = new Scanner(line); // Scanner to parse the line
        this.name = accountLine.next();
        this.id = accountLine.nextInt();
        this.balance = accountLine.nextFloat();
        accountLine.close();
    }

    @Override
    public String toString() {
        return "Account{name='" + name + "', id=" + id + ", balance=" + balance + "}";
    }
}
