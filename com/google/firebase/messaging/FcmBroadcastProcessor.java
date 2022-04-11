package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class FcmBroadcastProcessor
{
  @GuardedBy("lock")
  private static WithinAppServiceConnection fcmServiceConn;
  private static final Object lock = new Object();
  private final Context context;
  private final Executor executor;
  
  public FcmBroadcastProcessor(@NonNull Context paramContext)
  {
    this.context = paramContext;
    this.executor = FcmBroadcastProcessor..Lambda.0.$instance;
  }
  
  public FcmBroadcastProcessor(@NonNull Context paramContext, @NonNull ExecutorService paramExecutorService)
  {
    this.context = paramContext;
    this.executor = paramExecutorService;
  }
  
  private static Task<Integer> bindToMessagingService(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("FirebaseMessaging", 3)) {
      Log.d("FirebaseMessaging", "Binding to service");
    }
    return getServiceConnection(paramContext, "com.google.firebase.MESSAGING_EVENT").sendIntent(paramIntent).continueWith(FcmBroadcastProcessor..Lambda.3.$instance, FcmBroadcastProcessor..Lambda.4.$instance);
  }
  
  private static WithinAppServiceConnection getServiceConnection(Context paramContext, String arg1)
  {
    synchronized (lock)
    {
      if (fcmServiceConn == null)
      {
        WithinAppServiceConnection localWithinAppServiceConnection = new com/google/firebase/messaging/WithinAppServiceConnection;
        localWithinAppServiceConnection.<init>(paramContext, "com.google.firebase.MESSAGING_EVENT");
        fcmServiceConn = localWithinAppServiceConnection;
      }
      paramContext = fcmServiceConn;
      return paramContext;
    }
  }
  
  @VisibleForTesting
  public static void reset()
  {
    synchronized (lock)
    {
      fcmServiceConn = null;
      return;
    }
  }
  
  @NonNull
  @KeepForSdk
  public Task<Integer> process(@NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("gcm.rawData64");
    if (str != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    return startMessagingService(this.context, paramIntent);
  }
  
  @SuppressLint({"InlinedApi"})
  @NonNull
  public Task<Integer> startMessagingService(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    boolean bool = PlatformVersion.isAtLeastO();
    int i = 0;
    int j = i;
    if (bool)
    {
      j = i;
      if (paramContext.getApplicationInfo().targetSdkVersion >= 26) {
        j = 1;
      }
    }
    i = paramIntent.getFlags();
    if ((j != 0) && ((i & 0x10000000) == 0)) {
      return bindToMessagingService(paramContext, paramIntent);
    }
    return Tasks.call(this.executor, new FcmBroadcastProcessor..Lambda.1(paramContext, paramIntent)).continueWithTask(this.executor, new FcmBroadcastProcessor..Lambda.2(paramContext, paramIntent));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\FcmBroadcastProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */