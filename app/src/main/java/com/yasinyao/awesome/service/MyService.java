package com.yasinyao.awesome.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

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
