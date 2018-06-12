package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;
import app.main.wangliwei.baselib.utils.SimpleToast;
import app.main.wangliwei.baselib.utils.ViewUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wangliwei on 2018/5/6.
 */

public class MainFragment extends BaseMVPFragment {

    @BindView(R.id.tab_home)
    LinearLayout tabHome;
    @BindView(R.id.tab_follow)
    LinearLayout tabFollow;
    @BindView(R.id.tab_mine)
    LinearLayout tabMine;
    @BindView(R.id.image_home)
    ImageView imageHome;
    @BindView(R.id.image_follow)
    ImageView imageFollow;
    @BindView(R.id.image_mine)
    ImageView imageMine;
    @BindView(R.id.text_home)
    TextView textHome;
    @BindView(R.id.text_follow)
    TextView textFollow;
    @BindView(R.id.text_mine)
    TextView textMine;

    private boolean isExit = false;

    public static final int HOME = 0;
    public static final int FOLLOW = 1;
    public static final int MINE = 2;

    private BaseMVPFragment[] fragments = new BaseMVPFragment[3];
    private int selected = HOME;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSwipeBackEnable(false);
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        fragments = new BaseMVPFragment[3];
        fragments[0] = new HomeFragment();
        fragments[1] = new FollowFragment();
        fragments[2] = new MineFragment();

        loadMultipleRootFragment(R.id.fragment_content,0,fragments);
    }

    @OnClick({R.id.tab_home,R.id.tab_follow,R.id.tab_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_home :
                if(HOME == selected) {return;}
                imageHome.setImageResource(R.drawable.home_press);
                textHome.setTextColor(ViewUtil.getResourceColor(R.color.Color_ff4040));
                showHideFragment(fragments[HOME],fragments[selected]);
                selected = HOME;
                setTabNormal();
                break;
            case R.id.tab_follow :
                if(FOLLOW == selected) {return;}
                imageFollow.setImageResource(R.drawable.follow_press);
                textFollow.setTextColor(ViewUtil.getResourceColor(R.color.Color_ff4040));
                showHideFragment(fragments[FOLLOW],fragments[selected]);
                selected = FOLLOW;
                setTabNormal();
                break;
            case R.id.tab_mine :
                if(MINE == selected) {return;}
                imageMine.setImageResource(R.drawable.mine_press);
                textMine.setTextColor(ViewUtil.getResourceColor(R.color.Color_ff4040));
                showHideFragment(fragments[MINE],fragments[selected]);
                selected = MINE;
                setTabNormal();
                break;
            default:
        }
    }

    private void setTabNormal() {
        if(HOME != selected) {
            imageHome.setImageResource(R.drawable.home);
            textHome.setTextColor(ViewUtil.getResourceColor(R.color.Color_2c2c2c));
        }
        if(FOLLOW != selected) {
            imageFollow.setImageResource(R.drawable.follow);
            textFollow.setTextColor(ViewUtil.getResourceColor(R.color.Color_2c2c2c));
        }
        if(MINE != selected) {
            imageMine.setImageResource(R.drawable.mine);
            textMine.setTextColor(ViewUtil.getResourceColor(R.color.Color_2c2c2c));
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        if(isExit) {
            _mActivity.finish();
        }else {
            SimpleToast.showShort("再按一次退出应用");
            isExit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit = false;
                }
            },1500);
        }
        return true;
    }
}
