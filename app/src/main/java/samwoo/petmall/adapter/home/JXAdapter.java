package samwoo.petmall.adapter.home;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.model.home.JXModel;

/**
 * Created by Administrator on 2017/7/21.
 */

public class JXAdapter extends BaseAdapter {
    private List<JXModel> mList;
    private Context mContext;

    public JXAdapter(Context context, List<JXModel> list) {
        mContext = context;
        mList = list;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_home_jx, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mUserHeaderImg.setImageURI(Uri.parse("res://.../" + mList.get(i).getHeaderImg()));//头像
        holder.mUserPetImg.setImageURI(Uri.parse("res://.../" + mList.get(i).getUserImg()));//宠物头像
        Glide.with(mContext).load(mList.get(i).getMainImg()).centerCrop().into(holder.mItemImg);

        holder.mUserName.setText(mList.get(i).getUserName());
        holder.mUserPetName.setText(mList.get(i).getPetName());
        holder.mUserPetType.setText(mList.get(i).getPetType());
        holder.mUserAir.setText(mList.get(i).getUserAir());
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.user_headerImg)
        SimpleDraweeView mUserHeaderImg;
        @BindView(R.id.user_name)
        TextView mUserName;
        @BindView(R.id.user_air)
        TextView mUserAir;
        @BindView(R.id.user_pet_img)
        SimpleDraweeView mUserPetImg;
        @BindView(R.id.user_pet_name)
        TextView mUserPetName;
        @BindView(R.id.user_pet_type)
        TextView mUserPetType;
        @BindView(R.id.user_pet_footer)
        ImageView mUserPetFooter;
        @BindView(R.id.user_pet)
        AutoLinearLayout mUserPet;
        @BindView(R.id.item_img)
        ImageView mItemImg;
        @BindView(R.id.item_descript)
        TextView mItemDescript;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
