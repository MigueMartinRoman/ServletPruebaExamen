package org.eclipse.jakarta.dao;

import java.util.List;

public interface Crud<T> {
    default List<T> findAll()  {
        try {
            throw new Exception("Metode no implemenetat");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    default  void insert(T t){
        try {
            throw new Exception("Metode no implemenetat");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    default void delete(T t){
        try {
            throw new Exception("Metode no implemenetat");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    default void update(T t){
        try {
            throw new Exception("Metode no implemenetat");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
