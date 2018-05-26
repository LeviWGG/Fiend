package app.main.levi.fiend.contract;

import app.main.levi.fiend.bean.NewsInfo;
import app.main.levi.fiend.model.NewsModelImp;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by wlw on 2018/5/25.
 */

public class NewsPresenterImp extends INewsContract.INewsPresenter {
    /**
     * 在构造方法中赋值view
     *
     * @param view IView
     */
    public NewsPresenterImp(INewsContract.INewsView view) {
        super(view);
        attachMV(new NewsModelImp(),mView);
    }

    @Override
    public void getNesInfo() {
        mModel.getNewsInfo()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                    }
                })
                .subscribe(new Consumer<NewsInfo>() {
                    @Override
                    public void accept(NewsInfo newsInfo) throws Exception {
                        mView.onSuccess(newsInfo);
                    }
                });
    }

    @Override
    public void getMoreNewsInfo() {
        mModel.getMoreNewsInfo()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                    }
                })
                .subscribe(new Consumer<NewsInfo>() {
                    @Override
                    public void accept(NewsInfo newsInfo) throws Exception {
                        mView.onLoadMore(newsInfo);
                    }
                });
    }

    @Override
    public void onStart() {

    }
}
