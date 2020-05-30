package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User(1, 20, "John");
        ExecutorImpl executor = new ExecutorImpl();
        executor.save(user);
        System.out.println(executor.load(1, User.class));
    }
}
