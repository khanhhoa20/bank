interface IOperatorFunction {
	void createBankAccount(String idCard, String username, String phone, String address, String email);

	void lockBankAccount(String bankAccountID);

	void viewCusList();

	void updateCusList(String idCard, String username, String phone, String address, String email);

	void withdraw(String bankAccountID, Double withdrawMoney);

	void deposit(String bankAccountID, Double depositMoney);
	
	void login(String username, String password);
	
}
