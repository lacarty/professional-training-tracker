package org.launchcode.professionaltrainingtracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Email(message = "Invalid email")
    private String email;

    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
/*
    @NotNull (message = "Passwords do not match")  //added Dec 8
    @Transient
    private String verifyPassword;
*/
    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public User() {
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
  /*      checkPassword();                                //added following Dec 8
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword;
    }

    private void checkPassword() {
        if (password !=null && verifyPassword !=null
        && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }

   */
    }
}

