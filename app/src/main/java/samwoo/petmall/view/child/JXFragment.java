package samwoo.petmall.view.child;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
import butterknife.Unbinder;
import samwoo.petmall.R;
import samwoo.petmall.adapter.home.JXAdapter;
import samwoo.petmall.model.home.JXModel;
import samwoo.petmall.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/7/21.
 */

public class JXFragment extends BaseFragment {
    @BindView(R.id.jx_main)
    ListView mJxMain;
    private List<JXModel> mJxList;
    private List<View> mList;

    private JXAdapter mAdapter;

    private ViewPager mJxBanner;
    private ImageView mJxOne;
    private ImageView mJxTwo;
    private ImageView mJxThree;
    private ImageView mJxFour;
    private ImageView mJxFive;
    private boolean isRun = false;
    private Unbinder unbinder;

    //******************************轮播窗口****************************
    private int[] images =
            {
                    R.drawable.jx_header_1,
                    R.drawable.jx_header_2,
                    R.drawable.jx_header_3,
                    R.drawable.jx_header_4,
                    R.drawable.jx_header_5,
            };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            resetDic();
            switch (msg.what % images.length) {
                case 0:
                    mJxOne.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(0);
                    break;
                case 1:
                    mJxTwo.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(1);
                    break;
                case 2:
                    mJxThree.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(2);
                    break;
                case 3:
                    mJxFour.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(3);
                    break;
                case 4:
                    mJxFive.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(4);
                    break;
                default:
                    break;
            }
        }
    };

    //*************************************************************************/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_jx, container, false);
        init(view);
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
        mAdapter = null;
        mList = null;
        handler = null;
    }

    /**
     * 加载数据
     */
    @Override
    public void loadingDatas() {
        mJxList = new ArrayList<>();
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());

        mAdapter = new JXAdapter(getActivity(), mJxList);
        mJxMain.setAdapter(mAdapter);

        //添加HeaderView
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_jx, null);
        mJxMain.addHeaderView(header);

        mJxBanner = header.findViewById(R.id.header_banner);
        mJxOne = (ImageView) header.findViewById(R.id.dic_1);
        mJxTwo = (ImageView) header.findViewById(R.id.dic_2);
        mJxThree = (ImageView) header.findViewById(R.id.dic_3);
        mJxFour = (ImageView) header.findViewById(R.id.dic_4);
        mJxFive = (ImageView) header.findViewById(R.id.dic_5);

        //加载Banner轮播数据
        mList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            Glide.with(getActivity()).load(images[i]).centerCrop().into(imageView);
            mList.add(imageView);
        }

        mJxBanner.setAdapter(new BannerAdapter());
        isRun = true;
        startBanner();
    }

    /**
     * 开启一个线程执行Banner自动轮播
     */
    private void startBanner() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                int position = 0;
                while (isRun) {
                    handler.sendEmptyMessage(position++);
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 重置指示器
     */
    private void resetDic() {
        mJxOne.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxTwo.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxThree.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxFour.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxFive.setBackgroundResource(R.drawable.shape_jx_circle_c);
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
