package com.zz.pail.core.control;

import com.zz.pail.bean.User;
import com.zz.pail.core.mapper.UserMapper;
import com.zz.pail.sqlSession.PailsSqlsession;

public class test {

    public static void main(String[] args){
        PailsSqlsession sqlsession=new PailsSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println("user:"+user.toString());
        //logger.info("doTest2 method success!,id:{}-->name is {}",id,user.toString());
    }
}
