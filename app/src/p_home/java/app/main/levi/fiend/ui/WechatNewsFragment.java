package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import app.main.levi.fiend.R;
import app.main.levi.fiend.bean.Weixin;
import app.main.levi.fiend.contract.IWechatContract;
import app.main.levi.fiend.contract.WechatPresenterImp;
import app.main.levi.fiend.ui.adapter.WechatNewsAdapter;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import butterknife.BindView;

/**
 * Created by wlw on 2018/5/9.
 */

public class WechatNewsFragment extends BaseMVPFragment<IWechatContract.IWechatPresenter>
        implements IWechatContract.IWechatView {

    @BindView(R.id.recycler_only)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefreshLayout;

    private WechatNewsAdapter adapter;

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
        adapter = new WechatNewsAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public IWechatContract.IWechatPresenter initPresenter() {
        return new WechatPresenterImp(this);
    }

    @Override
    public void onSuccess(Weixin weixin) {

    }
}
