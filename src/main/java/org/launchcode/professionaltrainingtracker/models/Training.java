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
    @Size(min = 3, max = 55)
    private String name;

    @NotNull
    @Size(min = 1, message = "Description must not be empty")
    private String description;

    @NotNull
    private Date date;

    @NotNull
    //@Size(min = 1, message = "Description must not be empty")
    private String url;

    @NotNull
    //@Size(min = 1, message = "Description must not be empty")
    private Double ceus;

    @NotNull
  //  @Size(min = 1, message = "Description must not be empty")
    private Double hours;

    @NotNull
   // @Size(min = 1, message = "Description must not be empty")
    private String location;


    @ManyToOne
    private User user;

    // future feature (Scheduled, Completed, Wish list)
    //@ManyToMany(mappedBy = "cheeses")   example
    // private List<Menu> menus;



    public Training() {

    }

    public Training(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.url = url;
        this.ceus = ceus;
        this.hours = hours;
        this.location = location;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getCeus() {
        return ceus;
    }

    public void setCeus(Double ceus) {
        this.ceus = ceus;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

