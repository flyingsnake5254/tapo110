package com.google.android.datatransport.h.x;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

public final class g
  implements b<SchedulerConfig>
{
  private final d.a.a<com.google.android.datatransport.h.y.a> a;
  
  public g(d.a.a<com.google.android.datatransport.h.y.a> parama)
  {
    this.a = parama;
  }
  
  public static SchedulerConfig a(com.google.android.datatransport.h.y.a parama)
  {
    return (SchedulerConfig)d.c(f.a(parama), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public static g b(d.a.a<com.google.android.datatransport.h.y.a> parama)
  {
    return new g(parama);
  }
  
  public SchedulerConfig c()
  {
    return a((com.google.android.datatransport.h.y.a)this.a.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */