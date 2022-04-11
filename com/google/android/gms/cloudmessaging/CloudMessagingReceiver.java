package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.internal.cloudmessaging.zzb;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class CloudMessagingReceiver
  extends BroadcastReceiver
{
  private final ExecutorService zza = zza.zza().zza(new NamedThreadFactory("firebase-iid-executor"), zzf.zza);
  
  @WorkerThread
  private final int zza(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
    if (localPendingIntent != null) {
      try
      {
        localPendingIntent.send();
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
      }
    }
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null) {
      localBundle.remove("pending_intent");
    } else {
      localBundle = new Bundle();
    }
    if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(paramIntent.getAction()))
    {
      onNotificationOpen(paramContext, localBundle);
    }
    else
    {
      if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(paramIntent.getAction())) {
        break label97;
      }
      onNotificationDismissed(paramContext, localBundle);
    }
    return -1;
    label97:
    Log.e("CloudMessagingReceiver", "Unknown notification action");
    return 500;
  }
  
  @WorkerThread
  private final int zzb(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    if (paramIntent.getExtras() == null) {
      return 500;
    }
    Object localObject = paramIntent.getStringExtra("google.message_id");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Tasks.forResult(null);
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("google.message_id", (String)localObject);
      localObject = zze.zza(paramContext).zza(2, localBundle);
    }
    int i = onMessageReceive(paramContext, new CloudMessage(paramIntent));
    try
    {
      Tasks.await((Task)localObject, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
    }
    catch (TimeoutException paramContext) {}catch (InterruptedException paramContext) {}catch (ExecutionException paramContext) {}
    paramContext = String.valueOf(paramContext);
    paramIntent = new StringBuilder(paramContext.length() + 20);
    paramIntent.append("Message ack failed: ");
    paramIntent.append(paramContext);
    Log.w("CloudMessagingReceiver", paramIntent.toString());
    return i;
  }
  
  @NonNull
  protected Executor getBroadcastExecutor()
  {
    return this.zza;
  }
  
  @WorkerThread
  protected abstract int onMessageReceive(@NonNull Context paramContext, @NonNull CloudMessage paramCloudMessage);
  
  @WorkerThread
  protected void onNotificationDismissed(@NonNull Context paramContext, @NonNull Bundle paramBundle) {}
  
  @WorkerThread
  protected void onNotificationOpen(@NonNull Context paramContext, @NonNull Bundle paramBundle) {}
  
  public final void onReceive(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    boolean bool = isOrderedBroadcast();
    BroadcastReceiver.PendingResult localPendingResult = goAsync();
    getBroadcastExecutor().execute(new zzd(this, paramIntent, paramContext, bool, localPendingResult));
  }
  
  public static final class IntentActionKeys
  {
    @NonNull
    public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
    @NonNull
    public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";
  }
  
  public static final class IntentKeys
  {
    @NonNull
    public static final String PENDING_INTENT = "pending_intent";
    @NonNull
    public static final String WRAPPED_INTENT = "wrapped_intent";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\CloudMessagingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */