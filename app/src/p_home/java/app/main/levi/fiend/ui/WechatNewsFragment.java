package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import app.main.levi.fiend.R;
import app.main.levi.fiend.bean.Weixin;
import app.main.levi.fiend.contract.IWechatContract;
import app.main.levi.fiend.contract.WechatPresenterImp;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;

/**
 * Created by wlw on 2018/5/9.
 */

public class WechatNewsFragment extends BaseMVPFragment<IWechatContract.IWechatPresenter>
        implements IWechatContract.IWechatView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wechat_news;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSwipeBackEnable(false);
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public IWechatContract.IWechatPresenter initPresenter() {
        return new WechatPresenterImp(this);
    }

    @Override
    public void onSuccess(Weixin weixin) {

    }
}
