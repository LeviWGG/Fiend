package app.main.levi.fiend.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.orhanobut.hawk.Hawk;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import app.main.levi.fiend.BuildConfig;
import app.main.levi.fiend.R;
import app.main.wangliwei.baselib.utils.BaseUtils;
import me.yokeyword.fragmentation.Fragmentation;

/**
 * Created by wlw on 2018/5/7.
 */

public class FiendApp extends Application {

    private static Context context;

    //设置全局主题
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.Color_FFFFFF, R.color.Color_555E70);
                layout.setReboundDuration(150);
                return new ClassicsHeader(getFiendContext());
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.Color_FFFFFF, R.color.Color_555E70);
                layout.setReboundDuration(150);
                return new ClassicsFooter(getFiendContext());
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //key value存储器初始化
        Hawk.init(context).build();

        //BaseUtils 初始化
        BaseUtils.init(context);

        if (BuildConfig.FIEND_DEBUG) {
            // 栈视图等功能，建议在Application里初始化
            Fragmentation.builder()
                    // 显示悬浮球 ; 其他Mode:SHAKE: 摇一摇唤出   NONE：隐藏
                    .stackViewMode(Fragmentation.BUBBLE)
                    .debug(BuildConfig.FIEND_DEBUG)
                    .install();
        }
    }

    public static Context getFiendContext() {
        return context;
    }
}
