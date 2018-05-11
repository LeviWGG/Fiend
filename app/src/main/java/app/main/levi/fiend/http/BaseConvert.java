package app.main.levi.fiend.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by wlw on 2018/5/11.
 */

public class BaseConvert {
    private Type mType;

    public static Gson create() {
        return new GsonBuilder().registerTypeAdapter(Integer.class,new IntegerDefault0Adapter())
                .registerTypeAdapter(int.class,new IntegerDefault0Adapter())
                .registerTypeAdapter(Double.class,new DoubleDefaul0Adapter())
                .registerTypeAdapter(Long.class,new LongDefaul0Adapter()).create();
    }
}
