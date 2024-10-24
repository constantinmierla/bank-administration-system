package bank.management.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class Connn {
    Connection connection;
    Statement statement;

    public Connn() {
        try {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream("resources/config.properties");
            props.load(in);
            in.close();

            String url = props.getProperty("DB_URL");
            String user = props.getProperty("DB_USER");
            String password = props.getProperty("DB_PASSWORD");

            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}