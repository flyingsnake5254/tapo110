package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zaa
  extends ActivityLifecycleObserver
{
  private final WeakReference<zaa> zacl;
  
  public zaa(Activity paramActivity)
  {
    this(zaa.zab(paramActivity));
  }
  
  @VisibleForTesting(otherwise=2)
  private zaa(zaa paramzaa)
  {
    this.zacl = new WeakReference(paramzaa);
  }
  
  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable)
  {
    zaa localzaa = (zaa)this.zacl.get();
    if (localzaa != null)
    {
      zaa.zaa(localzaa, paramRunnable);
      return this;
    }
    throw new IllegalStateException("The target activity has already been GC'd");
  }
  
  @VisibleForTesting(otherwise=2)
  static class zaa
    extends LifecycleCallback
  {
    private List<Runnable> zacm = new ArrayList();
    
    private zaa(LifecycleFragment paramLifecycleFragment)
    {
      super();
      this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }
    
    private static zaa zaa(Activity paramActivity)
    {
      try
      {
        LifecycleFragment localLifecycleFragment = LifecycleCallback.getFragment(paramActivity);
        zaa localzaa1 = (zaa)localLifecycleFragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
        zaa localzaa2 = localzaa1;
        if (localzaa1 == null)
        {
          localzaa2 = new com/google/android/gms/common/api/internal/zaa$zaa;
          localzaa2.<init>(localLifecycleFragment);
        }
        return localzaa2;
      }
      finally {}
    }
    
    private final void zaa(Runnable paramRunnable)
    {
      try
      {
        this.zacm.add(paramRunnable);
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    @MainThread
    public void onStop()
    {
      try
      {
        List localList = this.zacm;
        Object localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        this.zacm = ((List)localObject1);
        localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Runnable)((Iterator)localObject1).next()).run();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */