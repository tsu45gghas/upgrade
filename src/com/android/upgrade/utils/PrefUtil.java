package com.android.upgrade.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtil {
	private static String SHARED_PREF_FILE = "pref";
	private static String RUN_TIME_CONFIG = "run_time";
	
	public static void setRuntime(Context context,int time) {
		SharedPreferences settings = context.getSharedPreferences(SHARED_PREF_FILE,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(RUN_TIME_CONFIG, time);
		editor.commit();
	}
	
	public static int getRuntime(Context context) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE);
		int runtime = sharedPreferences.getInt(RUN_TIME_CONFIG, 0);
		return runtime;
	}
}
