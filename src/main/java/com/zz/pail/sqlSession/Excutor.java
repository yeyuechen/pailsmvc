package com.zz.pail.sqlSession;

public interface Excutor {
    /**
     * 查询
     * @param statement
     * @param parameter
     * @param resultType
     * @param <T>
     * @return
     */
    public <T> T query(String statement, Object parameter, Object resultType);

    /**
     * 执行方法
     * @param statement
     * @param parameter
     * @return
     */
    public int execute(String statement, Object parameter);

}