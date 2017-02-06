package cn.qjm253.Action;

import cn.qjm253.Controll.CodeMSG;
import cn.qjm253.Entity.UserEntity;
import cn.qjm253.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

/**
 * Created by qjm3662 on 2017/1/31.
 */
public class ModifyUserInfoAction extends ActionSupport implements CookiesAware{
    private String username;
    private String nickname;
    private int sex;
    private String signature;
    private int code;
    private String errMSG;
    private Map<String, String> cookies;

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
        //如果用户没有传入username参数，尝试从cookies中获得
        if(getUsername() == null || getUsername().equals("")){
            setUsername(cookies.get("username"));
        }

        //既没有传入username，cookies中又不存在username或已失效
        if(getUsername() == null){
            setCode(CodeMSG.USERNAME_NOT_EXISTS);
            setErrMSG(CodeMSG.getCodeMSG(getCode()) + " 或 " + CodeMSG.getCodeMSG(CodeMSG.COOKIE_INVALID));
            return ERROR;
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

    @Override
    public void setCookiesMap(Map<String, String> map) {
        this.cookies = map;
    }
}
