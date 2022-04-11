package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class SyncTask
  implements Runnable
{
  private final FirebaseMessaging firebaseMessaging;
  private final long nextDelaySeconds;
  @VisibleForTesting
  ExecutorService processorExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
  private final PowerManager.WakeLock syncWakeLock;
  
  @SuppressLint({"InvalidWakeLockTag"})
  @VisibleForTesting
  public SyncTask(FirebaseMessaging paramFirebaseMessaging, long paramLong)
  {
    this.firebaseMessaging = paramFirebaseMessaging;
    this.nextDelaySeconds = paramLong;
    paramFirebaseMessaging = ((PowerManager)getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.syncWakeLock = paramFirebaseMessaging;
    paramFirebaseMessaging.setReferenceCounted(false);
  }
  
  static boolean isDebugLogEnabled()
  {
    boolean bool1 = Log.isLoggable("FirebaseMessaging", 3);
    boolean bool2 = false;
    if (!bool1)
    {
      if (Build.VERSION.SDK_INT != 23) {
        return bool2;
      }
      if (!Log.isLoggable("FirebaseMessaging", 3)) {
        return false;
      }
    }
    bool2 = true;
    return bool2;
  }
  
  Context getContext()
  {
    return this.firebaseMessaging.getApplicationContext();
  }
  
  boolean isDeviceConnected()
  {
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    if (localObject != null) {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } else {
      localObject = null;
    }
    return (localObject != null) && (((NetworkInfo)localObject).isConnected());
  }
  
  @VisibleForTesting
  boolean maybeRefreshToken()
    throws IOException
  {
    try
    {
      if (this.firebaseMessaging.blockingGetToken() == null)
      {
        Log.e("FirebaseMessaging", "Token retrieval failed: null");
        return false;
      }
      if (Log.isLoggable("FirebaseMessaging", 3)) {
        Log.d("FirebaseMessaging", "Token successfully retrieved");
      }
      return true;
    }
    catch (SecurityException localSecurityException)
    {
      Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
      return false;
    }
    catch (IOException localIOException)
    {
      String str;
      if (GmsRpc.isErrorMessageForRetryableError(localIOException.getMessage()))
      {
        str = localIOException.getMessage();
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 52);
        localStringBuilder.append("Token retrieval failed: ");
        localStringBuilder.append(str);
        localStringBuilder.append(". Will retry token retrieval");
        Log.w("FirebaseMessaging", localStringBuilder.toString());
        return false;
      }
      if (str.getMessage() == null)
      {
        Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
        return false;
      }
      throw str;
    }
  }
  
  /* Error */
  @SuppressLint({"WakelockTimeout"})
  public void run()
  {
    // Byte code:
    //   0: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   3: aload_0
    //   4: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   7: invokevirtual 197	com/google/firebase/messaging/ServiceStarter:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 77	com/google/firebase/messaging/SyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   17: invokevirtual 200	android/os/PowerManager$WakeLock:acquire	()V
    //   20: aload_0
    //   21: getfield 53	com/google/firebase/messaging/SyncTask:firebaseMessaging	Lcom/google/firebase/messaging/FirebaseMessaging;
    //   24: iconst_1
    //   25: invokevirtual 203	com/google/firebase/messaging/FirebaseMessaging:setSyncScheduledOrRunning	(Z)V
    //   28: aload_0
    //   29: getfield 53	com/google/firebase/messaging/SyncTask:firebaseMessaging	Lcom/google/firebase/messaging/FirebaseMessaging;
    //   32: invokevirtual 206	com/google/firebase/messaging/FirebaseMessaging:isGmsCorePresent	()Z
    //   35: ifne +32 -> 67
    //   38: aload_0
    //   39: getfield 53	com/google/firebase/messaging/SyncTask:firebaseMessaging	Lcom/google/firebase/messaging/FirebaseMessaging;
    //   42: iconst_0
    //   43: invokevirtual 203	com/google/firebase/messaging/FirebaseMessaging:setSyncScheduledOrRunning	(Z)V
    //   46: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   49: aload_0
    //   50: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   53: invokevirtual 197	com/google/firebase/messaging/ServiceStarter:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   56: ifeq +10 -> 66
    //   59: aload_0
    //   60: getfield 77	com/google/firebase/messaging/SyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   63: invokevirtual 209	android/os/PowerManager$WakeLock:release	()V
    //   66: return
    //   67: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   70: aload_0
    //   71: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   74: invokevirtual 212	com/google/firebase/messaging/ServiceStarter:hasAccessNetworkStatePermission	(Landroid/content/Context;)Z
    //   77: ifeq +40 -> 117
    //   80: aload_0
    //   81: invokevirtual 214	com/google/firebase/messaging/SyncTask:isDeviceConnected	()Z
    //   84: ifne +33 -> 117
    //   87: new 8	com/google/firebase/messaging/SyncTask$ConnectivityChangeReceiver
    //   90: astore_1
    //   91: aload_1
    //   92: aload_0
    //   93: invokespecial 217	com/google/firebase/messaging/SyncTask$ConnectivityChangeReceiver:<init>	(Lcom/google/firebase/messaging/SyncTask;)V
    //   96: aload_1
    //   97: invokevirtual 220	com/google/firebase/messaging/SyncTask$ConnectivityChangeReceiver:registerReceiver	()V
    //   100: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   103: aload_0
    //   104: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   107: invokevirtual 197	com/google/firebase/messaging/ServiceStarter:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   110: ifeq +6 -> 116
    //   113: goto -54 -> 59
    //   116: return
    //   117: aload_0
    //   118: invokevirtual 222	com/google/firebase/messaging/SyncTask:maybeRefreshToken	()Z
    //   121: ifeq +14 -> 135
    //   124: aload_0
    //   125: getfield 53	com/google/firebase/messaging/SyncTask:firebaseMessaging	Lcom/google/firebase/messaging/FirebaseMessaging;
    //   128: iconst_0
    //   129: invokevirtual 203	com/google/firebase/messaging/FirebaseMessaging:setSyncScheduledOrRunning	(Z)V
    //   132: goto +14 -> 146
    //   135: aload_0
    //   136: getfield 53	com/google/firebase/messaging/SyncTask:firebaseMessaging	Lcom/google/firebase/messaging/FirebaseMessaging;
    //   139: aload_0
    //   140: getfield 55	com/google/firebase/messaging/SyncTask:nextDelaySeconds	J
    //   143: invokevirtual 226	com/google/firebase/messaging/FirebaseMessaging:syncWithDelaySecondsInternal	(J)V
    //   146: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   149: aload_0
    //   150: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   153: invokevirtual 197	com/google/firebase/messaging/ServiceStarter:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   156: ifeq +90 -> 246
    //   159: goto -100 -> 59
    //   162: astore_1
    //   163: goto +84 -> 247
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_1
    //   173: invokestatic 164	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokevirtual 168	java/lang/String:length	()I
    //   179: istore_2
    //   180: new 158	java/lang/StringBuilder
    //   183: astore_3
    //   184: aload_3
    //   185: iload_2
    //   186: bipush 93
    //   188: iadd
    //   189: invokespecial 171	java/lang/StringBuilder:<init>	(I)V
    //   192: aload_3
    //   193: ldc -28
    //   195: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_3
    //   200: aload_1
    //   201: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_3
    //   206: ldc -26
    //   208: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 91
    //   214: aload_3
    //   215: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: aload_0
    //   223: getfield 53	com/google/firebase/messaging/SyncTask:firebaseMessaging	Lcom/google/firebase/messaging/FirebaseMessaging;
    //   226: iconst_0
    //   227: invokevirtual 203	com/google/firebase/messaging/FirebaseMessaging:setSyncScheduledOrRunning	(Z)V
    //   230: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   233: aload_0
    //   234: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   237: invokevirtual 197	com/google/firebase/messaging/ServiceStarter:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   240: ifeq +6 -> 246
    //   243: goto -184 -> 59
    //   246: return
    //   247: invokestatic 193	com/google/firebase/messaging/ServiceStarter:getInstance	()Lcom/google/firebase/messaging/ServiceStarter;
    //   250: aload_0
    //   251: invokevirtual 59	com/google/firebase/messaging/SyncTask:getContext	()Landroid/content/Context;
    //   254: invokevirtual 197	com/google/firebase/messaging/ServiceStarter:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   257: ifne +6 -> 263
    //   260: goto +10 -> 270
    //   263: aload_0
    //   264: getfield 77	com/google/firebase/messaging/SyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   267: invokevirtual 209	android/os/PowerManager$WakeLock:release	()V
    //   270: aload_1
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	SyncTask
    //   90	7	1	localConnectivityChangeReceiver	ConnectivityChangeReceiver
    //   162	1	1	localObject	Object
    //   166	2	1	localIOException	IOException
    //   171	100	1	str	String
    //   179	10	2	i	int
    //   183	32	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	46	162	finally
    //   67	100	162	finally
    //   117	132	162	finally
    //   135	146	162	finally
    //   167	230	162	finally
    //   20	46	166	java/io/IOException
    //   67	100	166	java/io/IOException
    //   117	132	166	java/io/IOException
    //   135	146	166	java/io/IOException
  }
  
  @VisibleForTesting
  static class ConnectivityChangeReceiver
    extends BroadcastReceiver
  {
    @Nullable
    private SyncTask task;
    
    public ConnectivityChangeReceiver(SyncTask paramSyncTask)
    {
      this.task = paramSyncTask;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = this.task;
      if (paramContext == null) {
        return;
      }
      if (!paramContext.isDeviceConnected()) {
        return;
      }
      if (SyncTask.isDebugLogEnabled()) {
        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
      }
      this.task.firebaseMessaging.enqueueTaskWithDelaySeconds(this.task, 0L);
      this.task.getContext().unregisterReceiver(this);
      this.task = null;
    }
    
    public void registerReceiver()
    {
      if (SyncTask.isDebugLogEnabled()) {
        Log.d("FirebaseMessaging", "Connectivity change received registered");
      }
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.task.getContext().registerReceiver(this, localIntentFilter);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\SyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */