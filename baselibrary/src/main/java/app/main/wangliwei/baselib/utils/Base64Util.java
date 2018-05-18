package app.main.wangliwei.baselib.utils;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wlw on 2018/4/2.
 */

public final class Base64Util {
    public static Observable<String> bitmapBase64Encode(final Bitmap bmp) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                String base64 = null;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] bytes = byteArrayOutputStream.toByteArray();
                base64 = Base64.encodeToString(bytes,Base64.NO_WRAP);
                emitter.onNext(base64);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 文件转Base64
     *
     * @param path
     * @return
     */
    public static Observable<String> FileBase64Encode(final String path) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                File file = new File(path);
                FileInputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                inputStream.read(bytes);
                inputStream.close();
                emitter.onNext(Base64.encodeToString(bytes,Base64.NO_WRAP));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
