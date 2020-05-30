package com.company;

public interface Executor<T> {
    void save(T objectData) throws Exception;

    <T> T load(long id, Class<T> clazz) throws Exception;

}
