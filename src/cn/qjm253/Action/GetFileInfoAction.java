package cn.qjm253.Action;

import cn.qjm253.Controll.HibernateOperator;
import cn.qjm253.Entity.FileEntity;
import cn.qjm253.Entity.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * Created by qjm3662 on 2017/2/2.
 */
public class GetFileInfoAction extends ActionSupport{
    private String fileName;
    private double fileSize;
    private String identifyCode;
    private long createTime;
    private long updateTime;
    private UserEntity owner;
    private int downloadCount;
    private byte isPublic;
    private String errMsg;
    private int Code;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public byte getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(byte isPublic) {
        this.isPublic = isPublic;
    }

    public String getFileInfo() throws Exception{
        //在Url中提取出 提取码
        String[] s = ServletActionContext.getRequest().getServletPath().split("/");
        setIdentifyCode(s[s.length - 1]);
        System.out.println(getIdentifyCode());
        FileEntity fileEntity = HibernateOperator.getFileInfoByIdentifyCode(getIdentifyCode());
        if(fileEntity == null){
            setCode(CodeMSG.CODE_ERROR);
            setErrMsg(CodeMSG.getCodeMSG(getCode()));
            return ERROR;
        }
        setCode(CodeMSG.ALREADY_LOGIN);
        setFileName(fileEntity.getFileName());
        setCreateTime(fileEntity.getCreateTime());
        setUpdateTime(fileEntity.getUpdateTime());
        setDownloadCount(fileEntity.getDownloadCount());
        setFileSize(fileEntity.getFileSize());
        setIsPublic(fileEntity.getIsPublic());
        setOwner(fileEntity.getOwner());
        if(fileEntity.getOwner().getUsername().equals("Robbin")){  //拥有者是默认用户，故是非登录上传的文件
            return "success_but_not_login";
        }
        return SUCCESS;
    }
}
