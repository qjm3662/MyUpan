package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by qjm3662 on 2017/2/4.
 */
public class UnFollowSBAction extends ActionSupport{
    private int code;
    private String errMSG;
    private String myselfName;
    private String otherName;

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

    public String unFollowSb() throws Exception{
        if(getMyselfName() == null || getOtherName() == null || getMyselfName().equals("") || getOtherName().equals("")){
            setCode(CodeMSG.PARAM_ERROR_FOLLOW);
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        return SUCCESS;
    }
}
