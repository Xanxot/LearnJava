package com.company.entyties;

import javax.persistence.*;

@Entity
public class AddressDataSet {
    @Id
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public AddressDataSet(Long id, String address, User user) {
        this.id = id;
        this.address = address;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}