package com.company;

public class User {
    @id
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

    public void setId(Long id) {
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
