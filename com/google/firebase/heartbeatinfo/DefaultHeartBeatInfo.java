package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultHeartBeatInfo
  implements HeartBeatInfo
{
  private static final ThreadFactory THREAD_FACTORY = a.c;
  private final Executor backgroundExecutor;
  private final Set<HeartBeatConsumer> consumers;
  private Provider<HeartBeatInfoStorage> storageProvider;
  
  private DefaultHeartBeatInfo(Context paramContext, Set<HeartBeatConsumer> paramSet)
  {
    this(new Lazy(new c(paramContext)), paramSet, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY));
  }
  
  @VisibleForTesting
  DefaultHeartBeatInfo(Provider<HeartBeatInfoStorage> paramProvider, Set<HeartBeatConsumer> paramSet, Executor paramExecutor)
  {
    this.storageProvider = paramProvider;
    this.consumers = paramSet;
    this.backgroundExecutor = paramExecutor;
  }
  
  @NonNull
  public static Component<HeartBeatInfo> component()
  {
    return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.setOf(HeartBeatConsumer.class)).factory(e.a).build();
  }
  
  public Task<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo()
  {
    return Tasks.call(this.backgroundExecutor, new b(this));
  }
  
  @NonNull
  public HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String paramString)
  {
    long l = System.currentTimeMillis();
    boolean bool1 = ((HeartBeatInfoStorage)this.storageProvider.get()).shouldSendSdkHeartBeat(paramString, l);
    boolean bool2 = ((HeartBeatInfoStorage)this.storageProvider.get()).shouldSendGlobalHeartBeat(l);
    if ((bool1) && (bool2)) {
      return HeartBeatInfo.HeartBeat.COMBINED;
    }
    if (bool2) {
      return HeartBeatInfo.HeartBeat.GLOBAL;
    }
    if (bool1) {
      return HeartBeatInfo.HeartBeat.SDK;
    }
    return HeartBeatInfo.HeartBeat.NONE;
  }
  
  public Task<Void> storeHeartBeatInfo(@NonNull String paramString)
  {
    if (this.consumers.size() <= 0) {
      return Tasks.forResult(null);
    }
    return Tasks.call(this.backgroundExecutor, new d(this, paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\DefaultHeartBeatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */