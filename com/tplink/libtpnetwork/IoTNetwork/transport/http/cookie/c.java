package com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie;

import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class c
  implements b
{
  private String a;
  private a b;
  private ConcurrentHashMap<String, Cookie> c = new ConcurrentHashMap();
  
  public c(a parama)
  {
    this.b = parama;
  }
  
  private void f(Cookie paramCookie)
  {
    if ((paramCookie == null) || (TextUtils.equals(paramCookie.name(), "TP_SESSIONID")) || ((TextUtils.isEmpty(paramCookie.name())) && (paramCookie.name().contains("SESSIONID"))))
    {
      this.b.g();
      l();
    }
  }
  
  private String g(Cookie paramCookie)
  {
    if (paramCookie == null)
    {
      paramCookie = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCookie.name());
      localStringBuilder.append(paramCookie.domain());
      paramCookie = localStringBuilder.toString();
    }
    return paramCookie;
  }
  
  private boolean i(Cookie paramCookie)
  {
    boolean bool;
    if ((paramCookie != null) && (paramCookie.expiresAt() >= System.currentTimeMillis())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean j(Cookie paramCookie)
  {
    if (paramCookie == null) {
      return false;
    }
    String str = g(paramCookie);
    if (this.c.containsKey(str))
    {
      this.c.remove(str);
      f(paramCookie);
      return true;
    }
    return false;
  }
  
  public List<Cookie> a(HttpUrl paramHttpUrl)
  {
    ArrayList localArrayList = new ArrayList();
    paramHttpUrl = this.c.values().iterator();
    while (paramHttpUrl.hasNext())
    {
      Cookie localCookie = (Cookie)paramHttpUrl.next();
      if (i(localCookie)) {
        j(localCookie);
      } else {
        localArrayList.add(localCookie);
      }
    }
    return localArrayList;
  }
  
  public boolean b()
  {
    return this.b.f();
  }
  
  public void c(HttpUrl paramHttpUrl, List<Cookie> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Cookie localCookie = (Cookie)paramList.next();
      if (!i(localCookie)) {
        e(paramHttpUrl, localCookie);
      }
    }
  }
  
  public void d()
  {
    this.b.g();
    k();
  }
  
  public void e(HttpUrl paramHttpUrl, Cookie paramCookie)
  {
    if (paramCookie == null) {
      return;
    }
    paramHttpUrl = g(paramCookie);
    this.c.put(paramHttpUrl, paramCookie);
  }
  
  public String h()
  {
    return this.a;
  }
  
  public boolean k()
  {
    this.c.clear();
    return true;
  }
  
  public void l()
  {
    this.a = null;
  }
  
  public void m(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\cookie\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */