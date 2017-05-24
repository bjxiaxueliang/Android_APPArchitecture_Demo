package com.xiaxl.apparchitecture.data;

import java.io.Serializable;

/**
 * @author xiaxueliang
 *         <p/>
 *         用户的基础数据
 */
public class UserVoData implements Serializable {
    private static final long serialVersionUID = 1L;


    public String id;
    // 用户编码（唯一业务号）
    public long userCode;
    // 用户昵称（默认手机号）
    public String userName;
    // 手机号
    public String phone;
    // 密码
    public String password;
    // 用户状态 1 正常，2 冻结，3 黑名单
    public int userStatus;
    // 背景图片url，以_@_分隔
    public String bgImgUrl;
    // 头像图片url，以_@_分隔
    public String headImgUrl;
    // 性别，男 m，女w，未知un
    public String gender;
    // 星座，枚举值参看数据字典
    public String constellation;
    // 城市，枚举值参看数据字典
    public String cityCode;
    // 等级，枚举值参看数据字典
    public int activeLevel;
    // 否	角色，01 普通用户，02 管理员，03 超级管理员
    public String userRole;
    // 个性签名
    public String signature;
    // 终端平台
    public String platform;
    // 注册时间
    public String createTime;
    // 最后修改时间
    public String updateTime;


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ");
        sb.append(id);
        sb.append(" userCode: ");
        sb.append(userCode);
        sb.append(" userName: ");
        sb.append(userName);
        sb.append(" phone: ");
        sb.append(phone);
        sb.append(" password: ");
        sb.append(password);
        sb.append(" userStatus: ");
        sb.append(userStatus);
        sb.append(" bgImgUrl: ");
        sb.append(bgImgUrl);
        sb.append(" headImgUrl: ");
        sb.append(headImgUrl);
        sb.append(" gender: ");
        sb.append(gender);
        sb.append(" constellation: ");
        sb.append(constellation);
        sb.append(" cityCode: ");
        sb.append(cityCode);
        sb.append(" activeLevel: ");
        sb.append(activeLevel);
        sb.append(" userRole: ");
        sb.append(userRole);
        sb.append(" signature: ");
        sb.append(signature);
        sb.append(" platform: ");
        sb.append(platform);
        sb.append(" createTime: ");
        sb.append(createTime);
        sb.append(" updateTime: ");
        sb.append(updateTime);
        return sb.toString();
    }


}
