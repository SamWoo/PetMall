package samwoo.petmall.view.activity;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import samwoo.petmall.R;
import samwoo.petmall.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/7/26.
 */

public class WebActivity extends AppCompatActivity {
    @BindView(R.id.web)
    WebView mWebView;
    @BindView(R.id.top_back)
    ImageView mBack;
    @BindView(R.id.top_text)
    TextView mTitle;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mTitle.setText("正文");
        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().getJavaScriptEnabled();
        mWebView.getSettings().setBlockNetworkImage(false);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.getSettings().setLoadWithOverviewMode(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        //加载需要显示的网页
        mWebView.loadUrl(url);
        //设置Web视图
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
    }

    @OnClick(R.id.top_back)
    public void onClickedView(View view) {
        onBackPressed();
    }

}

