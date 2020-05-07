package com.company;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Example for maven
 * <p>
 * To start the application:
 * mvn package
 * java -cp ./target/maven.jar com.company.Main
 * java -jar ./target/maven.jar //java.lang.NoClassDefFoundError: com/google/common/collect/Lists
 * java -cp ./target/maven.jar; /home/h1ka/.m2/repository/com/google/guava/guava/25.0-jre/guava-25.0-jre.jar com.company.Main
 * <p>
 * To unzip the jar:
 * 7z x -oJAR ./target/maven.jar
 * unzip -d JAR ./target/maven.jar
 * <p>
 * To build:
 * mvn package
 * mvn clean compile
 * mvn assembly:single
 * mvn clean compile assembly:single
 */
public class Main {
    private static final int MEASURE_COUNT = 1;

    public static void main(String... args) {
        Collection<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 999_999;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }

        List<Integer> result = new ArrayList<>();
        Collections.shuffle((List<Integer>) example);
        calcTime(() -> result.addAll(Lists.reverse((List<Integer>) example)));
    }

    private static void calcTime(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++)
            runnable.run();
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}