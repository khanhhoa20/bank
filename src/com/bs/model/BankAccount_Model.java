package model;

public class BankAccount_Model {
private long id;
private long balance;
private String bank_name;
private Customer cus_id;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
public String getBank_name() {
	return bank_name;
}
public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}
public Customer getCus_id() {
	return cus_id;
}
public void setCus_id(Customer cus_id) {
	this.cus_id = cus_id;
}

}
