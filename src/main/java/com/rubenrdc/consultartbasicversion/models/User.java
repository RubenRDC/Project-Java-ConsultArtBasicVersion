package com.rubenrdc.consultartbasicversion.models;

import com.rubenrdc.consultartbasicversion.models.interfaces.Exportable;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Ruben
 */
@Entity
@Table(name = "usuarios")
public class User implements Exportable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 165)
    private String User, Pass;

    @Transient
    private final Object[] row = new Object[3];

    public User(String userName, String pass) {
        this.User = userName;
        this.Pass = pass;
    }

    public User() {
    }

    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = User;
        row[2] = Pass;
        return row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        this.Pass = pass;
    }

}
