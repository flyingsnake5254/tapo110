package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.Builder;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class DisplayNotification
{
  private final Context context;
  private final Executor networkIoExecutor;
  private final NotificationParams params;
  
  public DisplayNotification(Context paramContext, NotificationParams paramNotificationParams, Executor paramExecutor)
  {
    this.networkIoExecutor = paramExecutor;
    this.context = paramContext;
    this.params = paramNotificationParams;
  }
  
  private boolean isAppForeground()
  {
    if (((KeyguardManager)this.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    if (!PlatformVersion.isAtLeastLollipop()) {
      SystemClock.sleep(10L);
    }
    int i = Process.myPid();
    Object localObject = ((ActivityManager)this.context.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
          if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void showNotification(CommonNotificationBuilder.DisplayNotificationInfo paramDisplayNotificationInfo)
  {
    if (Log.isLoggable("FirebaseMessaging", 3)) {
      Log.d("FirebaseMessaging", "Showing notification");
    }
    ((NotificationManager)this.context.getSystemService("notification")).notify(paramDisplayNotificationInfo.tag, paramDisplayNotificationInfo.id, paramDisplayNotificationInfo.notificationBuilder.build());
  }
  
  @Nullable
  private ImageDownload startImageDownloadInBackground()
  {
    ImageDownload localImageDownload = ImageDownload.create(this.params.getString("gcm.n.image"));
    if (localImageDownload != null) {
      localImageDownload.start(this.networkIoExecutor);
    }
    return localImageDownload;
  }
  
  private void waitForAndApplyImageDownload(NotificationCompat.Builder paramBuilder, @Nullable ImageDownload paramImageDownload)
  {
    if (paramImageDownload == null) {
      return;
    }
    try
    {
      Bitmap localBitmap = (Bitmap)Tasks.await(paramImageDownload.getTask(), 5L, TimeUnit.SECONDS);
      paramBuilder.setLargeIcon(localBitmap);
      NotificationCompat.BigPictureStyle localBigPictureStyle = new androidx/core/app/NotificationCompat$BigPictureStyle;
      localBigPictureStyle.<init>();
      paramBuilder.setStyle(localBigPictureStyle.bigPicture(localBitmap).bigLargeIcon(null));
      return;
    }
    catch (TimeoutException paramBuilder)
    {
      Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
      paramImageDownload.close();
      return;
    }
    catch (InterruptedException paramBuilder)
    {
      Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
      paramImageDownload.close();
      Thread.currentThread().interrupt();
      return;
    }
    catch (ExecutionException paramBuilder)
    {
      paramImageDownload = String.valueOf(paramBuilder.getCause());
      paramBuilder = new StringBuilder(paramImageDownload.length() + 26);
      paramBuilder.append("Failed to download image: ");
      paramBuilder.append(paramImageDownload);
      Log.w("FirebaseMessaging", paramBuilder.toString());
    }
  }
  
  boolean handleNotification()
  {
    if (this.params.getBoolean("gcm.n.noui")) {
      return true;
    }
    if (isAppForeground()) {
      return false;
    }
    ImageDownload localImageDownload = startImageDownloadInBackground();
    CommonNotificationBuilder.DisplayNotificationInfo localDisplayNotificationInfo = CommonNotificationBuilder.createNotificationInfo(this.context, this.params);
    waitForAndApplyImageDownload(localDisplayNotificationInfo.notificationBuilder, localImageDownload);
    showNotification(localDisplayNotificationInfo);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\DisplayNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */