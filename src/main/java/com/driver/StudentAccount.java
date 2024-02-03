package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;
    public String getInstitutionName(){
        return this.institutionName;
    }
    public  StudentAccount(String name, double balance, String  institutionName) throws Exception{
        super(name,balance,(double) 0);
        this.institutionName=institutionName;

        //minimum balance is 0 by default

    }

}
