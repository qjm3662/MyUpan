package cn.qjm253.Entity;

import cn.qjm253.Controll.UrlControl;

/**
 * Created by qjm3662 on 2017/2/4.
 */
public class UserInfoConcernEntity {
    private int id;
    private String username;
    private int sex;
    private String signature;
    private String avatar;
    private String nickname;
    private UserEntity concernMe;   //关注我的人

    public UserInfoConcernEntity(){

    }

    public UserInfoConcernEntity(String username, int sex, String signature, String avatar, String nickname, UserEntity concernMe) {
        this.username = username;
        this.sex = sex;
        this.signature = signature;
        this.avatar = avatar;
        this.nickname = nickname;
        this.concernMe = concernMe;
    }

    public UserInfoConcernEntity(String username){
        this.username = username;
        this.sex = 1;
        this.signature = "aa";
        this.avatar = UrlControl.default_avatar;
        this.nickname = "aa";
    }

    @Override
    public String toString() {
        return "UserInfoConcernEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", signature='" + signature + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", concernMe=" + concernMe +
                '}';
    }

    public UserEntity getConcernMe() {
        return concernMe;
    }

    public void setConcernMe(UserEntity concernMe) {
        this.concernMe = concernMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoConcernEntity that = (UserInfoConcernEntity) o;

//        if (sex != that.sex) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
//        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
//        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
//        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + sex;
//        result = 31 * result + (signature != null ? signature.hashCode() : 0);
//        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
//        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        return result;
    }
}
