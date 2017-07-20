package samwoo.petmall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.SPUtils;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/19.
 */

public class MissActivity extends AppCompatActivity implements TextWatcher {

    @BindView(R.id.top_text)
    TextView mTitle;
    @BindView(R.id.register_phone)
    EditText mRegisterPhone;
    @BindView(R.id.register_pass)
    EditText mRegisterPass;
    @BindView(R.id.miss_btn)
    TextView mMissBtn;
    @BindView(R.id.code_getnums)
    EditText mCodeGetNums;
    @BindView(R.id.code_nums)
    TextView mCodeNums;

    private String userPhone;
    private String userPasswd;
    private boolean isRun = false;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == -1) {
                isRun = false;
                mCodeNums.setBackgroundResource(R.drawable.shape_register_btn_pet);
                mCodeNums.setText("重新获取验证码");
                mCodeNums.setClickable(true);
            } else {
                mCodeNums.setBackgroundResource(R.drawable.shape_register_btn_32);
                mCodeNums.setText(msg.what + "s");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_miss);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTitle.setText("重置密码");
        mRegisterPhone.addTextChangedListener(this);
        mRegisterPass.addTextChangedListener(this);
        mCodeGetNums.addTextChangedListener(this);
        mCodeNums.setClickable(true);
        mMissBtn.setClickable(false);
    }

    @OnClick({R.id.top_back, R.id.miss_btn, R.id.parent_phone, R.id.parent_pass, R.id.code_nums})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                onBackPressed();
                break;
            case R.id.parent_phone:
                mRegisterPhone.requestFocus();
                break;
            case R.id.parent_pass:
                mRegisterPass.requestFocus();
                break;
            case R.id.code_nums:
                if (isRun) {
                    mCodeNums.setClickable(false);
                } else {
                    isRun = true;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int time = 20;
                            while (isRun) {
                                handler.sendEmptyMessage(time--);
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                }
                break;
            case R.id.miss_btn:
                if (mCodeGetNums.getText().toString().equals("123")) {
                    SPUtils.put(this, "user_phone", userPhone);
                    SPUtils.put(this, "user_passwd", userPasswd);
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        userPhone = mRegisterPhone.getText().toString();
        userPasswd = mRegisterPass.getText().toString();
        if (!TextUtils.isEmpty(userPasswd) && !TextUtils.isEmpty(userPhone) &&
                !mCodeGetNums.getText().toString().equals("")) {
            mMissBtn.setClickable(true);
            mMissBtn.setBackgroundResource(R.drawable.shape_register_btn_pet);
        } else {
            mMissBtn.setClickable(false);
            mMissBtn.setBackgroundResource(R.drawable.shape_register_btn_32);
        }
    }

}
