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
import samwoo.petmall.model.news.GeekEntity;
import samwoo.petmall.model.news.MagazineModel;

/**
 * Created by Administrator on 2017/7/24.
 */

public class GeekGirlsAdapter extends RecyclerView.Adapter<GeekGirlsAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<GeekEntity.ResultsBean> mList;
    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public GeekGirlsAdapter(Context context, List<GeekEntity.ResultsBean> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_msg_zazhi, null);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getUrl()).centerCrop().into(holder.mItemView);
        holder.mItemName.setText(mList.get(position).getWho());
        holder.mItemTimes.setText(mList.get(position).getDesc());
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
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

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    //最后暴露给外面的调用者，定义一个设置Listener的方法（）
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
