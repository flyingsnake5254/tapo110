package com.google.android.exoplayer2.util;

public class k
{
  private final h a;
  private boolean b;
  
  public k()
  {
    this(h.a);
  }
  
  public k(h paramh)
  {
    this.a = paramh;
  }
  
  public void a()
    throws InterruptedException
  {
    try
    {
      while (!this.b) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
  {
    int i = 0;
    try
    {
      for (;;)
      {
        boolean bool = this.b;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          i = 1;
        }
      }
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return;
    }
    finally {}
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.b;
      this.b = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean e()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        return false;
      }
      this.b = true;
      notifyAll();
      return true;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */