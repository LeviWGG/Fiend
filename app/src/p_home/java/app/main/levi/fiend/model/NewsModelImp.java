package app.main.levi.fiend.model;

import app.main.levi.fiend.bean.NewsInfo;
import app.main.levi.fiend.contract.INewsContract;
import app.main.levi.fiend.http.NewsService;
import app.main.levi.fiend.http.ServiceFactory;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by wlw on 2018/5/25.
 */

public class NewsModelImp implements INewsContract.INewsModel {

    private final static String BASE_URL = "http://c.m.163.com/";
    private int page = 10;

    private Retrofit retrofit;
    private NewsService newsService;

    public NewsModelImp() {
        retrofit = new ServiceFactory().create(BASE_URL);
        newsService = retrofit.create(NewsService.class);
    }

    @Override
    public Observable<NewsInfo> getNewsInfo() {
        page = 10;
        return newsService.getNewsInfo(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterNext(new Consumer<NewsInfo>() {
                    @Override
                    public void accept(NewsInfo newsInfo) throws Exception {
                        page += 10;
                    }
                });
    }

    @Override
    public Observable<NewsInfo> getMoreNewsInfo() {
        return newsService.getNewsInfo(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterNext(new Consumer<NewsInfo>() {
                    @Override
                    public void accept(NewsInfo newsInfo) throws Exception {
                        page += 10;
                    }
                });
    }
}
