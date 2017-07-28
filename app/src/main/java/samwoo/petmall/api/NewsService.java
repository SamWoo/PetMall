package samwoo.petmall.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import samwoo.petmall.model.news.NewsEntity;

/**
 * Created by Administrator on 2017/7/26.
 */

public interface NewsService {
    @GET("/news/api")
    Call<NewsEntity> getNews(@Query("type") String type, @Query("page") int page, @Query("limit") int limit);
}
