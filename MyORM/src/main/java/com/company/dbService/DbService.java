package com.company.dbService;

public interface DbService<T> {
    void save(T objectData) throws Exception;
    <T> T load(long id, Class<T> clazz);
}
