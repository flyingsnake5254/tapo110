package com.tplink.libtputility.log.tiny.bean;

import java.util.concurrent.TimeUnit;

public class c
{
  private String a;
  private long b;
  private TimeUnit c;
  
  public String a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.c.toMillis(this.b);
  }
  
  public boolean c()
  {
    String str = this.a;
    boolean bool;
    if ((str != null) && (!str.isEmpty()) && (this.b > 0L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\log\tiny\bean\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */