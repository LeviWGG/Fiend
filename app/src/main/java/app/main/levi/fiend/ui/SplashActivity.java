package app.main.levi.fiend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;

import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.base.BaseCompatActivity;
import app.main.wangliwei.baselib.utils.StatusBarUtil;

/**
 * Created by wlw on 2018/5/7.
 */

public class SplashActivity extends BaseCompatActivity {
    private Handler uiHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucent(this,0);
        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initView() {
        uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
