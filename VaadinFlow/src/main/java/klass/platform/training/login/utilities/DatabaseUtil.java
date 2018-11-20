package klass.platform.training.login.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;             // Creates a Connection(Session) with a Specific Database
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;            // Represents a persistent set of properties?

public class DatabaseUtil {

    public String userName;
    public String password;
    public String dbms = "mariadb";         // Define Database
    public String dbName = "userDB";

    public String serverName = "localhost";
    public int portNumber = 3306;



    public Connection getConnection() throws SQLException {

        Connection conn = null;                             // Creates a Connection
        Properties connectionProps = new Properties();

        // Maps specified key 'k' to the specified value 'v' in this hashtable. Neither key nor value can be null*
        connectionProps.put("username", this.userName);
        connectionProps.put("password", this.password);

        // 1. Establishes Connection to a Database by Containing a Connection Object.
        // -----------------------------------------------
        // Explanation ... :
        // - A Connection represents a session with a specific database.
        // - Within the context of a connection, SQL statements are executed and results are returned.
        // DatabaseUtil( String databaseUrl , String user , String password)

        if(this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName +
                                    ":" + portNumber + "/" + dbName,
                            connectionProps);
        } else if (this.dbms.equals("mariadb")) {
            conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName +
                            ":" + portNumber + "/" + dbName,
                    connectionProps);
        }
        System.out.println("Connected to database");
        return conn;


    }
}
