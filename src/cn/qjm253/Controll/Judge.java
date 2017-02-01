package cn.qjm253.Controll;

import cn.qjm253.Action.CodeMSG;
import cn.qjm253.Entity.FileEntity;
import cn.qjm253.Entity.UserEntity;
import cn.qjm253.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 *
 * Created by qjm3662 on 2017/1/23.
 */
public class Judge {

    /**
     * 注册判断
     * @param username
     * @param password
     * @param sex
     * @return
     */
    public static int registerJudge(String username, String password, int sex){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        System.out.println(username);
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(list.size() == 0){   //数据库中没有对应数据，即该用户名没有被注册
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setSex(sex);
            newUser.setAvatar("http://192.168.1.15:8080/download?fileName=default_avatar.jpg");
            newUser.setNickname(username);
            newUser.setSignature("优云，所想即所得&");
            session.save(newUser);
//            FileEntity fileEntity = new FileEntity("《想你所想》", 1024, "347211", System.currentTimeMillis(), System.currentTimeMillis(), newUser, (byte) 1);
//            session.persist(fileEntity);
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.ALREADY_LOGIN;
        }else{
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_ALREADY_EXISTS;
        }
    }

    /**
     * 登录判断
     * @param username
     * @param password
     * @return
     */
    public static int loginJudge(String username, String password){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username).list();
        if(list.size() != 0){
            UserEntity user = (UserEntity) list.get(0);
            if(user.getPassword().equals(password)){
                t.commit();
                HibernateUtil.closeSession();
                return CodeMSG.ALREADY_LOGIN;
            }else{
                t.commit();
                HibernateUtil.closeSession();
                return CodeMSG.USERNAME_OR_PASSWORD_ERROR;
            }
        }else{
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_NOT_EXISTS;
        }
    }

}
