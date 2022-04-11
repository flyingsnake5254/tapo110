package com.google.android.datatransport.h;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.x.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;

public final class t
  implements b<r>
{
  private final d.a.a<com.google.android.datatransport.h.y.a> a;
  private final d.a.a<com.google.android.datatransport.h.y.a> b;
  private final d.a.a<e> c;
  private final d.a.a<q> d;
  private final d.a.a<s> e;
  
  public t(d.a.a<com.google.android.datatransport.h.y.a> parama1, d.a.a<com.google.android.datatransport.h.y.a> parama2, d.a.a<e> parama, d.a.a<q> parama3, d.a.a<s> parama4)
  {
    this.a = parama1;
    this.b = parama2;
    this.c = parama;
    this.d = parama3;
    this.e = parama4;
  }
  
  public static t a(d.a.a<com.google.android.datatransport.h.y.a> parama1, d.a.a<com.google.android.datatransport.h.y.a> parama2, d.a.a<e> parama, d.a.a<q> parama3, d.a.a<s> parama4)
  {
    return new t(parama1, parama2, parama, parama3, parama4);
  }
  
  public static r c(com.google.android.datatransport.h.y.a parama1, com.google.android.datatransport.h.y.a parama2, e parame, q paramq, s params)
  {
    return new r(parama1, parama2, parame, paramq, params);
  }
  
  public r b()
  {
    return c((com.google.android.datatransport.h.y.a)this.a.get(), (com.google.android.datatransport.h.y.a)this.b.get(), (e)this.c.get(), (q)this.d.get(), (s)this.e.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */