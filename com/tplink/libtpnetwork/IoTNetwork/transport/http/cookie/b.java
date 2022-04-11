package com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie;

import java.util.List;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

public abstract interface b
{
  public abstract List<Cookie> a(HttpUrl paramHttpUrl);
  
  public abstract boolean b();
  
  public abstract void c(HttpUrl paramHttpUrl, List<Cookie> paramList);
  
  public abstract void d();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\cookie\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */