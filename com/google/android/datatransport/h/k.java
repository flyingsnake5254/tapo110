package com.google.android.datatransport.h;

import com.google.android.datatransport.h.u.a.b;
import com.google.android.datatransport.h.u.a.d;
import java.util.concurrent.Executor;

public final class k
  implements b<Executor>
{
  public static k a()
  {
    return a.a();
  }
  
  public static Executor b()
  {
    return (Executor)d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Executor c()
  {
    return b();
  }
  
  private static final class a
  {
    private static final k a = new k();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */