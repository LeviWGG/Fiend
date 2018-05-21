package app.main.levi.fiend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

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

    private List<Weixin.ResultBean.ListBean> listBeans;

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
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (listBeans.get(position).getUrl().isEmpty()) {return;}
                Log.d("item","url: "+view.getTag());
                Bundle bundle = new Bundle();
                bundle.putString("URL",(String)view.getTag());
                Intent intent = new Intent(getActivity(),WebDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent,bundle);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        recyclerView.setAdapter(adapter);

        showProgressDialog("请稍后");
        mPresenter.getWechatNews();
    }

    @Override
    public IWechatContract.IWechatPresenter initPresenter() {
        return new WechatPresenterImp(this);
    }

    @Override
    public void onSuccess(Weixin weixin) {
        hideProgressDialog();
        listBeans = weixin.getResult().getList();
        adapter.addData(listBeans);
    }
}
