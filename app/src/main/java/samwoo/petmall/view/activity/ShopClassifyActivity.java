package samwoo.petmall.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.view.child.AuthorityFragment;
import samwoo.petmall.view.child.CartoonFragment;
import samwoo.petmall.view.child.HeadlineFragment;
import samwoo.petmall.view.child.RecommendFragment;
import samwoo.petmall.view.child.SchoolFragment;

/**
 * Created by Administrator on 2017/8/1.
 */

public class ShopClassifyActivity extends FragmentActivity implements View.OnClickListener {
    @BindView(R.id.scrollview)
    ScrollView scrollView;
    @BindView(R.id.linearlayout)
    LinearLayout linearLayout;
    @BindView(R.id.framelayout)
    FrameLayout frameLayout;
    @BindView(R.id.top_text)
    TextView mTitle;
    @BindView(R.id.top_back)
    ImageView mBack;

    private String[] titles = {"常用分类", "潮流女装", "品牌男装", "内衣配饰", "家用电器", "手机数码", "电脑办公", "个护化妆", "母婴频道", "食物生鲜", "酒水饮料", "家居家纺", "整车车品", "鞋靴箱包", "运动户外", "图书", "玩具乐器", "钟表", "居家生活", "珠宝饰品", "音像制品", "家具建材", "计生情趣", "营养保健", "奢侈礼品", "生活服务", "旅游出行"};
    //装装ScrollView的item的TextView的数组
    private TextView[] textViewArray = new TextView[titles.length];
    //装ScrollView的item的数组
    private View[] views = new View[titles.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_classify);
        ButterKnife.bind(this);
        init();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new CartoonFragment()).commit();
    }

    /**
     * 初始化界面
     */
    private void init() {
        mTitle.setText("商品分类");

        for (int i = 0; i < titles.length; i++) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_scrollview, null);
            TextView tv = view.findViewById(R.id.shop_type);
            tv.setText(titles[i]);
            tv.setId(i);
            tv.setOnClickListener(this);
            linearLayout.addView(view);

            views[i] = view;
            textViewArray[i] = tv;
        }
        changeTextColor(0);
    }

    /**
     * 改变textView的颜色
     *
     * @param index
     */
    private void changeTextColor(int index) {
        for (int i = 0; i < textViewArray.length; i++) {
            if (i != index) {
                textViewArray[i].setBackgroundResource(android.R.color.transparent);
                textViewArray[i].setTextColor(getResources().getColor(R.color.color9));
            } else {
                textViewArray[i].setBackgroundResource(R.color.colorWhite);
                textViewArray[i].setTextColor(getResources().getColor(R.color.colorPet));
            }
        }
    }

    @Override
    public void onClick(View v) {
        changeTextColor((int) v.getId());
        changeTextLocation((int) v.getId());

        Fragment fragment = null;
        switch (v.getId()) {
            case 0:
                fragment = new CartoonFragment();
                break;
            case 1:
                fragment = new RecommendFragment();
                break;
            case 2:
                fragment = new SchoolFragment();
                break;
            case 3:
                fragment = new AuthorityFragment();
                break;
            case 4:
                fragment = new HeadlineFragment();
                break;
            default:
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
        }
    }


    /**
     * 改变栏目位置
     */
    private void changeTextLocation(int index) {

        //views[clickPosition].getTop()针对其父视图的顶部相对位置
        int x = (views[index].getTop() - scrollView.getHeight() / 2);
        scrollView.smoothScrollTo(0, x);
    }

    /**
     * 点击事件监听
     *
     * @param view
     */
    @OnClick({R.id.top_back})
    public void onClickedView(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
