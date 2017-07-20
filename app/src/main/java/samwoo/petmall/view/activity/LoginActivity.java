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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/19.
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_phone)
    EditText mLoginPhone;
    @BindView(R.id.login_pass)
    EditText mLoginPass;
    @BindView(R.id.top_text)
    TextView mTopText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mTopText.setText("登录");
    }

    /**
     * 设置点击监听
     *
     * @param view
     */
    @OnClick({R.id.top_back, R.id.login_miss, R.id.login_btn, R.id.login_more, R.id.parent_phone, R.id.parent_pass})
    public void onViewCliked(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                onBackPressed();
                break;
            case R.id.login_miss:
                startActivity(new Intent(this, MissActivity.class));
                finish();
                break;
            case R.id.login_btn:
                if (mLoginPass.getText().toString().equals("123") && mLoginPhone.getText().toString().equals("123")) {
                    startActivity(new Intent(this, PetMsgActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "您输入的账号密码有误！请重新输入！！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_more:

                break;
            case R.id.parent_phone:
                mLoginPhone.requestFocus();
                break;
            case R.id.parent_pass:
                mLoginPass.requestFocus();
                break;
            default:
                break;
        }
    }

}
