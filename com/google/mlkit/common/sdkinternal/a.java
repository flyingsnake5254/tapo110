package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadFactory;

public class a
{
  private final ReferenceQueue<Object> a = new ReferenceQueue();
  private final Set<b> b = Collections.synchronizedSet(new HashSet());
  
  @KeepForSdk
  public static a a()
  {
    ThreadFactory localThreadFactory = o.c;
    a locala = new a();
    locala.b(locala, q.c);
    localThreadFactory.newThread(new p(locala.a, locala.b)).start();
    return locala;
  }
  
  @KeepForSdk
  public a b(Object paramObject, Runnable paramRunnable)
  {
    paramObject = new b(paramObject, this.a, this.b, paramRunnable, null);
    this.b.add(paramObject);
    return (a)paramObject;
  }
  
  public static abstract interface a
  {
    @KeepForSdk
    public abstract void a();
  }
  
  static final class b
    extends PhantomReference<Object>
    implements a.a
  {
    private final Set<b> a;
    private final Runnable b;
    
    private b(Object paramObject, ReferenceQueue<? super Object> paramReferenceQueue, Set<b> paramSet, Runnable paramRunnable)
    {
      super(paramReferenceQueue);
      this.a = paramSet;
      this.b = paramRunnable;
    }
    
    public final void a()
    {
      if (!this.a.remove(this)) {
        return;
      }
      clear();
      this.b.run();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */