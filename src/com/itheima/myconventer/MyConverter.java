package com.itheima.myconventer;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/23 17:33
 * Description:Created with IntelliJ IDEA
 */
public class MyConverter implements Converter{
    @Override
    public Object convert(Class clazz, Object value) {
        //class 要装成的类型
        //object 页面上传入的值
        //将object转成date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse((String) value);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
