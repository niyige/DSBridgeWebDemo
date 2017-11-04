package com.oyy.dsbridgewebdemo.manage;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.oyy.dsbridgewebdemo.R;

/**
 * 分享相关
 * Created by
 * ouyangyi on 17/10/17.
 */

public class ShareManage {

    public static ShareManage shareManage;

    public static ShareManage getInstance() {
        if (shareManage == null) {
            shareManage = new ShareManage();
        }
        return shareManage;
    }


    //------------弹窗提示-----------------------------------
    private PopupWindow sharePopwin;

    View view = null;

    TextView weChatTxt;
    TextView weChatCircleTxt;
    TextView qqTxt;
    LinearLayout mainLayout;
    Button cancleBtn;

    /**
     * 分享弹窗
     *
     * @param mActivity
     * @param container_layout
     */
    public void showSharePopwin(final Activity mActivity, View container_layout, final String shareTitle) {
        if (sharePopwin == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.popwin_share_layout, null);

            weChatTxt = (TextView) view.findViewById(R.id.weChatTxt);
            weChatCircleTxt = (TextView) view.findViewById(R.id.weChatCircleTxt);
            qqTxt = (TextView) view.findViewById(R.id.qqTxt);
            mainLayout = (LinearLayout) view.findViewById(R.id.mainLayout);
            cancleBtn = (Button) view.findViewById(R.id.cancleBtn);


            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharePopwin.dismiss();
                }
            });

            weChatTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, weChatTxt + ":" + shareTitle, Toast.LENGTH_SHORT);
                    sharePopwin.dismiss();
                }
            });

            weChatCircleTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, weChatCircleTxt + ":" + shareTitle, Toast.LENGTH_SHORT);
                    sharePopwin.dismiss();
                }
            });

            qqTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, qqTxt + ":" + shareTitle, Toast.LENGTH_SHORT);
                    sharePopwin.dismiss();
                }
            });

            cancleBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharePopwin.dismiss();
                }
            });

            sharePopwin = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            sharePopwin.setBackgroundDrawable(new BitmapDrawable());
            sharePopwin.setOutsideTouchable(true);
            sharePopwin.setFocusable(true);

        }

        sharePopwin.showAtLocation(container_layout, Gravity.TOP, 0, 0);

    }


}
