package klass.platform.training.login.managers;

import com.vaadin.flow.component.UI;
import klass.platform.training.login.exceptions.InvalidCredentialsException;

public class AuthenticationManager {
//    //  How
//    // - Set Field to [Database Manager]
//
//    public DatabaseManager databaseManager;
//
//    public DatabaseManager getDatabaseManager() {
//        return databaseManager;
//    }
//
//    public void setDatabaseManager(DatabaseManager databaseManager) {
//        this.databaseManager = databaseManager;
//    }
//


    // 1. Used for Authenticating login Credentials.  (without database)
    public void authenticateCredentials(String username, String password) throws InvalidCredentialsException  {

        if (username.equals("sampleusername") && password.equals("samplepassword")) {
            System.out.print("Successfully Authenticated");
        }
    }





}

