package com.android.upgrade;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.android.upgrade.utils.Constants;
import com.android.upgrade.utils.ServiceUtil;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.analytics.social.UMPlatformData.UMedia;

public class Donate extends Activity {

	private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.umeng_example_analytics);
        ServiceUtil.startAlarm(mContext);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onEvent(mContext, Constants.UMENG_RUNTIME_ID, String.valueOf(10));
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onButtonClick(View view) {
        int id = view.getId();
        switch (id) {
        case R.id.umeng_example_analytics_event:
            MobclickAgent.onEvent(mContext, "run_time");
            MobclickAgent.onEvent(mContext, "run_time", "50");
            break;
        }
    }

}
