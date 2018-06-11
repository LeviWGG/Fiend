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
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.List;

import app.main.levi.fiend.R;
import app.main.levi.fiend.bean.NewsInfo;
import app.main.levi.fiend.contract.INewsContract;
import app.main.levi.fiend.contract.NewsPresenterImp;
import app.main.levi.fiend.ui.adapter.NewsAdapter;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.utils.SimpleToast;
import butterknife.BindView;

/**
 * Created by wlw on 2018/5/9.
 */

public class NewsFragment extends BaseMVPFragment<INewsContract.INewsPresenter>
        implements INewsContract.INewsView {

    @BindView(R.id.recycler_only)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefreshLayout;

    private NewsAdapter newsAdapter;
    private List<NewsInfo.T1348647909107Bean> list;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSwipeBackEnable(false);
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));

        newsAdapter = new NewsAdapter();
        newsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (list.get(position).getUrl().isEmpty()) {return;}
                Log.d("item","url: "+list.get(position).getUrl());
                Bundle bundle = new Bundle();
                bundle.putString("URL",list.get(position).getUrl());
                Intent intent = new Intent(getActivity(),WebDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent,bundle);
            }
        });
        recyclerView.setAdapter(newsAdapter);

        ((HomeFragment)getParentFragment()).setOnRefreshListener(new HomeFragment.OnRefreshListener() {
            @Override
            public void refresh() {
                if (getUserVisibleHint()) {
                    smartRefreshLayout.autoRefresh();
                }
            }
        });

        smartRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getMoreNewsInfo();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getNesInfo();
            }
        });
        smartRefreshLayout.autoRefresh();
    }

    @Override
    public INewsContract.INewsPresenter initPresenter() {
        return new NewsPresenterImp(this);
    }

    @Override
    public void onSuccess(NewsInfo newsInfo) {
        if (null  == newsInfo.getT1348647909107() || newsInfo.getT1348647909107().isEmpty()) {
            SimpleToast.showShort("没有更多了");
            return;
        }
        list = newsInfo.getT1348647909107();
        newsAdapter.setNewData(list);
        smartRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadMore(NewsInfo newsInfo) {
        if (null == newsInfo.getT1348647909107() || newsInfo.getT1348647909107().isEmpty()) {
            SimpleToast.showShort("没有更多了");
            return;
        }
        list.addAll(newsInfo.getT1348647909107());
        newsAdapter.addData(newsInfo.getT1348647909107());
        smartRefreshLayout.finishLoadmore();
    }
}
