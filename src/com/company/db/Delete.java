package com.company.db;

import java.sql.PreparedStatement;

public class Delete {
    public void setDeleteRows(int row) {
        try (var conn = Connect.getConnection()) {
            String sql = "DELETE FROM Products WHERE Id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, row);
            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d row(s) deleted\n", rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
