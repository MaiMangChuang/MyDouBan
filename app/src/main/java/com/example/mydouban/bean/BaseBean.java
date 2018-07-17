package com.example.mydouban.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.lang.reflect.Field;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/2/24 23:24
 */
public abstract class BaseBean   {

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        Field[] field=getClass().getDeclaredFields();
        for(Field f : field) {
            f.setAccessible(true);
            stringBuilder.append(f.getName()+":");
            System.out.println(f.getType().getName());//打印每个属性的类型名字
            try {
                stringBuilder.append(f.get(this)+";\n");
                f.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return stringBuilder.toString();
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
