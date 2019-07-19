package com.yasin.androiddemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.yasin.androiddemo.MainAdapter;

public class MyService extends Service {
    public static final String TAG = MyService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    private void serviceStart() {
        Log.d(TAG, "serviceStart: ");
        //String value = MainAdapter.Companion.getARG_PARAM1();
    }

    public class MyBinder extends Binder {

        public void invokeMethod() {
            serviceStart();
        }
    }
}
