package samwoo.petmall.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Administrator on 2017/7/21.
 */

public abstract class BaseFragment extends Fragment {
    public abstract void init(View view);

    public abstract void destoryData();

    public abstract void loadingDatas();//加载数据，初始化数据，初始化对象

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destoryData();
        System.gc();
    }
}
