package com.zz.pail.enums;

public enum  SqlTypeEnum {
    INSERT("insert","新增"),
    UPDATE("update","修改"),
    DELETE("delete","删除"),
    QUERY("select","查询");

    private String key;

    private String value;

    /**
     * 构造方法
     * @param key
     * @param value
     */
    private SqlTypeEnum(String key, String value){
        this.key=key;
        this.value=value;
    }

    /**
     * 通过Key获取value
     * @param key
     * @return
     */
    public static String getValueByKey(String key){
        for (SqlTypeEnum robotTypeEnum: SqlTypeEnum.values()) {
            if(key==robotTypeEnum.key){
                return robotTypeEnum.value;
            }
        }
        return null;
    }

    /**
     * 获取枚举
     * @param key
     * @return
     */
    public static SqlTypeEnum getEnum(String key){
        for (SqlTypeEnum sqlTypeEnum: SqlTypeEnum.values()) {
            if(key.equals(sqlTypeEnum.key)){
                return sqlTypeEnum;
            }
        }
        return null;
    }
    /**
     * 获取枚举key
     * @return
     */
    public String getValue(){
        return this.value;
    }

    /**
     * 获取枚举value
     * @return
     */
    public String getKey(){
        return this.key;
    }

    //覆盖方法
    @Override
    public String toString()
    {
        return this.key+"-"+this.value;
    }
}
