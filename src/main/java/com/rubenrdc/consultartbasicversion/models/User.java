package com.rubenrdc.consultartbasicversion.models;

import com.rubenrdc.consultartbasicversion.models.interfaces.Exportable;


/**
 *
 * @author Ruben
 */
public class User implements Exportable{

    private String userName, pass, nameSubname;
    private int id;
    private final Object[] row = new Object[3];

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = userName;
        row[2] = nameSubname;
        return row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
