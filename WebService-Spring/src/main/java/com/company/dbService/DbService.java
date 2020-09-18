package com.company.dbService;

public interface DbService<T> {
    void save(T objectData);
    <T> T load(long id, Class<T> clazz);
}
