package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) throws Exception{
        if(balance<minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
    this.name=name;
    this.balance=balance;
    this.minBalance=minBalance;

    }

    public BankAccount() {

    }
    public double getBalance()
    {
        return this.balance;
    }
    public void setBalance(double x)
    {
        this.balance=x;
    }
    public double getMinBalance()
    {
        return this.minBalance;
    }
    public String getName(){return  this.name;}

    public String generateAccountNumber(int digits, int sum) throws Exception{

    int arr[]=new int[10];
    for(int i=9;i>=1;i--)
    {
        int x=sum/i;
        sum =sum%i;
    }
    String str="";
        for(int i=9;i>=0;i--)
        {
            for(int j=0;j<arr[i];j++)
            {
                str += i;
            }
        }
        if(str.length()>digits)
        {
            throw  new Exception("Account Number can not be generated");
        }
        if(str.length()<digits)
        {
            int x= digits-str.length();
            for(int i=0;i<x;i++)
            {
                str+="0";
            }
        }
        return str;


        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

      
    }

    public void deposit(double amount) {
        this.balance +=amount;
        //add amount to balance

    }



    public void withdraw(double amount) throws Exception {
        if((this.balance-amount)<this.minBalance)
            throw new Exception("Insufficient Balance");
        this.balance -=amount;
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }


}