package app.main.levi.fiend.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import app.main.levi.fiend.R;
import app.main.levi.fiend.bean.Weixin;
import app.main.wangliwei.baselib.utils.GlideApp;

/**
 * Created by wangliwei on 2018/5/16.
 */

public class WechatNewsAdapter extends BaseQuickAdapter<Weixin.ResultBean.ListBean,BaseViewHolder> {

    public WechatNewsAdapter() {
        super(R.layout.item_wechat_news, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Weixin.ResultBean.ListBean item) {
        GlideApp.with(mContext).load(item.getFirstImg()).into((ImageView) helper.getView(R.id.view_picture));
        helper.setText(R.id.text_title,item.getTitle())
                .setText(R.id.text_source,item.getSource())
                .addOnClickListener(R.id.layout_item);
    }
}
