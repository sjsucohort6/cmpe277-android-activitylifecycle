package com.fitp.rwatsh.activity_lifecycle_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {
    private Runnable runnable;
    private long mThreadCount = 0;
    private TextView mThreadCountView;
    private Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                    mThreadCount++;
                    System.out.println("Set " + mThreadCount);
                }
            }
        };
        mThread = new Thread(runnable);
        mThread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mThreadCountView = (TextView)findViewById(R.id.threadCountVal);
        mThreadCountView.setText("" + mThreadCount);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mThread.interrupt();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }
}
