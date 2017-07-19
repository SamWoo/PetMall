package samwoo.petmall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/19.
 */

public class RegisterActivity extends AppCompatActivity implements TextWatcher {
    @BindView(R.id.register_phone)
    EditText mRegisterPhone;
    @BindView(R.id.register_pass)
    EditText mRegisterPass;
    @BindView(R.id.top_text)
    TextView mTopText;
    @BindView(R.id.register_btn)
    TextView mRegisterBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mTopText.setText("注册");
        mRegisterPhone.addTextChangedListener(this);
        mRegisterPass.addTextChangedListener(this);
    }

    /**
     * 设置点击监听
     *
     * @param view
     */
    @OnClick({R.id.top_back, R.id.register_btn, R.id.parent_phone, R.id.parent_pass, R.id.register_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                onBackPressed();
                break;
            case R.id.register_btn:
                startActivity(new Intent(this, VerificationCodeActivity.class));
                finish();
                break;
            case R.id.parent_phone:
                mRegisterPhone.requestFocus();
                break;
            case R.id.parent_pass:
                mRegisterPass.requestFocus();
                break;
            case R.id.register_agree:
                startActivity(new Intent(this, AgreeDetialActivity.class));
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
        if (!mRegisterPass.getText().toString().equals("") && !mRegisterPhone.getText().toString().equals("")) {
            mRegisterBtn.setBackgroundResource(R.drawable.shape_register_btn_pet);
        } else {
            mRegisterBtn.setBackgroundResource(R.drawable.shape_register_btn_32);
        }
    }
}
