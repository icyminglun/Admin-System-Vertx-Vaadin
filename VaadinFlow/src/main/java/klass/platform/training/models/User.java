package klass.platform.training.models;

public class User {

  // Static Attributes (username, password)
  private String username;
  private String password;

  // Constructor
  public User() {
    setUsername("myuser");
    setPassword("mypass");
  }

  // Methods (Set & Get)

  // Username
  public void setUsername(String username) {

    this.username = username;

  }

  public String getUsername() {

    return this.username;

  }

  // Password
  public void setPassword(String password) {

    this.password = password;

  }

  public String getPassword() {

    return this.password;
  }

//
//  public Boolean authenticate(String username, String password) {
//
//    if (username.equals(getUsername()) && password.equals(getPassword())) {
//
//      return true;
//    }
//
//    return false;
//
//  }




}
