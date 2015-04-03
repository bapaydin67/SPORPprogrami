/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshrio.entity;

import java.io.Serializable;

/**
 *
 * @author Batuhan
 */
public class JatomiYonetimPOJO implements Serializable {

    private String firstName;
    private String email;
    private String password;

    public JatomiYonetimPOJO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
    }

}
