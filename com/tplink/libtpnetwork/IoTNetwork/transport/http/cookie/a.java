package com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class a
  implements CookieJar
{
  private b a;
  
  public a(b paramb)
  {
    if (paramb != null)
    {
      this.a = paramb;
      return;
    }
    throw new IllegalArgumentException("cookieStore can not be null.");
  }
  
  @NonNull
  public List<Cookie> loadForRequest(@NonNull HttpUrl paramHttpUrl)
  {
    try
    {
      if (!this.a.b())
      {
        paramHttpUrl = new ArrayList();
        return paramHttpUrl;
      }
      List localList = this.a.a(paramHttpUrl);
      paramHttpUrl = localList;
      if (localList == null)
      {
        paramHttpUrl = new java/util/ArrayList;
        paramHttpUrl.<init>();
      }
      if (paramHttpUrl.isEmpty()) {
        this.a.d();
      }
      return paramHttpUrl;
    }
    finally {}
  }
  
  public void saveFromResponse(@NonNull HttpUrl paramHttpUrl, @NonNull List<Cookie> paramList)
  {
    try
    {
      this.a.c(paramHttpUrl, paramList);
      return;
    }
    finally
    {
      paramHttpUrl = finally;
      throw paramHttpUrl;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\cookie\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */