package dao;

import exception.NotExistException;

public interface Dao<T> {

    T get(long id) throws NotExistException;

    void add(T t) throws NotExistException;

    void update(T t) throws NotExistException;

    void remove(T t) throws NotExistException;

}
