package com.oyy.dsbridgewebdemo.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.oyy.dsbridgewebdemo.R;
import com.oyy.dsbridgewebdemo.entity.JsApiEntity;
import com.oyy.dsbridgewebdemo.manage.ShareManage;

import org.json.JSONObject;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.net.URLDecoder;

import wendu.dsbridge.DWebView;

/**
 * com.oyy.dsbridgewebdemo.ui.WebActivity
 *
 * @author ouyangyi
 * @date 2017/10/16.
 */
public class WebActivity extends AppCompatActivity {

    private DWebView webView;

    private LinearLayout mainLayout;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        EventBus.getDefault().register(this);
        initView();
        url = "http://localhost:8085/share.html";
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(this, "未知错误，请稍后再试", Toast.LENGTH_SHORT);
            return;
        }
        //  url = "http://mbao.fzfactor.com/noviceGift.html";
        try {
            webView.loadUrl(URLDecoder.decode(url, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            webView.loadUrl(url);
        }
    }

    /**
     * 初始化view
     */
    public void initView() {
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        webView = (DWebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setJavascriptInterface(new JsApiEntity(this));

        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        // 不把图片加载放在最后来加载渲染
        webView.getSettings().setBlockNetworkImage(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }
    }

//    public class TestEntity {
//       private  Context context;
//
//        public TestEntity(Context context) {
//            this.context = context;
//        }
//
//    }

    /**
     * 显示分享弹窗
     *
     * @param jsonObject
     */
    @Subscriber(tag = "SHOW_SHARE_DIALOG")
    public void showShareDialog(JSONObject jsonObject) {

        String title = jsonObject.optString("title");
        String content = jsonObject.optString("content");
        String imageUrl = jsonObject.optString("imageUrl");
        String url = jsonObject.optString("url");

        ShareManage.getInstance().showSharePopwin(WebActivity.this, mainLayout, title);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
