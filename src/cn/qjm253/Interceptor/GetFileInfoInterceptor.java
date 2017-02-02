package cn.qjm253.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by qjm3662 on 2017/2/2.
 */
public class GetFileInfoInterceptor extends AbstractInterceptor{

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        return null;
    }
}
