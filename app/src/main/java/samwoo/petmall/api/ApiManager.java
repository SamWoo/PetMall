package samwoo.petmall.api;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import samwoo.petmall.config.Config;

/**
 * Created by Administrator on 2017/7/26.
 */

public class ApiManager {
    private static ApiManager ourInstance;
    private NewsService newsService;
    private GeekService geekService;

    public static ApiManager getInstance() {
        if (ourInstance == null) {
            synchronized (ApiManager.class) {
                if (ourInstance == null) {
                    ourInstance = new ApiManager();
                }
            }
        }
        return ourInstance;
    }

    private ApiManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> showRetrofitLog(message))
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request()
//                                .newBuilder()
//                                .addHeader("apikey", "2ffc3e48c7086e0e1faa003d781c0e69")
//                                .build();
//                        return chain.proceed(request);
//
//                    }
//                })
                .addInterceptor(loggingInterceptor)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(8, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Config.BaseNewsUrl)
                .build();
        newsService = retrofit.create(NewsService.class);

        Retrofit retrofit1 = new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(5, TimeUnit.SECONDS)
                        .build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BaseGeekUrl)
                .build();
        geekService = retrofit1.create(GeekService.class);
    }

    /**
     * 打印日志
     * 返回的是json，就打印格式化好了的json，不是json就原样打印
     *
     * @param message
     */
    private void showRetrofitLog(String message) {
        if (message.startsWith("{")) {
            Log.e("Sam:", message);
        } else {
            Log.e("Sam:", "Msg======="+message);
        }
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public GeekService getGeekService() {
        return geekService;
    }
}
