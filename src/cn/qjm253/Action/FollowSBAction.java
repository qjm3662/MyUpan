package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Controll.HibernateOperator;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * Created by qjm3662 on 2017/2/4.
 */
public class FollowSBAction extends ActionSupport{
    private int code;
    private String errMSG;
    private String myselfName;      //待操作的用户
    private String otherName;       //要关注的对象

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

    public String getMyselfName() {
        return myselfName;
    }

    public void setMyselfName(String myselfName) {
        this.myselfName = myselfName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String followSb() throws Exception{
        if(getMyselfName() == null || getOtherName() == null || getMyselfName().equals("") || getOtherName().equals("")){
            setCode(CodeMSG.PARAM_ERROR_FOLLOW);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        int result = HibernateOperator.followSb(getMyselfName(), getOtherName());
        if(result > 0){
            setCode(0);
            return SUCCESS;
        }else{
            setCode(CodeMSG.USER_OR_TARGET_NOT_EXIST);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
    }
}
