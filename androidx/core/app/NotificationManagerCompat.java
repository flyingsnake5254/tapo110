package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class NotificationManagerCompat
{
  public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
  public static final int IMPORTANCE_DEFAULT = 3;
  public static final int IMPORTANCE_HIGH = 4;
  public static final int IMPORTANCE_LOW = 2;
  public static final int IMPORTANCE_MAX = 5;
  public static final int IMPORTANCE_MIN = 1;
  public static final int IMPORTANCE_NONE = 0;
  public static final int IMPORTANCE_UNSPECIFIED = -1000;
  static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
  private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
  private static final String TAG = "NotifManCompat";
  @GuardedBy("sEnabledNotificationListenersLock")
  private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
  @GuardedBy("sEnabledNotificationListenersLock")
  private static String sEnabledNotificationListeners;
  private static final Object sEnabledNotificationListenersLock = new Object();
  private static final Object sLock = new Object();
  @GuardedBy("sLock")
  private static SideChannelManager sSideChannelManager;
  private final Context mContext;
  private final NotificationManager mNotificationManager;
  
  private NotificationManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotificationManager = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  @NonNull
  public static NotificationManagerCompat from(@NonNull Context paramContext)
  {
    return new NotificationManagerCompat(paramContext);
  }
  
  @NonNull
  public static Set<String> getEnabledListenerPackages(@NonNull Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = sEnabledNotificationListenersLock;
    if (localObject1 != null) {}
    try
    {
      if (!((String)localObject1).equals(sEnabledNotificationListeners))
      {
        String[] arrayOfString = ((String)localObject1).split(":", -1);
        HashSet localHashSet = new java/util/HashSet;
        localHashSet.<init>(arrayOfString.length);
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          ComponentName localComponentName = ComponentName.unflattenFromString(arrayOfString[j]);
          if (localComponentName != null) {
            localHashSet.add(localComponentName.getPackageName());
          }
        }
        sEnabledNotificationListenerPackages = localHashSet;
        sEnabledNotificationListeners = (String)localObject1;
      }
      localObject1 = sEnabledNotificationListenerPackages;
      return (Set<String>)localObject1;
    }
    finally {}
  }
  
  private void pushSideChannelQueue(Task paramTask)
  {
    synchronized (sLock)
    {
      if (sSideChannelManager == null)
      {
        SideChannelManager localSideChannelManager = new androidx/core/app/NotificationManagerCompat$SideChannelManager;
        localSideChannelManager.<init>(this.mContext.getApplicationContext());
        sSideChannelManager = localSideChannelManager;
      }
      sSideChannelManager.queueTask(paramTask);
      return;
    }
  }
  
  private static boolean useSideChannelForNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    boolean bool;
    if ((paramNotification != null) && (paramNotification.getBoolean("android.support.useSideChannel"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean areNotificationsEnabled()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      return this.mNotificationManager.areNotificationsEnabled();
    }
    bool1 = true;
    bool2 = bool1;
    AppOpsManager localAppOpsManager;
    Object localObject;
    String str;
    if (i >= 19)
    {
      localAppOpsManager = (AppOpsManager)this.mContext.getSystemService("appops");
      localObject = this.mContext.getApplicationInfo();
      str = this.mContext.getApplicationContext().getPackageName();
      i = ((ApplicationInfo)localObject).uid;
    }
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      Class localClass = Integer.TYPE;
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { localClass, localClass, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      if (i == 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|InvocationTargetException|IllegalAccessException|RuntimeException localClassNotFoundException)
    {
      for (;;)
      {
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void cancel(int paramInt)
  {
    cancel(null, paramInt);
  }
  
  public void cancel(@Nullable String paramString, int paramInt)
  {
    this.mNotificationManager.cancel(paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), paramInt, paramString));
    }
  }
  
  public void cancelAll()
  {
    this.mNotificationManager.cancelAll();
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
    }
  }
  
  public void createNotificationChannel(@NonNull NotificationChannel paramNotificationChannel)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannel(paramNotificationChannel);
    }
  }
  
  public void createNotificationChannelGroup(@NonNull NotificationChannelGroup paramNotificationChannelGroup)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannelGroup(paramNotificationChannelGroup);
    }
  }
  
  public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> paramList)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannelGroups(paramList);
    }
  }
  
  public void createNotificationChannels(@NonNull List<NotificationChannel> paramList)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannels(paramList);
    }
  }
  
  public void deleteNotificationChannel(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.deleteNotificationChannel(paramString);
    }
  }
  
  public void deleteNotificationChannelGroup(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.deleteNotificationChannelGroup(paramString);
    }
  }
  
  public int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mNotificationManager.getImportance();
    }
    return 64536;
  }
  
  @Nullable
  public NotificationChannel getNotificationChannel(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mNotificationManager.getNotificationChannel(paramString);
    }
    return null;
  }
  
  @Nullable
  public NotificationChannelGroup getNotificationChannelGroup(@NonNull String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return this.mNotificationManager.getNotificationChannelGroup(paramString);
    }
    if (i >= 26)
    {
      Iterator localIterator = getNotificationChannelGroups().iterator();
      while (localIterator.hasNext())
      {
        NotificationChannelGroup localNotificationChannelGroup = (NotificationChannelGroup)localIterator.next();
        if (localNotificationChannelGroup.getId().equals(paramString)) {
          return localNotificationChannelGroup;
        }
      }
    }
    return null;
  }
  
  @NonNull
  public List<NotificationChannelGroup> getNotificationChannelGroups()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mNotificationManager.getNotificationChannelGroups();
    }
    return Collections.emptyList();
  }
  
  @NonNull
  public List<NotificationChannel> getNotificationChannels()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mNotificationManager.getNotificationChannels();
    }
    return Collections.emptyList();
  }
  
  public void notify(int paramInt, @NonNull Notification paramNotification)
  {
    notify(null, paramInt, paramNotification);
  }
  
  public void notify(@Nullable String paramString, int paramInt, @NonNull Notification paramNotification)
  {
    if (useSideChannelForNotification(paramNotification))
    {
      pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), paramInt, paramString, paramNotification));
      this.mNotificationManager.cancel(paramString, paramInt);
    }
    else
    {
      this.mNotificationManager.notify(paramString, paramInt, paramNotification);
    }
  }
  
  private static class CancelTask
    implements NotificationManagerCompat.Task
  {
    final boolean all;
    final int id;
    final String packageName;
    final String tag;
    
    CancelTask(String paramString)
    {
      this.packageName = paramString;
      this.id = 0;
      this.tag = null;
      this.all = true;
    }
    
    CancelTask(String paramString1, int paramInt, String paramString2)
    {
      this.packageName = paramString1;
      this.id = paramInt;
      this.tag = paramString2;
      this.all = false;
    }
    
    public void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException
    {
      if (this.all) {
        paramINotificationSideChannel.cancelAll(this.packageName);
      } else {
        paramINotificationSideChannel.cancel(this.packageName, this.id, this.tag);
      }
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
      localStringBuilder.append("packageName:");
      localStringBuilder.append(this.packageName);
      localStringBuilder.append(", id:");
      localStringBuilder.append(this.id);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(this.tag);
      localStringBuilder.append(", all:");
      localStringBuilder.append(this.all);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  private static class NotifyTask
    implements NotificationManagerCompat.Task
  {
    final int id;
    final Notification notif;
    final String packageName;
    final String tag;
    
    NotifyTask(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    {
      this.packageName = paramString1;
      this.id = paramInt;
      this.tag = paramString2;
      this.notif = paramNotification;
    }
    
    public void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException
    {
      paramINotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
      localStringBuilder.append("packageName:");
      localStringBuilder.append(this.packageName);
      localStringBuilder.append(", id:");
      localStringBuilder.append(this.id);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(this.tag);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  private static class ServiceConnectedEvent
  {
    final ComponentName componentName;
    final IBinder iBinder;
    
    ServiceConnectedEvent(ComponentName paramComponentName, IBinder paramIBinder)
    {
      this.componentName = paramComponentName;
      this.iBinder = paramIBinder;
    }
  }
  
  private static class SideChannelManager
    implements Handler.Callback, ServiceConnection
  {
    private static final int MSG_QUEUE_TASK = 0;
    private static final int MSG_RETRY_LISTENER_QUEUE = 3;
    private static final int MSG_SERVICE_CONNECTED = 1;
    private static final int MSG_SERVICE_DISCONNECTED = 2;
    private Set<String> mCachedEnabledPackages = new HashSet();
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap();
    
    SideChannelManager(Context paramContext)
    {
      this.mContext = paramContext;
      paramContext = new HandlerThread("NotificationManagerCompat");
      this.mHandlerThread = paramContext;
      paramContext.start();
      this.mHandler = new Handler(paramContext.getLooper(), this);
    }
    
    private boolean ensureServiceBound(ListenerRecord paramListenerRecord)
    {
      if (paramListenerRecord.bound) {
        return true;
      }
      Object localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(paramListenerRecord.componentName);
      boolean bool = this.mContext.bindService((Intent)localObject, this, 33);
      paramListenerRecord.bound = bool;
      if (bool)
      {
        paramListenerRecord.retryCount = 0;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to bind to listener ");
        ((StringBuilder)localObject).append(paramListenerRecord.componentName);
        Log.w("NotifManCompat", ((StringBuilder)localObject).toString());
        this.mContext.unbindService(this);
      }
      return paramListenerRecord.bound;
    }
    
    private void ensureServiceUnbound(ListenerRecord paramListenerRecord)
    {
      if (paramListenerRecord.bound)
      {
        this.mContext.unbindService(this);
        paramListenerRecord.bound = false;
      }
      paramListenerRecord.service = null;
    }
    
    private void handleQueueTask(NotificationManagerCompat.Task paramTask)
    {
      updateListenerMap();
      Iterator localIterator = this.mRecordMap.values().iterator();
      while (localIterator.hasNext())
      {
        ListenerRecord localListenerRecord = (ListenerRecord)localIterator.next();
        localListenerRecord.taskQueue.add(paramTask);
        processListenerQueue(localListenerRecord);
      }
    }
    
    private void handleRetryListenerQueue(ComponentName paramComponentName)
    {
      paramComponentName = (ListenerRecord)this.mRecordMap.get(paramComponentName);
      if (paramComponentName != null) {
        processListenerQueue(paramComponentName);
      }
    }
    
    private void handleServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      paramComponentName = (ListenerRecord)this.mRecordMap.get(paramComponentName);
      if (paramComponentName != null)
      {
        paramComponentName.service = INotificationSideChannel.Stub.asInterface(paramIBinder);
        paramComponentName.retryCount = 0;
        processListenerQueue(paramComponentName);
      }
    }
    
    private void handleServiceDisconnected(ComponentName paramComponentName)
    {
      paramComponentName = (ListenerRecord)this.mRecordMap.get(paramComponentName);
      if (paramComponentName != null) {
        ensureServiceUnbound(paramComponentName);
      }
    }
    
    private void processListenerQueue(ListenerRecord paramListenerRecord)
    {
      StringBuilder localStringBuilder1;
      if (Log.isLoggable("NotifManCompat", 3))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Processing component ");
        localStringBuilder1.append(paramListenerRecord.componentName);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(paramListenerRecord.taskQueue.size());
        localStringBuilder1.append(" queued tasks");
        Log.d("NotifManCompat", localStringBuilder1.toString());
      }
      if (paramListenerRecord.taskQueue.isEmpty()) {
        return;
      }
      if ((ensureServiceBound(paramListenerRecord)) && (paramListenerRecord.service != null))
      {
        for (;;)
        {
          Object localObject = (NotificationManagerCompat.Task)paramListenerRecord.taskQueue.peek();
          if (localObject != null) {
            try
            {
              if (Log.isLoggable("NotifManCompat", 3))
              {
                localStringBuilder1 = new java/lang/StringBuilder;
                localStringBuilder1.<init>();
                localStringBuilder1.append("Sending task ");
                localStringBuilder1.append(localObject);
                Log.d("NotifManCompat", localStringBuilder1.toString());
              }
              ((NotificationManagerCompat.Task)localObject).send(paramListenerRecord.service);
              paramListenerRecord.taskQueue.remove();
            }
            catch (RemoteException localRemoteException)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("RemoteException communicating with ");
              ((StringBuilder)localObject).append(paramListenerRecord.componentName);
              Log.w("NotifManCompat", ((StringBuilder)localObject).toString(), localRemoteException);
            }
            catch (DeadObjectException localDeadObjectException)
            {
              if (Log.isLoggable("NotifManCompat", 3))
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("Remote service has died: ");
                localStringBuilder2.append(paramListenerRecord.componentName);
                Log.d("NotifManCompat", localStringBuilder2.toString());
              }
            }
          }
        }
        if (!paramListenerRecord.taskQueue.isEmpty()) {
          scheduleListenerRetry(paramListenerRecord);
        }
        return;
      }
      scheduleListenerRetry(paramListenerRecord);
    }
    
    private void scheduleListenerRetry(ListenerRecord paramListenerRecord)
    {
      if (this.mHandler.hasMessages(3, paramListenerRecord.componentName)) {
        return;
      }
      int i = paramListenerRecord.retryCount + 1;
      paramListenerRecord.retryCount = i;
      StringBuilder localStringBuilder;
      if (i > 6)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Giving up on delivering ");
        localStringBuilder.append(paramListenerRecord.taskQueue.size());
        localStringBuilder.append(" tasks to ");
        localStringBuilder.append(paramListenerRecord.componentName);
        localStringBuilder.append(" after ");
        localStringBuilder.append(paramListenerRecord.retryCount);
        localStringBuilder.append(" retries");
        Log.w("NotifManCompat", localStringBuilder.toString());
        paramListenerRecord.taskQueue.clear();
        return;
      }
      i = (1 << i - 1) * 1000;
      if (Log.isLoggable("NotifManCompat", 3))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Scheduling retry for ");
        localStringBuilder.append(i);
        localStringBuilder.append(" ms");
        Log.d("NotifManCompat", localStringBuilder.toString());
      }
      paramListenerRecord = this.mHandler.obtainMessage(3, paramListenerRecord.componentName);
      this.mHandler.sendMessageDelayed(paramListenerRecord, i);
    }
    
    private void updateListenerMap()
    {
      Object localObject1 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
      if (((Set)localObject1).equals(this.mCachedEnabledPackages)) {
        return;
      }
      this.mCachedEnabledPackages = ((Set)localObject1);
      Object localObject2 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
      HashSet localHashSet = new HashSet();
      localObject2 = ((List)localObject2).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ResolveInfo)((Iterator)localObject2).next();
        if (((Set)localObject1).contains(((ResolveInfo)localObject3).serviceInfo.packageName))
        {
          localObject4 = ((ResolveInfo)localObject3).serviceInfo;
          localObject4 = new ComponentName(((ServiceInfo)localObject4).packageName, ((ServiceInfo)localObject4).name);
          if (((ResolveInfo)localObject3).serviceInfo.permission != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Permission present on component ");
            ((StringBuilder)localObject3).append(localObject4);
            ((StringBuilder)localObject3).append(", not adding listener record.");
            Log.w("NotifManCompat", ((StringBuilder)localObject3).toString());
          }
          else
          {
            localHashSet.add(localObject4);
          }
        }
      }
      localObject2 = localHashSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (ComponentName)((Iterator)localObject2).next();
        if (!this.mRecordMap.containsKey(localObject4))
        {
          if (Log.isLoggable("NotifManCompat", 3))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Adding listener record for ");
            ((StringBuilder)localObject1).append(localObject4);
            Log.d("NotifManCompat", ((StringBuilder)localObject1).toString());
          }
          this.mRecordMap.put(localObject4, new ListenerRecord((ComponentName)localObject4));
        }
      }
      localObject2 = this.mRecordMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        if (!localHashSet.contains(((Map.Entry)localObject4).getKey()))
        {
          if (Log.isLoggable("NotifManCompat", 3))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Removing listener record for ");
            ((StringBuilder)localObject1).append(((Map.Entry)localObject4).getKey());
            Log.d("NotifManCompat", ((StringBuilder)localObject1).toString());
          }
          ensureServiceUnbound((ListenerRecord)((Map.Entry)localObject4).getValue());
          ((Iterator)localObject2).remove();
        }
      }
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return false;
            }
            handleRetryListenerQueue((ComponentName)paramMessage.obj);
            return true;
          }
          handleServiceDisconnected((ComponentName)paramMessage.obj);
          return true;
        }
        paramMessage = (NotificationManagerCompat.ServiceConnectedEvent)paramMessage.obj;
        handleServiceConnected(paramMessage.componentName, paramMessage.iBinder);
        return true;
      }
      handleQueueTask((NotificationManagerCompat.Task)paramMessage.obj);
      return true;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (Log.isLoggable("NotifManCompat", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Connected to service ");
        localStringBuilder.append(paramComponentName);
        Log.d("NotifManCompat", localStringBuilder.toString());
      }
      this.mHandler.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(paramComponentName, paramIBinder)).sendToTarget();
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (Log.isLoggable("NotifManCompat", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Disconnected from service ");
        localStringBuilder.append(paramComponentName);
        Log.d("NotifManCompat", localStringBuilder.toString());
      }
      this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
    }
    
    public void queueTask(NotificationManagerCompat.Task paramTask)
    {
      this.mHandler.obtainMessage(0, paramTask).sendToTarget();
    }
    
    private static class ListenerRecord
    {
      boolean bound = false;
      final ComponentName componentName;
      int retryCount = 0;
      INotificationSideChannel service;
      ArrayDeque<NotificationManagerCompat.Task> taskQueue = new ArrayDeque();
      
      ListenerRecord(ComponentName paramComponentName)
      {
        this.componentName = paramComponentName;
      }
    }
  }
  
  private static abstract interface Task
  {
    public abstract void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\app\NotificationManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */