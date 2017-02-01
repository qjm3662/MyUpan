package Test;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by qjm3662 on 2017/1/23.
 */
public class TestAction extends ActionSupport{
    private String MSG = "I'm test message!";
    public String excute() throws Exception{
        return SUCCESS;
    }
}
