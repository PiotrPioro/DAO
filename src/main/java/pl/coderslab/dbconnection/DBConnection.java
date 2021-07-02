package pl.coderslab.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL_dao_data_base = "jdbc:mysql://localhost:3306/dao_data_base?serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Orzel777";

    public static Connection connect_dao_data_base() throws SQLException {
        return DriverManager.getConnection(DB_URL_dao_data_base, DB_USER, DB_PASS);
    }
}
