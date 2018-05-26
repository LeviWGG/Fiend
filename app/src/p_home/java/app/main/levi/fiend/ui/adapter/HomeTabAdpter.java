package app.main.levi.fiend.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.main.wangliwei.baselib.base.BaseMVPFragment;

/**
 * Created by wlw on 2018/5/10.
 */

public class HomeTabAdpter extends FragmentPagerAdapter {

    private BaseMVPFragment[] mFragments;
    private String[] mTabs;

    public HomeTabAdpter(FragmentManager fm,BaseMVPFragment[] mFragments,String[] mTabs) {
        super(fm);
        this.mFragments = mFragments;
        this.mTabs = mTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if(null != mFragments) {
            return mFragments[position];
        }
        return null;
    }

    @Override
    public int getCount() {
        if(null != mFragments){
            return mFragments.length;
        }
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(null != mTabs) {
            return mTabs[position];
        }
        return "";
    }
}
