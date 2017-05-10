package com.example.alex.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alex.job.R;

/**
 * Created by alex on 9/5/2017.
 * Activity 的生命週期
 */

public class ActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");

        // Activity已經可見，但是處於後台
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");

        // Activity已經可見，并在前台開始活動
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");

        // Activity正在停止，這裡的操作不能太耗時，onPause()必須執行完成后，新的Activity的onResume()方法才會執行
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");

        // Activity即將停止，可以做一些稍微重量級的回收工作，同樣不能太耗時
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");

        // Activity即將被銷毀，可以做一些回收工作和最終的資源釋放
    }

    private final static String TAG = ActivityLifecycle.class.getName();
}
