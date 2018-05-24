package app.main.levi.fiend.contract;


import app.main.levi.fiend.bean.Weixin;
import app.main.wangliwei.baselib.base.BasePresenter;
import io.reactivex.Observable;

/**
 * Created by wangliwei on 2018/5/13.
 */

public interface IWechatContract {
    abstract class IWechatPresenter extends BasePresenter<IWechatModel,IWechatView> {

        /**
         * 在构造方法中赋值view
         *
         * @param view IView
         */
        public IWechatPresenter(IWechatView view) {
            super(view);
        }

        public abstract void getWechatNews();

        public abstract void getWechatMore();
    }

    interface IWechatView {
        void onSuccess(Weixin weixin);

        void onLoadMore(Weixin weixin);
     }

    interface IWechatModel {
        Observable<Weixin> getWechatNews();

        Observable<Weixin> getWechatMore();
    }
}
