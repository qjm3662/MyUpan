package cn.qjm253.Action;

import cn.qjm253.Controll.HibernateOperator;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.*;
import javax.servlet.http.Cookie;
import java.util.Map;

/**
 * Created by qjm3662 on 2017/1/23.
 */
public class LoginAction extends ActionSupport implements CookiesAware, SessionAware{
    private String username;
    private String password;
    private int code;
    private String errMSG;
    private Map<String, Object> session;
    private Map<String, String> cookies;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        setCode(HibernateOperator.loginJudge(username, password));
        switch (getCode()){
            case CodeMSG.ALREADY_LOGIN:     //登录成功
                Cookie cookie = new Cookie("username", username);
                //设置Cookie的有效期为一天，单位为秒
                cookie.setMaxAge(60 * 60 * 24);
                ServletActionContext.getResponse().addCookie(cookie);
                return SUCCESS;
            case CodeMSG.USERNAME_OR_PASSWORD_ERROR:case CodeMSG.USERNAME_NOT_EXISTS:
                setErrMSG(CodeMSG.getCodeMSG(getCode()));
                return ERROR;
            default:
                setErrMSG("未知错误");
                return ERROR;
        }
    }

    @Override
    public void setCookiesMap(Map<String, String> map) {
        this.cookies = map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
