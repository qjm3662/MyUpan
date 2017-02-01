package cn.qjm253.Action;

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
    private String title; //文件标题
    private File upload;    //上传文件
    private String uploadContentType;   //上传文件类型
    private String uploadFileName;  //上传文件名
    private int code = -1;
    private String errMSG = "该类型的文件不允许上传";


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String upload() throws Exception{
        System.out.println(getUploadContentType());
        String path = ServletActionContext.getServletContext().getRealPath(getSavePath());
        //以服务器的文件保存地址和原文件名建立上传文件输出流
        FileOutputStream fos = new FileOutputStream( path + "\\" + UUIDUtil.addUUID(getUploadFileName()));
        FileInputStream fis = new FileInputStream(getUpload());
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = fis.read(buffer)) > 0){
            fos.write(buffer,0, len);
        }
        System.out.println(toString());
        setCode(CodeMSG.ALREADY_LOGIN);
        return SUCCESS;
    }

    @Override
    public String toString() {
        return "UploadAction{" +
                "title='" + title + '\'' +
                ", upload=" + upload +
                ", uploadContentType='" + uploadContentType + '\'' +
                ", uploadFileName='" + uploadFileName + '\'' +
                ", code=" + code +
                ", errMSG='" + errMSG + '\'' +
                ", savePath='" + savePath + '\'' +
                '}';
    }
}
