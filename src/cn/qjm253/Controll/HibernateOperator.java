package cn.qjm253.Controll;

import cn.qjm253.Entity.FeedbackEntity;
import cn.qjm253.Entity.FileEntity;
import cn.qjm253.Entity.UserEntity;
import cn.qjm253.Entity.UserInfoConcernEntity;
import cn.qjm253.util.HibernateUtil;
import cn.qjm253.util.UUIDUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by qjm3662 on 2017/1/23.
 */
public class HibernateOperator {

    private static FileEntity[] shareCenter;

    /**
     * 注册函数
     *
     * @param username
     * @param password
     * @param sex
     * @return
     */
    public static int registerJudge(String username, String password, int sex) {
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        System.out.println(username);
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if (list.size() == 0) {   //如果不存在则允许注册
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setSex(sex);
            newUser.setAvatar(UrlControl.default_avatar);
            newUser.setNickname(username);
            newUser.setSignature("优云，所想即所得&");
            session.save(newUser);
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.ALREADY_LOGIN;
        } else {
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_ALREADY_EXISTS;
        }
    }

    /**
     * 登录函数
     *
     * @param username
     * @param password
     * @return
     */
    public static int loginJudge(String username, String password) {
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username).list();
        if (list.size() != 0) {
            UserEntity user = (UserEntity) list.get(0);
            if (user.getPassword().equals(password)) {
                t.commit();
                HibernateUtil.closeSession();
                return CodeMSG.ALREADY_LOGIN;
            } else {
                t.commit();
                HibernateUtil.closeSession();
                return CodeMSG.USERNAME_OR_PASSWORD_ERROR;
            }
        } else {
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_NOT_EXISTS;
        }
    }

    /**
     * 保存文件
     * @param fileName
     * @param fileSize
     * @param isPublic
     * @param username
     * @return
     */
    public static String saveFile(String fileName, String saveName, double fileSize, byte isPublic, String username) {
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if (list.size() == 0) {     //用户名错误则保存为非登录上传
            list = session.createQuery("from UserEntity u where u.username = :usn")
                    .setParameter("usn", "Robbin")
                    .list();
        }
        String identifyCode = UUIDUtil.getRandomString(6);
        UserEntity user = (UserEntity) list.get(0);
        FileEntity fileEntity = new FileEntity(fileName, fileSize, identifyCode, System.currentTimeMillis(), System.currentTimeMillis(),
                user, isPublic, saveName);
        session.persist(fileEntity);
        t.commit();
        HibernateUtil.closeSession();
        return identifyCode;
    }

    /**
     * 通过提取码获得文件对象
     * @param identifyCode
     * @param where 1->download  2->getFileInfo
     * @return
     */
    public static FileEntity getFileInfoByIdentifyCode(String identifyCode, int where){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from FileEntity f where f.identifyCode = :ic")
                .setParameter("ic", identifyCode)
                .list();
        if(list.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return null;
        }else{
            FileEntity fileEntity = (FileEntity) list.get(0);
            if(where == 1){     //�����ǲ�����������
                fileEntity.setDownloadCount(fileEntity.getDownloadCount() + 1);
            }
            t.commit();
            HibernateUtil.closeSession();
            return fileEntity;
        }
    }


    /**
     * 通过提取码获得实际保存的名字
     * @param identifyCode
     * @return
     */
    public static String GetTargetPathByIdentifyCode(String identifyCode, int where){
        FileEntity f = getFileInfoByIdentifyCode(identifyCode, where);
        if(f != null){
            return f.getSaveName();
        }else{
            return null;
        }
    }


    /**
     * 修改头像
     * @param username  需要修改头像的用户名
     * @param avatarUrl 要修改成的头像的url
     * @return 返回是否修改成功
     */
    public static boolean modifyAvatar(String username, String avatarUrl){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(list.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return false;
        }
        UserEntity userEntity = (UserEntity) list.get(0);
        userEntity.setAvatar(avatarUrl);
        List l_followInfo = session.createQuery("from UserInfoConcernEntity uc where uc.username = :usn")
                .setParameter("usn", username)
                .list();
        for(Object uc : l_followInfo){ //更改该用户被关注的信息
            ((UserInfoConcernEntity)uc).setAvatar(avatarUrl);
        }
        t.commit();
        HibernateUtil.closeSession();
        return true;
    }

    /**
     * 获取分享中心
     * @return
     */
    public static FileEntity[] getShareCenter() {
        Session session = HibernateUtil.currentSession();
        List list = session.createQuery("from FileEntity f where f.isPublic = :isP")
                .setParameter("isP", (byte)1)
                .list();
        if(list.size() == 0){
            return null;
        }
        else{
            return (FileEntity[]) list.toArray(new FileEntity[]{});
        }
    }

    /**
     * 获得关注信息
     * @param username
     * @return
     */
    public static UserInfoConcernEntity[] getFollowInfo(String username) {
        Session session = HibernateUtil.currentSession();
        List l_user = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(l_user.size() == 0){
            return null;
        } else{
            return ((UserEntity)l_user.get(0)).getConcern().toArray(new UserInfoConcernEntity[]{});
        }
    }

    /**
     * 关注某人
     * @param username     待操作的对象
     * @param targetName    要关注的对象
     * @return  -1->username not exist       1->follow info already exist
     *           -2->targetName not exist     2->add follow info success
     */
    public static int followSb(String username, String targetName){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List l1 = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(l1.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return -1;
        }
        UserEntity user = (UserEntity) l1.get(0);
        if(session.createQuery("from UserInfoConcernEntity uc where uc.username = :usn and uc.concernMe.id = :id")
                .setParameter("usn", targetName)
                .setParameter("id", user.getId())
                .list().size() != 0){      //若关注信息已存在则不重复添加
            t.commit();
            HibernateUtil.closeSession();
           return 1;
        }
        List l2 = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", targetName)
                .list();
        if(l2.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return -2;
        }
        UserEntity target = (UserEntity) l2.get(0);
        UserInfoConcernEntity userInfoConcernEntity = new UserInfoConcernEntity(target.getUsername(),
                target.getSex(), target.getSignature(), target.getAvatar(), target.getNickname(), user);
        session.persist(userInfoConcernEntity);
        t.commit();
        HibernateUtil.closeSession();
        return 2;
    }

    /**
     * 取消关注某人
     * @param username     待操作的对象
     * @param targetName    要关注的对象
     * @return      -1->username not exist       1->delete follow info success
     *           -2->follow info not exist
     */
    public static int unFollowSb(String username, String targetName){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List l1 = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(l1.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return -1;
        }
        UserEntity user = (UserEntity) l1.get(0);
        List l2 = session.createQuery("from UserInfoConcernEntity u where u.username = :usn and u.concernMe.id = :id")
                .setParameter("usn", targetName)
                .setParameter("id", user.getId())
                .list();
        if(l2.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return -2;
        }
        UserInfoConcernEntity target = (UserInfoConcernEntity) l2.get(0);
        session.delete(target);
        t.commit();
        HibernateUtil.closeSession();
        return 1;
    }


    /**
     * 修改密码
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    public static int revisePsd(String username, String password, String newPassword){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(list.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_NOT_EXISTS;
        }
        UserEntity u = (UserEntity) list.get(0);
        if(!u.getPassword().equals(password)){
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.PASSWORD_ERROR;
        }
        if(newPassword != null && !newPassword.equals("")){
            u.setPassword(newPassword);
        }
        t.commit();
        HibernateUtil.closeSession();
        return 0;
    }

    /**
     * 用户反馈
     * @param username
     * @param text
     * @return
     */
    public static int feedBack(String username, String text){
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
        List list = session.createQuery("from UserEntity u where u.username = :usn")
                .setParameter("usn", username)
                .list();
        if(list.size() == 0){
            t.commit();
            HibernateUtil.closeSession();
            return CodeMSG.USERNAME_NOT_EXISTS;
        }
        FeedbackEntity feedbackEntity =  new FeedbackEntity();
        feedbackEntity.setText(text);
        feedbackEntity.setUsername(username);
        session.save(feedbackEntity);
        t.commit();
        HibernateUtil.closeSession();
        return 0;
    }
}
