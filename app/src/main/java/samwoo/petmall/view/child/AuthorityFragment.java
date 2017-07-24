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

public class AuthorityFragment extends BaseFragment {
    @BindView(R.id.guanfang_lists)
    ListView mAuthority;
    private List<NewsChildModel> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_authority, null);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        mList.add(new NewsChildModel("北京缉私犬基地将举办“国际禁毒日”宣传活动", false, false, "有宠小记者", 499, R.drawable.guanfang1));
        mList.add(new NewsChildModel("有宠福利购第八期来了，这次是个大手笔", false, false, "有宠小记者", 15000, R.drawable.guanfang2));
        mList.add(new NewsChildModel("这家最美宠物店，连鹿晗都要亲自做饭给店里员工吃！", false, false, "有宠小记者", 49900, R.drawable.guanfang3));
        mList.add(new NewsChildModel("【有宠推新品】“有宠蛋蛋”便携铲屎神器！", false, false, "有宠小记者", 18000, R.drawable.guanfang4));
        mList.add(new NewsChildModel("搞事情！有宠宠物生活会馆进驻广州禺万达~", true, false, "有宠小记者", 17000, R.drawable.guanfang5));
        mList.add(new NewsChildModel("有宠生而不凡 缔造互联网+宠物新模式", false, false, "有宠小记者", 6419, R.drawable.guanfang6));
        mList.add(new NewsChildModel("带上你的爱宠，来一场说走就走的免费泡泡浴吧！", false, false, "有宠小记者", 46000, R.drawable.guanfang7));
        mList.add(new NewsChildModel("有宠代表中国赴德出席2017FMBB比利时牧羊犬世界锦...", true, false, "刀斥", 21000, R.drawable.guanfang8));
        mList.add(new NewsChildModel("《有宠YOURPET》杂志封面背后的故事", false, false, "有宠小记者", 7819, R.drawable.guanfang9));
        mList.add(new NewsChildModel("温暖母亲节，虫虫现身担任拥抱大使~", false, false, "有宠小记者", 4259, R.drawable.guanfang10));
        mList.add(new NewsChildModel("高雄街头掀起虫虫旋风，大人小孩都疯狂！", true, false, "有宠小记者", 5259, R.drawable.guanfang11));
        mList.add(new NewsChildModel("有宠福利，逃脱游戏登场", true, false, "有宠小记者", 5800, R.drawable.guanfang12));

        NewsChildAdapter adapter = new NewsChildAdapter(getActivity(), mList);
        mAuthority.setAdapter(adapter);
    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {

    }
}
