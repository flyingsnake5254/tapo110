package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
public class j
{
  private static final AtomicReference<j> a = new AtomicReference();
  private final ComponentRuntime b;
  
  private j(Context paramContext)
  {
    List localList = ComponentDiscovery.forContext(paramContext, MlKitComponentDiscoveryService.class).discover();
    paramContext = new ComponentRuntime(TaskExecutors.MAIN_THREAD, localList, new Component[] { Component.of(paramContext, Context.class, new Class[0]), Component.of(this, j.class, new Class[0]) });
    this.b = paramContext;
    paramContext.initializeEagerComponents(true);
  }
  
  @KeepForSdk
  public static j c()
  {
    j localj = (j)a.get();
    boolean bool;
    if (localj != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "MlKitContext has not been initialized");
    return localj;
  }
  
  public static j d(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    paramContext = new j(paramContext);
    boolean bool;
    if ((j)a.getAndSet(paramContext) == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "MlKitContext is already initialized");
    return paramContext;
  }
  
  @KeepForSdk
  public <T> T a(Class<T> paramClass)
  {
    boolean bool;
    if (a.get() == this) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "MlKitContext has been deleted");
    return (T)this.b.get(paramClass);
  }
  
  @KeepForSdk
  public Context b()
  {
    return (Context)a(Context.class);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */