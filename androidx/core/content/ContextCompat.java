package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class ContextCompat
{
  private static final String TAG = "ContextCompat";
  private static final Object sLock = new Object();
  private static TypedValue sTempValue;
  
  public static int checkSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    if (paramString != null) {
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    }
    throw new IllegalArgumentException("permission is null");
  }
  
  @Nullable
  public static Context createDeviceProtectedStorageContext(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.createDeviceProtectedStorageContext();
    }
    return null;
  }
  
  private static File createFilesDir(File paramFile)
  {
    try
    {
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        boolean bool = paramFile.exists();
        if (bool) {
          return paramFile;
        }
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Unable to create files subdir ");
        localStringBuilder.append(paramFile.getPath());
        Log.w("ContextCompat", localStringBuilder.toString());
        return null;
      }
      return paramFile;
    }
    finally {}
  }
  
  public static File getCodeCacheDir(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getCodeCacheDir();
    }
    return createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "code_cache"));
  }
  
  @ColorInt
  public static int getColor(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  @Nullable
  public static ColorStateList getColorStateList(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  @Nullable
  public static File getDataDir(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.getDataDir();
    }
    paramContext = paramContext.getApplicationInfo().dataDir;
    if (paramContext != null) {
      paramContext = new File(paramContext);
    } else {
      paramContext = null;
    }
    return paramContext;
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    if (i >= 16) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    synchronized (sLock)
    {
      if (sTempValue == null)
      {
        TypedValue localTypedValue = new android/util/TypedValue;
        localTypedValue.<init>();
        sTempValue = localTypedValue;
      }
      paramContext.getResources().getValue(paramInt, sTempValue, true);
      paramInt = sTempValue.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    }
  }
  
  @NonNull
  public static File[] getExternalCacheDirs(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  @NonNull
  public static File[] getExternalFilesDirs(@NonNull Context paramContext, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(paramString);
    }
    return new File[] { paramContext.getExternalFilesDir(paramString) };
  }
  
  public static Executor getMainExecutor(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramContext.getMainExecutor();
    }
    return new MainHandlerExecutor(new Handler(paramContext.getMainLooper()));
  }
  
  @Nullable
  public static File getNoBackupFilesDir(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getNoBackupFilesDir();
    }
    return createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }
  
  @NonNull
  public static File[] getObbDirs(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getObbDirs();
    }
    return new File[] { paramContext.getObbDir() };
  }
  
  @Nullable
  public static <T> T getSystemService(@NonNull Context paramContext, @NonNull Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return (T)paramContext.getSystemService(paramClass);
    }
    paramClass = getSystemServiceName(paramContext, paramClass);
    if (paramClass != null) {
      paramContext = paramContext.getSystemService(paramClass);
    } else {
      paramContext = null;
    }
    return paramContext;
  }
  
  @Nullable
  public static String getSystemServiceName(@NonNull Context paramContext, @NonNull Class<?> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getSystemServiceName(paramClass);
    }
    return (String)LegacyServiceMapHolder.SERVICES.get(paramClass);
  }
  
  public static boolean isDeviceProtectedStorage(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.isDeviceProtectedStorage();
    }
    return false;
  }
  
  public static boolean startActivities(@NonNull Context paramContext, @NonNull Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(@NonNull Context paramContext, @NonNull Intent[] paramArrayOfIntent, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
    } else {
      paramContext.startActivities(paramArrayOfIntent);
    }
    return true;
  }
  
  public static void startActivity(@NonNull Context paramContext, @NonNull Intent paramIntent, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivity(paramIntent, paramBundle);
    } else {
      paramContext.startActivity(paramIntent);
    }
  }
  
  public static void startForegroundService(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext.startForegroundService(paramIntent);
    } else {
      paramContext.startService(paramIntent);
    }
  }
  
  private static final class LegacyServiceMapHolder
  {
    static final HashMap<Class<?>, String> SERVICES;
    
    static
    {
      HashMap localHashMap = new HashMap();
      SERVICES = localHashMap;
      int i = Build.VERSION.SDK_INT;
      if (i >= 22)
      {
        localHashMap.put(SubscriptionManager.class, "telephony_subscription_service");
        localHashMap.put(UsageStatsManager.class, "usagestats");
      }
      if (i >= 21)
      {
        localHashMap.put(AppWidgetManager.class, "appwidget");
        localHashMap.put(BatteryManager.class, "batterymanager");
        localHashMap.put(CameraManager.class, "camera");
        localHashMap.put(JobScheduler.class, "jobscheduler");
        localHashMap.put(LauncherApps.class, "launcherapps");
        localHashMap.put(MediaProjectionManager.class, "media_projection");
        localHashMap.put(MediaSessionManager.class, "media_session");
        localHashMap.put(RestrictionsManager.class, "restrictions");
        localHashMap.put(TelecomManager.class, "telecom");
        localHashMap.put(TvInputManager.class, "tv_input");
      }
      if (i >= 19)
      {
        localHashMap.put(AppOpsManager.class, "appops");
        localHashMap.put(CaptioningManager.class, "captioning");
        localHashMap.put(ConsumerIrManager.class, "consumer_ir");
        localHashMap.put(PrintManager.class, "print");
      }
      if (i >= 18) {
        localHashMap.put(BluetoothManager.class, "bluetooth");
      }
      if (i >= 17)
      {
        localHashMap.put(DisplayManager.class, "display");
        localHashMap.put(UserManager.class, "user");
      }
      if (i >= 16)
      {
        localHashMap.put(InputManager.class, "input");
        localHashMap.put(MediaRouter.class, "media_router");
        localHashMap.put(NsdManager.class, "servicediscovery");
      }
      localHashMap.put(AccessibilityManager.class, "accessibility");
      localHashMap.put(AccountManager.class, "account");
      localHashMap.put(ActivityManager.class, "activity");
      localHashMap.put(AlarmManager.class, "alarm");
      localHashMap.put(AudioManager.class, "audio");
      localHashMap.put(ClipboardManager.class, "clipboard");
      localHashMap.put(ConnectivityManager.class, "connectivity");
      localHashMap.put(DevicePolicyManager.class, "device_policy");
      localHashMap.put(DownloadManager.class, "download");
      localHashMap.put(DropBoxManager.class, "dropbox");
      localHashMap.put(InputMethodManager.class, "input_method");
      localHashMap.put(KeyguardManager.class, "keyguard");
      localHashMap.put(LayoutInflater.class, "layout_inflater");
      localHashMap.put(LocationManager.class, "location");
      localHashMap.put(NfcManager.class, "nfc");
      localHashMap.put(NotificationManager.class, "notification");
      localHashMap.put(PowerManager.class, "power");
      localHashMap.put(SearchManager.class, "search");
      localHashMap.put(SensorManager.class, "sensor");
      localHashMap.put(StorageManager.class, "storage");
      localHashMap.put(TelephonyManager.class, "phone");
      localHashMap.put(TextServicesManager.class, "textservices");
      localHashMap.put(UiModeManager.class, "uimode");
      localHashMap.put(UsbManager.class, "usb");
      localHashMap.put(Vibrator.class, "vibrator");
      localHashMap.put(WallpaperManager.class, "wallpaper");
      localHashMap.put(WifiP2pManager.class, "wifip2p");
      localHashMap.put(WifiManager.class, "wifi");
      localHashMap.put(WindowManager.class, "window");
    }
  }
  
  private static class MainHandlerExecutor
    implements Executor
  {
    private final Handler mHandler;
    
    MainHandlerExecutor(@NonNull Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public void execute(Runnable paramRunnable)
    {
      if (this.mHandler.post(paramRunnable)) {
        return;
      }
      paramRunnable = new StringBuilder();
      paramRunnable.append(this.mHandler);
      paramRunnable.append(" is shutting down");
      throw new RejectedExecutionException(paramRunnable.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */