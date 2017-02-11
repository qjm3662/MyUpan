# 优云
![logo](https://github.com/qjm3662/MyUpan/blob/master/logo192x192.png) 
***
## 服务器信息
host : 123.207.96.66  
port : 8080  
项目访问路径：[点我](http://123.207.96.66:8080/MyUpan_war/)
***

## 注册
url : /user/RegisterAction  
parm : 
```Java
    private String username;        //传入的用户名
    private String password;        //传入的密码
    private int sex;                //传入的性别
```
注册成功返回信息实例：     
```
{
    "avatar": "http://123.207.96.66:8080/MyUpan_war/download?fileName=default_avatar.jpg",
    "code": 0
}
```




## 登录
url : /user/LoginAction  
parm :
```Java
    private String username;        //传入的用户名
    private String password;        //传入的密码
```
登录成功返回信息：
```
{"code":0}
```

## 获取用户信息
url : /GetUserInfoAction  
parm : 
```Java
    private String visitor;     //实际访问该路由的用户名（若未登录可以不传）
    private String username;    //要获取信息的目标用户名
```
成功返回信息：
```
{
    "avatar": "http://123.207.96.66:8080/MyUpan_war/download?fileName=default_avatar.jpg",
    "code": 0,
    "nickname": "Robbin",
    "relative": false,
    "sex": 1,
    "shares": [
        {
            "createTime": 1486813987084,
            "downloadCount": 8,
            "fileName": "logo192x192.png",
            "fileSize": 0.0149698,
            "id": 25,
            "identifyCode": "FEsY6I",
            "isPublic": 1,
            "updateTime": 1486813987084
        }
    ],
    "signature": "优云，所想即所得&",
    "username": "Robbin"
}
```
其中，relative表示访问路由的对象是否已经关注目标对象，shares表示其分享的文件的信息

## 修改用户信息
url : /user/ModifyUserInfoAction  
parm : 
```Java
    private String username;        //用户名
    private String nickname;        //昵称
    private int sex;                //性别（1表示男，2表示女）
    private String signature;       //个性签名
```
成功返回信息：
```
{"code":0}
```
## 关注别人
url : /user/follow  
parm : 
```Java
    private String myselfName;      //待操作的用户
    private String otherName;       //要关注的对象
```
成功返回信息：
```
{"code":0}
```

## 取消关注别人
url : /user/unFollow  
parm : 
```Java
    private String myselfName;      //待操作的用户
    private String otherName;       //要取消关注的对象
```
成功返回信息：
```
{"code":0}
```
## 获取关注的人信息
url : /user/followInfo  
parm : 
```Java
    private String username; 
```
成功返回信息:
```
{"code":0,"follows":[]}
```

## 文件上传
url : /user/upload   或者  /upload (前者是登录后上传，后者是非登录上传)  
parm : 
```Java
    private File file;    //上传文件
    private byte share;     //是否分享
    private String username; //非登录上传该参数可以省略
```
成功返回信息：
```
{"code":0}
```

## 修改密码
url : /user/revisePSD  
parm : 
```Java
    private String username;
    private String password;
    private String newPassword;
```
成功返回信息：
```
{"code":0}
```
## 用户反馈
url : /user/feedback  
parm : 
```Java
    private String username;
    private String text;
```
成功返回信息:
```
{"code":0}
```

## 修改头像
url : /user/modifyAvatar  
parm : 
```Java
    private File avatar;
    private String username;
```
成功返回信息:
```
{"code":0}
```

## 下载文件
url : /download/****** (其中******表示六位提取码) [我是示例](http://123.207.96.66:8080/MyUpan_war/download/FEsY6I)  
parm : 无

## 获取分享中心
url : /share  
parm : 无<br/>
成功返回信息：
```
{
    "code": 0,
    "shares": [
        {
            "createTime": 1486699867823,
            "downloadCount": 6,
            "fileName": "aa.jpg",
            "fileSize": 0.0258732,
            "id": 20,
            "identifyCode": "AkZGSt",
            "isPublic": 1,
            "updateTime": 1486699867823
        },
        {
            "createTime": 1486700438738,
            "downloadCount": 3,
            "fileName": "第七章 群与环：New2016  [自动保存的].pdf",
            "fileSize": 2.49385,
            "id": 21,
            "identifyCode": "SYH1ec",
            "isPublic": 1,
            "updateTime": 1486700438738
        },
        {
            "createTime": 1486714469926,
            "downloadCount": 0,
            "fileName": "header.jpg",
            "fileSize": 0.0157766,
            "id": 22,
            "identifyCode": "fir0PV",
            "isPublic": 1,
            "updateTime": 1486714469926
        },
        {
            "createTime": 1486717018809,
            "downloadCount": 0,
            "fileName": "header.jpg",
            "fileSize": 0.024354,
            "id": 23,
            "identifyCode": "hFPZMh",
            "isPublic": 1,
            "updateTime": 1486717018809
        },
        {
            "createTime": 1486717074748,
            "downloadCount": 3,
            "fileName": "IMG20170118131501.jpg",
            "fileSize": 0.522092,
            "id": 24,
            "identifyCode": "mWEywx",
            "isPublic": 1,
            "updateTime": 1486717074748
        },
        {
            "createTime": 1486813987084,
            "downloadCount": 9,
            "fileName": "logo192x192.png",
            "fileSize": 0.0149698,
            "id": 25,
            "identifyCode": "FEsY6I",
            "isPublic": 1,
            "updateTime": 1486813987084
        }
    ]
}
```

## 获取文件信息
url : /GetFileInfoAction/****** (其中******表示六位提取码)  [我是示例](http://123.207.96.66:8080/MyUpan_war/GetFileInfoAction/FEsY6I)  
parm ：无<br/>
成功返回信息 : 
```
{
    "code": 0,
    "createTime": 1486813987084,
    "downloadCount": 9,
    "fileName": "logo192x192.png",
    "fileSize": 0.0149698,
    "identifyCode": "FEsY6I",
    "isPublic": 1,
    "updateTime": 1486813987084
}
```
