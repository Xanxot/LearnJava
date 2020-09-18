package com.company.entities;

import javax.persistence.*;

@Entity
public class PhoneDataSet {
    @Id
    @Column(name = "user_phone_id")
    private Long id;

    @Column(name = "phone")
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PhoneDataSet(Long id, String number,User user){
        this.id=id;
        this.number=number;
        this.user=user;
    }
    public PhoneDataSet(){}

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void numberToString() {
        System.out.println("id: " + " number: " + number);
    }
}
