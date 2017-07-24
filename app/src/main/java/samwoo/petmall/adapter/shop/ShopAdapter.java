package samwoo.petmall.adapter.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.model.shop.ShopModel;

/**
 * Created by Administrator on 2017/7/24.
 */

public class ShopAdapter extends BaseAdapter {
    private Context context;
    private List<ShopModel> mList;
    private LinearLayout.LayoutParams left;
    private LinearLayout.LayoutParams right;
    private int width;

    public ShopAdapter(Context context, List<ShopModel> list) {
        this.context = context;
        this.mList = list;
        width = getScreenWidth();
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
            view = LayoutInflater.from(context).inflate(R.layout.item_shopping, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mItemTitle.setText(mList.get(i).getTitles());
        Glide.with(context).load(mList.get(i).getImage()).centerCrop().into(holder.mItemImages);

        if (i == 0) {
            Glide.with(context).load(mList.get(i).getImages()[0]).centerCrop().into(holder.mImage1);
            Glide.with(context).load(mList.get(i).getImages()[1]).centerCrop().into(holder.mImage2);
            Glide.with(context).load(mList.get(i).getImages()[2]).centerCrop().into(holder.mImage3);
            Glide.with(context).load(mList.get(i).getImages()[3]).centerCrop().into(holder.mImage4);
            Glide.with(context).load(mList.get(i).getImages()[4]).centerCrop().into(holder.mImage5);
            Glide.with(context).load(mList.get(i).getImages()[5]).centerCrop().into(holder.mImage6);
            Glide.with(context).load(mList.get(i).getImages()[6]).centerCrop().into(holder.mImage7);
            Glide.with(context).load(mList.get(i).getImages()[7]).centerCrop().into(holder.mImage8);
            Glide.with(context).load(mList.get(i).getImages()[8]).centerCrop().into(holder.mImage9);

            left = new LinearLayout.LayoutParams(width / 2, width / 4);
            right = new LinearLayout.LayoutParams(width / 4, width / 4);
            holder.mImage1.setLayoutParams(left);
            holder.mImage2.setLayoutParams(right);
            holder.mImage3.setLayoutParams(right);
            holder.mImage4.setLayoutParams(left);
            holder.mImage5.setLayoutParams(right);
            holder.mImage6.setLayoutParams(right);
        } else if (i == 1) {
            Glide.with(context).load(mList.get(i).getImages()[0]).centerCrop().into(holder.mImage1);
            Glide.with(context).load(mList.get(i).getImages()[1]).centerCrop().into(holder.mImage2);
            Glide.with(context).load(mList.get(i).getImages()[3]).centerCrop().into(holder.mImage4);
            Glide.with(context).load(mList.get(i).getImages()[4]).centerCrop().into(holder.mImage5);
            Glide.with(context).load(mList.get(i).getImages()[6]).centerCrop().into(holder.mImage7);
            Glide.with(context).load(mList.get(i).getImages()[8]).centerCrop().into(holder.mImage9);

            holder.mImage3.setVisibility(View.GONE);
            holder.mImage6.setVisibility(View.GONE);
            holder.mImage8.setVisibility(View.GONE);

            left = new LinearLayout.LayoutParams(width / 2, width / 4, 1);
            right = new LinearLayout.LayoutParams(width / 2, width / 4, 1);
            holder.mImage1.setLayoutParams(left);
            holder.mImage2.setLayoutParams(right);
            holder.mImage4.setLayoutParams(left);
            holder.mImage5.setLayoutParams(right);
        } else if (i == 2) {
            Glide.with(context).load(mList.get(i).getImages()[0]).centerCrop().into(holder.mImage1);
            Glide.with(context).load(mList.get(i).getImages()[1]).centerCrop().into(holder.mImage2);
            Glide.with(context).load(mList.get(i).getImages()[2]).centerCrop().into(holder.mImage3);
            Glide.with(context).load(mList.get(i).getImages()[3]).centerCrop().into(holder.mImage4);
            Glide.with(context).load(mList.get(i).getImages()[4]).centerCrop().into(holder.mImage5);
            Glide.with(context).load(mList.get(i).getImages()[5]).centerCrop().into(holder.mImage6);
            Glide.with(context).load(mList.get(i).getImages()[6]).centerCrop().into(holder.mImage7);
            Glide.with(context).load(mList.get(i).getImages()[7]).centerCrop().into(holder.mImage8);
            Glide.with(context).load(mList.get(i).getImages()[8]).centerCrop().into(holder.mImage9);

            left = new LinearLayout.LayoutParams(width / 3, width / 3, 1);
            right = new LinearLayout.LayoutParams(width / 3, width / 3, 1);
            holder.mImage1.setLayoutParams(left);
            holder.mImage2.setLayoutParams(right);
            holder.mImage3.setLayoutParams(right);

            holder.mImage4.setLayoutParams(left);
            holder.mImage5.setLayoutParams(right);
            holder.mImage6.setLayoutParams(right);
        }

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.item_images)
        ImageView mItemImages;
        @BindView(R.id.image1)
        ImageView mImage1;
        @BindView(R.id.image2)
        ImageView mImage2;
        @BindView(R.id.image3)
        ImageView mImage3;
        @BindView(R.id.image4)
        ImageView mImage4;
        @BindView(R.id.image5)
        ImageView mImage5;
        @BindView(R.id.image6)
        ImageView mImage6;
        @BindView(R.id.image7)
        ImageView mImage7;
        @BindView(R.id.image8)
        ImageView mImage8;
        @BindView(R.id.image9)
        ImageView mImage9;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 获取屏幕宽度
     */
    private int getScreenWidth() {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }
}
