package com.google.common.cache;

public enum RemovalCause
{
  static
  {
    a locala = new a("EXPLICIT", 0);
    EXPLICIT = locala;
    b localb = new b("REPLACED", 1);
    REPLACED = localb;
    c localc = new c("COLLECTED", 2);
    COLLECTED = localc;
    d locald = new d("EXPIRED", 3);
    EXPIRED = locald;
    e locale = new e("SIZE", 4);
    SIZE = locale;
    $VALUES = new RemovalCause[] { locala, localb, localc, locald, locale };
  }
  
  abstract boolean wasEvicted();
  
  static enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    boolean wasEvicted()
    {
      return false;
    }
  }
  
  static enum b
  {
    b()
    {
      super(paramInt, null);
    }
    
    boolean wasEvicted()
    {
      return false;
    }
  }
  
  static enum c
  {
    c()
    {
      super(paramInt, null);
    }
    
    boolean wasEvicted()
    {
      return true;
    }
  }
  
  static enum d
  {
    d()
    {
      super(paramInt, null);
    }
    
    boolean wasEvicted()
    {
      return true;
    }
  }
  
  static enum e
  {
    e()
    {
      super(paramInt, null);
    }
    
    boolean wasEvicted()
    {
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\cache\RemovalCause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */