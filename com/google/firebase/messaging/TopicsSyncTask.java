package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

class TopicsSyncTask
  implements Runnable
{
  private static final Object TOPIC_SYNC_TASK_LOCK = new Object();
  @GuardedBy("TOPIC_SYNC_TASK_LOCK")
  private static Boolean hasAccessNetworkStatePermission;
  @GuardedBy("TOPIC_SYNC_TASK_LOCK")
  private static Boolean hasWakeLockPermission;
  private final Context context;
  private final Metadata metadata;
  private final long nextDelaySeconds;
  private final PowerManager.WakeLock syncWakeLock;
  private final TopicsSubscriber topicsSubscriber;
  
  TopicsSyncTask(TopicsSubscriber paramTopicsSubscriber, Context paramContext, Metadata paramMetadata, long paramLong)
  {
    this.topicsSubscriber = paramTopicsSubscriber;
    this.context = paramContext;
    this.nextDelaySeconds = paramLong;
    this.metadata = paramMetadata;
    this.syncWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
  }
  
  private static String createPermissionMissingLog(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 142);
    localStringBuilder.append("Missing Permission: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
    return localStringBuilder.toString();
  }
  
  private static boolean hasAccessNetworkStatePermission(Context paramContext)
  {
    synchronized (TOPIC_SYNC_TASK_LOCK)
    {
      Boolean localBoolean = hasAccessNetworkStatePermission;
      if (localBoolean == null) {
        bool = hasPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE", localBoolean);
      } else {
        bool = localBoolean.booleanValue();
      }
      paramContext = Boolean.valueOf(bool);
      hasAccessNetworkStatePermission = paramContext;
      boolean bool = paramContext.booleanValue();
      return bool;
    }
  }
  
  private static boolean hasPermission(Context paramContext, String paramString, Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      return paramBoolean.booleanValue();
    }
    boolean bool;
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (Log.isLoggable("FirebaseMessaging", 3)))
    {
      Log.d("FirebaseMessaging", createPermissionMissingLog(paramString));
      return false;
    }
    return bool;
  }
  
  private static boolean hasWakeLockPermission(Context paramContext)
  {
    synchronized (TOPIC_SYNC_TASK_LOCK)
    {
      Boolean localBoolean = hasWakeLockPermission;
      if (localBoolean == null) {
        bool = hasPermission(paramContext, "android.permission.WAKE_LOCK", localBoolean);
      } else {
        bool = localBoolean.booleanValue();
      }
      paramContext = Boolean.valueOf(bool);
      hasWakeLockPermission = paramContext;
      boolean bool = paramContext.booleanValue();
      return bool;
    }
  }
  
  /* Error */
  private boolean isDeviceConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   6: ldc -115
    //   8: invokevirtual 51	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11: checkcast 143	android/net/ConnectivityManager
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +11 -> 27
    //   19: aload_1
    //   20: invokevirtual 147	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   23: astore_1
    //   24: goto +5 -> 29
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +18 -> 48
    //   33: aload_1
    //   34: invokevirtual 152	android/net/NetworkInfo:isConnected	()Z
    //   37: istore_2
    //   38: iload_2
    //   39: ifeq +9 -> 48
    //   42: iconst_1
    //   43: istore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: iconst_0
    //   49: istore_2
    //   50: goto -6 -> 44
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	TopicsSyncTask
    //   14	20	1	localObject1	Object
    //   53	4	1	localObject2	Object
    //   37	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	53	finally
    //   19	24	53	finally
    //   33	38	53	finally
  }
  
  private static boolean isLoggable()
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
  
  /* Error */
  @android.annotation.SuppressLint({"Wakelock"})
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   4: invokestatic 167	com/google/firebase/messaging/TopicsSyncTask:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   7: ifeq +13 -> 20
    //   10: aload_0
    //   11: getfield 61	com/google/firebase/messaging/TopicsSyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   14: getstatic 172	com/google/firebase/messaging/Constants:WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS	J
    //   17: invokevirtual 178	android/os/PowerManager$WakeLock:acquire	(J)V
    //   20: aload_0
    //   21: getfield 37	com/google/firebase/messaging/TopicsSyncTask:topicsSubscriber	Lcom/google/firebase/messaging/TopicsSubscriber;
    //   24: iconst_1
    //   25: invokevirtual 184	com/google/firebase/messaging/TopicsSubscriber:setSyncScheduledOrRunning	(Z)V
    //   28: aload_0
    //   29: getfield 43	com/google/firebase/messaging/TopicsSyncTask:metadata	Lcom/google/firebase/messaging/Metadata;
    //   32: invokevirtual 189	com/google/firebase/messaging/Metadata:isGmscorePresent	()Z
    //   35: ifne +39 -> 74
    //   38: aload_0
    //   39: getfield 37	com/google/firebase/messaging/TopicsSyncTask:topicsSubscriber	Lcom/google/firebase/messaging/TopicsSubscriber;
    //   42: iconst_0
    //   43: invokevirtual 184	com/google/firebase/messaging/TopicsSubscriber:setSyncScheduledOrRunning	(Z)V
    //   46: aload_0
    //   47: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   50: invokestatic 167	com/google/firebase/messaging/TopicsSyncTask:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   53: ifeq +20 -> 73
    //   56: aload_0
    //   57: getfield 61	com/google/firebase/messaging/TopicsSyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   60: invokevirtual 192	android/os/PowerManager$WakeLock:release	()V
    //   63: return
    //   64: astore_1
    //   65: ldc 124
    //   67: ldc -62
    //   69: invokestatic 197	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: return
    //   74: aload_0
    //   75: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   78: invokestatic 199	com/google/firebase/messaging/TopicsSyncTask:hasAccessNetworkStatePermission	(Landroid/content/Context;)Z
    //   81: ifeq +52 -> 133
    //   84: aload_0
    //   85: invokespecial 67	com/google/firebase/messaging/TopicsSyncTask:isDeviceConnected	()Z
    //   88: ifne +45 -> 133
    //   91: new 8	com/google/firebase/messaging/TopicsSyncTask$ConnectivityChangeReceiver
    //   94: astore_1
    //   95: aload_1
    //   96: aload_0
    //   97: aload_0
    //   98: invokespecial 202	com/google/firebase/messaging/TopicsSyncTask$ConnectivityChangeReceiver:<init>	(Lcom/google/firebase/messaging/TopicsSyncTask;Lcom/google/firebase/messaging/TopicsSyncTask;)V
    //   101: aload_1
    //   102: invokevirtual 205	com/google/firebase/messaging/TopicsSyncTask$ConnectivityChangeReceiver:registerReceiver	()V
    //   105: aload_0
    //   106: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   109: invokestatic 167	com/google/firebase/messaging/TopicsSyncTask:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   112: ifeq +20 -> 132
    //   115: aload_0
    //   116: getfield 61	com/google/firebase/messaging/TopicsSyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   119: invokevirtual 192	android/os/PowerManager$WakeLock:release	()V
    //   122: return
    //   123: astore_1
    //   124: ldc 124
    //   126: ldc -62
    //   128: invokestatic 197	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: return
    //   133: aload_0
    //   134: getfield 37	com/google/firebase/messaging/TopicsSyncTask:topicsSubscriber	Lcom/google/firebase/messaging/TopicsSubscriber;
    //   137: invokevirtual 208	com/google/firebase/messaging/TopicsSubscriber:syncTopics	()Z
    //   140: ifeq +14 -> 154
    //   143: aload_0
    //   144: getfield 37	com/google/firebase/messaging/TopicsSyncTask:topicsSubscriber	Lcom/google/firebase/messaging/TopicsSubscriber;
    //   147: iconst_0
    //   148: invokevirtual 184	com/google/firebase/messaging/TopicsSubscriber:setSyncScheduledOrRunning	(Z)V
    //   151: goto +14 -> 165
    //   154: aload_0
    //   155: getfield 37	com/google/firebase/messaging/TopicsSyncTask:topicsSubscriber	Lcom/google/firebase/messaging/TopicsSubscriber;
    //   158: aload_0
    //   159: getfield 41	com/google/firebase/messaging/TopicsSyncTask:nextDelaySeconds	J
    //   162: invokevirtual 211	com/google/firebase/messaging/TopicsSubscriber:syncWithDelaySecondsInternal	(J)V
    //   165: aload_0
    //   166: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   169: invokestatic 167	com/google/firebase/messaging/TopicsSyncTask:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   172: ifeq +103 -> 275
    //   175: aload_0
    //   176: getfield 61	com/google/firebase/messaging/TopicsSyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   179: invokevirtual 192	android/os/PowerManager$WakeLock:release	()V
    //   182: return
    //   183: astore_1
    //   184: ldc 124
    //   186: ldc -62
    //   188: invokestatic 197	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   191: pop
    //   192: return
    //   193: astore_2
    //   194: goto +82 -> 276
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 214	java/io/IOException:getMessage	()Ljava/lang/String;
    //   202: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 85	java/lang/String:length	()I
    //   210: ifeq +13 -> 223
    //   213: ldc -37
    //   215: aload_1
    //   216: invokevirtual 222	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: goto +13 -> 233
    //   223: new 81	java/lang/String
    //   226: dup
    //   227: ldc -37
    //   229: invokespecial 225	java/lang/String:<init>	(Ljava/lang/String;)V
    //   232: astore_1
    //   233: ldc 124
    //   235: aload_1
    //   236: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   239: pop
    //   240: aload_0
    //   241: getfield 37	com/google/firebase/messaging/TopicsSyncTask:topicsSubscriber	Lcom/google/firebase/messaging/TopicsSubscriber;
    //   244: iconst_0
    //   245: invokevirtual 184	com/google/firebase/messaging/TopicsSubscriber:setSyncScheduledOrRunning	(Z)V
    //   248: aload_0
    //   249: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   252: invokestatic 167	com/google/firebase/messaging/TopicsSyncTask:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   255: ifeq +20 -> 275
    //   258: aload_0
    //   259: getfield 61	com/google/firebase/messaging/TopicsSyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   262: invokevirtual 192	android/os/PowerManager$WakeLock:release	()V
    //   265: return
    //   266: astore_1
    //   267: ldc 124
    //   269: ldc -62
    //   271: invokestatic 197	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: return
    //   276: aload_0
    //   277: getfield 39	com/google/firebase/messaging/TopicsSyncTask:context	Landroid/content/Context;
    //   280: invokestatic 167	com/google/firebase/messaging/TopicsSyncTask:hasWakeLockPermission	(Landroid/content/Context;)Z
    //   283: ifeq +22 -> 305
    //   286: aload_0
    //   287: getfield 61	com/google/firebase/messaging/TopicsSyncTask:syncWakeLock	Landroid/os/PowerManager$WakeLock;
    //   290: invokevirtual 192	android/os/PowerManager$WakeLock:release	()V
    //   293: goto +12 -> 305
    //   296: astore_1
    //   297: ldc 124
    //   299: ldc -62
    //   301: invokestatic 197	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   304: pop
    //   305: aload_2
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	TopicsSyncTask
    //   64	1	1	localRuntimeException1	RuntimeException
    //   94	8	1	localConnectivityChangeReceiver	ConnectivityChangeReceiver
    //   123	1	1	localRuntimeException2	RuntimeException
    //   183	1	1	localRuntimeException3	RuntimeException
    //   197	2	1	localIOException	java.io.IOException
    //   205	31	1	str	String
    //   266	1	1	localRuntimeException4	RuntimeException
    //   296	1	1	localRuntimeException5	RuntimeException
    //   193	113	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	63	64	java/lang/RuntimeException
    //   115	122	123	java/lang/RuntimeException
    //   175	182	183	java/lang/RuntimeException
    //   20	46	193	finally
    //   74	105	193	finally
    //   133	151	193	finally
    //   154	165	193	finally
    //   198	220	193	finally
    //   223	233	193	finally
    //   233	248	193	finally
    //   20	46	197	java/io/IOException
    //   74	105	197	java/io/IOException
    //   133	151	197	java/io/IOException
    //   154	165	197	java/io/IOException
    //   258	265	266	java/lang/RuntimeException
    //   286	293	296	java/lang/RuntimeException
  }
  
  @VisibleForTesting
  class ConnectivityChangeReceiver
    extends BroadcastReceiver
  {
    @GuardedBy("this")
    @Nullable
    private TopicsSyncTask task;
    
    public ConnectivityChangeReceiver(TopicsSyncTask paramTopicsSyncTask)
    {
      this.task = paramTopicsSyncTask;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        paramIntent = this.task;
        if (paramIntent == null) {
          return;
        }
        boolean bool = paramIntent.isDeviceConnected();
        if (!bool) {
          return;
        }
        if (TopicsSyncTask.access$100()) {
          Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
        }
        this.task.topicsSubscriber.scheduleSyncTaskWithDelaySeconds(this.task, 0L);
        paramContext.unregisterReceiver(this);
        this.task = null;
        return;
      }
      finally {}
    }
    
    public void registerReceiver()
    {
      if (TopicsSyncTask.access$100()) {
        Log.d("FirebaseMessaging", "Connectivity change received registered");
      }
      TopicsSyncTask.this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\TopicsSyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */