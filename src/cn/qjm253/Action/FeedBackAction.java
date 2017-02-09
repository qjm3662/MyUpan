package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by qjm3662 on 2017/2/9.
 */
public class FeedBackAction extends ActionSupport{
    private int code;
    private String errMSG;
    private String username;
    private String text;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String feedback() throws Exception{
        if(username == null || username.equals("")){
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        setCode(HibernateOperator.feedBack(getUsername(), getText()));
        if(getCode() != 0){
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        return SUCCESS;
    }
}
