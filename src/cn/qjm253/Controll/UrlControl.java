package cn.qjm253.Controll;

/**
 * Created by qjm3662 on 2017/2/3.
 */
public class UrlControl {
    public static final String IP = "http://123.207.96.66";
    public static final int PORT = 8080;

    public static final String path = IP + ":" + PORT + "/MyUpan_war";
    public static final String avatarUrl = path + "/download?fileName=";
    public static final String default_avatar = path + "/download?fileName=default_avatar.jpg";

}
