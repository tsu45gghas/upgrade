package com.android.upgrade.utils;


public class Constants {

	public static final int ALARM_ELAPSED_TIME_MIN = 10;
    public static final int ALARM_ELAPSED_TIME = ALARM_ELAPSED_TIME_MIN * 60 * 1000;
    public static final int RETRIVE_SERVICE_COUNT = 50;
    public static final int ELAPSED_TIME_DELAY = 2*60*1000;//get GPS delayed
    public static final int BROADCAST_ELAPSED_TIME_DELAY = 1000;
    public static final String WORKER_SERVICE = "com.android.upgrade..service.WorkService";
    public static final String POI_SERVICE = "com.android.upgrade.service.UploadPOIService";
    public static final String POI_SERVICE_ACTION = "com.android.upgrade.service.UploadPOIService.action";

    public static final String UMENG_RUNTIME_ID = "run_time";
}
