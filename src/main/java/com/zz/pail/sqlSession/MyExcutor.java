package com.zz.pail.sqlSession;

import com.zz.pail.bean.JavaBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 执行器
 */
public class MyExcutor implements Excutor {

    private static final Logger logger = LoggerFactory.getLogger(MyExcutor.class);

    private MyConfiguration xmlConfiguration = new MyConfiguration();

    @Override
    public <T> T query(String sql, Object parameter, Object resultType) {
        Connection connection = getConnection();
        ResultSet set = null;
        PreparedStatement pre = null;
        try {
            logger.info("sql:{},param:{}", sql, parameter.toString());
            pre = connection.prepareStatement(sql);

            //设置参数
            pre.setString(1, parameter.toString());
            set = pre.executeQuery();

            ResultSetMetaData rsmd = set.getMetaData();

            int count = rsmd.getColumnCount();
            Map<String, Object> map = new HashMap<>();
            //遍历结果集
            while (set.next()) {
                for (int i = 0; i < count; i++) {
                    map.put(rsmd.getColumnName(i + 1), set.getString(rsmd.getColumnName((i + 1))));
                }
            }
            return (T) JavaBeanUtil.map2Object(map, resultType);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (set != null) {
                    set.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int execute(String sql, Object parameter) {
        Connection connection = getConnection();
        PreparedStatement pre = null;
        try {
            logger.info("sql:{},param:{}", sql, parameter.toString());
            pre = connection.prepareStatement(sql);
            //设置参数
            Map<String, Object> map = JavaBeanUtil.object2Map(parameter);
            int index=1;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                pre.setObject(index,entry.getValue());
                index++;
            }
            return pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    private Connection getConnection() {
        try {
            Connection connection = xmlConfiguration.build("config.xml");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}