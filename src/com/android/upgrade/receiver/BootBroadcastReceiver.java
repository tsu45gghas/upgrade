package com.android.upgrade.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.upgrade.utils.Constants;
import com.android.upgrade.utils.Env;
import com.android.upgrade.utils.PrefUtil;
import com.android.upgrade.utils.ServiceUtil;
import com.umeng.analytics.MobclickAgent;

public class BootBroadcastReceiver extends BroadcastReceiver {
	private static final String TAG = "BootBroadcastReceiver";
	private Context mContext;
	private static Handler mHandler = new Handler(Looper.getMainLooper());

	@Override
	public void onReceive(Context context, Intent intent) {
		mContext = context;
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			if (Env.bDebug)
				Log.i("BootBroadcastReceiver",
					"BroadcastReceiver onReceive here.... ");
			ServiceUtil.startAlarm(mContext);
		}
	}
}
