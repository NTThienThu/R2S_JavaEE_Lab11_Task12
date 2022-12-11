package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBUtil {
    public static Connection openConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=baitap2_hangkhong";
            Connection connect= DriverManager.getConnection(connectionUrl,"sa","sapassword");
            return connect;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
}}
