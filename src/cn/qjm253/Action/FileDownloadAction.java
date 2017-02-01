package cn.qjm253.Action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import java.io.InputStream;

/**
 * Created by qjm3662 on 2017/1/24.
 */

public class FileDownloadAction extends ActionSupport{
    public static final String DEFAULT_AVATAR_PATH = "src/default_avatar.jpg";
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getTargetFile() throws Exception{
        return ServletActionContext.getServletContext()
                .getResourceAsStream(DEFAULT_AVATAR_PATH);
    }
}
