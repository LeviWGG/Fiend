package app.main.levi.fiend.contract;

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
    }

    @Override
    public void getNesInfo() {

    }

    @Override
    public void getMoreNewsInfo() {

    }

    @Override
    public void onStart() {

    }
}
