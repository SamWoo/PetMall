package samwoo.petmall.view.child;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import samwoo.petmall.R;
import samwoo.petmall.adapter.news.NewsAdapter;
import samwoo.petmall.adapter.news.NewsChildAdapter;
import samwoo.petmall.api.ApiManager;
import samwoo.petmall.config.Config;
import samwoo.petmall.model.news.NewsChildModel;
import samwoo.petmall.model.news.NewsEntity;
import samwoo.petmall.utils.RequsetDataUtil;
import samwoo.petmall.view.activity.WebActivity;
import samwoo.petmall.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/7/24.
 */

public class RecommendFragment extends BaseFragment {
    @BindView(R.id.tuijian_main)
    ListView mRecMain;
    private ViewPager banner;
    private ImageView mIndic1;
    private ImageView mIndic2;
    private ImageView mIndic3;
    private ImageView mIndic4;
    private ImageView mIndic5;
    private List<View> mList;
    private List<NewsChildModel> mRecList;
    private List<NewsEntity.ListBean> mNewsList;

    private boolean isRun = false;

    private int[] images =//banner图片
            {
                    R.drawable.banner_tuijian1,
                    R.drawable.banner_tuijian2,
                    R.drawable.banner_tuijian3,
                    R.drawable.banner_tuijian4,
                    R.drawable.banner_tuijian5
            };
    private String[] titles =
            {
                    "有宠福利购第八期来了，这次是个大手笔",
                    "世界献血日，宠物用血为何这么难",
                    "有宠福布斯：探秘名画中的狗，哪些狗是画家...",
                    "宠事儿：宅男网红养成记",
                    "名撕其实：你走过狗屎运吗？"
            };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            restDic();
            switch (msg.what % images.length) {
                case 0:
                    banner.setCurrentItem(0);
                    mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 1:
                    banner.setCurrentItem(1);
                    mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 2:
                    banner.setCurrentItem(2);
                    mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 3:
                    banner.setCurrentItem(3);
                    mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 4:
                    banner.setCurrentItem(4);
                    mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommend, container, false);
        init(view);
//        loadingDatas();
        showEduNews();
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);

    }

    @Override
    public void destoryData() {

    }

    public void showEduNews() {
        mNewsList = new ArrayList<>();
        new RequsetDataUtil().getNews(Config.NEWS_EDU, new Callback<NewsEntity>() {
            @Override
            public void onResponse(Call<NewsEntity> call, Response<NewsEntity> response) {
                mNewsList.clear();
                mNewsList.addAll(response.body().getList());
                Log.e("Sam","List$$$$$$$$$++++===="+response.body().getList());
                NewsAdapter adapter = new NewsAdapter(getActivity(), mNewsList);
                adapter.notifyDataSetChanged();
                mRecMain.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsEntity> call, Throwable t) {

            }
        });

        mRecMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String urlPath = mNewsList.get(i).getDocurl();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url", urlPath);
                startActivity(intent);
            }
        });
    }

    @Override
    public void loadingDatas() {
        mRecList = new ArrayList<>();
        mRecList.add(new NewsChildModel("世界献血日，宠物用血为何这么难", true, true, "刀斥", 22000, R.drawable.tuijian1));
        mRecList.add(new NewsChildModel("牧羊犬眼部问题", false, false, "娜酷子", 1199, R.drawable.tuijian2));
        mRecList.add(new NewsChildModel("夜里鬼哭狼嚎的猫，可不止发情这么简单", false, false, "哦四姑", 2298, R.drawable.tuijian3));
        mRecList.add(new NewsChildModel("三款“板凳”狗，挑选你中意的腊肠犬", false, false, "娜酷子", 1839, R.drawable.tuijian4));
        mRecList.add(new NewsChildModel("有宠探访实录父亲节特辑：揭秘“种公犬”背后的故事", true, false, "阿汤", 7599, R.drawable.tuijian5));
        mRecList.add(new NewsChildModel("有宠三句半：东航又一金毛在托运中惨死", false, false, "阿汤", 32000, R.drawable.tuijian6));
        mRecList.add(new NewsChildModel("猫咪下巴变黑怎么办？", false, false, "娜酷子", 9678, R.drawable.tuijian7));
        mRecList.add(new NewsChildModel("猫形积木，吸猫新方式", false, false, "蒂娜", 11000, R.drawable.tuijian8));
        mRecList.add(new NewsChildModel("喵星人打哈欠只是因为困了吗？", false, false, "娜酷子", 9119, R.drawable.tuijian9));
        mRecList.add(new NewsChildModel("犬激光治疗，缓解炎症和疼痛的首选", false, false, "哦四姑", 3259, R.drawable.tuijian10));
        mRecList.add(new NewsChildModel("到底是什么引起的呕吐呢？", false, false, "来份豆沙包", 13000, R.drawable.tuijian11));
        mRecList.add(new NewsChildModel("动物咖啡馆再添新成员，猫头鹰味的可以“尝尝”", false, false, "小灰灰", 5959, R.drawable.tuijian12));
        mRecList.add(new NewsChildModel("这个世界能不能对我好一点？别让我这么尴尬？", false, false, "云宁", 7879, R.drawable.tuijian13));
        mRecList.add(new NewsChildModel("挺可爱的小金毛，却长了一张忧国忧民的脸......", false, false, "苗仔", 16000, R.drawable.tuijian14));
        mRecList.add(new NewsChildModel("自从隔壁开了炸鸡店 哈士奇有了很大的转变", false, false, "苗仔", 18000, R.drawable.tuijian15));
        mRecList.add(new NewsChildModel("印度女用乳房喂牛吃奶 非洲小孩在全身；涂抹粪便", false, false, "蒂娜", 12000, R.drawable.tuijian16));
        mRecList.add(new NewsChildModel("来京旅游的亲戚趁主人不在把老猫扔了", false, false, "云宁", 12000, R.drawable.tuijian17));
        mRecList.add(new NewsChildModel("托运之痛：回家的旅程，竟是一场血淋林的惊魂记", true, true, "欢喜", 87000, R.drawable.tuijian18));

        NewsChildAdapter mAdapter = new NewsChildAdapter(getActivity(), mRecList);
        mRecMain.setAdapter(mAdapter);

        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_msg_tuijian, null);
        mRecMain.addHeaderView(header);
        banner = header.findViewById(R.id.banner_ViewPager);
        mIndic1 = header.findViewById(R.id.indic1);
        mIndic2 = header.findViewById(R.id.indic2);
        mIndic3 = header.findViewById(R.id.indic3);
        mIndic4 = header.findViewById(R.id.indic4);
        mIndic5 = header.findViewById(R.id.indic5);

        //加载Banner轮播数据
        mList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_msg_tuijian_banner, null);
            ImageView imageView = view.findViewById(R.id.banner_image);
            TextView title = view.findViewById(R.id.banner_titles);
            Glide.with(getActivity()).load(images[i]).centerCrop().into(imageView);
            title.setText(titles[i]);
            mList.add(view);
        }

        BannerAdapter adapter = new BannerAdapter();
        banner.setAdapter(adapter);
        banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                restDic();
                switch (position) {
                    case 0:
                        banner.setCurrentItem(0);
                        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 1:
                        banner.setCurrentItem(1);
                        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 2:
                        banner.setCurrentItem(2);
                        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 3:
                        banner.setCurrentItem(3);
                        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 4:
                        banner.setCurrentItem(4);
                        mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        isRun = true;
        startBanner();

    }

    /**
     * 开启一个线程执行Banner自动轮播
     */
    private void startBanner() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int position = 0;
                while (isRun) {
                    handler.sendEmptyMessage(position++);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 重置指示器
     */
    private void restDic() {
        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
    }

    /**
     * Banner轮播适配器
     */
    private class BannerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isRun = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRun = false;
    }
}
