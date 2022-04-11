package com.tplink.libtpanalytics.utils;

import android.content.Context;

public class j
  extends k
{
  private static j c;
  
  private j(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public static j g(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          j localj = new com/tplink/libtpanalytics/utils/j;
          localj.<init>(paramContext, "tpa_sp");
          c = localj;
        }
      }
      finally {}
    }
    return c;
  }
  
  public long e()
  {
    return a("aes_generate_time", -1L);
  }
  
  public String f()
  {
    return b("app_version", "");
  }
  
  public String h()
  {
    return b("os_version", "");
  }
  
  public String i()
  {
    return b("uuid", "");
  }
  
  public void j(long paramLong)
  {
    c("aes_generate_time", paramLong);
  }
  
  public void k(String paramString)
  {
    d("app_version", paramString);
  }
  
  public void l(String paramString)
  {
    d("os_version", paramString);
  }
  
  public void m(String paramString)
  {
    d("uuid", paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */