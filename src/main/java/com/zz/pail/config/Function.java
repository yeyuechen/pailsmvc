package com.zz.pail.config;

public class Function {
    private String sqlType;
    private String funcName;
    private String sql;
    private Object resultType;
    private Object parameterType;

    public Object getParameterType() {
        return parameterType;
    }

    public void setParameterType(Object parameterType) {
        this.parameterType = parameterType;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object getResultType() {
        return resultType;
    }

    public void setResultType(Object resultType) {
        this.resultType = resultType;
    }
}