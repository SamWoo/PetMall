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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import samwoo.petmall.R;
import samwoo.petmall.view.child.AuthorityFragment;
import samwoo.petmall.view.child.CartoonFragment;
import samwoo.petmall.view.child.ChoicenessFragment;
import samwoo.petmall.view.child.HeadlineFragment;
import samwoo.petmall.view.child.MagazineFragment;
import samwoo.petmall.view.child.RecommendFragment;
import samwoo.petmall.view.child.SchoolFragment;

/**
 * Created by Administrator on 2017/7/21.
 */

public class NewsFragment extends BaseFragment {
    @BindView(R.id.msg_line1)
    TextView mLine1;
    @BindView(R.id.msg_line2)
    TextView mLine2;
    @BindView(R.id.msg_line3)
    TextView mLine3;
    @BindView(R.id.msg_line4)
    TextView mLine4;
    @BindView(R.id.msg_line5)
    TextView mLine5;
    @BindView(R.id.msg_line6)
    TextView mLine6;
    @BindView(R.id.msg_ViewPager)
    ViewPager mMsgViewPager;


    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news, container, false);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        restBackround();
        NewsAdapter newsAdapter = new NewsAdapter(getChildFragmentManager());
        mMsgViewPager.setAdapter(newsAdapter);
        mMsgViewPager.setOffscreenPageLimit(1);
        mMsgViewPager.setCurrentItem(0);
        mLine1.setBackgroundResource(R.color.colorWhite);

        mMsgViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                restBackround();
                switch (position) {
                    case 0:
                        mMsgViewPager.setCurrentItem(0);
                        mLine1.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 1:
                        mMsgViewPager.setCurrentItem(1);
                        mLine2.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 2:
                        mMsgViewPager.setCurrentItem(2);
                        mLine3.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 3:
                        mMsgViewPager.setCurrentItem(3);
                        mLine4.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 4:
                        mMsgViewPager.setCurrentItem(4);
                        mLine5.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 5:
                        mMsgViewPager.setCurrentItem(5);
                        mLine6.setBackgroundResource(R.color.colorWhite);
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

    /**
     * 点击事件监听
     *
     * @param view
     */
    @OnClick({R.id.msg_title1, R.id.msg_title2, R.id.msg_title3, R.id.msg_title4, R.id.msg_title5, R.id.msg_title6})
    public void onClickedView(View view) {
        restBackround();
        switch (view.getId()) {
            case R.id.msg_title1:
                mMsgViewPager.setCurrentItem(0);
                mLine1.setBackgroundResource(R.color.colorWhite);
                break;
            case R.id.msg_title2:
                mMsgViewPager.setCurrentItem(1);
                mLine2.setBackgroundResource(R.color.colorWhite);
                break;
            case R.id.msg_title3:
                mMsgViewPager.setCurrentItem(2);
                mLine3.setBackgroundResource(R.color.colorWhite);
                break;
            case R.id.msg_title4:
                mMsgViewPager.setCurrentItem(3);
                mLine4.setBackgroundResource(R.color.colorWhite);
                break;
            case R.id.msg_title5:
                mMsgViewPager.setCurrentItem(4);
                mLine5.setBackgroundResource(R.color.colorWhite);
                break;
            case R.id.msg_title6:
                mMsgViewPager.setCurrentItem(5);
                mLine6.setBackgroundResource(R.color.colorWhite);
                break;
            default:
                break;
        }
    }

    @Override
    public void destoryData() {
        unbinder.unbind();
        System.gc();
    }

    @Override
    public void loadingDatas() {

    }

    /**
     * 重置指示器颜色
     */
    private void restBackround() {
        mLine1.setBackgroundResource(R.color.colorPet);
        mLine2.setBackgroundResource(R.color.colorPet);
        mLine3.setBackgroundResource(R.color.colorPet);
        mLine4.setBackgroundResource(R.color.colorPet);
        mLine5.setBackgroundResource(R.color.colorPet);
        mLine6.setBackgroundResource(R.color.colorPet);
    }

    /**
     * 适配器
     */
    private class NewsAdapter extends FragmentPagerAdapter {
        private List<Fragment> mList;

        public NewsAdapter(FragmentManager fm) {
            super(fm);
            mList = new ArrayList<>();
            mList.add(new RecommendFragment());
            mList.add(new HeadlineFragment());
            mList.add(new CartoonFragment());
            mList.add(new MagazineFragment());
            mList.add(new SchoolFragment());
            mList.add(new AuthorityFragment());
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
