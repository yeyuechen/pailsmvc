package com.zz.pail.core.mapper;


import com.zz.pail.bean.User;

public interface UserMapper {

    public<T> T getUserById(String id);

    public int insert(User user);
}