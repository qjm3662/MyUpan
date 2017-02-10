package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.Controll.UrlControl;
import cn.qjm253.util.UUIDUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * Created by qjm3662 on 2017/2/3.
 */
public class ModifyUserAvatarAction extends ActionSupport implements CookiesAware{
    private File avatar;
    private String avatarContentType;   //上传文件类型
    private String avatarFileName;  //上传文件名
    private int code = -1;
    private String errMSG = "上传了非图片文件";
    private String username;
    //直接在struts.xml文件配置的属性
    private String savePath;
    private Map<String, String> cookies;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public File getAvatar() {
        return avatar;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }

    public String getAvatarContentType() {
        return avatarContentType;
    }

    public void setAvatarContentType(String avatarContentType) {
        this.avatarContentType = avatarContentType;
    }

    public String getAvatarFileName() {
        return avatarFileName;
    }

    public void setAvatarFileName(String avatarFileName) {
        this.avatarFileName = avatarFileName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMSG() {
        return errMSG;
    }

    public void setErrMSG(String errMSG) {
        this.errMSG = errMSG;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String modifyAvatar() throws Exception{
        //如果用户没有传入username参数，尝试从cookies中获得
//        System.out.println("1 : " + cookies.entrySet());
        if((getUsername() == null || getUsername().equals("")) && cookies != null){
            setUsername(cookies.get("username"));
            System.out.println("2 : " + cookies.entrySet());
        }

        //既没有传入username，cookies中又不存在username或已失效
        if(getUsername() == null){
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
            setErrMSG(CodeMSG.getCodeMSG(getCode()) + " 或 " + CodeMSG.getCodeMSG(CodeMSG.COOKIE_INVALID));
            return ERROR;
        }

        String path = ServletActionContext.getServletContext().getRealPath(getSavePath());
        String saveName = getUsername() + "-avatar";
        FileOutputStream fos = new FileOutputStream(path + "/" + saveName);
        FileInputStream fis = new FileInputStream(getAvatar());
        System.out.println(path + "/" + saveName);
        byte[] buffer = new byte[1024];
        int len = 0;
        int fileSize = 0;
        while((len = fis.read(buffer)) > 0){
            fileSize += len;
            fos.write(buffer, 0, len);
        }
        boolean result = HibernateOperator.modifyAvatar(getUsername(), UrlControl.avatarUrl + saveName);
        if(result){
            setCode(CodeMSG.ALREADY_LOGIN);
            return SUCCESS;
        }else{
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
    }
    @Override
    public String toString() {
        return "ModifyUserAvatarAction{" +
                "avatar=" + avatar +
                ", avatarContentType='" + avatarContentType + '\'' +
                ", avatarFileName='" + avatarFileName + '\'' +
                ", code=" + code +
                ", errMSG='" + errMSG + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public void setCookiesMap(Map<String, String> map) {
        this.cookies = map;
        if(map != null){
            System.out.println(map.entrySet());
        }else{
            System.out.println("map is null");
        }
    }
}
