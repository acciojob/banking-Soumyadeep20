package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) throws Exception {
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        if((this.getBalance()-amount)<this.getMinBalance())
            throw new Exception("Insufficient Balance");
        this.setBalance(this.getBalance()-amount);
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        double ans=this.getBalance()+((this.getBalance()*rate)*years);
        return ans;
        // Return the final amount considering that bank gives simple interest on current amount

    }


    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double currAmount = super.getBalance();
        for (int i = 0; i < years; i++) {
            for (int j = 0; j < times; j++) {
                double interest = (currAmount * rate) / (100 * times);
                currAmount += interest;
            }
        }
        return currAmount;
    }

}
