package app.main.levi.fiend.ui;

import android.content.Intent;
import android.os.Bundle;

import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.base.BaseCompatActivity;

public class ExternalActivity extends BaseCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ExternalActivity.this,SplashActivity.class));
            }
        },200);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_external;
    }
}
