package com.xiaxl.apparchitecture.vm;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.util.Log;

import com.xiaxl.apparchitecture.data.UserData;
import com.xiaxl.apparchitecture.model.UserModel;

/**
 * Created by xiaxl
 */

public class UserViewModel extends BaseObservable {
    private static final String TAG = "UserViewModel";

    /**
     * 展示数据
     */
    //
    public final ObservableField<String> userId = new ObservableField<>();
    //
    public final ObservableField<String> userName = new ObservableField<>();

    /**
     * Model
     */
    public UserModel mUserModel;


    /**
     * 构造方法
     *
     * @param userModel
     */
    public UserViewModel(UserModel userModel) {
        this.mUserModel = userModel;
    }

    // ##########################################

    /**
     * 获取用户数据
     */
    public void getRemoteUserData() {
        mUserModel.getRemoteUserData();
    }


    /**
     * 更新UI
     *
     * @param userData
     */
    public void setUserData(UserData userData) {
        Log.e("xiaxl: " + TAG, "userData: " + userData);
        userId.set(userData.id);
        userName.set(userData.userName);
        // 更新UI

    }

}
