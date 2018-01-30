package com.xiaxl.apparchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xiaxl.apparchitecture.data.UserLoginData;
import com.xiaxl.apparchitecture.presenter.LoginPrecentor;
import com.xiaxl.apparchitecture.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    //
    private Button mBtn;
    //
    private LoginPrecentor mPrecenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化UI
        intiUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 页面退出
        if (mPrecenter != null) {
            mPrecenter.onDestroy();
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

                // 加载数据
                loadData();
            }
        });
    }

    /**
     * 请求数据
     */
    private void loadData() {
        mPrecenter = new LoginPrecentor(this);
        mPrecenter.login();
    }


    // #########################################################################################

    /**
     * 数据返回
     *
     * @param data
     */
    @Override
    public void onLoginSu(UserLoginData data) {
        //
        updateUI(data);
    }

    @Override
    public void onLoginErr() {

        mBtn.setText("error");
    }


    /**
     * 更新UI
     */
    private void updateUI(UserLoginData data) {
        // TODO 登录成功的数据更新UI

        String str = data.toString();
        Log.e("xiaxl: ", "updateUI: " + str);

        mBtn.setText(str);

    }
}
