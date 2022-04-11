package com.google.android.exoplayer2.upstream;

import android.content.Context;
import androidx.annotation.Nullable;

public final class r
  implements l.a
{
  private final Context a;
  @Nullable
  private final a0 b;
  private final l.a c;
  
  public r(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  public r(Context paramContext, @Nullable a0 parama0, l.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = parama0;
    this.c = parama;
  }
  
  public r(Context paramContext, @Nullable String paramString, @Nullable a0 parama0)
  {
    this(paramContext, parama0, new s.b().c(paramString));
  }
  
  public q b()
  {
    q localq = new q(this.a, this.c.a());
    a0 locala0 = this.b;
    if (locala0 != null) {
      localq.b(locala0);
    }
    return localq;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */