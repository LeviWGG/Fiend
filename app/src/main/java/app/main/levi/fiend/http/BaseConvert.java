package app.main.levi.fiend.http;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by wlw on 2018/5/11.
 */

public class BaseConvert extends Converter.Factory{
    private Type mType;
    private Gson gson;

    private BaseConvert(Gson gson) {this.gson = gson;}

    public static Converter.Factory create() {

        return new BaseConvert(new GsonBuilder().registerTypeAdapter(Integer.class,new IntegerDefault0Adapter())
                .registerTypeAdapter(int.class,new IntegerDefault0Adapter())
                .registerTypeAdapter(Double.class,new DoubleDefaul0Adapter())
                .registerTypeAdapter(Long.class,new LongDefaul0Adapter()).create());
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new BaseResponseBodeConverter<>(gson, adapter);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new BaseRequestBodyConverter<>(gson, adapter);
    }
}
