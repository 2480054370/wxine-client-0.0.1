package com.client.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/31.
 */
public class ResetActivity extends AppCompatActivity {
    private TextView alreadyuser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset);
        alreadyuser = (TextView) findViewById(R.id.alreadyuser);
        alreadyuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
