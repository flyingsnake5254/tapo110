package com.google.android.datatransport.h.x;

import com.google.android.datatransport.g;
import com.google.android.datatransport.h.i;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.r;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class c
  implements e
{
  private static final Logger a = Logger.getLogger(r.class.getName());
  private final u b;
  private final Executor c;
  private final com.google.android.datatransport.runtime.backends.e d;
  private final y e;
  private final com.google.android.datatransport.runtime.synchronization.a f;
  
  public c(Executor paramExecutor, com.google.android.datatransport.runtime.backends.e parame, u paramu, y paramy, com.google.android.datatransport.runtime.synchronization.a parama)
  {
    this.c = paramExecutor;
    this.d = parame;
    this.b = paramu;
    this.e = paramy;
    this.f = parama;
  }
  
  public void a(n paramn, i parami, g paramg)
  {
    this.c.execute(new a(this, paramn, paramg, parami));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */