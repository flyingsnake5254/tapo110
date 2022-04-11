package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.content.ContextCompat;
import java.util.concurrent.atomic.AtomicInteger;

public final class CommonNotificationBuilder
{
  @NonNull
  public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL = "fcm_fallback_notification_channel";
  @NonNull
  public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL = "fcm_fallback_notification_channel_label";
  @NonNull
  public static final String METADATA_DEFAULT_CHANNEL_ID = "com.google.firebase.messaging.default_notification_channel_id";
  @NonNull
  public static final String METADATA_DEFAULT_COLOR = "com.google.firebase.messaging.default_notification_color";
  @NonNull
  public static final String METADATA_DEFAULT_ICON = "com.google.firebase.messaging.default_notification_icon";
  private static final AtomicInteger requestCodeProvider = new AtomicInteger((int)SystemClock.elapsedRealtime());
  
  @Nullable
  private static PendingIntent createContentIntent(Context paramContext, NotificationParams paramNotificationParams, String paramString, PackageManager paramPackageManager)
  {
    paramString = createTargetIntent(paramString, paramNotificationParams, paramPackageManager);
    if (paramString == null) {
      return null;
    }
    paramString.addFlags(67108864);
    paramString.putExtras(paramNotificationParams.paramsWithReservedKeysRemoved());
    if (shouldUploadMetrics(paramNotificationParams)) {
      paramString.putExtra("gcm.n.analytics_data", paramNotificationParams.paramsForAnalyticsIntent());
    }
    return PendingIntent.getActivity(paramContext, generatePendingIntentRequestCode(), paramString, getPendingIntentFlags(1073741824));
  }
  
  @Nullable
  private static PendingIntent createDeleteIntent(Context paramContext, NotificationParams paramNotificationParams)
  {
    if (!shouldUploadMetrics(paramNotificationParams)) {
      return null;
    }
    return createMessagingPendingIntent(paramContext, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(paramNotificationParams.paramsForAnalyticsIntent()));
  }
  
  private static PendingIntent createMessagingPendingIntent(Context paramContext, Intent paramIntent)
  {
    return PendingIntent.getBroadcast(paramContext, generatePendingIntentRequestCode(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(paramContext, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", paramIntent), getPendingIntentFlags(1073741824));
  }
  
  static DisplayNotificationInfo createNotificationInfo(Context paramContext, NotificationParams paramNotificationParams)
  {
    Bundle localBundle = getManifestMetadata(paramContext.getPackageManager(), paramContext.getPackageName());
    return createNotificationInfo(paramContext, paramContext.getPackageName(), paramNotificationParams, getOrCreateChannel(paramContext, paramNotificationParams.getNotificationChannelId(), localBundle), paramContext.getResources(), paramContext.getPackageManager(), localBundle);
  }
  
  @NonNull
  public static DisplayNotificationInfo createNotificationInfo(@NonNull Context paramContext, @NonNull String paramString1, @NonNull NotificationParams paramNotificationParams, @NonNull String paramString2, @NonNull Resources paramResources, @NonNull PackageManager paramPackageManager, @NonNull Bundle paramBundle)
  {
    paramString2 = new NotificationCompat.Builder(paramContext, paramString2);
    String str = paramNotificationParams.getPossiblyLocalizedString(paramResources, paramString1, "gcm.n.title");
    if (!TextUtils.isEmpty(str)) {
      paramString2.setContentTitle(str);
    }
    str = paramNotificationParams.getPossiblyLocalizedString(paramResources, paramString1, "gcm.n.body");
    if (!TextUtils.isEmpty(str))
    {
      paramString2.setContentText(str);
      paramString2.setStyle(new NotificationCompat.BigTextStyle().bigText(str));
    }
    paramString2.setSmallIcon(getSmallIcon(paramPackageManager, paramResources, paramString1, paramNotificationParams.getString("gcm.n.icon"), paramBundle));
    paramResources = getSound(paramString1, paramNotificationParams, paramResources);
    if (paramResources != null) {
      paramString2.setSound(paramResources);
    }
    paramString2.setContentIntent(createContentIntent(paramContext, paramNotificationParams, paramString1, paramPackageManager));
    paramString1 = createDeleteIntent(paramContext, paramNotificationParams);
    if (paramString1 != null) {
      paramString2.setDeleteIntent(paramString1);
    }
    paramContext = getColor(paramContext, paramNotificationParams.getString("gcm.n.color"), paramBundle);
    if (paramContext != null) {
      paramString2.setColor(paramContext.intValue());
    }
    paramString2.setAutoCancel(paramNotificationParams.getBoolean("gcm.n.sticky") ^ true);
    paramString2.setLocalOnly(paramNotificationParams.getBoolean("gcm.n.local_only"));
    paramContext = paramNotificationParams.getString("gcm.n.ticker");
    if (paramContext != null) {
      paramString2.setTicker(paramContext);
    }
    paramContext = paramNotificationParams.getNotificationPriority();
    if (paramContext != null) {
      paramString2.setPriority(paramContext.intValue());
    }
    paramContext = paramNotificationParams.getVisibility();
    if (paramContext != null) {
      paramString2.setVisibility(paramContext.intValue());
    }
    paramContext = paramNotificationParams.getNotificationCount();
    if (paramContext != null) {
      paramString2.setNumber(paramContext.intValue());
    }
    paramContext = paramNotificationParams.getLong("gcm.n.event_time");
    if (paramContext != null)
    {
      paramString2.setShowWhen(true);
      paramString2.setWhen(paramContext.longValue());
    }
    paramContext = paramNotificationParams.getVibrateTimings();
    if (paramContext != null) {
      paramString2.setVibrate(paramContext);
    }
    paramContext = paramNotificationParams.getLightSettings();
    if (paramContext != null) {
      paramString2.setLights(paramContext[0], paramContext[1], paramContext[2]);
    }
    paramString2.setDefaults(getConsolidatedDefaults(paramNotificationParams));
    return new DisplayNotificationInfo(paramString2, getTag(paramNotificationParams), 0);
  }
  
  private static Intent createTargetIntent(String paramString, NotificationParams paramNotificationParams, PackageManager paramPackageManager)
  {
    String str = paramNotificationParams.getString("gcm.n.click_action");
    if (!TextUtils.isEmpty(str))
    {
      paramNotificationParams = new Intent(str);
      paramNotificationParams.setPackage(paramString);
      paramNotificationParams.setFlags(268435456);
      return paramNotificationParams;
    }
    paramNotificationParams = paramNotificationParams.getLink();
    if (paramNotificationParams != null)
    {
      paramPackageManager = new Intent("android.intent.action.VIEW");
      paramPackageManager.setPackage(paramString);
      paramPackageManager.setData(paramNotificationParams);
      return paramPackageManager;
    }
    paramString = paramPackageManager.getLaunchIntentForPackage(paramString);
    if (paramString == null) {
      Log.w("FirebaseMessaging", "No activity found to launch app");
    }
    return paramString;
  }
  
  private static int generatePendingIntentRequestCode()
  {
    return requestCodeProvider.incrementAndGet();
  }
  
  private static Integer getColor(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        i = Color.parseColor(paramString);
        return Integer.valueOf(i);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 56);
        localStringBuilder.append("Color is invalid: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(". Notification will use default color.");
        Log.w("FirebaseMessaging", localStringBuilder.toString());
      }
    }
    int i = paramBundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
    if (i != 0) {
      try
      {
        i = ContextCompat.getColor(paramContext, i);
        return Integer.valueOf(i);
      }
      catch (Resources.NotFoundException paramContext)
      {
        Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
      }
    }
    return null;
  }
  
  private static int getConsolidatedDefaults(NotificationParams paramNotificationParams)
  {
    boolean bool1 = paramNotificationParams.getBoolean("gcm.n.default_sound");
    boolean bool2 = bool1;
    int i;
    if (paramNotificationParams.getBoolean("gcm.n.default_vibrate_timings")) {
      i = bool1 | true;
    }
    if (paramNotificationParams.getBoolean("gcm.n.default_light_settings")) {
      return i | 0x4;
    }
    return i;
  }
  
  private static Bundle getManifestMetadata(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      paramPackageManager = paramPackageManager.getApplicationInfo(paramString, 128);
      if (paramPackageManager != null)
      {
        paramPackageManager = paramPackageManager.metaData;
        if (paramPackageManager != null) {
          return paramPackageManager;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      paramString = String.valueOf(paramPackageManager);
      paramPackageManager = new StringBuilder(paramString.length() + 35);
      paramPackageManager.append("Couldn't get own application info: ");
      paramPackageManager.append(paramString);
      Log.w("FirebaseMessaging", paramPackageManager.toString());
    }
    return Bundle.EMPTY;
  }
  
  @TargetApi(26)
  @NonNull
  @VisibleForTesting
  public static String getOrCreateChannel(@NonNull Context paramContext, @NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return null;
    }
    try
    {
      int i = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).targetSdkVersion;
      if (i >= 26)
      {
        NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(NotificationManager.class);
        if (!TextUtils.isEmpty(paramString))
        {
          if (localNotificationManager.getNotificationChannel(paramString) != null) {
            return paramString;
          }
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 122);
          localStringBuilder.append("Notification Channel requested (");
          localStringBuilder.append(paramString);
          localStringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
          Log.w("FirebaseMessaging", localStringBuilder.toString());
        }
        paramString = paramBundle.getString("com.google.firebase.messaging.default_notification_channel_id");
        if (!TextUtils.isEmpty(paramString))
        {
          if (localNotificationManager.getNotificationChannel(paramString) != null) {
            return paramString;
          }
          Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
        }
        else
        {
          Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
        }
        if (localNotificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null)
        {
          i = paramContext.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", paramContext.getPackageName());
          if (i == 0)
          {
            Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
            paramContext = "Misc";
          }
          else
          {
            paramContext = paramContext.getString(i);
          }
          localNotificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", paramContext, 3));
        }
        return "fcm_fallback_notification_channel";
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static int getPendingIntentFlags(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return 1140850688;
    }
    return 1073741824;
  }
  
  private static int getSmallIcon(PackageManager paramPackageManager, Resources paramResources, String paramString1, String paramString2, Bundle paramBundle)
  {
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      i = paramResources.getIdentifier(paramString2, "drawable", paramString1);
      if ((i != 0) && (isValidIcon(paramResources, i))) {
        return i;
      }
      i = paramResources.getIdentifier(paramString2, "mipmap", paramString1);
      if ((i != 0) && (isValidIcon(paramResources, i))) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 61);
      localStringBuilder.append("Icon resource ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" not found. Notification will use default icon.");
      Log.w("FirebaseMessaging", localStringBuilder.toString());
    }
    int j = paramBundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
    if (j != 0)
    {
      i = j;
      if (isValidIcon(paramResources, j)) {}
    }
    else
    {
      try
      {
        i = paramPackageManager.getApplicationInfo(paramString1, 0).icon;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        paramString1 = String.valueOf(paramPackageManager);
        paramPackageManager = new StringBuilder(paramString1.length() + 35);
        paramPackageManager.append("Couldn't get own application info: ");
        paramPackageManager.append(paramString1);
        Log.w("FirebaseMessaging", paramPackageManager.toString());
        i = j;
      }
    }
    if (i != 0)
    {
      j = i;
      if (!isValidIcon(paramResources, i)) {
        return 17301651;
      }
    }
    else
    {
      j = 17301651;
    }
    return j;
  }
  
  private static Uri getSound(String paramString, NotificationParams paramNotificationParams, Resources paramResources)
  {
    paramNotificationParams = paramNotificationParams.getSoundResourceName();
    if (TextUtils.isEmpty(paramNotificationParams)) {
      return null;
    }
    if ((!"default".equals(paramNotificationParams)) && (paramResources.getIdentifier(paramNotificationParams, "raw", paramString) != 0))
    {
      paramResources = new StringBuilder(String.valueOf(paramString).length() + 24 + String.valueOf(paramNotificationParams).length());
      paramResources.append("android.resource://");
      paramResources.append(paramString);
      paramResources.append("/raw/");
      paramResources.append(paramNotificationParams);
      return Uri.parse(paramResources.toString());
    }
    return RingtoneManager.getDefaultUri(2);
  }
  
  private static String getTag(NotificationParams paramNotificationParams)
  {
    paramNotificationParams = paramNotificationParams.getString("gcm.n.tag");
    if (!TextUtils.isEmpty(paramNotificationParams)) {
      return paramNotificationParams;
    }
    long l = SystemClock.uptimeMillis();
    paramNotificationParams = new StringBuilder(37);
    paramNotificationParams.append("FCM-Notification:");
    paramNotificationParams.append(l);
    return paramNotificationParams.toString();
  }
  
  @TargetApi(26)
  private static boolean isValidIcon(Resources paramResources, int paramInt)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return true;
    }
    try
    {
      if ((paramResources.getDrawable(paramInt, null) instanceof AdaptiveIconDrawable))
      {
        paramResources = new java/lang/StringBuilder;
        paramResources.<init>(77);
        paramResources.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
        paramResources.append(paramInt);
        Log.e("FirebaseMessaging", paramResources.toString());
        return false;
      }
      return true;
    }
    catch (Resources.NotFoundException paramResources)
    {
      paramResources = new StringBuilder(66);
      paramResources.append("Couldn't find resource ");
      paramResources.append(paramInt);
      paramResources.append(", treating it as an invalid icon");
      Log.e("FirebaseMessaging", paramResources.toString());
    }
    return false;
  }
  
  static boolean shouldUploadMetrics(@NonNull NotificationParams paramNotificationParams)
  {
    return paramNotificationParams.getBoolean("google.c.a.e");
  }
  
  public static class DisplayNotificationInfo
  {
    public final int id;
    @NonNull
    public final NotificationCompat.Builder notificationBuilder;
    @NonNull
    public final String tag;
    
    DisplayNotificationInfo(NotificationCompat.Builder paramBuilder, String paramString, int paramInt)
    {
      this.notificationBuilder = paramBuilder;
      this.tag = paramString;
      this.id = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\CommonNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */