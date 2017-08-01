package samwoo.petmall.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.adapter.shop.PinTuanAdapter;
import samwoo.petmall.adapter.shop.ShopAdapter;
import samwoo.petmall.model.shop.PinTuanModel;
import samwoo.petmall.model.shop.ShopModel;
import samwoo.petmall.view.activity.ShopClassifyActivity;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ShopFragment extends BaseFragment {
    @BindView(R.id.shop_main)
    ListView mShopMain;
    private List<View> mViewList;
    private ViewPager mBanner;
    private ImageView mIndic1;
    private ImageView mIndic2;
    private ImageView mIndic3;
    private ImageView mIndic4;
    private ImageView mIndic5;

    private boolean isRun = false;
    private List<ShopModel> mShopList;

    private int[] images =
            {
                    R.drawable.banner_shop1,
                    R.drawable.banner_shop2,
                    R.drawable.banner_shop3,
                    R.drawable.banner_shop4,
                    R.drawable.banner_shop5
            };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            resetDic();
            switch (msg.what % images.length) {
                case 0:
                    mBanner.setCurrentItem(0);
                    mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 1:
                    mBanner.setCurrentItem(1);
                    mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 2:
                    mBanner.setCurrentItem(2);
                    mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 3:
                    mBanner.setCurrentItem(3);
                    mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                case 4:
                    mBanner.setCurrentItem(4);
                    mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    break;
                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_shopping, null);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        initHead();
        mShopList = new ArrayList<>();
        mShopList.add(new ShopModel("主粮零食", R.drawable.shop_parent1, new int[]{R.drawable.shop_child1, R.drawable.shop_child2, R.drawable.shop_child3, R.drawable.shop_child4,
                R.drawable.shop_child5, R.drawable.shop_child6, R.drawable.shop_child7, R.drawable.shop_child8, R.drawable.shop_child9}));

        mShopList.add(new ShopModel("医疗保健", R.drawable.shop_parent2, new int[]{R.drawable.shop_child10, R.drawable.shop_child11, 0, R.drawable.shop_child12, R.drawable.shop_child13, 0,
                R.drawable.shop_child14, 0, R.drawable.shop_child15}));

        mShopList.add(new ShopModel("玩具用品", R.drawable.shop_parent3, new int[]{R.drawable.shop_child16, R.drawable.shop_child17, R.drawable.shop_child18, R.drawable.shop_child19,
                R.drawable.shop_child20, R.drawable.shop_child21, R.drawable.shop_child22, R.drawable.shop_child23, R.drawable.shop_child24}));

        mShopMain.setAdapter(new ShopAdapter(getActivity(), mShopList));

        initFooter();

    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {

    }

    /**
     * 初始化顶部View
     */
    public void initHead() {
        List<PinTuanModel> mList = new ArrayList<>();
        mList.add(new PinTuanModel(R.drawable.pintuan_one, "【天然健康膳\n食狗粮，提升...", 39.9, 99));
        mList.add(new PinTuanModel(R.drawable.pintuan_two, "【适合搭配\n各类猫砂使用...", 29, 62));
        mList.add(new PinTuanModel(R.drawable.pintuan_three, "【温和配方,\n消炎止痒，抗...", 25, 40));
        mList.add(new PinTuanModel(R.drawable.pintuan_four, "【精致牛肉肉\n粒，美味有营...", 9.9, 35));
        mList.add(new PinTuanModel(R.drawable.pintuan_five, "【营养护理系\n列零食，美毛...", 19.9, 39));
        mList.add(new PinTuanModel(R.drawable.pintuan_six, "【买即送罐\n头】贵族鸸鹋...", 59, 125));
        mList.add(new PinTuanModel(R.drawable.pintuan_seven, "派地奥 盒装乳\n胶犬用玩具 宠...", 15.9, 35));
        mList.add(new PinTuanModel(R.drawable.pintuan_eight, "【满99送大礼\n包】 大宠爱 体...", 219, 438));
        mList.add(new PinTuanModel(R.drawable.pintuan_nine, "柏可心 猫薄荷\n猫零食 天然4...", 6.9, 19));

        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_shopping, null);

        RecyclerView mHeaderMain = header.findViewById(R.id.header_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mHeaderMain.setLayoutManager(manager);
        mHeaderMain.setNestedScrollingEnabled(false);
        mHeaderMain.setAdapter(new PinTuanAdapter(getActivity(), mList));

        mBanner = header.findViewById(R.id.header_banner);
        mIndic1 = header.findViewById(R.id.indic1);
        mIndic2 = header.findViewById(R.id.indic2);
        mIndic3 = header.findViewById(R.id.indic3);
        mIndic4 = header.findViewById(R.id.indic4);
        mIndic5 = header.findViewById(R.id.indic5);

        mViewList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            Glide.with(getActivity()).load(images[i]).centerCrop().into(imageView);
            mViewList.add(imageView);
        }

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
                        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 1:
                        mBanner.setCurrentItem(1);
                        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 2:
                        mBanner.setCurrentItem(2);
                        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 3:
                        mBanner.setCurrentItem(3);
                        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 4:
                        mBanner.setCurrentItem(4);
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

        mShopMain.addHeaderView(header);
        isRun = true;
        startBanner();
    }

    private void initFooter() {
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.item_shopping_footer, null);
        mShopMain.addFooterView(footer);
    }

    /**
     * 开启线程轮播广告
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

    private void resetDic() {
        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
    }

    private class BannerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mViewList == null ? 0 : mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @OnClick({R.id.shop_type, R.id.shop_xiaoer})
    public void onClickedView(View view) {
        switch (view.getId()) {
            case R.id.shop_type:
                startActivity(new Intent(getActivity(), ShopClassifyActivity.class));
                break;
            default:
                break;
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
