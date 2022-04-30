package peaksoft.util;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Environment;

import org.hibernate.cfg.Configuration;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private final Connection connection;


    public static EntityManagerFactory createEntityManagerFactory() {


        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "aikamama_95");

        properties.setProperty(Environment.HBM2DDL_AUTO, "create");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }

    public Util() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres", "aikamama_95");
    }

    public Connection getConnection() {
        return connection;
    }

}
