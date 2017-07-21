package samwoo.petmall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import samwoo.petmall.R;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MineFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine,container,false);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void destoryData() {

    }

    @Override
    public void loadingDatas() {

    }
}
