package cn.qjm253.Entity;

/**
 * Created by qjm3662 on 2017/1/30.
 */
public class FileEntity {
    private int id;
    private String fileName;
    private double fileSize;
    private String identifyCode;
    private long createTime;
    private long updateTime;
    private UserEntity owner;
    private int downloadCount;
    private byte isPublic;
    private String saveName;    //包含了UUID码的文件名

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public FileEntity(){

    }

    public FileEntity(String fileName, double fileSize, String identifyCode, long createTime, long updateTime, UserEntity owner, byte isPublic, String saveName) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.identifyCode = identifyCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.owner = owner;
        this.isPublic = isPublic;
        this.saveName = saveName;
    }

//    public FileEntity(String fileName, double fileSize, String fileCode, long createTime, long updateTime, UserEntity owner, byte isPublic) {
//        this.fileName = fileName;
//        this.fileSize = fileSize;
//        this.identifyCode = fileCode;
//        this.createTime = String.valueOf(createTime);
//        this.updateTime = String.valueOf(updateTime);
//        this.owner = owner;
//        this.isPublic = isPublic;
//    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(byte isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEntity that = (FileEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.fileSize, fileSize) != 0) return false;
        if (isPublic != that.isPublic) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (identifyCode != null ? !identifyCode.equals(that.identifyCode) : that.identifyCode != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        temp = Double.doubleToLongBits(fileSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (identifyCode != null ? identifyCode.hashCode() : 0);
//        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
//        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (int) isPublic;
        return result;
    }
}
