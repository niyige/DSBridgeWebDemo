package com.oyy.dsbridgewebdemo.entity;

import android.app.Activity;
import android.webkit.JavascriptInterface;

import org.json.JSONException;
import org.json.JSONObject;
import org.simple.eventbus.EventBus;

import wendu.dsbridge.CompletionHandler;

/**
 * Created by
 * ouyangyi on 17/10/17.
 */

public class JsApiEntity {

    private Activity mActivity;

    public JsApiEntity(Activity mActivity) {
        this.mActivity = mActivity;
    }

    //for synchronous invocation 同步
    @JavascriptInterface
    String testSyn(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("msg") + "［syn call］";
    }

    //for asynchronous invocation  异步
    //分享相关
    @JavascriptInterface
    void share(JSONObject jsonObject, CompletionHandler handler) throws JSONException {

        EventBus.getDefault().post(jsonObject, "SHOW_SHARE_DIALOG");

        handler.complete("对应后台里面的flag");  //回调数据给H5
    }



}
