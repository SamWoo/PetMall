package samwoo.petmall.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import samwoo.petmall.model.news.GeekEntity;

/**
 * Created by Administrator on 2017/7/26.
 */

public interface GeekService {
    @GET("/api/data/{categroy}/40/1")
    Call<GeekEntity> getInformaition(@Path("categroy") String categroy);
}
