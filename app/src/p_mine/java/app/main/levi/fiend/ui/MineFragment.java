package app.main.levi.fiend.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.tencent.bugly.beta.Beta;

import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;
import app.main.wangliwei.baselib.utils.PermissionUtils;
import app.main.wangliwei.baselib.utils.SimpleToast;
import app.main.wangliwei.baselib.utils.constant.PermissionConstants;
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

    @OnClick({R.id.image_back,R.id.layout_abort})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back :
                break;
            case R.id.layout_abort :
                PermissionUtils.permission(PermissionConstants.STORAGE).callback(new PermissionUtils.SimpleCallback() {
                    @Override
                    public void onGranted() {
                        Beta.applyTinkerPatch(_mActivity, Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
                    }

                    @Override
                    public void onDenied() {
                        SimpleToast.showShort("请打开存储权限");
                    }
                }).request();
                break;
            default:
        }
    }
}
