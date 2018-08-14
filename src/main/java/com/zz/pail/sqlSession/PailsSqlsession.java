package com.zz.pail.sqlSession;

import java.lang.reflect.Proxy;

public class PailsSqlsession {

    private Excutor excutor= new PailsExcutor();

    private PailsConfiguration myConfiguration = new PailsConfiguration();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clas){
        //动态代理调用
        return (T)Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas},
                new PailsMapperProxy(myConfiguration,this));
    }

}