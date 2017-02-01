package cn.qjm253.Action;

import cn.qjm253.Entity.FileEntity;
import cn.qjm253.Entity.UserEntity;
import cn.qjm253.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 *
 * Created by qjm3662 on 2017/1/25.
 */
public class GetUserInfoAction extends ActionSupport {
    private String username;
    private String avatar;
    private String nickname;
    private String signature;
    private int sex;
    private int code;
    private String errMSG;
    private FileEntity[] shares;

    public FileEntity[] getShares() {
        return shares;
    }

    public void setShares(FileEntity[] shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "GetUserInfoAction{" +
                "username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", signature='" + signature + '\'' +
                ", sex=" + sex +
                ", code=" + code +
                ", errMSG='" + errMSG + '\'' +
                '}';
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserInfo() throws Exception {
        if (username == null) {
            return ERROR;
        }
        setCode(getUserInfoJude(username));
        if (getCode() == 0) {
            return SUCCESS;
        } else {
            setErrMSG(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
    }

    /**
     * 获取用户信息判断
     *
     * @param username
     * @return
     */
    public int getUserInfoJude(String username) {
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username).list();
        System.out.println(list);
        if (list.size() == 0) {  //该用户不存在
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_NOT_EXISTS;
        } else {
            UserEntity userEntity = (UserEntity) list.get(0);
            setSignature(userEntity.getSignature());
            setNickname(userEntity.getNickname());
            setAvatar(userEntity.getAvatar());
            setSex(userEntity.getSex());
            if (userEntity.getShares() == null) {
                System.out.println(username + "'s shares is null!!");
            } else {
                setShares(userEntity.getShares().toArray(new FileEntity[]{}));
                System.out.println(getShares()[0].getOwner());
            }
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.ALREADY_LOGIN;
        }
    }
}