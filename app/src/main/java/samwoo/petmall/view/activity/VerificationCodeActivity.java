package samwoo.petmall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/19.
 */

public class VerificationCodeActivity extends AppCompatActivity implements TextWatcher {

    @BindView(R.id.top_text)
    TextView mTopText;
    @BindView(R.id.code_getnums)
    EditText mCodeGetNums;
    @BindView(R.id.code_nums)
    TextView mCodeNums;
    @BindView(R.id.code_btn)
    TextView mCodeBtn;
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
        setContentView(R.layout.activity_verification_code);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTopText.setText("注册");
        mCodeBtn.setClickable(false);
        mCodeNums.setClickable(true);
        mCodeGetNums.addTextChangedListener(this);
    }

    @OnClick({R.id.top_back, R.id.code_btn, R.id.register_agree, R.id.code_nums})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                onBackPressed();
                break;
            case R.id.code_btn:
                if (mCodeGetNums.getText().toString().equals("123")) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "输入的验证码有误，请重新输入！！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_agree:
                startActivity(new Intent(this, AgreeDetialActivity.class));
                finish();
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
        if (!mCodeGetNums.getText().toString().equals("")) {
            mCodeBtn.setClickable(true);
            mCodeBtn.setBackgroundResource(R.drawable.shape_register_btn_pet);
        }
    }
}
