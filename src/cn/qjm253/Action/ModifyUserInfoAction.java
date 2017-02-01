package cn.qjm253.Action;

import cn.qjm253.Entity.UserEntity;
import cn.qjm253.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by qjm3662 on 2017/1/31.
 */
public class ModifyUserInfoAction extends ActionSupport {
    private String username;
    private String nickname;
    private int sex;
    private String signature;
    private int code;
    private String errMSG;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    public String modifyUserInfo() throws Exception {
        if (getUsername() == null || getUsername().equals("")) {  //传入的参数
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
        }
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", getUsername())
                .list();
        if (list.size() == 0) {
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
        }
        if(getCode() != 0){
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        UserEntity user = (UserEntity) list.get(0);
        user.setSex(getSex());
        user.setNickname(getNickname());
        user.setSignature(getSignature());
        t.commit();
        HibernateUtil.closeSession();
        return SUCCESS;
    }
}
