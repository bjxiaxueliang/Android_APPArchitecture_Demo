package com.xiaxl.apparchitecture.view;

import com.xiaxl.apparchitecture.data.UserLoginData;

/**
 * Created by xiaxl
 */

public interface ILoginView {

    void onLoginSu(UserLoginData data);

    void onLoginErr();
}
