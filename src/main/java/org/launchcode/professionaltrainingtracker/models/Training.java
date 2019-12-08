package org.launchcode.professionaltrainingtracker.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Training {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @NotNull
    private Date date;  //private Calendar date;  ??

    @ManyToOne
    private User user;  //private String user; ??


    // future feature (Scheduled, Completed, Wish list)
    // @ManyToMany
    //private Category category;

    //@ManyToMany(mappedBy = "cheeses")
    // private List<Menu> menus;


    public Training () {

    }

    public Training(String name, String description, Date date ) {
        this.name = name;
        this.description = description;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotNull Date getDate() {
        return date;
    }

    public void setDate(@NotNull Date date) {
        this.date = date;
        }


    public User getUser()  {
        return user;
        }

    public void setUser(User user) {
        this.user = user;
        }


    /* (future addition of category: Scheduled, Completed, Wish list drop down menu)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;

    }
*/
}