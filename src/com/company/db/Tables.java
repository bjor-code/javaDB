package com.company.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Tables {
    public void GetTable() {
        try (var conn = Connect.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            if (resultSet != null) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnCount = rsmd.getColumnCount();
                System.out.print("-------------------------\n|");
                for (int i = 1; i <= columnCount; i++) {
                    String nameRows = rsmd.getColumnName(i);
                    System.out.printf("%s\t", nameRows);
                }
                System.out.println("|");
                while (resultSet.next()) {
                    var id = resultSet.getInt(1);
                    var name = resultSet.getString(2);
                    var price = resultSet.getInt(3);
                    System.out.printf("|%d\t%s\t%d\t|\n", id, name, price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
