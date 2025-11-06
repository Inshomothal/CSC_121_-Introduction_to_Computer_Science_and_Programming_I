package class_examples;

import lab_06a.BankAccount;

public class Sandbox {
    public static void main(String[] args) 
    {
        BankAccount account1 = new BankAccount("Sarah", 50.0);
        BankAccount account2 = new BankAccount("Fred", 100);

        // account1.deposit(100.00);

        
        System.out.println(
            "BankAccount " + account1.getName() + ": " +
            "balance = " +account1.getBalance()
        );
        
        // account1.withdraw(50.00);
        
        
        System.out.println(
            "BankAccount " + account2.getName() + ": " +
            "balance = " +account2.getBalance()
        );
        
        account1.transferTo(account2, 10.00);
        
        System.out.println(
            "BankAccount " + account1.getName() + ": " +
            "new balance = " + account1.getBalance()
        );

        System.out.println(
            "BankAccount " + account2.getName() + ": " +
            "new balance = " + account2.getBalance()
        );

        account1.withdraw(10.0);
        account1.withdraw("10");

        System.out.println(
            "BankAccount " + account1.getName() + ": " +
            "new balance with withdrawn monees = " + account1.getBalance()
        );
        // System.out.println("Hello!");
        
        // Rectangle rect = new Rectangle();
        // Rectangle rect2 = new Rectangle();

        // rect.setLength(2.0);
        // rect.setWidth(4.0);

        // rect2.setLength(3.0);
        // rect2.setWidth(2.0);
        

        // System.out.println(
        //     "Rectangle rect - " + 
        //     "length = " + rect.getLength() +
        //     ", width = " + rect.getWidth() +
        //     ", area = " + rect.getArea()
        // );

        // System.out.println(
        //     "Rectangle 2 rect - " + 
        //     "length = " + rect2.getLength() +
        //     ", width = " + rect2.getWidth() +
        //     ", area = " + rect2.getArea()
        // );
    }
}