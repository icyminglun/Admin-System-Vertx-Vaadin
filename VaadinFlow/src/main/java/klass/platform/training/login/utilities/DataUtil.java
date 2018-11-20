.package klass.platform.training.login.utilities;


import java.sql.Connection;                 // Creates a Connection(Session) with a Specific Database
import java.sql.ResultSet;                  // A Table of Data representing database result set. Generated by executing a statement that queries the database.
import java.sql.SQLException;
import java.sql.Statement;                  // The Object used for executing a static SQL statement and returning the results it produces.

//
public class DataUtil {

    private static void retrieveUser(Connection con, String dbName) throws SQLException {

        Statement stmt = null;
        String query = "SELECT * FROM" + dbName;
        System.out.println("The SQL query is: " + query);      // For Debugging Purposes


        try {
            stmt = con.createStatement();                       // Creates a Statement object for sending SQL statements to the database ...
            ResultSet rs = stmt.executeQuery(query);            // ... Sends SQL query to database and retrieves database result.
            while (rs.next()) {                                 // Move cursor forward one row from its current position.

                // Retrieve Values from mariaDB (using JDBC)
                int userID = rs.getInt("userid");            // Retrieve value from 'userid' column ...
                System.out.println("I am retrieving the userid");  // For Illustration Purpose

                String username = rs.getString("username");  // Retrieve value from 'usename' column ...
                System.out.println("I am retrieving the username"); // For Illustration Purpose

                String password = rs.getString("password");  // Retrieve value from 'password column...
                System.out.println("I am retrieving the password"); // For Illustration Purpose

                System.out.println(userID + "\t" + username + "\t" + password); // Prints out all the retrieved data.

            }

        } catch (SQLException e) {
            e.printStackTrace();                                // Prints out error if there's an issue with database.
        } finally {
            if (stmt != null) {stmt.close();}                   // Closes the Statement (for resource efficiency)
        }


    }




}

