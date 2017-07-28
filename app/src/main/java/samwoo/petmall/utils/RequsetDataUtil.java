package samwoo.petmall.utils;


import retrofit2.Call;
import retrofit2.Callback;
import samwoo.petmall.api.ApiManager;
import samwoo.petmall.config.Config;
import samwoo.petmall.model.news.GeekEntity;
import samwoo.petmall.model.news.NewsEntity;

/**
 * Created by Administrator on 2017/7/26.
 */

public class RequsetDataUtil {

    public void getInformation(Callback<GeekEntity> callback) {

        Call<GeekEntity> call = ApiManager.getInstance().getGeekService().getInformaition();
        call.enqueue(callback);
    }

    public void getNews(String type, Callback<NewsEntity> callback) {
        Call<NewsEntity> call = ApiManager.getInstance().getNewsService().getNews(type, Config.NEWS_PAGE, Config.NEWS_LIMIT);
        call.enqueue(callback);
    }
}
