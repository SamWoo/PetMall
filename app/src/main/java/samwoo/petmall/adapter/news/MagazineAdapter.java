package samwoo.petmall.adapter.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.model.news.MagazineModel;

/**
 * Created by Administrator on 2017/7/24.
 */

public class MagazineAdapter extends RecyclerView.Adapter<MagazineAdapter.ViewHolder> {
    private Context context;
    private List<MagazineModel> mList;

    public MagazineAdapter(Context context, List<MagazineModel> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_msg_zazhi, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getImage()).centerCrop().into(holder.mItemView);
        holder.mItemName.setText(mList.get(position).getNames());
        holder.mItemTimes.setText(mList.get(position).getTimes());

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_parents)
        AutoLinearLayout mItemParents;
        @BindView(R.id.item_image)
        SimpleDraweeView mItemView;
        @BindView(R.id.item_name)
        TextView mItemName;
        @BindView(R.id.item_times)
        TextView mItemTimes;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
