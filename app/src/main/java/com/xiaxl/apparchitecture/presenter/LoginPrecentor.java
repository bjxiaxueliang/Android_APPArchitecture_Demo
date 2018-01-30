package com.xiaxl.apparchitecture.presenter;

import com.xiaxl.apparchitecture.data.UserLoginData;
import com.xiaxl.apparchitecture.model.LoginModel;
import com.xiaxl.apparchitecture.view.ILoginView;

/**
 * Created by xiaxl
 */

public class LoginPrecentor {

    // model
    LoginModel mModle = null;
    // view
    ILoginView mView = null;


    public LoginPrecentor(ILoginView iRecordView) {
        this.mView = iRecordView;
        initModle();
    }


    public void onDestroy() {
        // model 注销
        if (mModle != null) {
            mModle.onDestroy();
        }
        // view 置空
        if (mView != null) {
            mView = null;
        }
    }

    /**
     * 登录
     */
    public void login() {
        mModle.getLoginDataFromNet();
    }


    private void initModle() {
        mModle = new LoginModel(new LoginModel.LoginModelListener() {
            @Override
            public void onLoginModelSu(UserLoginData data) {
                if (mView != null) {
                    mView.onLoginSu(data);
                }
            }

            @Override
            public void onLoginModelErr() {
                if (mView != null) {
                    mView.onLoginErr();
                }
            }
        });
    }
}
