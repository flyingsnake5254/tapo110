package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class FirebaseMessagingService
  extends EnhancedIntentService
{
  @NonNull
  public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
  private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);
  
  private boolean alreadyReceivedMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Queue localQueue = recentlyReceivedMessageIds;
    if (localQueue.contains(paramString))
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Received duplicate message: ".concat(paramString);
        } else {
          paramString = new String("Received duplicate message: ");
        }
        Log.d("FirebaseMessaging", paramString);
      }
      return true;
    }
    if (localQueue.size() >= 10) {
      localQueue.remove();
    }
    localQueue.add(paramString);
    return false;
  }
  
  private void dispatchMessage(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getExtras();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new Bundle();
    }
    ((Bundle)localObject2).remove("androidx.content.wakelockid");
    Object localObject3;
    if (NotificationParams.isNotification((Bundle)localObject2))
    {
      localObject3 = new NotificationParams((Bundle)localObject2);
      localObject1 = FcmExecutors.newNetworkIOExecutor();
      localObject3 = new DisplayNotification(this, (NotificationParams)localObject3, (Executor)localObject1);
    }
    try
    {
      boolean bool = ((DisplayNotification)localObject3).handleNotification();
      if (bool) {
        return;
      }
      ((ExecutorService)localObject1).shutdown();
      if (MessagingAnalytics.shouldUploadScionMetrics(paramIntent)) {
        MessagingAnalytics.logNotificationForeground(paramIntent);
      }
    }
    finally
    {
      ((ExecutorService)localObject1).shutdown();
    }
  }
  
  private String getMessageId(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("google.message_id");
    if (str == null) {
      return paramIntent.getStringExtra("message_id");
    }
    return str;
  }
  
  private void handleMessageIntent(Intent paramIntent)
  {
    if (!alreadyReceivedMessage(paramIntent.getStringExtra("google.message_id"))) {
      passMessageIntentToSdk(paramIntent);
    }
  }
  
  private void passMessageIntentToSdk(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("message_type");
    String str2 = str1;
    if (str1 == null) {
      str2 = "gcm";
    }
    switch (str2.hashCode())
    {
    default: 
      break;
    case 814800675: 
      if (str2.equals("send_event")) {
        i = 2;
      }
      break;
    case 814694033: 
      if (str2.equals("send_error")) {
        i = 3;
      }
      break;
    case 102161: 
      if (str2.equals("gcm")) {
        i = 0;
      }
      break;
    case -2062414158: 
      if (str2.equals("deleted_messages")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (str2.length() != 0) {
              paramIntent = "Received message with unknown type: ".concat(str2);
            } else {
              paramIntent = new String("Received message with unknown type: ");
            }
            Log.w("FirebaseMessaging", paramIntent);
            return;
          }
          onSendError(getMessageId(paramIntent), new SendException(paramIntent.getStringExtra("error")));
          return;
        }
        onMessageSent(paramIntent.getStringExtra("google.message_id"));
        return;
      }
      onDeletedMessages();
      return;
    }
    MessagingAnalytics.logNotificationReceived(paramIntent);
    dispatchMessage(paramIntent);
  }
  
  @NonNull
  protected Intent getStartCommandIntent(@NonNull Intent paramIntent)
  {
    return ServiceStarter.getInstance().getMessagingEvent();
  }
  
  public void handleIntent(@NonNull Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!"com.google.android.c2dm.intent.RECEIVE".equals(str)) && (!"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(str)))
    {
      if ("com.google.firebase.messaging.NEW_TOKEN".equals(str))
      {
        onNewToken(paramIntent.getStringExtra("token"));
        return;
      }
      paramIntent = String.valueOf(paramIntent.getAction());
      if (paramIntent.length() != 0) {
        paramIntent = "Unknown intent action: ".concat(paramIntent);
      } else {
        paramIntent = new String("Unknown intent action: ");
      }
      Log.d("FirebaseMessaging", paramIntent);
      return;
    }
    handleMessageIntent(paramIntent);
  }
  
  @WorkerThread
  public void onDeletedMessages() {}
  
  @WorkerThread
  public void onMessageReceived(@NonNull RemoteMessage paramRemoteMessage) {}
  
  @WorkerThread
  public void onMessageSent(@NonNull String paramString) {}
  
  @WorkerThread
  public void onNewToken(@NonNull String paramString) {}
  
  @WorkerThread
  public void onSendError(@NonNull String paramString, @NonNull Exception paramException) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\FirebaseMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */