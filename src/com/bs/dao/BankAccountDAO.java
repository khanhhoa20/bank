package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.DBConnection;
import model.BankAccount_Model;

public class BankAccountDAO {
	Connection connection;
public BankAccountDAO() {
	try {
		connection =DBConnection.getConnection();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
