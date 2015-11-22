package com.android.upgrade.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;

import com.android.upgrade.utils.Constants;
import com.android.upgrade.utils.Env;
import com.android.upgrade.utils.PrefUtil;
import com.umeng.analytics.MobclickAgent;


public class AlarmService extends Service{
	private Context mContext;
    private String TAG = AlarmService.class.getSimpleName();
    private static boolean mResumedCalled = false;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        recordTime();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Env.bDebug)
			Log.i(TAG, "AlarmService onDestroy here.... ");
    }

    private void recordTime() {

        int runtime = PrefUtil.getRuntime(this);
        runtime += Constants.ALARM_ELAPSED_TIME_MIN;
        PrefUtil.setRuntime(mContext, runtime);

        if (Env.bDebug)
            Log.i(TAG, "AlarmService uploadInfo here....runTime: " + runtime);
        
    	if (isNetworkAvailable()) {
    	    if (!mResumedCalled) {
    	        MobclickAgent.onResume(mContext);
    	        mResumedCalled = true;
    	    }
            MobclickAgent.onEvent(mContext, "run_time", String.valueOf(runtime));
    	}
    	
    	stopSelf();
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivity = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    if (Env.bDebug)
                        Log.i(TAG, "isNetworkAvailable true" + info.toString());
                    return true;
                }
            }
        }
        return false;
    }

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
