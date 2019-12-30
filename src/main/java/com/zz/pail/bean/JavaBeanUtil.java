package com.zz.pail.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * javaBean工具
 */
public class JavaBeanUtil {
    /**
     * 实体对象转成Map
     *
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Map转成实体对象
     *
     * @param map    实体对象包含属性
     * @param object 实体对象类型
     * @return
     */
    public static Object map2Object(Map<String, Object> map, Object object) {
        if (map == null) {
            return null;
        }
        Object ob = null;
        try {
            ob = object.getClass().newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(ob, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }
}
