package com.contacts.contact.model;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "number")
    private String number;

    public ContactModel() {
    }

    public ContactModel(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                '}';
    }
}
