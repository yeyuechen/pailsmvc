package com.zz.pail.sqlSession;

import com.zz.pail.config.Function;
import com.zz.pail.config.MapperBean;
import com.zz.pail.enums.SqlTypeEnum;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * mapper代理机
 */
public class MyMapperProxy implements InvocationHandler {

    private static final String MAPPER_SUFFIX = ".xml";

    private static final String MAPPER_BASER_PATH="mapper/";

    private MySqlsession mySqlSession;

    private MyConfiguration myConfiguration;

    private String mapperName;

    public MyMapperProxy(MyConfiguration myConfiguration, MySqlsession mySqlSession, String mapperName) {
        this.myConfiguration = myConfiguration;
        this.mySqlSession = mySqlSession;
        this.mapperName = mapperName;
    }

    /**
     * 动态代理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        MapperBean readMapper = myConfiguration.readMapper(MAPPER_BASER_PATH+mapperName + MAPPER_SUFFIX);
        //是否是xml文件对应的接口
        if (!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())) {
            return null;
        }
        List<Function> list = readMapper.getList();
        if (null != list || 0 != list.size()) {
            for (Function function : list) {
                //id是否和接口方法名一样
                if (method.getName().equals(function.getFuncName()) || SqlTypeEnum.QUERY.getKey().equals(function.getSqlType())) {

                    return mySqlSession.select(function.getSql(),args[0], function.getResultType());
                } else {
                    return mySqlSession.execute(function.getSql(), function.getParameterType());
                }
            }
        }
        return null;
    }
}