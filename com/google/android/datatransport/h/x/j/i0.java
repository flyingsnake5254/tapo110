package com.google.android.datatransport.h.x.j;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;
import d.a.a;

public final class i0
  implements b<h0>
{
  private final a<Context> a;
  private final a<String> b;
  private final a<Integer> c;
  
  public i0(a<Context> parama, a<String> parama1, a<Integer> parama2)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
  }
  
  public static i0 a(a<Context> parama, a<String> parama1, a<Integer> parama2)
  {
    return new i0(parama, parama1, parama2);
  }
  
  public static h0 c(Context paramContext, String paramString, int paramInt)
  {
    return new h0(paramContext, paramString, paramInt);
  }
  
  public h0 b()
  {
    return c((Context)this.a.get(), (String)this.b.get(), ((Integer)this.c.get()).intValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */