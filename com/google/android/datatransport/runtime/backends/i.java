package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;

public final class i
  implements b<h>
{
  private final d.a.a<Context> a;
  private final d.a.a<com.google.android.datatransport.h.y.a> b;
  private final d.a.a<com.google.android.datatransport.h.y.a> c;
  
  public i(d.a.a<Context> parama, d.a.a<com.google.android.datatransport.h.y.a> parama1, d.a.a<com.google.android.datatransport.h.y.a> parama2)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
  }
  
  public static i a(d.a.a<Context> parama, d.a.a<com.google.android.datatransport.h.y.a> parama1, d.a.a<com.google.android.datatransport.h.y.a> parama2)
  {
    return new i(parama, parama1, parama2);
  }
  
  public static h c(Context paramContext, com.google.android.datatransport.h.y.a parama1, com.google.android.datatransport.h.y.a parama2)
  {
    return new h(paramContext, parama1, parama2);
  }
  
  public h b()
  {
    return c((Context)this.a.get(), (com.google.android.datatransport.h.y.a)this.b.get(), (com.google.android.datatransport.h.y.a)this.c.get());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */