package samwoo.petmall.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.StatusBarUtils;
import samwoo.petmall.view.fragment.HomeFragment;
import samwoo.petmall.view.fragment.MineFragment;
import samwoo.petmall.view.fragment.NewsFragment;
import samwoo.petmall.view.fragment.ServiceFragment;
import samwoo.petmall.view.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_fragment)
    AutoFrameLayout mMainFragment;
    @BindView(R.id.img_home)
    ImageView mImgHome;
    @BindView(R.id.img_news)
    ImageView mImgNews;
    @BindView(R.id.img_shop)
    ImageView mImgShop;
    @BindView(R.id.img_service)
    ImageView mImgService;
    @BindView(R.id.img_mine)
    ImageView mImgMine;
    @BindView(R.id.tv_home)
    TextView mTvHome;
    @BindView(R.id.tv_news)
    TextView mTvNews;
    @BindView(R.id.tv_shop)
    TextView mTvShop;
    @BindView(R.id.tv_service)
    TextView mTvService;
    @BindView(R.id.tv_mine)
    TextView mTvMine;

    private FragmentManager fm;
    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private ShopFragment shopFragment;
    private ServiceFragment serviceFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        showFragment(0);
        mImgHome.setBackgroundResource(R.drawable.ic_show_press);
        mTvHome.setTextColor(getResources().getColor(R.color.colorPet));
    }

    /**
     * 设置点击监听
     *
     * @param view
     */
    @OnClick({R.id.parent_home, R.id.parent_news, R.id.parent_shop, R.id.parent_service, R.id.parent_mine})
    public void onClickedView(View view) {
        resetBackground();
        switch (view.getId()) {
            case R.id.parent_home:
                showFragment(0);
                mImgHome.setBackgroundResource(R.drawable.ic_show_press);
                mTvHome.setTextColor(getResources().getColor(R.color.colorPet));
                break;
            case R.id.parent_news:
                showFragment(1);
                mImgNews.setBackgroundResource(R.drawable.ic_news_press);
                mTvNews.setTextColor(getResources().getColor(R.color.colorPet));
                break;
            case R.id.parent_shop:
                showFragment(2);
                mImgShop.setBackgroundResource(R.drawable.ic_bottom_share_press);
                mTvShop.setTextColor(getResources().getColor(R.color.colorPet));
                break;
            case R.id.parent_service:
                showFragment(3);
                mImgService.setBackgroundResource(R.drawable.ic_service_press);
                mTvService.setTextColor(getResources().getColor(R.color.colorPet));
                break;
            case R.id.parent_mine:
                showFragment(4);
                mImgMine.setBackgroundResource(R.drawable.ic_me_press);
                mTvMine.setTextColor(getResources().getColor(R.color.colorPet));
                break;
            default:
                break;
        }
    }

    /**
     * 显示对应的Fragment界面
     *
     * @param position
     */
    private void showFragment(int position) {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (position) {
            case 0:
                if (null != homeFragment) {
                    ft.show(homeFragment);
                } else {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.main_fragment, homeFragment);
                }
                break;
            case 1:
                if (null != newsFragment) {
                    ft.show(newsFragment);
                } else {
                    newsFragment = new NewsFragment();
                    ft.add(R.id.main_fragment, newsFragment);
                }
                break;
            case 2:
                if (null != shopFragment) {
                    ft.show(shopFragment);
                } else {
                    shopFragment = new ShopFragment();
                    ft.add(R.id.main_fragment, shopFragment);
                }
                break;
            case 3:
                if (null != serviceFragment) {
                    ft.show(serviceFragment);
                } else {
                    serviceFragment = new ServiceFragment();
                    ft.add(R.id.main_fragment, serviceFragment);
                }
                break;
            case 4:
                if (null != mineFragment) {
                    ft.show(mineFragment);
                } else {
                    mineFragment = new MineFragment();
                    ft.add(R.id.main_fragment, mineFragment);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }

    /**
     * 隐藏其他Fragment界面
     *
     * @param ft
     */
    private void hideFragment(FragmentTransaction ft) {
        if (null != homeFragment) {
            ft.hide(homeFragment);
        }
        if (null != newsFragment) {
            ft.hide(newsFragment);
        }
        if (null != shopFragment) {
            ft.hide(shopFragment);

        }
        if (null != serviceFragment) {
            ft.hide(serviceFragment);
        }
        if (null != mineFragment) {
            ft.hide(mineFragment);
        }
    }

    /**
     * 重置各控件背景颜色
     */
    private void resetBackground() {
        mImgHome.setBackgroundResource(R.drawable.ic_show);
        mTvHome.setTextColor(getResources().getColor(R.color.color9));

        mImgNews.setBackgroundResource(R.drawable.ic_news);
        mTvNews.setTextColor(getResources().getColor(R.color.color9));

        mImgShop.setBackgroundResource(R.drawable.ic_bottom_share);
        mTvShop.setTextColor(getResources().getColor(R.color.color9));

        mImgService.setBackgroundResource(R.drawable.ic_service);
        mTvService.setTextColor(getResources().getColor(R.color.color9));

        mImgMine.setBackgroundResource(R.drawable.ic_me);
        mTvMine.setTextColor(getResources().getColor(R.color.color9));
    }
}
