package app.main.levi.fiend.app;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by wlw on 2018/6/8.
 */

public class BuglyApplication extends TinkerApplication {
    public BuglyApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "app.main.levi.fiend.app.FiendApp",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
