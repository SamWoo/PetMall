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
import samwoo.petmall.model.news.NewsEntity;

/**
 * Created by Administrator on 2017/7/24.
 */

public class NewsAdapter extends BaseAdapter {
    private Context mContext;
    private List<NewsEntity.ListBean> mList;

    public NewsAdapter(Context context, List<NewsEntity.ListBean> list) {
        this.mContext = context;
        this.mList = list;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_msg_news, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mList.get(i).getImgurl()).centerCrop().into(holder.mItemImage);
        holder.mItemTitle.setText(mList.get(i).getTitle());
        holder.mItemAuthor.setText(mList.get(i).getTime());
//        holder.mItemTime.setText(mList.get(i).getTime());
        return view;

    }

    static class ViewHolder {
        @BindView(R.id.item_image)
        ImageView mItemImage;
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.item_author)
        TextView mItemAuthor;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
