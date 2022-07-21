package co.com.pesonalsoft.shop.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author William Johan Novoa Melendrez
 * @date 19/07/2022
 */
@Entity
@Table(name = "roles")
public class Roles {

    @Id
    private Long id;

    private String name;

    //@ManyToMany(mappedBy = "roles")
    //private Set<User> users = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}