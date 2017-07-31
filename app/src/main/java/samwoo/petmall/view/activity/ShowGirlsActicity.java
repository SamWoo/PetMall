package samwoo.petmall.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import samwoo.petmall.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class ShowGirlsActicity extends AppCompatActivity {
    @BindView(R.id.show_girl)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_girls);
        ButterKnife.bind(this);

        String imageUrl = getIntent().getStringExtra("imageUrl");
        Glide.with(this).load(imageUrl).centerCrop().into(imageView);
    }
}
