package samwoo.petmall.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import samwoo.petmall.model.news.GeekEntity;

/**
 * Created by Administrator on 2017/7/26.
 */

public interface GeekService {
    @GET("1")
    Call<GeekEntity> getInformaition();
}
