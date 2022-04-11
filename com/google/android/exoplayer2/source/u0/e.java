package com.google.android.exoplayer2.source.u0;

import java.util.NoSuchElementException;

public abstract interface e
{
  public static final e a = new a();
  
  public abstract long a();
  
  public abstract long b();
  
  public abstract boolean next();
  
  class a
    implements e
  {
    public long a()
    {
      throw new NoSuchElementException();
    }
    
    public long b()
    {
      throw new NoSuchElementException();
    }
    
    public boolean next()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\u0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */