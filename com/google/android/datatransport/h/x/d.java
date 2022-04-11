package com.google.android.datatransport.h.x;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import java.util.concurrent.Executor;

public final class d
  implements b<c>
{
  private final d.a.a<Executor> a;
  private final d.a.a<e> b;
  private final d.a.a<u> c;
  private final d.a.a<y> d;
  private final d.a.a<com.google.android.datatransport.runtime.synchronization.a> e;
  
  public d(d.a.a<Executor> parama, d.a.a<e> parama1, d.a.a<u> parama2, d.a.a<y> parama3, d.a.a<com.google.android.datatransport.runtime.synchronization.a> parama4)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = parama3;
    this.e = parama4;
  }
  
  public static d a(d.a.a<Executor> parama, d.a.a<e> parama1, d.a.a<u> parama2, d.a.a<y> parama3, d.a.a<com.google.android.datatransport.runtime.synchronization.a> parama4)
  {
    return new d(parama, parama1, parama2, parama3, parama4);
  }
  
  public static c c(Executor paramExecutor, e parame, u paramu, y paramy, com.google.android.datatransport.runtime.synchronization.a parama)
  {
    return new c(paramExecutor, parame, paramu, paramy, parama);
  }
  
  public c b()
  {
    return c((Executor)this.a.get(), (e)this.b.get(), (u)this.c.get(), (y)this.d.get(), (com.google.android.datatransport.runtime.synchronization.a)this.e.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */