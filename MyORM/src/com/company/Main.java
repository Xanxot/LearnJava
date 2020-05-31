package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        CreateDemoDB createDemoDB = new CreateDemoDB();
        User user = new User(1, 20, "John");
        ExecutorImpl executor = new ExecutorImpl(user);
        executor.save(user);
        System.out.println(executor.load(1, User.class));

    }
}
