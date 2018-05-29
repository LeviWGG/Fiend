package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;
import butterknife.OnClick;

/**
 * Created by wlw on 2018/5/7.
 */

public class MineFragment extends BaseMVPFragment {
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSwipeBackEnable(false);
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @OnClick({R.id.image_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back :
                break;
            default:
        }
    }
}
