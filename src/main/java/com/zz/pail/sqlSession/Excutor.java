package com.zz.pail.sqlSession;

public interface Excutor {
    public <T> T query(String statement,Object parameter);
}