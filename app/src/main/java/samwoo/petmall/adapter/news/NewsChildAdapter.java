package samwoo.petmall.adapter.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.model.news.NewsChildModel;

/**
 * Created by Administrator on 2017/7/24.
 */

public class NewsChildAdapter extends BaseAdapter {
    private Context mContext;
    private List<NewsChildModel> mList;

    public NewsChildAdapter(Context context, List<NewsChildModel> mRecList) {
        this.mContext = context;
        this.mList = mRecList;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_msg_child, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mList.get(i).getResourceId()).centerCrop().into(holder.mItemImage);
        holder.mItemTitle.setText(mList.get(i).getTitle());
        holder.mItemAuthor.setText(mList.get(i).getAuthor());
        holder.mItemWatch.setText(mList.get(i).getStars() + "");

        if (mList.get(i).isZhiding()) {
            holder.mItemZhiding.setVisibility(View.VISIBLE);
        } else {
            holder.mItemZhiding.setVisibility(View.GONE);
        }

        if (mList.get(i).isJingxuan()) {
            holder.mItemJingxuan.setVisibility(View.VISIBLE);
        } else {
            holder.mItemJingxuan.setVisibility(View.GONE);
        }
        return view;

    }

    static class ViewHolder {
        @BindView(R.id.item_image)
        ImageView mItemImage;
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.item_zhiding)
        TextView mItemZhiding;
        @BindView(R.id.item_jingxuan)
        TextView mItemJingxuan;
        @BindView(R.id.item_author)
        TextView mItemAuthor;
        @BindView(R.id.item_watch)
        TextView mItemWatch;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
