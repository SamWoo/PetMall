package samwoo.petmall.view.child;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import samwoo.petmall.R;
import samwoo.petmall.adapter.news.GeekAdapter;
import samwoo.petmall.adapter.news.NewsAdapter;
import samwoo.petmall.adapter.news.NewsChildAdapter;
import samwoo.petmall.config.Config;
import samwoo.petmall.model.news.GeekEntity;
import samwoo.petmall.model.news.NewsChildModel;
import samwoo.petmall.model.news.NewsEntity;
import samwoo.petmall.utils.NetworkUtil;
import samwoo.petmall.utils.RequsetDataUtil;
import samwoo.petmall.view.activity.WebActivity;
import samwoo.petmall.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/7/24.
 */

public class HeadlineFragment extends BaseFragment {
    @BindView(R.id.yaowen_list)
    ListView mHeadline;
    private List<NewsChildModel> mList;
    private List<GeekEntity.ResultsBean> list;
    private List<NewsEntity.ListBean> mNewsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_headline, null);
        init(view);
        if (NetworkUtil.isConnected(getActivity()) && NetworkUtil.isAvailable(getActivity())) {
//        showGeekNews();
            showTechNews();
        } else {
            loadingDatas();
        }
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
    }

    /**
     * 测试Retrofit功能
     */
    private void showGeekNews() {
        list = new ArrayList<>();
        new RequsetDataUtil().getInformation(Config.GEEK_CATEGROY_ANDROID, new Callback<GeekEntity>() {
            @Override
            public void onResponse(Call<GeekEntity> call, Response<GeekEntity> response) {
                list.clear();
                list.addAll(response.body().getResults());
                GeekAdapter adapter1 = new GeekAdapter(getActivity(), list);
                mHeadline.setAdapter(adapter1);
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GeekEntity> call, Throwable t) {

            }
        });

        mHeadline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String urlPath = list.get(i).getUrl();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url", urlPath);
                startActivity(intent);
            }
        });
    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {
        mList = new ArrayList<>();
        mList.add(new NewsChildModel("又当爹又当妈的动物奶爸，怎么这么迷人", false, false, "蒂娜", 4191, R.drawable.yaowen1));
        mList.add(new NewsChildModel("金毛每天早上叼着钱为主人买早餐", false, false, "苗仔", 5178, R.drawable.yaowen2));
        mList.add(new NewsChildModel("又来一个情敌，真烦！它有我好看吗？！", false, false, "云宁", 4679, R.drawable.yaowen3));
        mList.add(new NewsChildModel("大金毛与奶奶相依为伴，成为田间最靓丽的风景线", false, false, "金毛总动员", 8209, R.drawable.yaowen4));
        mList.add(new NewsChildModel("这只狗狗拥有独特的表情 大家看见它都会非常高兴", false, false, "苗仔", 5038, R.drawable.yaowen5));
        mList.add(new NewsChildModel("前途无量的警犬，却偏偏走了另一种狗生", false, false, "小灰灰", 4238, R.drawable.yaowen6));
        mList.add(new NewsChildModel("法斗犬秒变贴心小棉袄 为睡觉中的主人盖被子", false, false, "苗仔", 14000, R.drawable.yaowen7));
        mList.add(new NewsChildModel("主人离家一年 再次回来后狗狗的举动像个个孩子", false, false, "苗仔", 6939, R.drawable.yaowen8));
        mList.add(new NewsChildModel("主人患病期间金毛离家出走，家人找回后反而更加疼爱", false, false, "金毛总动员", 8579, R.drawable.yaowen9));
        mList.add(new NewsChildModel("世界上竟然还有长相这么怪异的稀有动物！", false, false, "蒂娜", 5039, R.drawable.yaowen10));

        NewsChildAdapter adapter = new NewsChildAdapter(getActivity(), mList);
        mHeadline.setAdapter(adapter);
    }

    public void showTechNews() {
        mNewsList = new ArrayList<>();
        new RequsetDataUtil().getNews(Config.NEWS_TECH, new Callback<NewsEntity>() {
            @Override
            public void onResponse(Call<NewsEntity> call, Response<NewsEntity> response) {
                mNewsList.clear();
                mNewsList.addAll(response.body().getList());
                NewsAdapter adapter = new NewsAdapter(getActivity(), mNewsList);
                adapter.notifyDataSetChanged();
                mHeadline.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsEntity> call, Throwable t) {

            }
        });

        mHeadline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String urlPath = mNewsList.get(i).getDocurl();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url", urlPath);
                startActivity(intent);
            }
        });
    }
}
