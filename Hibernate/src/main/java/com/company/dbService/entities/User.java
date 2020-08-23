package com.company.dbService.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    public Long id;
    public int age;
    public String name;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.age = age;
        this.name = name;

    }

    public User() {
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_address")
    private AddressDataSet addressDataSet;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_phone")
    private Set<PhoneDataSet> phoneDataSet = new HashSet<>();

    public void setPhone(Set<PhoneDataSet> phoneDataSet) {
        this.phoneDataSet = phoneDataSet;
    }

    public Set<PhoneDataSet> getPhone() {
        return phoneDataSet;
    }

    public void setAddress(AddressDataSet addressDataSet) {
        this.addressDataSet = addressDataSet;
    }

    private AddressDataSet getAddress() {
        return addressDataSet;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return ("id: " + id + " age: " + age + " name: " + name);
    }

}
