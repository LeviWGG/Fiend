package app.main.levi.fiend.contract;

import app.main.levi.fiend.bean.Weixin;
import app.main.levi.fiend.model.WechatModelImp;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by wangliwei on 2018/5/13.
 */

public class WechatPresenterImp extends IWechatContract.IWechatPresenter {
    /**
     * 在构造方法中赋值view
     *
     * @param view IView
     */
    public WechatPresenterImp(IWechatContract.IWechatView view) {
        super(view);
        attachMV(new WechatModelImp(),mView);
    }

    @Override
    public void getWechatNews() {
        mModel.getWechatNews()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                    }
                })
                .subscribe(new Consumer<Weixin>() {
                    @Override
                    public void accept(Weixin weixin) throws Exception {
                        mView.onSuccess(weixin);
                    }
                });
    }

    @Override
    public void getWechatMore() {
        mModel.getWechatMore()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                    }
                })
                .subscribe(new Consumer<Weixin>() {
                    @Override
                    public void accept(Weixin weixin) throws Exception {
                        mView.onLoadMore(weixin);
                    }
                });
    }

    @Override
    public void onStart() {

    }
}
