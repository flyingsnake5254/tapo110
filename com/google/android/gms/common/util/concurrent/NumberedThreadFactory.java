package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory
  implements ThreadFactory
{
  private final int priority;
  private final ThreadFactory zzhr = Executors.defaultThreadFactory();
  private final String zzhs;
  private final AtomicInteger zzht = new AtomicInteger();
  
  @KeepForSdk
  public NumberedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }
  
  private NumberedThreadFactory(String paramString, int paramInt)
  {
    this.zzhs = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = 0;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = this.zzhr.newThread(new zza(paramRunnable, 0));
    paramRunnable = this.zzhs;
    int i = this.zzht.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramRunnable).length() + 13);
    localStringBuilder.append(paramRunnable);
    localStringBuilder.append("[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    localThread.setName(localStringBuilder.toString());
    return localThread;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\concurrent\NumberedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */