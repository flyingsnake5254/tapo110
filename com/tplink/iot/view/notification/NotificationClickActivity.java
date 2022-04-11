package com.tplink.iot.view.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.firebase.CloudMessageBean;
import com.tplink.iot.view.welcome.StartupActivity;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationClickActivity
  extends AppCompatActivity
{
  private void P0(Activity paramActivity, CloudMessageBean paramCloudMessageBean)
  {
    int i;
    if (o.a() == 0) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramActivity = b.a(paramActivity, paramCloudMessageBean);
      if (paramActivity != null) {
        startActivity(paramActivity);
      }
      finish();
    }
    else
    {
      S0(paramActivity, paramCloudMessageBean);
    }
  }
  
  private CloudMessageBean Q0(Intent paramIntent)
  {
    String str1 = "";
    String str2 = R0(paramIntent, "msgId", "");
    String str3 = R0(paramIntent, "title", "");
    String str4 = R0(paramIntent, "content", "");
    String str5 = R0(paramIntent, "msgType", "");
    String str6 = R0(paramIntent, "time", "");
    R0(paramIntent, "deviceCount", String.valueOf(0));
    String str7 = R0(paramIntent, "userName", "");
    String str8 = R0(paramIntent, "deviceId", "");
    String str9 = R0(paramIntent, "imgUrl", "");
    String str10 = R0(paramIntent, "alias", "");
    String str11 = R0(paramIntent, "uuid", "");
    String str12 = R0(paramIntent, "iac", "");
    String str13 = R0(paramIntent, "summaryDate", "");
    paramIntent = str1;
    Object localObject = str5;
    if (!TextUtils.isEmpty(str12))
    {
      paramIntent = str1;
      localObject = str5;
      if (!TextUtils.isEmpty(U0(str12)))
      {
        localObject = U0(str12);
        paramIntent = V0(str12, (String)localObject);
      }
    }
    localObject = new CloudMessageBean(str2, (String)localObject, str6);
    ((CloudMessageBean)localObject).setTitle(str3);
    ((CloudMessageBean)localObject).setContent(str4);
    ((CloudMessageBean)localObject).setUserName(str7);
    ((CloudMessageBean)localObject).setDeviceId(str8);
    ((CloudMessageBean)localObject).setImgUrl(str9);
    ((CloudMessageBean)localObject).setAlias(str10);
    ((CloudMessageBean)localObject).setUuid(str11);
    ((CloudMessageBean)localObject).setTaskId(paramIntent);
    ((CloudMessageBean)localObject).setSummaryDate(str13);
    return (CloudMessageBean)localObject;
  }
  
  private String R0(Intent paramIntent, String paramString1, String paramString2)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra(paramString1)))
    {
      paramIntent = paramIntent.getStringExtra(paramString1);
      if (paramIntent == null) {
        return paramString2;
      }
      return paramIntent;
    }
    return paramString2;
  }
  
  private void S0(Context paramContext, CloudMessageBean paramCloudMessageBean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, StartupActivity.class);
    localIntent.setFlags(268435456);
    if (!TextUtils.isEmpty(paramCloudMessageBean.getTaskId())) {
      localIntent.putExtra("task_id", paramCloudMessageBean.getTaskId());
    }
    EnumMsgSubscribeType localEnumMsgSubscribeType = EnumMsgSubscribeType.fromString(paramCloudMessageBean.getMessageType());
    switch (a.a[localEnumMsgSubscribeType.ordinal()])
    {
    default: 
      break;
    case 1: 
    case 2: 
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
      W0(localIntent, paramCloudMessageBean);
    }
    paramContext.startActivity(localIntent);
    finish();
    overridePendingTransition(0, 0);
  }
  
  private void T0()
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      finish();
      return;
    }
    localObject = Q0((Intent)localObject);
    if (TextUtils.isEmpty(((CloudMessageBean)localObject).getMessageType()))
    {
      finish();
      return;
    }
    P0(this, (CloudMessageBean)localObject);
  }
  
  public static String U0(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    Object localObject = str;
    if (!bool) {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        localObject = ((JSONObject)localObject).optString("msgType", "");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localObject = str;
      }
    }
    return (String)localObject;
  }
  
  public static String V0(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    String str1 = "";
    String str2 = str1;
    if (!bool)
    {
      str2 = str1;
      if ("pushWithTaskId".equals(paramString2)) {
        try
        {
          paramString2 = new org/json/JSONObject;
          paramString2.<init>(paramString1);
          str2 = paramString2.optString("taskId", "");
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          str2 = str1;
        }
      }
    }
    return str2;
  }
  
  private void W0(Intent paramIntent, CloudMessageBean paramCloudMessageBean)
  {
    paramIntent.putExtra("fcm_device_id", paramCloudMessageBean.getDeviceId());
    paramIntent.putExtra("fcm_event_time", paramCloudMessageBean.getTimestamp());
    paramIntent.putExtra("notification_msg_type", paramCloudMessageBean.getMessageType());
    paramIntent.putExtra("fcm_uuid", paramCloudMessageBean.getUuid());
  }
  
  public void onBackPressed() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    supportRequestWindowFeature(1);
    setContentView(2131558593);
    T0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\NotificationClickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */