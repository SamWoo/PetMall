package samwoo.petmall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.view.child.DTFragment;
import samwoo.petmall.view.child.JXFragment;
import samwoo.petmall.view.child.PDFragment;

/**
 * Created by Administrator on 2017/7/21.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.camera)
    ImageView mCamera;
    @BindView(R.id.dic_one)
    TextView mDicOne;
    @BindView(R.id.dic_two)
    TextView mDicTwo;
    @BindView(R.id.dic_three)
    TextView mDicThree;
    @BindView(R.id.home_main)
    ViewPager mHomeMain;

    private HomeAdapter homeAdapter;
    private JXFragment jxFragment = new JXFragment();
    private PDFragment pdFragment = new PDFragment();
    private DTFragment dtFragment = new DTFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }


    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        restBackground();
        homeAdapter = new HomeAdapter(getChildFragmentManager());
        mHomeMain.setOffscreenPageLimit(1);
        mHomeMain.setAdapter(homeAdapter);
        mHomeMain.setCurrentItem(0);
        mDicOne.setBackgroundResource(R.color.colorWhite);

        mHomeMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                restBackground();
                switch (position) {
                    case 0:
                        mHomeMain.setCurrentItem(0);
                        mDicOne.setBackgroundResource(R.color.colorWhite);
                        mCamera.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        mHomeMain.setCurrentItem(1);
                        mDicTwo.setBackgroundResource(R.color.colorWhite);
                        mCamera.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mHomeMain.setCurrentItem(2);
                        mDicThree.setBackgroundResource(R.color.colorWhite);
                        mCamera.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {

    }

    @OnClick({R.id.home_one, R.id.home_two, R.id.home_three})
    public void onClickedView(View view) {
        restBackground();
        switch (view.getId()) {
            case R.id.home_one:
                mDicOne.setBackgroundResource(R.color.colorWhite);
                mCamera.setVisibility(View.VISIBLE);
                mHomeMain.setCurrentItem(0);
                break;
            case R.id.home_two:
                mDicTwo.setBackgroundResource(R.color.colorWhite);
                mCamera.setVisibility(View.VISIBLE);
                mHomeMain.setCurrentItem(1);
                break;
            case R.id.home_three:
                mDicThree.setBackgroundResource(R.color.colorWhite);
                mCamera.setVisibility(View.GONE);
                mHomeMain.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    /**
     * 重置指示器颜色
     */
    private void restBackground() {
        mDicOne.setBackgroundResource(R.color.colorPet);
        mDicTwo.setBackgroundResource(R.color.colorPet);
        mDicThree.setBackgroundResource(R.color.colorPet);
    }

    private class HomeAdapter extends FragmentPagerAdapter {
        private List<Fragment> mList;

        public HomeAdapter(FragmentManager fm) {
            super(fm);
            mList = new ArrayList<>();
            mList.add(jxFragment);
            mList.add(dtFragment);
            mList.add(pdFragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }
    }
}
