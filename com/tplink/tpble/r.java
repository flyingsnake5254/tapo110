package com.tplink.tpble;

import android.app.Application;

class r
{
  private Application a;
  
  public static r b()
  {
    return a.a();
  }
  
  Application a()
  {
    return this.a;
  }
  
  void c(Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  private static class a
  {
    private static final r a = new r();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */