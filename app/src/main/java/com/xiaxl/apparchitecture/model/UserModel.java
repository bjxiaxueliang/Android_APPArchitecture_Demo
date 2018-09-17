package com.xiaxl.apparchitecture.model;

import com.xiaxl.apparchitecture.data.UserData;

import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;

/**
 * @author xiaxueliang
 * 登录Model管理类
 */
public class UserModel {


    private static final String TAG = UserModel.class.getSimpleName();


    private UserModelListener mUserModelListener;

    public UserModel(UserModelListener listener) {
        this.mUserModelListener = listener;
    }


    public void onDestroy() {
        if (mUserModelListener != null) {
            mUserModelListener = null;
        }
    }

    /**
     * 获取网络的用户信息
     */
    public void getRemoteUserData() {

        /**
         * TODO 模拟获取用户的网络数据
         */
        Task.call(new Callable<UserData>() {
            @Override
            public UserData call() throws Exception {
                // TODO 模拟获取用户的网络数据
                // 异步线程
                // 线程睡3s
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // TODO 构造一个假数据返回

                UserData userVo = new UserData();
                userVo.id = "000001";
                userVo.userName = "小明";


                return userVo;
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<UserData, Object>() {
            @Override
            public Object then(Task<UserData> task) throws Exception {

                UserData result = task.getResult();

                // TODO 通知登录状态的观察者 登录成功
                if (mUserModelListener != null) {
                    mUserModelListener.onUserDatalSu(result);
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }


    //##################################回调接口######################################


    public interface UserModelListener {

        void onUserDatalSu(UserData data);

        void onUserDataErr();

    }

}
