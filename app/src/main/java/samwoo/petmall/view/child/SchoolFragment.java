package samwoo.petmall.view.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.adapter.news.NewsChildAdapter;
import samwoo.petmall.model.news.NewsChildModel;
import samwoo.petmall.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/7/24.
 */

public class SchoolFragment extends BaseFragment {
    @BindView(R.id.xuetang_lists)
    ListView mSchool;
    private List<NewsChildModel> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_school, null);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        mList.add(new NewsChildModel("拉布拉多和金毛的区别", false, false, "刀斥", 52000, R.drawable.xuetang1));
        mList.add(new NewsChildModel("不要再咬我的袜子", false, false, "娜酷子", 1000, R.drawable.xuetang2));
        mList.add(new NewsChildModel("子宫蓄脓+膀胱结石=小宝的痛苦", false, false, "派美特长青宠物医院", 1000, R.drawable.xuetang3));
        mList.add(new NewsChildModel("炎炎夏日，狂洗澡&剃光狗狗的毛就对了？", false, false, "哦四姑", 10000, R.drawable.xuetang4));
        mList.add(new NewsChildModel("市面疫苗种类那么多，我们该怎么选择？", false, false, "来份豆沙包", 2658, R.drawable.xuetang5));
        mList.add(new NewsChildModel("喜欢偷吃的喵星人", false, false, "来份豆沙包", 2019, R.drawable.xuetang6));
        mList.add(new NewsChildModel("与犬疫苗接种相关的常见问题", false, false, "娜酷子", 2398, R.drawable.xuetang7));
        mList.add(new NewsChildModel("母犬的假孕", false, false, "来份豆沙包", 2419, R.drawable.xuetang8));
        mList.add(new NewsChildModel("你的兔子有脚炎吗？", false, false, "刀斥", 1339, R.drawable.xuetang9));
        mList.add(new NewsChildModel("因肾衰竭而呕吐，抽搐的TA，在这里恢复了健康", false, false, "芭比唐堂", 2179, R.drawable.xuetang10));
        mList.add(new NewsChildModel("犬猫胰腺炎", false, false, "来份豆沙包", 959, R.drawable.xuetang11));
        mList.add(new NewsChildModel("夏天要格外小心体表寄生虫病！", false, false, "来份豆沙包", 1719, R.drawable.xuetang12));

        NewsChildAdapter adapter = new NewsChildAdapter(getActivity(), mList);
        mSchool.setAdapter(adapter);
    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {

    }
}
