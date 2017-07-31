package samwoo.petmall.view.child;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import samwoo.petmall.R;
import samwoo.petmall.adapter.news.GeekGirlsAdapter;
import samwoo.petmall.adapter.news.MagazineAdapter;
import samwoo.petmall.config.Config;
import samwoo.petmall.model.news.GeekEntity;
import samwoo.petmall.model.news.MagazineModel;
import samwoo.petmall.utils.NetworkUtil;
import samwoo.petmall.utils.RequsetDataUtil;
import samwoo.petmall.view.activity.ShowGirlsActicity;
import samwoo.petmall.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/7/24.
 */

public class MagazineFragment extends BaseFragment {
    private Unbinder unbinder;
    @BindView(R.id.zhazi_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.zazhi_viewPager)
    ViewPager mBanner;
    @BindView(R.id.inidc1)
    ImageView mInidc1;
    @BindView(R.id.inidc2)
    ImageView mInidc2;
    @BindView(R.id.inidc3)
    ImageView mInidc3;
    @BindView(R.id.inidc4)
    ImageView mInidc4;
    @BindView(R.id.inidc5)
    ImageView mInidc5;
    @BindView(R.id.titles)
    TextView mTitles;

    private List<View> mList;
    private List<MagazineModel> magazineModelList;
    private boolean isRun = false;
    private List<GeekEntity.ResultsBean> mGeekList;

    private int[] images =
            {
                    R.drawable.banner_zazhi1,
                    R.drawable.banner_zazhi2,
                    R.drawable.banner_zazhi3,
                    R.drawable.banner_zazhi4,
                    R.drawable.banner_zazhi5
            };
    private String[] titles =
            {
                    "封面故事--《家·猫·果实》",
                    "专题巨献--《帝苑猫说》",
                    "封面故事--《戏痞士与惊魂鸟》",
                    "活着--《生存游戏》",
                    "专题巨献--《猎场》"
            };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            resetDic();
            switch (msg.what % images.length) {
                case 0:
                    mBanner.setCurrentItem(0);
                    mInidc1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 1:
                    mBanner.setCurrentItem(1);
                    mInidc2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 2:
                    mBanner.setCurrentItem(2);
                    mInidc3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 3:
                    mBanner.setCurrentItem(3);
                    mInidc4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 4:
                    mBanner.setCurrentItem(4);
                    mInidc5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_magazine, null);
        init(view);
        if (NetworkUtil.isConnected(getActivity()) && NetworkUtil.isAvailable(getActivity())) {
            showGirls();
        } else {
            showMagazine();
        }
        loadingDatas();
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void destoryData() {
        unbinder.unbind();
        System.gc();
    }

    public void showMagazine() {
        magazineModelList = new ArrayList<>();
        magazineModelList.add(new MagazineModel(R.drawable.zazhi1, "第12期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi2, "第11期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi3, "第10期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi4, "第9期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi5, "第8期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi6, "第7期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi7, "第6期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi8, "第5期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi9, "第4期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi10, "第3期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi11, "第2期", "May.2017"));
        magazineModelList.add(new MagazineModel(R.drawable.zazhi12, "第1期", "May.2017"));
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setNestedScrollingEnabled(false);
        mRecycler.setLayoutManager(manager);
        MagazineAdapter adapter = new MagazineAdapter(getActivity(), magazineModelList);
        mRecycler.setAdapter(adapter);
    }

    public void showGirls() {
        mGeekList = new ArrayList<GeekEntity.ResultsBean>();
        new RequsetDataUtil().getInformation(Config.GEEK_CATEGROY_FULI, new Callback<GeekEntity>() {
            @Override
            public void onResponse(Call<GeekEntity> call, Response<GeekEntity> response) {
                if (response.isSuccessful()) {
                    mGeekList.clear();
                    mGeekList.addAll(response.body().getResults());
                    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                    mRecycler.setNestedScrollingEnabled(false);
                    mRecycler.setLayoutManager(manager);
                    GeekGirlsAdapter adapter = new GeekGirlsAdapter(getActivity(), mGeekList);
                    mRecycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    adapter.setOnItemClickListener(new GeekGirlsAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            String imageUrl = mGeekList.get(position).getUrl();
                            Intent intent = new Intent(getActivity(), ShowGirlsActicity.class);
                            intent.putExtra("imageUrl", imageUrl);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<GeekEntity> call, Throwable t) {
                Toast.makeText(getContext(), "获取资源失败!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void loadingDatas() {
        mList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.header_msg_zazhi, null);
            ImageView imageView = view.findViewById(R.id.item_images);
            Glide.with(getActivity()).load(images[i]).centerCrop().into(imageView);
            TextView textView = view.findViewById(R.id.item_titles);
            textView.setText(titles[i]);
            mList.add(view);
        }
        mBanner.setOffscreenPageLimit(1);
        mBanner.setAdapter(new BannerAdapter());
        mBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetDic();
                switch (position) {
                    case 0:
                        mBanner.setCurrentItem(0);
                        mInidc1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 1:
                        mBanner.setCurrentItem(1);
                        mInidc2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 2:
                        mBanner.setCurrentItem(2);
                        mInidc3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 3:
                        mBanner.setCurrentItem(3);
                        mInidc4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 4:
                        mBanner.setCurrentItem(4);
                        mInidc5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
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

    private void resetDic() {
        mInidc1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
    }

    private class BannerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isRun = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        isRun = true;
    }
}
