package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

public final class FirebaseInstanceIdReceiver
  extends CloudMessagingReceiver
{
  @WorkerThread
  protected final int onMessageReceive(@NonNull Context paramContext, @NonNull CloudMessage paramCloudMessage)
  {
    try
    {
      FcmBroadcastProcessor localFcmBroadcastProcessor = new com/google/firebase/messaging/FcmBroadcastProcessor;
      localFcmBroadcastProcessor.<init>(paramContext);
      int i = ((Integer)Tasks.await(localFcmBroadcastProcessor.process(paramCloudMessage.getIntent()))).intValue();
      return i;
    }
    catch (InterruptedException paramContext) {}catch (ExecutionException paramContext) {}
    Log.e("FirebaseMessaging", "Failed to send message to service.", paramContext);
    return 500;
  }
  
  @WorkerThread
  protected final void onNotificationDismissed(@NonNull Context paramContext, @NonNull Bundle paramBundle)
  {
    paramContext = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(paramBundle);
    if (MessagingAnalytics.shouldUploadScionMetrics(paramContext)) {
      MessagingAnalytics.logNotificationDismiss(paramContext);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\iid\FirebaseInstanceIdReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */