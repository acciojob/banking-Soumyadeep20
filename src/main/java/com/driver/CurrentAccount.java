package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    public String getTradeLicenseId() throws Exception{
        return this.tradeLicenseId;
    }
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name , balance,5000);

        this.tradeLicenseId=tradeLicenseId;
        this.validateLicenseId();
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception {
        String str =this.tradeLicenseId;
        HashMap<Character,Integer> hm=new HashMap<>();
        int c=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)<65 ||  str.charAt(i)>90 ) {
                throw new Exception("Valid License can not be generated");
            }
            c=0;
            if(hm.containsKey(str.charAt(i)))
                c=hm.get(str.charAt(i));
            hm.put(str.charAt(i),c+1);
        }
        for(Character key : hm.keySet())
        {
            if(hm.get(key)>(str.length()/2)) {
                throw new Exception("Valid License can not be generated");
            }
        }
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

    }

}
