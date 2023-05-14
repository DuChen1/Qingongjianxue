package com.niit.service;


import java.util.List;

/**
 * 接口描述: 所有用户泛型接口，简化代码
 *
 * @Author: 杨扬
 * @Date: 2022/11/14 19:20
 */
public interface UserService<T> {

    void add(T obj);

    void delete(String id);

    void update(T obj);

    List<T> findAll();

    T findById(String id);


}
