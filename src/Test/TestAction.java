package Test;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by qjm3662 on 2017/1/23.
 */
public class TestAction extends ActionSupport implements SessionAware{
    private String MSG = "I'm test message!";
    private Map<String, Object> session;

    public String test() throws Exception{
        System.out.println("begin");
        for(Map.Entry<String, Object> ele : session.entrySet()){
            System.out.println(ele.getKey() + " : " + ele.getValue());
        }
        session.put("count" + session.size(), session.size());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
