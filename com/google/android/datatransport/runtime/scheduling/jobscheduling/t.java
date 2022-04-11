package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.j.y;
import java.util.concurrent.Executor;

public final class t
  implements b<s>
{
  private final d.a.a<Executor> a;
  private final d.a.a<y> b;
  private final d.a.a<u> c;
  private final d.a.a<com.google.android.datatransport.runtime.synchronization.a> d;
  
  public t(d.a.a<Executor> parama, d.a.a<y> parama1, d.a.a<u> parama2, d.a.a<com.google.android.datatransport.runtime.synchronization.a> parama3)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = parama3;
  }
  
  public static t a(d.a.a<Executor> parama, d.a.a<y> parama1, d.a.a<u> parama2, d.a.a<com.google.android.datatransport.runtime.synchronization.a> parama3)
  {
    return new t(parama, parama1, parama2, parama3);
  }
  
  public static s c(Executor paramExecutor, y paramy, u paramu, com.google.android.datatransport.runtime.synchronization.a parama)
  {
    return new s(paramExecutor, paramy, paramu, parama);
  }
  
  public s b()
  {
    return c((Executor)this.a.get(), (y)this.b.get(), (u)this.c.get(), (com.google.android.datatransport.runtime.synchronization.a)this.d.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */