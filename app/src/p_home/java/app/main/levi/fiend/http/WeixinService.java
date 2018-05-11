package app.main.levi.fiend.http;


import app.main.levi.fiend.bean.Weixin;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeixinService {
    @GET("weixin/query")
    Observable<Weixin> getWeixinNews(@Query("pno") int pno,
                                     @Query("ps") int ps,
                                     @Query("dtype") String dtype,
                                     @Query("key") String key);
}
