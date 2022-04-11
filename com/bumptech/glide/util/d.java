package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class d
{
  private static final Executor a = new a();
  private static final Executor b = new b();
  
  public static Executor a()
  {
    return b;
  }
  
  public static Executor b()
  {
    return a;
  }
  
  class a
    implements Executor
  {
    public void execute(@NonNull Runnable paramRunnable)
    {
      j.v(paramRunnable);
    }
  }
  
  class b
    implements Executor
  {
    public void execute(@NonNull Runnable paramRunnable)
    {
      paramRunnable.run();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */