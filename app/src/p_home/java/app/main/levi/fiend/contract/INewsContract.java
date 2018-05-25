package app.main.levi.fiend.contract;

import app.main.levi.fiend.bean.NewsInfo;
import app.main.wangliwei.baselib.base.BasePresenter;
import io.reactivex.Observable;

/**
 * Created by wlw on 2018/5/25.
 */

public interface INewsContract {

    abstract class INewsPresenter extends BasePresenter<INewsModel,INewsView> {

        /**
         * 在构造方法中赋值view
         *
         * @param view IView
         */
        public INewsPresenter(INewsView view) {
            super(view);
        }

        public abstract void getNesInfo();

        public abstract void getMoreNewsInfo();
    }

    interface INewsView {
        void onSuccess(NewsInfo newsInfo);

        void onLoadMore(NewsInfo newsInfo);
    }

    interface INewsModel {
        Observable<NewsInfo> getNewsInfo();

        Observable<NewsInfo> getMoreNewsInfo();
    }
}
