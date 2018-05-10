package app.main.wangliwei.baselib.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.main.wangliwei.baselib.R;

public class SimpleToast {

    public static void showShort(String message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void showLong(String message) {
        show(message, Toast.LENGTH_LONG);
    }

    public static void showShort(int id) {
        show(ViewUtil.getResourceString(id), Toast.LENGTH_SHORT);
    }

    public static void showLong(int id) {
        show(ViewUtil.getResourceString(id), Toast.LENGTH_LONG);
    }

    private static void show(String massage, int show_length) {
        Context context = BaseUtils.getApp();
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        //获取TextView
        TextView title = (TextView) view.findViewById(R.id.tv_toast_text);
        //设置显示的内容
        title.setText(massage);
        Toast toast = new Toast(context);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 0);
        //设置显示时间
        toast.setDuration(show_length);
        toast.setView(view);
        toast.show();
    }

}
