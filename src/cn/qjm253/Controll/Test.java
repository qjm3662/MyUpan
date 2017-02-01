package cn.qjm253.Controll;

import cn.qjm253.Entity.FileEntity;
import cn.qjm253.Entity.UserEntity;
import cn.qjm253.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qjm3662 on 2017/1/24.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(Judge.registerJudge("Robbin1", "123456", 2));
        Session session = HibernateUtil.currentSession();
        Transaction t = session.beginTransaction();
//        List list = session.createQuery("from UserEntity u where u.username = :usn")
//                .setParameter("usn", "Ronn")
//                .list();
//        UserEntity user = (UserEntity) list.get(0);
//        System.out.println(user.getShares().size());

//        List list = session.createQuery("from UserEntity u where u.username = :usn")
//                .setParameter("usn", "Robbin9")
//                .list();
//        UserEntity userEntity = (UserEntity) list.get(0);
//        System.out.println(userEntity.getShares());
//        for(FileEntity fileEntity : userEntity.getShares()){
//            System.out.println(fileEntity.getUsername());
//        }

//        UserEntity newUser = new UserEntity();
//        newUser.setUsername("Ronn");
//        newUser.setPassword("123456");
//        newUser.setSex(1);
//        newUser.setAvatar("http://192.168.1.15:8080/download?fileName=default_avatar.jpg");
//        newUser.setNickname("asdfas");
//        newUser.setSignature("优云，所想即所得&");
//        //先持久化UserEntity对象
//        session.save(newUser);
//        //创建一个瞬态的FileEntity
//        FileEntity fileEntity = new FileEntity("Ronn", 1024, "325225", System.currentTimeMillis(), System.currentTimeMillis(),
//                newUser, (byte) 1);
//        session.persist(fileEntity);
        t.commit();
        HibernateUtil.closeSession();
    }

}
