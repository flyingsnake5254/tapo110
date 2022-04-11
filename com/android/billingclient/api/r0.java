package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class r0
  implements ThreadFactory
{
  private final ThreadFactory c = Executors.defaultThreadFactory();
  private final AtomicInteger d = new AtomicInteger(1);
  
  r0(d paramd) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = this.c.newThread(paramRunnable);
    int i = this.d.getAndIncrement();
    paramRunnable = new StringBuilder(30);
    paramRunnable.append("PlayBillingLibrary-");
    paramRunnable.append(i);
    localThread.setName(paramRunnable.toString());
    return localThread;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */