package com.fitp.rwatsh.activity_lifecycle_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }

}
