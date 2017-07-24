package samwoo.petmall.adapter.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.model.shop.PinTuanModel;

/**
 * Created by Administrator on 2017/7/24.
 */

public class PinTuanAdapter extends RecyclerView.Adapter<PinTuanAdapter.ViewHolder> {
    private Context context;
    private List<PinTuanModel> mList;

    public PinTuanAdapter(Context context, List<PinTuanModel> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_pintuan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getImageId()).centerCrop().into(holder.mItemImg);
        holder.mItemDescript.setText(mList.get(position).getDescript());
        holder.mItemMutchOne.setText("￥" + mList.get(position).getMutch_one());
        holder.mItemMutchTwo.setText("￥" + mList.get(position).getMutch_two());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView mItemImg;
        @BindView(R.id.item_descript)
        TextView mItemDescript;
        @BindView(R.id.item_mutchOne)
        TextView mItemMutchOne;
        @BindView(R.id.item_mutchTwo)
        TextView mItemMutchTwo;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
