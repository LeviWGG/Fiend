package app.main.levi.fiend.model;

import app.main.levi.fiend.bean.Weixin;
import app.main.levi.fiend.contract.IWechatContract;
import app.main.levi.fiend.http.ServiceFactory;
import app.main.levi.fiend.http.WeixinService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by wangliwei on 2018/5/13.
 */

public class WechatModelImp implements IWechatContract.IWechatModel{

    private final static String BASE_URL = "http://v.juhe.cn/";
    private final static String KEY = "d99d7aa8e1709c2f115553b7c3b075eb";

    private Retrofit retrofit;
    private WeixinService weixinService;
    private int page = 1;

    public WechatModelImp() {
        retrofit = new ServiceFactory().create(BASE_URL);
        weixinService = retrofit.create(WeixinService.class);
    }

    @Override
    public Observable<Weixin> getWechatNews() {
        return weixinService.getWeixinNews(page,10,"json",KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        page++;
                    }
                });
    }

    @Override
    public Observable<Weixin> getWechatMore() {
        page = 1;
        return weixinService.getWeixinNews(page,10,"json",KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        page++;
                    }
                });
    }
}
