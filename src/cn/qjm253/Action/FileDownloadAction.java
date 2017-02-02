package cn.qjm253.Action;

import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.Entity.FileEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import java.io.InputStream;

/**
 * Created by qjm3662 on 2017/1/24.
 */

public class FileDownloadAction extends ActionSupport{
    public static final String DEFAULT_AVATAR_PATH = "src/default_avatar.jpg";

    private String identifyCode;

    private String fileName;

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getTargetFile() throws Exception{
        //在Url中提取出 提取码
        String[] s = ServletActionContext.getRequest().getServletPath().split("/");
        setIdentifyCode(s[s.length - 1]);

        FileEntity f = HibernateOperator.getFileInfoByIdentifyCode(getIdentifyCode());
//        String targetFileName = HibernateOperator.GetTargetPathByIdentifyCode(getIdentifyCode());
        if(f == null){ //要下载的文件不存在
            return null;
        }
        setFileName(new String(f.getFileName().getBytes(), "ISO8859-1"));
        System.out.println("src/" + f.getSaveName());
        return ServletActionContext.getServletContext()
                .getResourceAsStream("WEB-INF/upload/" + f.getSaveName());
    }
}
