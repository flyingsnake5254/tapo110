package com.tplink.libtpanalytics.core.define;

import android.os.HandlerThread;

public class a
  extends HandlerThread
{
  public static final a c = new a("EventsConsumer");
  
  private a(String paramString)
  {
    super(paramString);
    start();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\core\define\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */