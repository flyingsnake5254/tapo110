package com.tplink.iot.view.notification;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import b.d.n.i.g;
import com.tplink.iot.core.p;
import com.tplink.iot.firebase.CloudMessageBean;
import com.tplink.iot.view.deviceshare.ShareDeviceActivity;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.view.home.message.NotificationCenterActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;

public class b
{
  public static Intent a(Activity paramActivity, CloudMessageBean paramCloudMessageBean)
  {
    EnumMsgSubscribeType localEnumMsgSubscribeType = EnumMsgSubscribeType.fromString(paramCloudMessageBean.getMessageType());
    Intent localIntent = new Intent();
    switch (a.a[localEnumMsgSubscribeType.ordinal()])
    {
    default: 
      localIntent.setClass(paramActivity, NotificationCenterActivity.class);
      break;
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
      localIntent.setClass(paramActivity, BillingActivity.class);
      break;
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
      if (p.d()) {
        return null;
      }
      localIntent.setClass(paramActivity, NotificationClickLoadingActivity.class);
      break;
    case 18: 
    case 19: 
      localIntent.setClass(paramActivity, MainActivity.class);
      localIntent.putExtra("app_downgrade_required", true);
      localIntent.addFlags(67108864);
      break;
    case 17: 
      localIntent.setClass(paramActivity, MainActivity.class);
      localIntent.putExtra("app_marketing_source", true);
      localIntent.addFlags(67108864);
      break;
    case 15: 
    case 16: 
      if (p.d()) {
        return null;
      }
      localIntent.setClass(paramActivity, MainActivity.class);
      b(localIntent, paramCloudMessageBean);
      break;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
      localIntent.setClass(paramActivity, MainActivity.class);
      b(localIntent, paramCloudMessageBean);
      break;
    case 2: 
      localIntent.setClass(paramActivity, ShareDeviceActivity.class);
      localIntent.putExtra("share_push_msg", true);
      break;
    case 1: 
      localIntent.setClass(paramActivity, FirmwareSlideActivity.class);
      localIntent.putExtra("entry", "notification");
    }
    if (!TextUtils.isEmpty(paramCloudMessageBean.getTaskId())) {
      b.d.n.f.b.l().i(paramCloudMessageBean.getTaskId());
    }
    return localIntent;
  }
  
  public static void b(Intent paramIntent, CloudMessageBean paramCloudMessageBean)
  {
    paramIntent.putExtra("fcm_device_id", paramCloudMessageBean.getDeviceId());
    paramIntent.putExtra("fcm_event_time", paramCloudMessageBean.getTimestamp());
    paramIntent.putExtra("notification_msg_type", paramCloudMessageBean.getMessageType());
    paramIntent.putExtra("fcm_uuid", paramCloudMessageBean.getUuid());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */