package samwoo.petmall.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.yancy.gallerypick.inter.ImageLoader;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import samwoo.petmall.R;
import samwoo.petmall.config.Config;
import samwoo.petmall.utils.ImageLoaderUtil;
import samwoo.petmall.utils.SPUtils;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/20.
 */

public class PetMsgActivity extends AppCompatActivity {
    @BindView(R.id.msg_headerImg)
    CircleImageView mHeadImg;
    @BindView(R.id.top_text)
    TextView mTopText;
    @BindView(R.id.msg_root_layout)
    AutoLinearLayout mRootLayout;
    @BindView(R.id.msg_name)
    EditText mPetName;
    @BindView(R.id.tv_type)
    TextView mPetType;
    @BindView(R.id.tv_birthday)
    TextView mPetBirth;
    @BindView(R.id.tv_day)
    TextView mPetBuy;
    @BindView(R.id.img_gg)
    ImageView mPetGG;
    @BindView(R.id.img_mm)
    ImageView mPetMM;

    private String petName;
    private GalleryConfig mGalleryConfig;//图片选择器的配置
    private List<String> mHeaderImgPaths = new ArrayList<>();//记录已选图片路径

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_pet_msg);
        ButterKnife.bind(this);
        init();
    }

    /**
     * 初始化界面
     */
    private void init() {
        mTopText.setText("添加萌宠");

//        if (!TextUtils.isEmpty((String) SPUtils.get(this, Config.HEADER_IMG_PATH, ""))) {
//            Glide.with(this).load((String) SPUtils.get(this, Config.HEADER_IMG_PATH, ""))
//                    .into(mHeadImg);
//        }
    }


    /**
     * 设置点击监听
     *
     * @param view
     */
    @OnClick({R.id.msg_headerImg, R.id.top_back, R.id.msg_long, R.id.msg_save, R.id.img_mm, R.id.img_gg})
    public void onClickedView(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                onBackPressed();
                break;
            case R.id.msg_headerImg:
                changeHeader();
                break;
            case R.id.msg_long:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.msg_save:
                save();
                break;
            case R.id.img_gg:
                mPetMM.setBackgroundResource(R.drawable.icon_pet_sex_grey);
                mPetGG.setBackgroundResource(R.drawable.icon_pet_boy_light);
                SPUtils.put(this, "pet_sex", 1);
                break;
            case R.id.img_mm:
                mPetGG.setBackgroundResource(R.drawable.icon_pet_sex_grey);
                mPetMM.setBackgroundResource(R.drawable.icon_pet_boy_light);
                SPUtils.put(this, "pet_sex", 0);
                break;
            default:
                break;
        }
    }

    /**
     * 保存萌宠信息
     */
    private void save() {
        petName = mPetName.getText().toString();
        if (!TextUtils.isEmpty(petName)) {
            SPUtils.put(this, "pet_name", petName);
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    //更换使用者图像
    private void changeHeader() {
        initGalleryConfig();//初始化图片选择器的配置参数
        initPermission();//授权管理
    }

    //初始化图片选择器的配置参数
    private void initGalleryConfig() {
        mGalleryConfig = new GalleryConfig.Builder()
                .imageLoader(new ImageLoaderUtil())
                .iHandlerCallBack(imgTakeListener)
                .pathList(mHeaderImgPaths)
                .multiSelect(false)//是否多选
                .crop(true)//开启快捷裁剪功能
                .isShowCamera(true)//显示相机按钮，默认是false
                .filePath("/EasyMvp")//图片存放路径
                .build();
        Log.e("Sam", "Config====" + mGalleryConfig);
    }

    //授权管理
    private void initPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //需要授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Snackbar.make(mRootLayout, "请在 设置-应用管理 中开启此应用的存储权限", Snackbar.LENGTH_SHORT).show();
            } else {
                //进行授权
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 8);
            }
        } else {
            //不需要授权
            GalleryPick.getInstance().setGalleryConfig(mGalleryConfig).open(this);
            Log.e("Sam", "Open=====不需要授权");
        }
    }

    //授权管理结果返回
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 8) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //同意授权
                GalleryPick.getInstance().setGalleryConfig(mGalleryConfig).open(this);
                Log.e("Sam", "Open=====同意授权");
            } else {

            }
        }
    }

    //图片选择器的监听借口
    IHandlerCallBack imgTakeListener = new IHandlerCallBack() {
        @Override
        public void onStart() {
        }

        @Override
        public void onSuccess(List<String> photoList) {
            SPUtils.put(PetMsgActivity.this, Config.HEADER_IMG_PATH, photoList.get(0));
            Log.e("Sam", "list====" + photoList);
            Glide.with(PetMsgActivity.this).load(photoList.get(0)).into(mHeadImg);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onFinish() {
        }

        @Override
        public void onError() {
        }
    };
}
