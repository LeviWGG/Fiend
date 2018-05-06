package app.main.levi.fiend;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;

/**
 * Created by wangliwei on 2018/5/6.
 */

public class HomeFragment extends BaseMVPFragment {
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }
}
