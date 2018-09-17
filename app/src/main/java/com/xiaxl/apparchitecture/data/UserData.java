package com.xiaxl.apparchitecture.data;

import java.io.Serializable;

/**
 * @author xiaxueliang
 * <p/>
 * 用户的基础数据
 */
public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;


    public String id;
    // 用户昵称（默认手机号）
    public String userName;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ");
        sb.append(id);
        sb.append(" userName: ");
        sb.append(userName);
        return sb.toString();
    }


}
