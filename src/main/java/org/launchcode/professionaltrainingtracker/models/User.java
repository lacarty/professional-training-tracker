package org.launchcode.professionaltrainingtracker.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    //@NotNull(message = "Passwords do not match")
    @Transient
    private String verifyPassword;


    @OneToMany // one user, many trainings
    @JoinColumn(name = "id")
    private List<Training> trainings = new ArrayList<>();

    public User(String email, String password) {
        //this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;

    }

    public User() {

    }

   /* public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
*/
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
        checkPassword();
    }

    public int getId(){

        return id;
    }

   public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null
                && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }



    }
}

