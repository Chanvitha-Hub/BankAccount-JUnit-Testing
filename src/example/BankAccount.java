
package example;

import java.text.NumberFormat;

/**
 * bank account is a account with basic services for deposit,
 * withdrawal, and interest.
 */

public class BankAccount
{
    private NumberFormat fmt = NumberFormat.getCurrencyInstance();

    private final float kInterestRate = 0.045f;  // interest rate of 4.5%

    private long acctNumber;
    private float balance;
    public final String name;

    public BankAccount(String owner, long account, float initial)
    {
        name = owner; // name of account holder 
        acctNumber = account; // the account number, an identifier for the account
        balance = initial; // the initial amount of money in the account
    }

    /**
     *  Deposit the specified amount into the account. 
     *  @param amount value to be added to the balance
     *  @return true if amount is non-negative, false if amount 
     *  is negative; indicates balance was not changed.
     */
    public boolean deposit(float amount)
    {
        boolean result = true;
        if (amount < 0)   // is amount invalid?
        {
            result = false;
        }
        else
        {
            balance = balance + amount;
        }

        return result;
    }

    /**
     *  Withdraw the specified amount from the account,
     *  unless amount is negative, fee is negative, or
     *  amount exceeds current balance. 
     *  @param amount value to be deducted from the balance
     *  @param fee the transaction fee debited from the account
     *  @return true if transaction was successful, false otherwise;
     */
    public boolean withdraw(float amount, float fee)
    {
        if (isValidWithdrawl(amount, fee)) // validate parameters
        {
            amount += fee;
            balance = balance - amount;
        }
        return isValidWithdrawl(amount, fee);
    }

    private boolean isValidWithdrawl(float amount, float fee)
    {
        return amount >= 0 && fee >= 0 && amount <= balance; // validate withdrawal
    }

    public void addInterest()
    {
        balance += (balance * kInterestRate); // add interest
    }

    public float getBalance()
    {
        return balance; // return the current balance of the account
    }

    public long getAccountNumber()
    {
        return acctNumber; //return the bank account number
    }

    public String toString()
    {
        return (acctNumber + "\t" + name + "\t" + fmt.format(balance)); // return formatted account information
    }
}
