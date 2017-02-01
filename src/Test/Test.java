package Test;

import cn.qjm253.Entity.UserEntity;
import cn.qjm253.util.HibernateUtil;
import cn.qjm253.util.UUIDUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Created by qjm3662 on 2017/1/23.
 */
public class Test {
    public static void main(String[] args) {
//        SpringTest();
//        Session session = HibernateUtil.currentSession();
//        Transaction t = session.beginTransaction();
//        UserEntity user = new UserEntity();
//        user.setSex(1);
//        user.setSignature("dasf afsdf asdfsa");
//        user.setNickname("sdafasfasf");
//        user.setUsername("Robbin");
//        user.setAvatar("dfsaddf");
//        user.setPassword("123456");
//        session.save(user);
//        t.commit();
//        HibernateUtil.closeSession();

        String msg = "mdzz";
        msg = UUIDUtil.addUUID(msg);
        System.out.println(msg);
        System.out.println(UUIDUtil.deleteUUID(msg));
    }

    private static void SpringTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Test/bean.xml");
        Person p = context.getBean("person", Person.class);
        System.out.println(p);
    }
}
