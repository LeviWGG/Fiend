package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import app.main.levi.fiend.R;
import app.main.levi.fiend.adapter.HomeTabAdpter;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;
import app.main.wangliwei.baselib.utils.ViewUtil;
import butterknife.BindView;

/**
 * Created by wangliwei on 2018/5/6.
 */

public class HomeFragment extends BaseMVPFragment {

    @BindView(R.id.layout_tab_home)
    SmartTabLayout smartTabLayout;
    @BindView(R.id.view_paper)
    ViewPager viewPager;

    private String[] mTabs = {ViewUtil.getResourceString(R.string.news),ViewUtil.getResourceString(R.string.wechat_new)};
    private BaseMVPFragment[] mFragments;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSwipeBackEnable(false);
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        mFragments = new BaseMVPFragment[2];
        mFragments[0] = new NewsFragment();
        mFragments[1] = new WechatNewsFragment();

        HomeTabAdpter homeTabAdpter = new HomeTabAdpter(getChildFragmentManager(),mFragments,mTabs);
        viewPager.setAdapter(homeTabAdpter);
        smartTabLayout.setViewPager(viewPager);
    }
}
