package com.xiaxl.apparchitecture.model;

import android.content.Context;

import com.xiaxl.apparchitecture.data.UserLoginData;
import com.xiaxl.apparchitecture.data.UserVoData;

import java.util.Observable;
import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;

/**
 * @author xiaxueliang
 *         登录Model管理类
 */
public class LoginModel extends Observable {


    private static final String TAG = LoginModel.class.getSimpleName();

    /**
     * ------单例相关begin-----
     */
    private static final LoginModel single = new LoginModel();

    private LoginModel() {
    }

    public static LoginModel getInstance() {
        return single;
    }


    /**
     * 获取网络的用户信息
     *
     * @param context
     * @param phone
     * @param password
     * @param validCode
     * @param timestamp
     */
    public void getLoginDataFromNet(final Context context, final String phone, final String password, final String validCode, final String timestamp) {

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
                cacheLoginData(context, result);
                // TODO 通知登录状态的观察者 登录成功
                notifyUserDataObservers(LoginCallBack.LOGIN_SUCCESS, "123456", result);

                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }


    //##################################缓存######################################

    /**
     * 缓存登录数据
     *
     * @param context
     * @param data
     */
    private void cacheLoginData(Context context, UserLoginData data) {
        // TODO 缓存数据

    }

    //##################################通知UI变化######################################

    /**
     * * 通知全部观察者，channel数据发生了变化
     *
     * @param type   操作类型，如 登录成功，退出登录 等等
     * @param key    回调的Value相同时，可以用key区分
     * @param value  回调的Value数据
     * @param value1
     */
    private void notifyUserDataObservers(int type, Object key, Object value, Object value1) {
        //

        /**
         * 通知观察者，数据发生了变化
         */
        setChanged();
        //
        Object[] values = new Object[2];
        values[0] = value;
        values[1] = value1;
        //
        notifyObservers(new LoginCallBack(type, key, values));

    }


    /**
     * 通知全部观察者，channel数据发生了变化
     *
     * @param type  操作类型，如 登录成功，退出登录 等等
     * @param key   回调的Value相同时，可以用key区分
     * @param value 回调的Value数据
     */
    public void notifyUserDataObservers(int type, Object key, Object value) {

        /**
         * 通知观察者，数据发生了变化
         */
        setChanged();
        //
        Object[] values = new Object[1];
        values[0] = value;
        //
        notifyObservers(new LoginCallBack(type, key, values));

    }


}
