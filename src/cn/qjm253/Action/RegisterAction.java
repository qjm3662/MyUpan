package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.Controll.UrlControl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by qjm3662 on 2017/1/23.
 */
public class RegisterAction extends ActionSupport{
    private String username;        //传入的用户名
    private String password;        //传入的密码
    private int sex;                //传入的性别
    private String errorMsg;        //错误信息
    private int code;               //提示码
    private String avatar;          //默认头像

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String register() throws Exception{
        System.out.println("sex : " + getSex());
        setCode(HibernateOperator.registerJudge(username, password, 1));
        setAvatar(UrlControl.default_avatar);
        setSex(1);      //默认为Man
        System.out.println(getAvatar());
        if(getCode() == CodeMSG.ALREADY_LOGIN){ //注册成功
            return SUCCESS;
        }else{
            setErrorMsg(CodeMSG.getCodeMSG(code));
            return ERROR;
        }
    }
}
