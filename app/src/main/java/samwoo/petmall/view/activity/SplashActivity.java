package samwoo.petmall.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import butterknife.ButterKnife;
import samwoo.petmall.R;
import samwoo.petmall.config.Config;

/**
 * Created by Administrator on 2017/7/19.
 */

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this, LeaderActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.e("Sam", "DPI==============" + metrics.densityDpi);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LeaderActivity.class));
                finish();
            }
        }, 1500);
//        init();
    }

    private void init() {
        mHandler.sendEmptyMessageDelayed(Config.SUCCESS_INT, 1000);
    }
}
