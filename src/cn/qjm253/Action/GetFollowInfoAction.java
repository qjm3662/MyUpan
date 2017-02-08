package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.Entity.UserInfoConcernEntity;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by qjm3662 on 2017/2/7.
 */
public class GetFollowInfoAction extends ActionSupport{
    private int code;
    private String errMSG;
    private String username;
    private UserInfoConcernEntity[] follows;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    private void setErrMSG(String errMSG) {
        this.errMSG = errMSG;
    }

    public UserInfoConcernEntity[] getFollows() {
        return follows;
    }

    private void setFollows(UserInfoConcernEntity[] follows) {
        this.follows = follows;
    }

    public String getFollowInfo() throws Exception{
        if(getUsername() == null || getUsername().equals("")){
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        setFollows(HibernateOperator.getFollowInfo(getUsername()));
        setCode(0);
        return SUCCESS;
    }
}
