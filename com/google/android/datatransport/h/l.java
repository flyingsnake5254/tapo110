package com.google.android.datatransport.h;

import com.google.android.datatransport.h.v.a;
import java.util.concurrent.Executor;

class l
  implements Executor
{
  private final Executor c;
  
  l(Executor paramExecutor)
  {
    this.c = paramExecutor;
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.c.execute(new a(paramRunnable));
  }
  
  static class a
    implements Runnable
  {
    private final Runnable c;
    
    a(Runnable paramRunnable)
    {
      this.c = paramRunnable;
    }
    
    public void run()
    {
      try
      {
        this.c.run();
      }
      catch (Exception localException)
      {
        a.c("Executor", "Background execution failure.", localException);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */