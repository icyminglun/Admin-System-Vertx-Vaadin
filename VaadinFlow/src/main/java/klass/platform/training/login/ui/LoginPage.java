package klass.platform.training.login.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;


import com.vaadin.flow.component.html.H2;

import klass.platform.training.login.exceptions.InvalidCredentialsException;
import klass.platform.training.login.managers.AuthenticationManager;
import klass.platform.training.models.User;

/**
 * The main view of the application
 */
@Route(value= "")
@BodySize(height = "100vh", width = "100vw")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class LoginPage extends VerticalLayout {

//  public static User AUTH;                                              // (for now not touching) ->

  public static AuthenticationManager AUTH;

  public LoginPage() {

    H2 title  = new H2("Klass Login");


    // 2. Login Form
    FormLayout loginForm = new FormLayout();                            // Create Vaadin Form Object

    // a. Username Field
    TextField userField = new TextField();                             // Creates a Textfield (username) ...
    userField.setLabel("Username");                                    // ... set a Label "Username" (Login)
    userField.setPlaceholder("username");                              // ... set a Placeholder "username" in login username input box


    // b. Password Field
    TextField passwordField = new TextField();                         // Creates a Textfield (password) ...
    passwordField.setLabel("Password");                                // ... set a Label "Password" (Password)
    passwordField.setPlaceholder("password");                          // .... set a Placeholder "password" in the password input box




    // c. 'Login' Button
    Button loginButton = new Button("Login");
    loginButton.setId("loginAction");
    loginButton.addClickListener(event -> {                           // When loginButton is being clicked ... (event handler)


        // Authentication Logic

        String username = userField.getValue();                         // Stores user's username input into ... 'username'
        String password = passwordField.getValue();                     // Stores user's password input into ... 'password'

        loginButton.setText(username + " " + password);

        try {
            AUTH.authenticateCredentials(username, password);
        } catch (InvalidCredentialsException e) {
            System.out.println("Wrong Password La");
        } catch (Exception e) {
            e.printStackTrace();
        }

    });

    // Add Components
    loginForm.add(title, userField, passwordField, loginButton);                       // Adds 'userfield' & 'passwordfield' to the loginform
    add(loginForm);                                                                    // Adds this loginfrom onto "this" layout (VerticalLayout)




    }





  }



