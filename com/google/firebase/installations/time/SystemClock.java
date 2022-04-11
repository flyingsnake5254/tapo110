package com.google.firebase.installations.time;

public class SystemClock
  implements Clock
{
  private static SystemClock singleton;
  
  public static SystemClock getInstance()
  {
    if (singleton == null) {
      singleton = new SystemClock();
    }
    return singleton;
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\time\SystemClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */