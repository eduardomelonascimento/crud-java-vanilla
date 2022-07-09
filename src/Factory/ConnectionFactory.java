package Factory;

import java.sql.*;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) throws Exception {
        Connection connection = createConnectionToMySQL();
        if (connection != null) {
            System.out.println("Conexão iniciada");
            connection.close();
        }
    }
}