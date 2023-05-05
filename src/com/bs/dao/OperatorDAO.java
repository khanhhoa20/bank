package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bs.model.Operator;

public class OperatorDAO {

    private Connection connection;

    public OperatorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Operator> getAllOperators() throws SQLException {
        List<Operator> operators = new ArrayList<>();
        String sql = "SELECT * FROM Operator";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String operPhone = resultSet.getString("oper_phone");
            String operAddress = resultSet.getString("oper_address");
            String operName = resultSet.getString("oper_name");
            String userId = resultSet.getString("user_id");
            int departmentId = resultSet.getInt("department_id");
            Operator operator = new Operator(id, operPhone, operAddress, operName, userId, departmentId);
            operators.add(operator);
        }
        return operators;
    }
    
    public boolean deleteOperator(int id) throws SQLException {
        String sql = "DELETE FROM Operator WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }

    public Operator findOperatorById(int id) throws SQLException {
        String sql = "SELECT * FROM Operator WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String operPhone = resultSet.getString("oper_phone");
            String operAddress = resultSet.getString("oper_address");
            String operName = resultSet.getString("oper_name");
            String userId = resultSet.getString("user_id");
            int departmentId = resultSet.getInt("department_id");
            Operator operator = new Operator(id, operPhone, operAddress, operName, userId, departmentId);
            return operator;
        }
        return null;
    }

    public boolean updateOperator(Operator operator) throws SQLException {
        String sql = "UPDATE Operator SET oper_phone = ?, oper_address = ?, oper_name = ?, user_id = ?, department_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, operator.getOperPhone());
        statement.setString(2, operator.getOperAddress());
        statement.setString(3, operator.getOperName());
        statement.setString(4, operator.getUserId());
        statement.setInt(5, operator.getDepartmentId());
        statement.setInt(6, operator.getId());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }


}
