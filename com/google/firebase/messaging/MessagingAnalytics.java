package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEvent.Builder;
import com.google.firebase.messaging.reporting.MessagingClientEvent.Event;
import com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType;
import com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension.Builder;
import java.util.concurrent.ExecutionException;

public class MessagingAnalytics
{
  static boolean deliveryMetricsExportToBigQueryEnabled()
  {
    for (;;)
    {
      try
      {
        FirebaseApp.getInstance();
        localObject1 = FirebaseApp.getInstance().getApplicationContext();
        localObject2 = ((Context)localObject1).getSharedPreferences("com.google.firebase.messaging", 0);
        if (((SharedPreferences)localObject2).contains("export_to_big_query")) {
          return ((SharedPreferences)localObject2).getBoolean("export_to_big_query", false);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject1;
        Object localObject2;
        Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
        return false;
      }
      try
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        if (localObject2 != null)
        {
          localObject1 = ((PackageManager)localObject2).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
          if (localObject1 != null)
          {
            localObject2 = ((ApplicationInfo)localObject1).metaData;
            if ((localObject2 != null) && (((Bundle)localObject2).containsKey("delivery_metrics_exported_to_big_query_enabled")))
            {
              boolean bool = ((ApplicationInfo)localObject1).metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
              return bool;
            }
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
    return false;
  }
  
  static MessagingClientEvent eventToProto(MessagingClientEvent.Event paramEvent, Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    Object localObject = paramIntent.getExtras();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = Bundle.EMPTY;
    }
    localObject = MessagingClientEvent.newBuilder();
    ((MessagingClientEvent.Builder)localObject).setTtl(getTtl(paramIntent));
    ((MessagingClientEvent.Builder)localObject).setEvent(paramEvent);
    ((MessagingClientEvent.Builder)localObject).setInstanceId(getInstanceId(paramIntent));
    ((MessagingClientEvent.Builder)localObject).setPackageName(getPackageName());
    ((MessagingClientEvent.Builder)localObject).setSdkPlatform(MessagingClientEvent.SDKPlatform.ANDROID);
    ((MessagingClientEvent.Builder)localObject).setMessageType(getMessageTypeForFirelog(paramIntent));
    paramEvent = getMessageId(paramIntent);
    if (paramEvent != null) {
      ((MessagingClientEvent.Builder)localObject).setMessageId(paramEvent);
    }
    paramEvent = getTopic(paramIntent);
    if (paramEvent != null) {
      ((MessagingClientEvent.Builder)localObject).setTopic(paramEvent);
    }
    paramEvent = getCollapseKey(paramIntent);
    if (paramEvent != null) {
      ((MessagingClientEvent.Builder)localObject).setCollapseKey(paramEvent);
    }
    paramEvent = getMessageLabel(paramIntent);
    if (paramEvent != null) {
      ((MessagingClientEvent.Builder)localObject).setAnalyticsLabel(paramEvent);
    }
    paramEvent = getComposerLabel(paramIntent);
    if (paramEvent != null) {
      ((MessagingClientEvent.Builder)localObject).setComposerLabel(paramEvent);
    }
    long l = getProjectNumber(paramIntent);
    if (l > 0L) {
      ((MessagingClientEvent.Builder)localObject).setProjectNumber(l);
    }
    return ((MessagingClientEvent.Builder)localObject).build();
  }
  
  @Nullable
  static String getCollapseKey(Bundle paramBundle)
  {
    return paramBundle.getString("collapse_key");
  }
  
  @Nullable
  static String getComposerId(Bundle paramBundle)
  {
    return paramBundle.getString("google.c.a.c_id");
  }
  
  @Nullable
  static String getComposerLabel(Bundle paramBundle)
  {
    return paramBundle.getString("google.c.a.c_l");
  }
  
  @NonNull
  static String getInstanceId(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("google.to");
    if (!TextUtils.isEmpty(paramBundle)) {
      return paramBundle;
    }
    try
    {
      paramBundle = (String)Tasks.await(FirebaseInstallations.getInstance(FirebaseApp.getInstance()).getId());
      return paramBundle;
    }
    catch (InterruptedException paramBundle) {}catch (ExecutionException paramBundle) {}
    throw new RuntimeException(paramBundle);
  }
  
  @Nullable
  static String getMessageChannel(Bundle paramBundle)
  {
    return paramBundle.getString("google.c.a.m_c");
  }
  
  @Nullable
  static String getMessageId(Bundle paramBundle)
  {
    String str = paramBundle.getString("google.message_id");
    if (str == null) {
      return paramBundle.getString("message_id");
    }
    return str;
  }
  
  @Nullable
  static String getMessageLabel(Bundle paramBundle)
  {
    return paramBundle.getString("google.c.a.m_l");
  }
  
  @Nullable
  static String getMessageTime(Bundle paramBundle)
  {
    return paramBundle.getString("google.c.a.ts");
  }
  
  @NonNull
  static MessagingClientEvent.MessageType getMessageTypeForFirelog(Bundle paramBundle)
  {
    if ((paramBundle != null) && (NotificationParams.isNotification(paramBundle))) {
      paramBundle = MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    } else {
      paramBundle = MessagingClientEvent.MessageType.DATA_MESSAGE;
    }
    return paramBundle;
  }
  
  @NonNull
  static String getMessageTypeForScion(Bundle paramBundle)
  {
    if (true != NotificationParams.isNotification(paramBundle)) {
      return "data";
    }
    return "display";
  }
  
  @NonNull
  static String getPackageName()
  {
    return FirebaseApp.getInstance().getApplicationContext().getPackageName();
  }
  
  @Nullable
  static long getProjectNumber(Bundle paramBundle)
  {
    long l;
    if (paramBundle.containsKey("google.c.sender.id")) {
      try
      {
        l = Long.parseLong(paramBundle.getString("google.c.sender.id"));
        return l;
      }
      catch (NumberFormatException paramBundle)
      {
        Log.w("FirebaseMessaging", "error parsing project number", paramBundle);
      }
    }
    paramBundle = FirebaseApp.getInstance();
    String str = paramBundle.getOptions().getGcmSenderId();
    if (str != null) {
      try
      {
        l = Long.parseLong(str);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w("FirebaseMessaging", "error parsing sender ID", localNumberFormatException);
      }
    }
    paramBundle = paramBundle.getOptions().getApplicationId();
    if (!paramBundle.startsWith("1:"))
    {
      try
      {
        l = Long.parseLong(paramBundle);
        return l;
      }
      catch (NumberFormatException paramBundle)
      {
        Log.w("FirebaseMessaging", "error parsing app ID", paramBundle);
      }
    }
    else
    {
      paramBundle = paramBundle.split(":");
      if (paramBundle.length < 2) {
        return 0L;
      }
      paramBundle = paramBundle[1];
      if (paramBundle.isEmpty()) {
        return 0L;
      }
      try
      {
        l = Long.parseLong(paramBundle);
        return l;
      }
      catch (NumberFormatException paramBundle)
      {
        Log.w("FirebaseMessaging", "error parsing app ID", paramBundle);
      }
    }
    return 0L;
  }
  
  @Nullable
  static String getTopic(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("from");
    if ((paramBundle != null) && (paramBundle.startsWith("/topics/"))) {
      return paramBundle;
    }
    return null;
  }
  
  @NonNull
  static int getTtl(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("google.ttl");
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof String)) {
      try
      {
        int i = Integer.parseInt((String)localObject);
        return i;
      }
      catch (NumberFormatException paramBundle)
      {
        localObject = String.valueOf(localObject);
        paramBundle = new StringBuilder(((String)localObject).length() + 13);
        paramBundle.append("Invalid TTL: ");
        paramBundle.append((String)localObject);
        Log.w("FirebaseMessaging", paramBundle.toString());
      }
    }
    return 0;
  }
  
  @Nullable
  static String getUseDeviceTime(Bundle paramBundle)
  {
    if (paramBundle.containsKey("google.c.a.udt")) {
      return paramBundle.getString("google.c.a.udt");
    }
    return null;
  }
  
  private static boolean isDirectBootMessage(Intent paramIntent)
  {
    return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(paramIntent.getAction());
  }
  
  public static void logNotificationDismiss(@NonNull Intent paramIntent)
  {
    logToScion("_nd", paramIntent.getExtras());
  }
  
  public static void logNotificationForeground(@NonNull Intent paramIntent)
  {
    logToScion("_nf", paramIntent.getExtras());
  }
  
  public static void logNotificationOpen(@NonNull Bundle paramBundle)
  {
    setUserPropertyIfRequired(paramBundle);
    logToScion("_no", paramBundle);
  }
  
  public static void logNotificationReceived(@NonNull Intent paramIntent)
  {
    if (shouldUploadScionMetrics(paramIntent)) {
      logToScion("_nr", paramIntent.getExtras());
    }
    if (shouldUploadFirelogAnalytics(paramIntent)) {
      logToFirelog(MessagingClientEvent.Event.MESSAGE_DELIVERED, paramIntent, FirebaseMessaging.getTransportFactory());
    }
  }
  
  private static void logToFirelog(MessagingClientEvent.Event paramEvent, Intent paramIntent, @Nullable f paramf)
  {
    if (paramf == null)
    {
      Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
      return;
    }
    paramEvent = eventToProto(paramEvent, paramIntent);
    if (paramEvent == null) {
      return;
    }
    try
    {
      paramf = paramf.b("FCM_CLIENT_EVENT_LOGGING", MessagingClientEventExtension.class, b.b("proto"), MessagingAnalytics..Lambda.0.$instance);
      paramIntent = MessagingClientEventExtension.newBuilder();
      paramIntent.setMessagingClientEvent(paramEvent);
      paramf.b(c.e(paramIntent.build()));
      return;
    }
    catch (RuntimeException paramEvent)
    {
      Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", paramEvent);
    }
  }
  
  @VisibleForTesting
  static void logToScion(String paramString, Bundle paramBundle)
  {
    Object localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    paramBundle = new Bundle();
    String str1 = getComposerId((Bundle)localObject);
    if (str1 != null) {
      paramBundle.putString("_nmid", str1);
    }
    str1 = getComposerLabel((Bundle)localObject);
    if (str1 != null) {
      paramBundle.putString("_nmn", str1);
    }
    str1 = getMessageLabel((Bundle)localObject);
    if (!TextUtils.isEmpty(str1)) {
      paramBundle.putString("label", str1);
    }
    str1 = getMessageChannel((Bundle)localObject);
    if (!TextUtils.isEmpty(str1)) {
      paramBundle.putString("message_channel", str1);
    }
    str1 = getTopic((Bundle)localObject);
    if (str1 != null) {
      paramBundle.putString("_nt", str1);
    }
    str1 = getMessageTime((Bundle)localObject);
    if (str1 != null) {
      try
      {
        paramBundle.putInt("_nmt", Integer.parseInt(str1));
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", localNumberFormatException1);
      }
    }
    String str2 = getUseDeviceTime((Bundle)localObject);
    if (str2 != null) {
      try
      {
        paramBundle.putInt("_ndt", Integer.parseInt(str2));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", localNumberFormatException2);
      }
    }
    localObject = getMessageTypeForScion((Bundle)localObject);
    if (("_nr".equals(paramString)) || ("_nf".equals(paramString))) {
      paramBundle.putString("_nmc", (String)localObject);
    }
    if (Log.isLoggable("FirebaseMessaging", 3))
    {
      String str3 = String.valueOf(paramBundle);
      localObject = new StringBuilder(paramString.length() + 37 + str3.length());
      ((StringBuilder)localObject).append("Logging to scion event=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" scionPayload=");
      ((StringBuilder)localObject).append(str3);
      Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
    }
    localObject = (AnalyticsConnector)FirebaseApp.getInstance().get(AnalyticsConnector.class);
    if (localObject != null)
    {
      ((AnalyticsConnector)localObject).logEvent("fcm", paramString, paramBundle);
      return;
    }
    Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
  }
  
  static void setDeliveryMetricsExportToBigQuery(boolean paramBoolean)
  {
    FirebaseApp.getInstance().getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", paramBoolean).apply();
  }
  
  private static void setUserPropertyIfRequired(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ("1".equals(paramBundle.getString("google.c.a.tc")))
    {
      AnalyticsConnector localAnalyticsConnector = (AnalyticsConnector)FirebaseApp.getInstance().get(AnalyticsConnector.class);
      if (Log.isLoggable("FirebaseMessaging", 3)) {
        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
      }
      if (localAnalyticsConnector != null)
      {
        paramBundle = paramBundle.getString("google.c.a.c_id");
        localAnalyticsConnector.setUserProperty("fcm", "_ln", paramBundle);
        Bundle localBundle = new Bundle();
        localBundle.putString("source", "Firebase");
        localBundle.putString("medium", "notification");
        localBundle.putString("campaign", paramBundle);
        localAnalyticsConnector.logEvent("fcm", "_cmp", localBundle);
        return;
      }
      Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
      return;
    }
    if (Log.isLoggable("FirebaseMessaging", 3)) {
      Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
    }
  }
  
  public static boolean shouldUploadFirelogAnalytics(@NonNull Intent paramIntent)
  {
    if ((paramIntent != null) && (!isDirectBootMessage(paramIntent))) {
      return deliveryMetricsExportToBigQueryEnabled();
    }
    return false;
  }
  
  public static boolean shouldUploadScionMetrics(@NonNull Intent paramIntent)
  {
    if ((paramIntent != null) && (!isDirectBootMessage(paramIntent))) {
      return shouldUploadScionMetrics(paramIntent.getExtras());
    }
    return false;
  }
  
  public static boolean shouldUploadScionMetrics(@NonNull Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    return "1".equals(paramBundle.getString("google.c.a.e"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\MessagingAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */