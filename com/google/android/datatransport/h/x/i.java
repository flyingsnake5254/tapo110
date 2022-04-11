package com.google.android.datatransport.h.x;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;

public final class i
  implements b<u>
{
  private final d.a.a<Context> a;
  private final d.a.a<y> b;
  private final d.a.a<SchedulerConfig> c;
  private final d.a.a<com.google.android.datatransport.h.y.a> d;
  
  public i(d.a.a<Context> parama, d.a.a<y> parama1, d.a.a<SchedulerConfig> parama2, d.a.a<com.google.android.datatransport.h.y.a> parama3)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = parama3;
  }
  
  public static i a(d.a.a<Context> parama, d.a.a<y> parama1, d.a.a<SchedulerConfig> parama2, d.a.a<com.google.android.datatransport.h.y.a> parama3)
  {
    return new i(parama, parama1, parama2, parama3);
  }
  
  public static u c(Context paramContext, y paramy, SchedulerConfig paramSchedulerConfig, com.google.android.datatransport.h.y.a parama)
  {
    return (u)d.c(h.a(paramContext, paramy, paramSchedulerConfig, parama), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public u b()
  {
    return c((Context)this.a.get(), (y)this.b.get(), (SchedulerConfig)this.c.get(), (com.google.android.datatransport.h.y.a)this.d.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */