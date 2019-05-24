package com.xiaxl.apparchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xiaxl.apparchitecture.data.UserLoginData;
import com.xiaxl.apparchitecture.model.LoginCallBack;
import com.xiaxl.apparchitecture.model.LoginModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    //
    boolean DEBUG = false;

    //
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 注册观察者
        LoginModel.getInstance().addObserver(this);

        // 初始化UI
        intiUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        // TODO 取消观察者注册
        LoginModel.getInstance().deleteObserver(this);
    }

    /**
     * 观察者的回调
     *
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        // 没有数据回调回来
        if (data == null) {
            return;
        }

        if (data instanceof LoginCallBack) {
            LoginCallBack callbackData = (LoginCallBack) data;
            //
            int valueType = callbackData.valueType;
            Object key = callbackData.key;
            Object value = callbackData.value[0];

            switch (valueType) {
                // TODO 登录成功的回调
                case LoginCallBack.LOGIN_SUCCESS:
                    //
                    updateUI((UserLoginData) value);
                    return;
                // TODO 退出登录
                case LoginCallBack.LOGIN_EXIT:
                    return;
                // TODO 登录用户数据变化
                case LoginCallBack.LOGIN_USER_CHANGE:
                    return;
            }

        }
    }

    /**
     * 初始化UI
     */
    private void intiUI() {
        // 登录按钮
        mBtn = (Button) findViewById(R.id.button);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO 取网络数据
                LoginModel.getInstance().getLoginDataFromNet(MainActivity.this, "111", "222", "333", "666");
            }
        });
    }


    /**
     * 更新UI
     */
    private void updateUI(UserLoginData data) {
        // TODO 登录成功的数据更新UI

        String str = data.toString();
        Log.e("xiaxl: ","updateUI: " + str);

        mBtn.setText(str);


    }

}
