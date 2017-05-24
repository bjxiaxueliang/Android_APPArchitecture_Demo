package com.xiaxl.apparchitecture.data;

import java.io.Serializable;

/**
 * @author xiaxueliang
 */
public class UserLoginData implements Serializable {
    private static final long serialVersionUID = 1L;


    // 登录成功唯一凭证
    public String token;
    // 密码错误次数，三次以后必须显示验证码
    public int errorNum;
    // 是否登录成功
    public boolean isSuccess;
    // 用户基础数据
    public UserVoData userVo;


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("token: ");
        sb.append(token);
        sb.append(" errorNum: ");
        sb.append(errorNum);
        sb.append(" isSuccess: ");
        sb.append(isSuccess);
        sb.append(" userVo: ");
        sb.append(userVo);
        return sb.toString();
    }

}
