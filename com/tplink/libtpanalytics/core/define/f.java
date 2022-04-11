package com.tplink.libtpanalytics.core.define;

public class f
{
  private static f a;
  private int b = 0;
  
  public static f a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          f localf = new com/tplink/libtpanalytics/core/define/f;
          localf.<init>();
          a = localf;
        }
      }
      finally {}
    }
    return a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.b = ((int)(System.currentTimeMillis() / 1000L));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\core\define\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */