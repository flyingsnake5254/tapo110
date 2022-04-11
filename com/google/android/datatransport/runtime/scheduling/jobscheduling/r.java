package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.e;
import java.util.concurrent.Executor;

public final class r
  implements b<q>
{
  private final d.a.a<Context> a;
  private final d.a.a<e> b;
  private final d.a.a<y> c;
  private final d.a.a<u> d;
  private final d.a.a<Executor> e;
  private final d.a.a<com.google.android.datatransport.runtime.synchronization.a> f;
  private final d.a.a<com.google.android.datatransport.h.y.a> g;
  
  public r(d.a.a<Context> parama, d.a.a<e> parama1, d.a.a<y> parama2, d.a.a<u> parama3, d.a.a<Executor> parama4, d.a.a<com.google.android.datatransport.runtime.synchronization.a> parama5, d.a.a<com.google.android.datatransport.h.y.a> parama6)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = parama3;
    this.e = parama4;
    this.f = parama5;
    this.g = parama6;
  }
  
  public static r a(d.a.a<Context> parama, d.a.a<e> parama1, d.a.a<y> parama2, d.a.a<u> parama3, d.a.a<Executor> parama4, d.a.a<com.google.android.datatransport.runtime.synchronization.a> parama5, d.a.a<com.google.android.datatransport.h.y.a> parama6)
  {
    return new r(parama, parama1, parama2, parama3, parama4, parama5, parama6);
  }
  
  public static q c(Context paramContext, e parame, y paramy, u paramu, Executor paramExecutor, com.google.android.datatransport.runtime.synchronization.a parama, com.google.android.datatransport.h.y.a parama1)
  {
    return new q(paramContext, parame, paramy, paramu, paramExecutor, parama, parama1);
  }
  
  public q b()
  {
    return c((Context)this.a.get(), (e)this.b.get(), (y)this.c.get(), (u)this.d.get(), (Executor)this.e.get(), (com.google.android.datatransport.runtime.synchronization.a)this.f.get(), (com.google.android.datatransport.h.y.a)this.g.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */