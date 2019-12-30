package com.zz.pail.sqlSession;

import java.lang.reflect.Proxy;

public class MySqlsession {

    private Excutor excutor= new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T select(String statement,Object parameter,Object object){
        return excutor.query(statement, parameter,object);
    }

    /**
     * 新增、修改、删除
     * @param statement
     * @param parameter
     * @return
     */
    public int execute(String statement,Object parameter){
        return excutor.execute(statement, parameter);
    }
    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> classes){
        //动态代理调用
        return (T)Proxy.newProxyInstance(classes.getClassLoader(),new Class[]{classes},
                new MyMapperProxy(myConfiguration,this,classes.getSimpleName()));
    }

}