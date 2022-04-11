package com.google.android.datatransport.h.x.j;

import com.google.android.datatransport.h.u.a.b;

public final class g0
  implements b<f0>
{
  private final d.a.a<com.google.android.datatransport.h.y.a> a;
  private final d.a.a<com.google.android.datatransport.h.y.a> b;
  private final d.a.a<z> c;
  private final d.a.a<h0> d;
  
  public g0(d.a.a<com.google.android.datatransport.h.y.a> parama1, d.a.a<com.google.android.datatransport.h.y.a> parama2, d.a.a<z> parama, d.a.a<h0> parama3)
  {
    this.a = parama1;
    this.b = parama2;
    this.c = parama;
    this.d = parama3;
  }
  
  public static g0 a(d.a.a<com.google.android.datatransport.h.y.a> parama1, d.a.a<com.google.android.datatransport.h.y.a> parama2, d.a.a<z> parama, d.a.a<h0> parama3)
  {
    return new g0(parama1, parama2, parama, parama3);
  }
  
  public static f0 c(com.google.android.datatransport.h.y.a parama1, com.google.android.datatransport.h.y.a parama2, Object paramObject1, Object paramObject2)
  {
    return new f0(parama1, parama2, (z)paramObject1, (h0)paramObject2);
  }
  
  public f0 b()
  {
    return c((com.google.android.datatransport.h.y.a)this.a.get(), (com.google.android.datatransport.h.y.a)this.b.get(), this.c.get(), this.d.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */