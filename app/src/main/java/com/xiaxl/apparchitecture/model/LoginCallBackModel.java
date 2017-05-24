package com.xiaxl.apparchitecture.model;

/**
 *
 */
public class LoginCallBackModel {


    private static final String TAG = LoginCallBackModel.class.getSimpleName();

    // 登录成功
    public static final int LOGIN_SUCCESS = 0;
    // 退出登录
    public static final int LOGIN_EXIT = 1;
    // 登录用户数据变化
    public static final int LOGIN_USER_CHANGE = 2;


    public int valueType = 0;
    public Object key = null;
    public Object[] value = null;

    public LoginCallBackModel(int valueType, Object key, Object... value) {
        this.valueType = valueType;
        this.key = key;
        this.value = value;
    }


}
