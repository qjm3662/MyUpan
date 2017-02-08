package cn.qjm253.Controll;

/**
 * Created by qjm3662 on 2017/2/3.
 */
public class UrlControl {
    public static final String IP = "http://192.168.1.8";
    public static final int PORT = 8080;

    public static final String path = IP + ":" + PORT;
    public static final String avatarUrl = path + "/download?fileName=";
    public static final String default_avatar = path + "/download?fileName=default_avatar.jpg";
}
