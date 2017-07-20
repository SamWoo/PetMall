package samwoo.petmall.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/19.
 */

public class AgreeDetialActivity extends AppCompatActivity {

    @BindView(R.id.agree_web)
    WebView mWebView;
    @BindView(R.id.top_text)
    TextView mTopText;

    private static final String url = "http://www.yc.cn/app/info/agreement.html?petVer=390&petPlat=1&packetId=2000";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_agree_detail);
        ButterKnife.bind(this);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mTopText.setText("萌宠用户服务协议");
        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().getJavaScriptEnabled();
        //加载需要显示的网页
        mWebView.loadUrl(url);
        //设置Web视图
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @OnClick(R.id.top_back)
    public void onViewClicked(View view) {
        onBackPressed();
    }
}
