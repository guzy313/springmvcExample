package com.my.dao;

import com.my.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findByConditions(List<String> list);


    List<User> findUserOrders();

}
