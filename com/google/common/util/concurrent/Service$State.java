package com.google.common.util.concurrent;

public enum Service$State
{
  static
  {
    a locala = new a("NEW", 0);
    NEW = locala;
    b localb = new b("STARTING", 1);
    STARTING = localb;
    c localc = new c("RUNNING", 2);
    RUNNING = localc;
    d locald = new d("STOPPING", 3);
    STOPPING = locald;
    e locale = new e("TERMINATED", 4);
    TERMINATED = locale;
    f localf = new f("FAILED", 5);
    FAILED = localf;
    $VALUES = new State[] { locala, localb, localc, locald, locale, localf };
  }
  
  abstract boolean isTerminal();
  
  static enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    boolean isTerminal()
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
    
    boolean isTerminal()
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
    
    boolean isTerminal()
    {
      return false;
    }
  }
  
  static enum d
  {
    d()
    {
      super(paramInt, null);
    }
    
    boolean isTerminal()
    {
      return false;
    }
  }
  
  static enum e
  {
    e()
    {
      super(paramInt, null);
    }
    
    boolean isTerminal()
    {
      return true;
    }
  }
  
  static enum f
  {
    f()
    {
      super(paramInt, null);
    }
    
    boolean isTerminal()
    {
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\Service$State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */