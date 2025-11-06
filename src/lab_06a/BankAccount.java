package lab_06a;

public class BankAccount {

    private String name;
    private double balance;

    public BankAccount (
        String acctName,
        double startBalance)
    {
        name = acctName;
        balance = startBalance;
    }

    public BankAccount ()
    {
    }

    public double getBalance()
    {
        return balance;
    }

    public String getAccountHolderName()
    {
        return name;
    }

    public void deposit (double amount)
    {
        balance += amount;
    }

    public void deposit (String amount)
    {
    }

    public void withdraw (double amount)
    {
        balance -= amount;
    }
    public void withdraw (String amount)
    {
        balance = balance - Double.parseDouble(amount);
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String n)
    {
        name = n;
    }


    public void transferTo ( BankAccount toAcct, double amount)
    {
        toAcct.deposit(amount);
        // balance-=amount;
        withdraw(amount);
    }

}