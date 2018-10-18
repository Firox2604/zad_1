package com.firox.pawel.zad_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private TextView orderInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        orderInfo = findViewById(R.id.order_info_view);
        Intent intent = getIntent();
        orderInfo.setText(intent.getStringExtra(MainActivity.ORDER));

    }
    public void returnReply(View view) {
        Intent replyInenet = new Intent();
        setResult(RESULT_OK, replyInenet);
        finish();
    }
}
