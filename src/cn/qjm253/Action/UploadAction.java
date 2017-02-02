package cn.qjm253.Action;

import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.util.HibernateUtil;
import cn.qjm253.util.UUIDUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by qjm3662 on 2017/1/31.
 */
public class UploadAction extends ActionSupport{
    private File file;    //上传文件
    private String fileContentType;   //上传文件类型
    private String fileFileName;  //上传文件名
    private int code = -1;
    private String errMSG = "该类型的文件不允许上传";
    private String username = "Robbin";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMSG() {
        return errMSG;
    }

    public void setErrMSG(String errMSG) {
        this.errMSG = errMSG;
    }

    //直接在struts.xml文件配置的属性
    private String savePath;
    //接受struts.xml文件配置值的方法
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    //返回上传文件的保存位置
    private String getSavePath() {
        return savePath;
    }

    public String upload() throws Exception{
        System.out.println(getFileContentType());
        String path = ServletActionContext.getServletContext().getRealPath(getSavePath());
        String saveName = UUIDUtil.addUUID(getFileFileName());
        //以服务器的文件保存地址和原文件名建立上传文件输出流
        FileOutputStream fos = new FileOutputStream( path + "\\" + saveName);
        FileInputStream fis = new FileInputStream(getFile());
        byte[] buffer = new byte[1024];
        int len = 0;
        int fileSize = 0;
        while((len = fis.read(buffer)) > 0){
            fileSize += len;
            fos.write(buffer,0, len);
        }
        HibernateOperator.saveFile(getFileFileName(), saveName, fileSize, (byte)1, username);
        System.out.println(toString());
        setCode(CodeMSG.ALREADY_LOGIN);
        return SUCCESS;
    }

    @Override
    public String toString() {
        return "UploadAction{" +
//                "title='" + title + '\'' +
                ", file=" + file +
                ", fileContentType='" + fileContentType + '\'' +
                ", fileFileName='" + fileFileName + '\'' +
                ", code=" + code +
                ", errMSG='" + errMSG + '\'' +
                ", savePath='" + savePath + '\'' +
                '}';
    }
}
