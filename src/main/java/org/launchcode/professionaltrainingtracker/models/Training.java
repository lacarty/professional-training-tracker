package org.launchcode.professionaltrainingtracker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Training {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 1, message = "Description must not be empty")
    private String description;

    @NotNull
    private Date date;

    // future feature (Scheduled, Completed, Wish list)
    //@ManyToMany(mappedBy = "cheeses")   example
    // private List<Menu> menus;


    public Training() {

    }

    public Training(String name, String description, Date date) {
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
}

    /* (future addition of category: Scheduled, Completed, Wish list drop down menu)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;

    }

}
*/

