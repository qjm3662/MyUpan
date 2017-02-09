package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by qjm3662 on 2017/2/9.
 */
public class RevisePSDAction extends ActionSupport{
    private int code;
    private String errMSG;
    private String username;
    private String password;
    private String newPassword;

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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String revisePsd() throws Exception{
        if(username == null || username.equals("")){
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        setCode(HibernateOperator.revisePsd(getUsername(), getPassword(), getNewPassword()));
        setErrMSG(CodeMSG.getCodeMSG(getCode()));
        if(getCode() != 0){
            return ERROR;
        }
        return SUCCESS;
    }
}
