package com.zz.pail.core.control;

import com.zz.pail.bean.User;
import com.zz.pail.core.mapper.UserMapper;
import com.zz.pail.sqlSession.MySqlsession;

public class test {

    public static void main(String[] args){
        MySqlsession sqlSession=new MySqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println("user:"+user.toString());
    }
}
