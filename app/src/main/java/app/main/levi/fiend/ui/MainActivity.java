package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.base.BaseMVPActivity;
import app.main.wangliwei.baselib.base.BasePresenter;
import app.main.wangliwei.baselib.utils.StatusBarUtil;

public class MainActivity extends BaseMVPActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    private void initView() {
        MainFragment mainFragment = new MainFragment();
        loadRootFragment(R.id.fragment_content,mainFragment);

        StatusBarUtil.setTranslucentForImageView(this,0,mainFragment.getView());
    }
}
