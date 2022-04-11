package com.tplink.libtpnetwork.cameranetwork.h4.m4.b;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Cookie;
import okhttp3.Cookie.Builder;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class a
  implements CookieJar
{
  private WeakReference<b> a;
  private String b;
  
  public a(@NonNull b paramb, @NonNull String paramString)
  {
    this.a = new WeakReference(paramb);
    this.b = paramString;
  }
  
  public List<Cookie> loadForRequest(@NonNull HttpUrl paramHttpUrl)
  {
    Object localObject1 = (b)this.a.get();
    paramHttpUrl = new ArrayList();
    if (localObject1 != null)
    {
      Object localObject2 = ((b)localObject1).c(this.b);
      localObject1 = ((b)localObject1).b(this.b);
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          paramHttpUrl.add(new Cookie.Builder().name((String)localEntry.getKey()).value((String)localEntry.getValue()).domain((String)localObject1).build());
        }
      }
    }
    return paramHttpUrl;
  }
  
  public void saveFromResponse(@NonNull HttpUrl paramHttpUrl, @NonNull List<Cookie> paramList)
  {
    paramHttpUrl = (b)this.a.get();
    if (paramHttpUrl != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Cookie localCookie = (Cookie)paramList.next();
        paramHttpUrl.a(this.b, localCookie.name(), localCookie.value());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\m4\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */