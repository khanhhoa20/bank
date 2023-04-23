package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bs.util.DBUtil;

public class BankAccountDAO {
	Connection connection;
public BankAccountDAO() {
	try {
		connection =DBUtil.getConnection();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
