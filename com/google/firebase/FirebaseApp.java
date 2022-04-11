package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.ComponentRuntime.Builder;
import com.google.firebase.components.Lazy;
import com.google.firebase.internal.DataCollectionConfigStorage;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp
{
  @NonNull
  public static final String DEFAULT_APP_NAME = "[DEFAULT]";
  private static final String FIREBASE_ANDROID = "fire-android";
  private static final String FIREBASE_COMMON = "fire-core";
  @GuardedBy("LOCK")
  static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
  private static final String KOTLIN = "kotlin";
  private static final Object LOCK = new Object();
  private static final String LOG_TAG = "FirebaseApp";
  private static final Executor UI_EXECUTOR = new UiExecutor(null);
  private final Context applicationContext;
  private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
  private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
  private final ComponentRuntime componentRuntime;
  private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
  private final AtomicBoolean deleted = new AtomicBoolean();
  private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList();
  private final String name;
  private final FirebaseOptions options;
  
  protected FirebaseApp(Context paramContext, String paramString, FirebaseOptions paramFirebaseOptions)
  {
    this.applicationContext = ((Context)Preconditions.checkNotNull(paramContext));
    this.name = Preconditions.checkNotEmpty(paramString);
    this.options = ((FirebaseOptions)Preconditions.checkNotNull(paramFirebaseOptions));
    paramString = ComponentDiscovery.forContext(paramContext, ComponentDiscoveryService.class).discoverLazy();
    this.componentRuntime = ComponentRuntime.builder(UI_EXECUTOR).addLazyComponentRegistrars(paramString).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponent(Component.of(paramContext, Context.class, new Class[0])).addComponent(Component.of(this, FirebaseApp.class, new Class[0])).addComponent(Component.of(paramFirebaseOptions, FirebaseOptions.class, new Class[0])).build();
    this.dataCollectionConfigStorage = new Lazy(new a(this, paramContext));
  }
  
  private void checkNotDeleted()
  {
    Preconditions.checkState(this.deleted.get() ^ true, "FirebaseApp was deleted");
  }
  
  @VisibleForTesting
  public static void clearInstancesForTest()
  {
    synchronized (LOCK)
    {
      INSTANCES.clear();
      return;
    }
  }
  
  private static List<String> getAllAppNames()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (LOCK)
    {
      Iterator localIterator = INSTANCES.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((FirebaseApp)localIterator.next()).getName());
      }
      Collections.sort(localArrayList);
      return localArrayList;
    }
  }
  
  @NonNull
  public static List<FirebaseApp> getApps(@NonNull Context arg0)
  {
    synchronized (LOCK)
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(INSTANCES.values());
      return localArrayList;
    }
  }
  
  @NonNull
  public static FirebaseApp getInstance()
  {
    synchronized (LOCK)
    {
      Object localObject2 = (FirebaseApp)INSTANCES.get("[DEFAULT]");
      if (localObject2 != null) {
        return (FirebaseApp)localObject2;
      }
      localObject2 = new java/lang/IllegalStateException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Default FirebaseApp is not initialized in this process ");
      localStringBuilder.append(ProcessUtils.getMyProcessName());
      localStringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
      ((IllegalStateException)localObject2).<init>(localStringBuilder.toString());
      throw ((Throwable)localObject2);
    }
  }
  
  @NonNull
  public static FirebaseApp getInstance(@NonNull String paramString)
  {
    synchronized (LOCK)
    {
      Object localObject2 = (FirebaseApp)INSTANCES.get(normalize(paramString));
      if (localObject2 != null) {
        return (FirebaseApp)localObject2;
      }
      List localList = getAllAppNames();
      if (localList.isEmpty())
      {
        localObject2 = "";
      }
      else
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Available app names: ");
        ((StringBuilder)localObject2).append(TextUtils.join(", ", localList));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = String.format("FirebaseApp with name %s doesn't exist. %s", new Object[] { paramString, localObject2 });
      paramString = new java/lang/IllegalStateException;
      paramString.<init>((String)localObject2);
      throw paramString;
    }
  }
  
  @KeepForSdk
  public static String getPersistenceKey(String paramString, FirebaseOptions paramFirebaseOptions)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramString.getBytes(Charset.defaultCharset())));
    localStringBuilder.append("+");
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramFirebaseOptions.getApplicationId().getBytes(Charset.defaultCharset())));
    return localStringBuilder.toString();
  }
  
  private void initializeAllApis()
  {
    StringBuilder localStringBuilder;
    if ((UserManagerCompat.isUserUnlocked(this.applicationContext) ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
      localStringBuilder.append(getName());
      Log.i("FirebaseApp", localStringBuilder.toString());
      UserUnlockReceiver.ensureReceiverRegistered(this.applicationContext);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device unlocked: initializing all Firebase APIs for app ");
      localStringBuilder.append(getName());
      Log.i("FirebaseApp", localStringBuilder.toString());
      this.componentRuntime.initializeEagerComponents(isDefaultApp());
    }
  }
  
  @Nullable
  public static FirebaseApp initializeApp(@NonNull Context paramContext)
  {
    synchronized (LOCK)
    {
      if (INSTANCES.containsKey("[DEFAULT]"))
      {
        paramContext = getInstance();
        return paramContext;
      }
      FirebaseOptions localFirebaseOptions = FirebaseOptions.fromResource(paramContext);
      if (localFirebaseOptions == null)
      {
        Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
        return null;
      }
      paramContext = initializeApp(paramContext, localFirebaseOptions);
      return paramContext;
    }
  }
  
  @NonNull
  public static FirebaseApp initializeApp(@NonNull Context paramContext, @NonNull FirebaseOptions paramFirebaseOptions)
  {
    return initializeApp(paramContext, paramFirebaseOptions, "[DEFAULT]");
  }
  
  @NonNull
  public static FirebaseApp initializeApp(@NonNull Context paramContext, @NonNull FirebaseOptions paramFirebaseOptions, @NonNull String paramString)
  {
    GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(paramContext);
    paramString = normalize(paramString);
    if (paramContext.getApplicationContext() != null) {
      paramContext = paramContext.getApplicationContext();
    }
    synchronized (LOCK)
    {
      Map localMap = INSTANCES;
      boolean bool;
      if (!localMap.containsKey(paramString)) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("FirebaseApp name ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" already exists!");
      Preconditions.checkState(bool, ((StringBuilder)localObject2).toString());
      Preconditions.checkNotNull(paramContext, "Application context cannot be null.");
      localObject2 = new com/google/firebase/FirebaseApp;
      ((FirebaseApp)localObject2).<init>(paramContext, paramString, paramFirebaseOptions);
      localMap.put(paramString, localObject2);
      ((FirebaseApp)localObject2).initializeAllApis();
      return (FirebaseApp)localObject2;
    }
  }
  
  private static String normalize(@NonNull String paramString)
  {
    return paramString.trim();
  }
  
  private void notifyBackgroundStateChangeListeners(boolean paramBoolean)
  {
    Log.d("FirebaseApp", "Notifying background state change listeners.");
    Iterator localIterator = this.backgroundStateChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((BackgroundStateChangeListener)localIterator.next()).onBackgroundStateChanged(paramBoolean);
    }
  }
  
  private void notifyOnAppDeleted()
  {
    Iterator localIterator = this.lifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((FirebaseAppLifecycleListener)localIterator.next()).onDeleted(this.name, this.options);
    }
  }
  
  @KeepForSdk
  public void addBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    checkNotDeleted();
    if ((this.automaticResourceManagementEnabled.get()) && (BackgroundDetector.getInstance().isInBackground())) {
      paramBackgroundStateChangeListener.onBackgroundStateChanged(true);
    }
    this.backgroundStateChangeListeners.add(paramBackgroundStateChangeListener);
  }
  
  @KeepForSdk
  public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener)
  {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.add(paramFirebaseAppLifecycleListener);
  }
  
  public void delete()
  {
    if (!this.deleted.compareAndSet(false, true)) {
      return;
    }
    synchronized (LOCK)
    {
      INSTANCES.remove(this.name);
      notifyOnAppDeleted();
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FirebaseApp)) {
      return false;
    }
    return this.name.equals(((FirebaseApp)paramObject).getName());
  }
  
  @KeepForSdk
  public <T> T get(Class<T> paramClass)
  {
    checkNotDeleted();
    return (T)this.componentRuntime.get(paramClass);
  }
  
  @NonNull
  public Context getApplicationContext()
  {
    checkNotDeleted();
    return this.applicationContext;
  }
  
  @NonNull
  public String getName()
  {
    checkNotDeleted();
    return this.name;
  }
  
  @NonNull
  public FirebaseOptions getOptions()
  {
    checkNotDeleted();
    return this.options;
  }
  
  @KeepForSdk
  public String getPersistenceKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())));
    localStringBuilder.append("+");
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset())));
    return localStringBuilder.toString();
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  @VisibleForTesting
  void initializeAllComponents()
  {
    this.componentRuntime.initializeAllComponentsForTests();
  }
  
  @KeepForSdk
  public boolean isDataCollectionDefaultEnabled()
  {
    checkNotDeleted();
    return ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).isEnabled();
  }
  
  @VisibleForTesting
  @KeepForSdk
  public boolean isDefaultApp()
  {
    return "[DEFAULT]".equals(getName());
  }
  
  @KeepForSdk
  public void removeBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    checkNotDeleted();
    this.backgroundStateChangeListeners.remove(paramBackgroundStateChangeListener);
  }
  
  @KeepForSdk
  public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener)
  {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.remove(paramFirebaseAppLifecycleListener);
  }
  
  public void setAutomaticResourceManagementEnabled(boolean paramBoolean)
  {
    checkNotDeleted();
    if (this.automaticResourceManagementEnabled.compareAndSet(paramBoolean ^ true, paramBoolean))
    {
      boolean bool = BackgroundDetector.getInstance().isInBackground();
      if ((paramBoolean) && (bool)) {
        notifyBackgroundStateChangeListeners(true);
      } else if ((!paramBoolean) && (bool)) {
        notifyBackgroundStateChangeListeners(false);
      }
    }
  }
  
  @KeepForSdk
  public void setDataCollectionDefaultEnabled(Boolean paramBoolean)
  {
    checkNotDeleted();
    ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).setEnabled(paramBoolean);
  }
  
  @Deprecated
  @KeepForSdk
  public void setDataCollectionDefaultEnabled(boolean paramBoolean)
  {
    setDataCollectionDefaultEnabled(Boolean.valueOf(paramBoolean));
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).add("options", this.options).toString();
  }
  
  @KeepForSdk
  public static abstract interface BackgroundStateChangeListener
  {
    @KeepForSdk
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
  
  @TargetApi(14)
  private static class GlobalBackgroundStateListener
    implements BackgroundDetector.BackgroundStateChangeListener
  {
    private static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference();
    
    private static void ensureBackgroundStateListenerRegistered(Context paramContext)
    {
      if ((PlatformVersion.isAtLeastIceCreamSandwich()) && ((paramContext.getApplicationContext() instanceof Application)))
      {
        Application localApplication = (Application)paramContext.getApplicationContext();
        if (INSTANCE.get() == null)
        {
          paramContext = new GlobalBackgroundStateListener();
          if (INSTANCE.compareAndSet(null, paramContext))
          {
            BackgroundDetector.initialize(localApplication);
            BackgroundDetector.getInstance().addListener(paramContext);
          }
        }
      }
    }
    
    public void onBackgroundStateChanged(boolean paramBoolean)
    {
      synchronized (FirebaseApp.LOCK)
      {
        Object localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>(FirebaseApp.INSTANCES.values());
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (FirebaseApp)localIterator.next();
          if (((FirebaseApp)localObject2).automaticResourceManagementEnabled.get()) {
            ((FirebaseApp)localObject2).notifyBackgroundStateChangeListeners(paramBoolean);
          }
        }
        return;
      }
    }
  }
  
  private static class UiExecutor
    implements Executor
  {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    
    public void execute(@NonNull Runnable paramRunnable)
    {
      HANDLER.post(paramRunnable);
    }
  }
  
  @TargetApi(24)
  private static class UserUnlockReceiver
    extends BroadcastReceiver
  {
    private static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference();
    private final Context applicationContext;
    
    public UserUnlockReceiver(Context paramContext)
    {
      this.applicationContext = paramContext;
    }
    
    private static void ensureReceiverRegistered(Context paramContext)
    {
      if (INSTANCE.get() == null)
      {
        UserUnlockReceiver localUserUnlockReceiver = new UserUnlockReceiver(paramContext);
        if (INSTANCE.compareAndSet(null, localUserUnlockReceiver)) {
          paramContext.registerReceiver(localUserUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        }
      }
    }
    
    public void onReceive(Context arg1, Intent paramIntent)
    {
      synchronized (FirebaseApp.LOCK)
      {
        paramIntent = FirebaseApp.INSTANCES.values().iterator();
        while (paramIntent.hasNext()) {
          ((FirebaseApp)paramIntent.next()).initializeAllApis();
        }
        unregister();
        return;
      }
    }
    
    public void unregister()
    {
      this.applicationContext.unregisterReceiver(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\FirebaseApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */