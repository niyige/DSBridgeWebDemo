package com.oyy.dsbridgewebdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.oyy.dsbridgewebdemo.R;
/**
 * com.oyy.dsbridgewebdemo.ui.MainActivity
 * @author ouyangyi
 * @date 2017/10/16.
 */
public class MainActivity extends AppCompatActivity {

    private Button jumpWebBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumpWebBtn = (Button) findViewById(R.id.jumpWebBtn);

        jumpWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WebActivity.class));
            }
        });
    }
}
