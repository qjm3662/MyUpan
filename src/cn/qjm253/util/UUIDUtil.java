package cn.qjm253.util;

import java.util.UUID;

/**
 * Created by qjm3662 on 2017/1/31.
 */
public class UUIDUtil {
    //添加标识码
    public static String addUUID(String msg){
        return UUID.randomUUID() + msg;
    }

    //剔除标识码
    public static String deleteUUID(String msg){
        return msg.substring(36, msg.length());
    }
}
