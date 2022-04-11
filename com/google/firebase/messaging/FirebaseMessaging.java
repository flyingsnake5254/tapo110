package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseMessaging
{
  @Deprecated
  @NonNull
  public static final String INSTANCE_ID_SCOPE = "FCM";
  private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8L);
  @SuppressLint({"StaticFieldLeak"})
  private static Store store;
  @VisibleForTesting
  @GuardedBy("FirebaseMessaging.class")
  static ScheduledExecutorService syncExecutor;
  @SuppressLint({"FirebaseUnknownNullness"})
  @Nullable
  @VisibleForTesting
  static f transportFactory;
  private final AutoInit autoInit;
  private final Context context;
  private final Executor fileIoExecutor;
  private final FirebaseApp firebaseApp;
  private final FirebaseInstallationsApi fis;
  private final GmsRpc gmsRpc;
  @Nullable
  private final FirebaseInstanceIdInternal iid;
  private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
  private final Metadata metadata;
  private final RequestDeduplicator requestDeduplicator;
  @GuardedBy("this")
  private boolean syncScheduledOrRunning = false;
  private final Executor taskExecutor;
  private final Task<TopicsSubscriber> topicsSubscriberTask;
  
  FirebaseMessaging(FirebaseApp paramFirebaseApp, @Nullable FirebaseInstanceIdInternal paramFirebaseInstanceIdInternal, Provider<UserAgentPublisher> paramProvider, Provider<HeartBeatInfo> paramProvider1, FirebaseInstallationsApi paramFirebaseInstallationsApi, @Nullable f paramf, Subscriber paramSubscriber)
  {
    this(paramFirebaseApp, paramFirebaseInstanceIdInternal, paramProvider, paramProvider1, paramFirebaseInstallationsApi, paramf, paramSubscriber, new Metadata(paramFirebaseApp.getApplicationContext()));
  }
  
  FirebaseMessaging(FirebaseApp paramFirebaseApp, @Nullable FirebaseInstanceIdInternal paramFirebaseInstanceIdInternal, Provider<UserAgentPublisher> paramProvider, Provider<HeartBeatInfo> paramProvider1, FirebaseInstallationsApi paramFirebaseInstallationsApi, @Nullable f paramf, Subscriber paramSubscriber, Metadata paramMetadata)
  {
    this(paramFirebaseApp, paramFirebaseInstanceIdInternal, paramFirebaseInstallationsApi, paramf, paramSubscriber, paramMetadata, new GmsRpc(paramFirebaseApp, paramMetadata, paramProvider, paramProvider1, paramFirebaseInstallationsApi), FcmExecutors.newTaskExecutor(), FcmExecutors.newInitExecutor());
  }
  
  FirebaseMessaging(FirebaseApp paramFirebaseApp, @Nullable FirebaseInstanceIdInternal paramFirebaseInstanceIdInternal, FirebaseInstallationsApi paramFirebaseInstallationsApi, @Nullable f paramf, Subscriber paramSubscriber, Metadata paramMetadata, GmsRpc paramGmsRpc, Executor paramExecutor1, Executor paramExecutor2)
  {
    transportFactory = paramf;
    this.firebaseApp = paramFirebaseApp;
    this.iid = paramFirebaseInstanceIdInternal;
    this.fis = paramFirebaseInstallationsApi;
    this.autoInit = new AutoInit(paramSubscriber);
    paramf = paramFirebaseApp.getApplicationContext();
    this.context = paramf;
    paramSubscriber = new FcmLifecycleCallbacks();
    this.lifecycleCallbacks = paramSubscriber;
    this.metadata = paramMetadata;
    this.taskExecutor = paramExecutor1;
    this.gmsRpc = paramGmsRpc;
    this.requestDeduplicator = new RequestDeduplicator(paramExecutor1);
    this.fileIoExecutor = paramExecutor2;
    paramFirebaseApp = paramFirebaseApp.getApplicationContext();
    if ((paramFirebaseApp instanceof Application))
    {
      ((Application)paramFirebaseApp).registerActivityLifecycleCallbacks(paramSubscriber);
    }
    else
    {
      paramSubscriber = String.valueOf(paramFirebaseApp);
      paramFirebaseApp = new StringBuilder(paramSubscriber.length() + 125);
      paramFirebaseApp.append("Context ");
      paramFirebaseApp.append(paramSubscriber);
      paramFirebaseApp.append(" was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
      Log.w("FirebaseMessaging", paramFirebaseApp.toString());
    }
    if (paramFirebaseInstanceIdInternal != null) {
      paramFirebaseInstanceIdInternal.addNewTokenListener(new FirebaseMessaging..Lambda.0(this));
    }
    try
    {
      if (store == null)
      {
        paramFirebaseApp = new com/google/firebase/messaging/Store;
        paramFirebaseApp.<init>(paramf);
        store = paramFirebaseApp;
      }
      paramExecutor2.execute(new FirebaseMessaging..Lambda.1(this));
      paramFirebaseApp = TopicsSubscriber.createInstance(this, paramFirebaseInstallationsApi, paramMetadata, paramGmsRpc, paramf, FcmExecutors.newTopicsSyncExecutor());
      this.topicsSubscriberTask = paramFirebaseApp;
      paramFirebaseApp.addOnSuccessListener(FcmExecutors.newTopicsSyncTriggerExecutor(), new FirebaseMessaging..Lambda.2(this));
      return;
    }
    finally {}
  }
  
  @NonNull
  public static FirebaseMessaging getInstance()
  {
    try
    {
      FirebaseMessaging localFirebaseMessaging = getInstance(FirebaseApp.getInstance());
      return localFirebaseMessaging;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Keep
  @NonNull
  static FirebaseMessaging getInstance(@NonNull FirebaseApp paramFirebaseApp)
  {
    try
    {
      paramFirebaseApp = (FirebaseMessaging)paramFirebaseApp.get(FirebaseMessaging.class);
      Preconditions.checkNotNull(paramFirebaseApp, "Firebase Messaging component is not present");
      return paramFirebaseApp;
    }
    finally
    {
      paramFirebaseApp = finally;
      throw paramFirebaseApp;
    }
  }
  
  private String getSubtype()
  {
    String str;
    if ("[DEFAULT]".equals(this.firebaseApp.getName())) {
      str = "";
    } else {
      str = this.firebaseApp.getPersistenceKey();
    }
    return str;
  }
  
  @Nullable
  public static f getTransportFactory()
  {
    return transportFactory;
  }
  
  private void invokeOnTokenRefresh(String paramString)
  {
    if ("[DEFAULT]".equals(this.firebaseApp.getName()))
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        localObject = String.valueOf(this.firebaseApp.getName());
        if (((String)localObject).length() != 0) {
          localObject = "Invoking onNewToken for app: ".concat((String)localObject);
        } else {
          localObject = new String("Invoking onNewToken for app: ");
        }
        Log.d("FirebaseMessaging", (String)localObject);
      }
      Object localObject = new Intent("com.google.firebase.messaging.NEW_TOKEN");
      ((Intent)localObject).putExtra("token", paramString);
      new FcmBroadcastProcessor(this.context).process((Intent)localObject);
    }
  }
  
  private void startSync()
  {
    try
    {
      if (!this.syncScheduledOrRunning)
      {
        syncWithDelaySecondsInternal(0L);
        return;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void startSyncIfNecessary()
  {
    FirebaseInstanceIdInternal localFirebaseInstanceIdInternal = this.iid;
    if (localFirebaseInstanceIdInternal != null)
    {
      localFirebaseInstanceIdInternal.getToken();
      return;
    }
    if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
      startSync();
    }
  }
  
  String blockingGetToken()
    throws IOException
  {
    Object localObject1 = this.iid;
    if (localObject1 != null)
    {
      try
      {
        localObject1 = (String)Tasks.await(((FirebaseInstanceIdInternal)localObject1).getTokenTask());
        return (String)localObject1;
      }
      catch (InterruptedException localInterruptedException1) {}catch (ExecutionException localExecutionException1) {}
      throw new IOException(localExecutionException1);
    }
    Store.Token localToken = getTokenWithoutTriggeringSync();
    if (!tokenNeedsRefresh(localToken)) {
      return localToken.token;
    }
    String str = Metadata.getDefaultSenderId(this.firebaseApp);
    Object localObject2 = this.fis.getId().continueWithTask(FcmExecutors.newNetworkIOExecutor(), new FirebaseMessaging..Lambda.8(this, str));
    try
    {
      localObject2 = (String)Tasks.await((Task)localObject2);
      store.saveToken(getSubtype(), str, (String)localObject2, this.metadata.getAppVersionCode());
      if ((localToken == null) || (!((String)localObject2).equals(localToken.token))) {
        invokeOnTokenRefresh((String)localObject2);
      }
      return (String)localObject2;
    }
    catch (InterruptedException localInterruptedException2) {}catch (ExecutionException localExecutionException2) {}
    throw new IOException(localExecutionException2);
  }
  
  @NonNull
  public Task<Void> deleteToken()
  {
    if (this.iid != null)
    {
      localObject = new TaskCompletionSource();
      this.fileIoExecutor.execute(new FirebaseMessaging..Lambda.4(this, (TaskCompletionSource)localObject));
      return ((TaskCompletionSource)localObject).getTask();
    }
    if (getTokenWithoutTriggeringSync() == null) {
      return Tasks.forResult(null);
    }
    Object localObject = FcmExecutors.newNetworkIOExecutor();
    return this.fis.getId().continueWithTask((Executor)localObject, new FirebaseMessaging..Lambda.5(this, (ExecutorService)localObject));
  }
  
  @NonNull
  public boolean deliveryMetricsExportToBigQueryEnabled()
  {
    return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
  }
  
  void enqueueTaskWithDelaySeconds(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (syncExecutor == null)
      {
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = new java/util/concurrent/ScheduledThreadPoolExecutor;
        NamedThreadFactory localNamedThreadFactory = new com/google/android/gms/common/util/concurrent/NamedThreadFactory;
        localNamedThreadFactory.<init>("TAG");
        localScheduledThreadPoolExecutor.<init>(1, localNamedThreadFactory);
        syncExecutor = localScheduledThreadPoolExecutor;
      }
      syncExecutor.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
      return;
    }
    finally {}
  }
  
  Context getApplicationContext()
  {
    return this.context;
  }
  
  @NonNull
  public Task<String> getToken()
  {
    Object localObject = this.iid;
    if (localObject != null) {
      return ((FirebaseInstanceIdInternal)localObject).getTokenTask();
    }
    localObject = new TaskCompletionSource();
    this.fileIoExecutor.execute(new FirebaseMessaging..Lambda.3(this, (TaskCompletionSource)localObject));
    return ((TaskCompletionSource)localObject).getTask();
  }
  
  @Nullable
  @VisibleForTesting
  Store.Token getTokenWithoutTriggeringSync()
  {
    return store.getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
  }
  
  public boolean isAutoInitEnabled()
  {
    return this.autoInit.isEnabled();
  }
  
  @VisibleForTesting
  boolean isGmsCorePresent()
  {
    return this.metadata.isGmscorePresent();
  }
  
  public void send(@NonNull RemoteMessage paramRemoteMessage)
  {
    if (!TextUtils.isEmpty(paramRemoteMessage.getTo()))
    {
      Intent localIntent1 = new Intent("com.google.android.gcm.intent.SEND");
      Intent localIntent2 = new Intent();
      localIntent2.setPackage("com.google.example.invalidpackage");
      Context localContext = this.context;
      int i;
      if (Build.VERSION.SDK_INT >= 23) {
        i = 67108864;
      } else {
        i = 0;
      }
      localIntent1.putExtra("app", PendingIntent.getBroadcast(localContext, 0, localIntent2, i));
      localIntent1.setPackage("com.google.android.gms");
      paramRemoteMessage.populateSendMessageIntent(localIntent1);
      this.context.sendOrderedBroadcast(localIntent1, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
      return;
    }
    throw new IllegalArgumentException("Missing 'to'");
  }
  
  public void setAutoInitEnabled(boolean paramBoolean)
  {
    this.autoInit.setEnabled(paramBoolean);
  }
  
  public void setDeliveryMetricsExportToBigQuery(boolean paramBoolean)
  {
    MessagingAnalytics.setDeliveryMetricsExportToBigQuery(paramBoolean);
  }
  
  void setSyncScheduledOrRunning(boolean paramBoolean)
  {
    try
    {
      this.syncScheduledOrRunning = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @NonNull
  public Task<Void> subscribeToTopic(@NonNull String paramString)
  {
    return this.topicsSubscriberTask.onSuccessTask(new FirebaseMessaging..Lambda.6(paramString));
  }
  
  void syncWithDelaySecondsInternal(long paramLong)
  {
    try
    {
      long l = Math.min(Math.max(30L, paramLong + paramLong), MAX_DELAY_SEC);
      SyncTask localSyncTask = new com/google/firebase/messaging/SyncTask;
      localSyncTask.<init>(this, l);
      enqueueTaskWithDelaySeconds(localSyncTask, paramLong);
      this.syncScheduledOrRunning = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  boolean tokenNeedsRefresh(@Nullable Store.Token paramToken)
  {
    return (paramToken == null) || (paramToken.needsRefresh(this.metadata.getAppVersionCode()));
  }
  
  @NonNull
  public Task<Void> unsubscribeFromTopic(@NonNull String paramString)
  {
    return this.topicsSubscriberTask.onSuccessTask(new FirebaseMessaging..Lambda.7(paramString));
  }
  
  private class AutoInit
  {
    @Nullable
    @GuardedBy("this")
    private Boolean autoInitEnabled;
    @Nullable
    @GuardedBy("this")
    private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
    @GuardedBy("this")
    private boolean initialized;
    private final Subscriber subscriber;
    
    AutoInit(Subscriber paramSubscriber)
    {
      this.subscriber = paramSubscriber;
    }
    
    @Nullable
    private Boolean readEnabled()
    {
      Object localObject1 = FirebaseMessaging.this.firebaseApp.getApplicationContext();
      Object localObject2 = ((Context)localObject1).getSharedPreferences("com.google.firebase.messaging", 0);
      if (((SharedPreferences)localObject2).contains("auto_init")) {
        return Boolean.valueOf(((SharedPreferences)localObject2).getBoolean("auto_init", false));
      }
      try
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        if (localObject2 != null)
        {
          localObject2 = ((PackageManager)localObject2).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
          if (localObject2 != null)
          {
            localObject1 = ((ApplicationInfo)localObject2).metaData;
            if ((localObject1 != null) && (((Bundle)localObject1).containsKey("firebase_messaging_auto_init_enabled")))
            {
              boolean bool = ((ApplicationInfo)localObject2).metaData.getBoolean("firebase_messaging_auto_init_enabled");
              return Boolean.valueOf(bool);
            }
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
      return null;
    }
    
    void initialize()
    {
      try
      {
        boolean bool = this.initialized;
        if (bool) {
          return;
        }
        Object localObject1 = readEnabled();
        this.autoInitEnabled = ((Boolean)localObject1);
        if (localObject1 == null)
        {
          localObject1 = new com/google/firebase/messaging/FirebaseMessaging$AutoInit$$Lambda$0;
          ((FirebaseMessaging.AutoInit..Lambda.0)localObject1).<init>(this);
          this.dataCollectionDefaultChangeEventHandler = ((EventHandler)localObject1);
          this.subscriber.subscribe(DataCollectionDefaultChange.class, (EventHandler)localObject1);
        }
        this.initialized = true;
        return;
      }
      finally {}
    }
    
    boolean isEnabled()
    {
      try
      {
        initialize();
        Boolean localBoolean = this.autoInitEnabled;
        boolean bool;
        if (localBoolean != null) {
          bool = localBoolean.booleanValue();
        } else {
          bool = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
        }
        return bool;
      }
      finally {}
    }
    
    void setEnabled(boolean paramBoolean)
    {
      try
      {
        initialize();
        Object localObject1 = this.dataCollectionDefaultChangeEventHandler;
        if (localObject1 != null)
        {
          this.subscriber.unsubscribe(DataCollectionDefaultChange.class, (EventHandler)localObject1);
          this.dataCollectionDefaultChangeEventHandler = null;
        }
        localObject1 = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("auto_init", paramBoolean);
        ((SharedPreferences.Editor)localObject1).apply();
        if (paramBoolean) {
          FirebaseMessaging.this.startSyncIfNecessary();
        }
        this.autoInitEnabled = Boolean.valueOf(paramBoolean);
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\FirebaseMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */