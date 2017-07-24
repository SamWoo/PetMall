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

public class CartoonFragment extends BaseFragment {
    @BindView(R.id.dongman_lists)
    ListView mCartoon;

    private List<NewsChildModel> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cartoon, null);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        mList.add(new NewsChildModel("《瑞兽》父亲节--特别篇", "果脯儿", 4256, R.drawable.dongman1));
        mList.add(new NewsChildModel("瑞兽--救命恩猫（下）", "宋霸霸 小铁&毛大侠 暖气仔", 9999, R.drawable.dongman2));
        mList.add(new NewsChildModel("瑞兽--救命恩猫（上）", "宋霸霸 小铁&果脯儿 军统小队长", 13000, R.drawable.dongman3));
        mList.add(new NewsChildModel("瑞兽--猫落平阳被犬欺（下）", true, false, "宋霸霸 小铁&果脯儿 军统小队长", 17000, R.drawable.dongman4));
        mList.add(new NewsChildModel("瑞兽--高清福利图", true, false, "果脯儿&军统小队长", 29000, R.drawable.dongman5));
        mList.add(new NewsChildModel("樱花苹果派", "大贝贝", 619, R.drawable.dongman6));
        mList.add(new NewsChildModel("家有萌喵--奥利奥的故事（一）", "兔子猫", 1657, R.drawable.dongman7));
        mList.add(new NewsChildModel("徐芝麻--番外2", "原作冬瓜茶仙人&画手嘤嘤嘤因", 1518, R.drawable.dongman8));
        mList.add(new NewsChildModel("影子猫--技巧，规则与天赋", "牧羊阿卡", 1679, R.drawable.dongman9));
        mList.add(new NewsChildModel("抖抖村--另一个世界", "DDM大王", 2103, R.drawable.dongman10));

        NewsChildAdapter adapter = new NewsChildAdapter(getActivity(), mList);
        mCartoon.setAdapter(adapter);

    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {

    }
}
