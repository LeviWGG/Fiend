package app.main.levi.fiend.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import app.main.levi.fiend.R;
import app.main.levi.fiend.bean.NewsInfo;
import app.main.wangliwei.baselib.utils.GlideApp;

/**
 * Created by wlw on 2018/5/26.
 */

public class NewsAdapter extends BaseQuickAdapter<NewsInfo.T1348647909107Bean,BaseViewHolder> {
    public NewsAdapter() {
        super(R.layout.item_news_normal);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsInfo.T1348647909107Bean item) {
        helper.setText(R.id.text_title,item.getTitle())
                .setText(R.id.text_time,item.getLmodify().substring(0,10))
                .setText(R.id.text_source,item.getSource())
                .addOnClickListener(R.id.layout_item);
        GlideApp.with(mContext).load(item.getImgsrc()).into((ImageView) helper.getView(R.id.view_picture));
    }
}
