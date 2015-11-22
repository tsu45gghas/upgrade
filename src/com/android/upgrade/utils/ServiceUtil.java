package com.android.upgrade.utils;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.upgrade.service.AlarmService;


public class ServiceUtil {

    public static void startAlarm(Context context){
    	if (Env.bDebug)
			Log.i("ServiceUtil-AlarmManager", "invokeTimerPOIService wac called.." );
        PendingIntent alarmSender = null;
        Intent startIntent = new Intent(context, AlarmService.class);
        try {
            alarmSender = PendingIntent.getService(context, 0, startIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        } catch (Exception e) {
        }
        AlarmManager am = (AlarmManager) context.getSystemService(Activity.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + Constants.ALARM_ELAPSED_TIME,
        		Constants.ALARM_ELAPSED_TIME, alarmSender);
    }

    public static void cancleAlarm(Context context){
    	if (Env.bDebug)
			Log.i("ServiceUtil-AlarmManager", "cancleAlarmManager to start ");
        Intent intent = new Intent(context,AlarmService.class);
        PendingIntent pendingIntent=PendingIntent.getService(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm=(AlarmManager)context.getSystemService(Activity.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
    }
}
