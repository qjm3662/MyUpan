package cn.qjm253.Action;

import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.Entity.FileEntity;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by qjm3662 on 2017/2/3.
 */
public class GetShareCenterAction extends ActionSupport{
    private int code;
    private String errMSG;
    private FileEntity[] shares;

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

    public FileEntity[] getShares() {
        return shares;
    }

    public void setShares(FileEntity[] shares) {
        this.shares = shares;
    }

    public String getShareCenter() throws Exception{
        setShares(HibernateOperator.getShareCenter());
        setCode(0);
        return SUCCESS;
    }
}
