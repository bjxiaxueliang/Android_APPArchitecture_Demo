package com.xiaxl.apparchitecture;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaxl.apparchitecture.data.UserData;
import com.xiaxl.apparchitecture.databinding.ActivityMainBinding;
import com.xiaxl.apparchitecture.model.UserModel;
import com.xiaxl.apparchitecture.vm.UserViewModel;

public class MainActivity extends AppCompatActivity implements UserModel.UserModelListener {


    /**
     * Model
     */
    UserModel mUserModel = null;

    /**
     * ViewModel
     */
    UserViewModel mUserViewModel = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View
        ActivityMainBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        // Model
        mUserModel = new UserModel(this);
        // ViewModel
        mUserViewModel = new UserViewModel(mUserModel);
        // 设置ViewModel
        binding.setViewmodel(mUserViewModel);
    }

    // #################################Model数据返回####################################

    @Override
    public void onUserDatalSu(UserData data) {
        // 数据返回，设置数据
        mUserViewModel.setUserData(data);
    }

    @Override
    public void onUserDataErr() {
        // TODO 错误提醒
    }
}
