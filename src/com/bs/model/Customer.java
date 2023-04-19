package com.bs.model;

import java.sql.Date;

public class Customer {
    private Integer CustomerID;
    private String CustomerName;
    private Integer CustomerPhoneNumber;
    private String CustomerEmail;
    private Date customerDOB_Date;
    private String CustomerAccount;
    private String CustomerPassWord;
    private String CustomerType;

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Integer getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(Integer customerPhoneNumber) {
        CustomerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public Date getCustomerDOB_Date() {
        return customerDOB_Date;
    }

    public void setCustomerDOB_Date(Date customerDOB_Date) {
        this.customerDOB_Date = customerDOB_Date;
    }

    public String getCustomerAccount() {
        return CustomerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        CustomerAccount = customerAccount;
    }

    public String getCustomerPassWord() {
        return CustomerPassWord;
    }

    public void setCustomerPassWord(String customerPassWord) {
        CustomerPassWord = customerPassWord;
    }

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }

}
