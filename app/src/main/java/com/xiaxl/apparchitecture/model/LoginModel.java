package com.xiaxl.apparchitecture.model;

import android.content.Context;

import com.xiaxl.apparchitecture.data.UserLoginData;
import com.xiaxl.apparchitecture.data.UserVoData;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;

/**
 * @author xiaxueliang
 *         登录Model管理类
 */
public class LoginModel {


    private static final String TAG = LoginModel.class.getSimpleName();


    private LoginModelListener mLoginModelListener;

    public LoginModel(LoginModelListener listener) {
        this.mLoginModelListener = listener;
    }


    public void onDestroy() {
        if (mLoginModelListener != null) {
            mLoginModelListener = null;
        }
    }

    /**
     * 获取网络的用户信息
     */
    public void getLoginDataFromNet() {

        /**
         * TODO 模拟获取用户的网络数据
         */
        Task.call(new Callable<UserLoginData>() {
            @Override
            public UserLoginData call() throws Exception {
                // TODO 模拟获取用户的网络数据
                // 异步线程
                // 线程睡3s
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO 构造一个假数据返回
                UserLoginData mUserLoginData = new UserLoginData();
                mUserLoginData.token = "123";
                mUserLoginData.errorNum = 0;
                mUserLoginData.isSuccess = true;
                //
                mUserLoginData.userVo = new UserVoData();
                mUserLoginData.userVo.id = "1111";
                mUserLoginData.userVo.userCode = 5555555;
                mUserLoginData.userVo.userName = "1111";
                mUserLoginData.userVo.phone = "1111";
                mUserLoginData.userVo.password = "1111";
                mUserLoginData.userVo.userStatus = 1;
                mUserLoginData.userVo.bgImgUrl = "1111";
                mUserLoginData.userVo.headImgUrl = "1111";
                mUserLoginData.userVo.gender = "1111";
                mUserLoginData.userVo.constellation = "1111";
                mUserLoginData.userVo.cityCode = "1111";
                mUserLoginData.userVo.activeLevel = 100;
                mUserLoginData.userVo.userRole = "1111";
                mUserLoginData.userVo.signature = "1111";
                mUserLoginData.userVo.platform = "android";
                mUserLoginData.userVo.createTime = "1111";
                mUserLoginData.userVo.updateTime = "1111";


                return mUserLoginData;
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<UserLoginData, Object>() {
            @Override
            public Object then(Task<UserLoginData> task) throws Exception {

                UserLoginData result = task.getResult();

                // TODO 缓存数据
                cacheLoginData(result);
                // TODO 通知登录状态的观察者 登录成功
                if (mLoginModelListener != null) {
                    mLoginModelListener.onLoginModelSu(result);
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }


    //##################################缓存######################################

    /**
     * 缓存登录数据
     *
     * @param data
     */
    private void cacheLoginData(UserLoginData data) {
        // TODO 缓存数据

    }


    //##################################回调接口######################################


    public interface LoginModelListener {

        void onLoginModelSu(UserLoginData data);

        void onLoginModelErr();

    }

}
