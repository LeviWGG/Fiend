package app.main.levi.fiend.model;

import app.main.levi.fiend.bean.NewsInfo;
import app.main.levi.fiend.contract.INewsContract;
import io.reactivex.Observable;

/**
 * Created by wlw on 2018/5/25.
 */

public class NewsModelImp implements INewsContract.INewsModel {
    @Override
    public Observable<NewsInfo> getNewsInfo() {
        return null;
    }

    @Override
    public Observable<NewsInfo> getMoreNewsInfo() {
        return null;
    }
}
