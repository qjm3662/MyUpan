package Test;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import java.util.Map;

/**
 * Created by qjm3662 on 2017/2/2.
 */
public class LoginAction extends ActionSupport implements SessionAware{
    private String username;
    private String password;
    private String msg;
    private Map<String, Object> session;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String execute() throws Exception {

        return super.execute();
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
