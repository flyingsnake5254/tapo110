package com.tplink.iot.Utils.v0.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tplink.libtpnetwork.Utils.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class b
  implements a
{
  public static final a a = new a(null);
  private final SharedPreferences b;
  private final HashMap<String, c> c;
  private final Context d;
  
  public b(Context paramContext)
  {
    this.d = paramContext;
    this.b = paramContext.getSharedPreferences("cloudVideoCache", 0);
    this.c = new HashMap();
  }
  
  private final void i()
  {
    String str = i.f(this.c);
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putString("cacheKey", str);
    localEditor.apply();
  }
  
  public void a(String paramString, long paramLong)
  {
    j.e(paramString, "deviceId");
    Object localObject = (c)this.c.get(paramString);
    if (localObject != null)
    {
      localObject = ((c)localObject).a();
      if ((localObject != null) && (!((ArrayList)localObject).contains(Long.valueOf(paramLong)))) {
        return;
      }
    }
    localObject = (c)this.c.get(paramString);
    if (localObject != null)
    {
      localObject = ((c)localObject).a();
      if (localObject != null) {
        ((ArrayList)localObject).remove(Long.valueOf(paramLong));
      }
    }
    paramString = (c)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.g(System.currentTimeMillis());
      i();
    }
  }
  
  public Long b(String paramString)
  {
    j.e(paramString, "deviceId");
    c localc = (c)this.c.get(paramString);
    if (localc != null)
    {
      localc.g(System.currentTimeMillis());
      i();
    }
    paramString = (c)this.c.get(paramString);
    if (paramString != null) {
      paramString = Long.valueOf(paramString.c());
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public void c(String paramString1, long paramLong, String paramString2, List<Long> paramList)
  {
    j.e(paramString1, "deviceId");
    j.e(paramString2, "timeZone");
    j.e(paramList, "dates");
    Object localObject;
    if (this.c.get(paramString1) == null)
    {
      localObject = new c();
      ((c)localObject).e(paramString2);
      this.c.put(paramString1, localObject);
    }
    paramString1 = (c)this.c.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.g(System.currentTimeMillis());
      paramString1.f(paramLong);
      paramString1.e(paramString2);
      paramString1.a().clear();
      paramString1.a().addAll(paramList);
      paramList = paramString1.a();
      paramString2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        paramLong = ((Number)localObject).longValue();
        int i;
        if (System.currentTimeMillis() - paramLong < 2764800000L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          paramString2.add(localObject);
        }
      }
      paramString1.a().clear();
      paramString1.a().addAll(paramString2);
      l.n(paramString1.a());
      i();
    }
  }
  
  public void d()
  {
    Object localObject1 = this.b.getString("cacheKey", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CloudVideoCache:");
      ((StringBuilder)localObject2).append((String)localObject1);
      b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject2).toString());
      localObject2 = (HashMap)i.b((String)localObject1, new b().getType());
      j.d(localObject2, "map");
      localObject1 = new LinkedHashMap();
      Object localObject3 = ((Map)localObject2).entrySet().iterator();
      int i;
      for (;;)
      {
        boolean bool = ((Iterator)localObject3).hasNext();
        i = 1;
        if (!bool) {
          break;
        }
        localObject2 = (Map.Entry)((Iterator)localObject3).next();
        if (((c)((Map.Entry)localObject2).getValue()).d() <= System.currentTimeMillis() - 2592000000L) {
          i = 0;
        }
        if (i != 0) {
          ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
      }
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        Object localObject4 = ((c)((Map.Entry)localObject2).getValue()).a();
        localObject3 = new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          long l = ((Number)localObject5).longValue();
          if (System.currentTimeMillis() - l < 2764800000L) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        ((c)((Map.Entry)localObject2).getValue()).a().clear();
        ((c)((Map.Entry)localObject2).getValue()).a().addAll((Collection)localObject3);
      }
      this.c.clear();
      this.c.putAll((Map)localObject1);
      i();
    }
  }
  
  public void e(String paramString, long paramLong)
  {
    j.e(paramString, "deviceId");
    Object localObject = (c)this.c.get(paramString);
    if (localObject != null)
    {
      localObject = ((c)localObject).a();
      if ((localObject != null) && (((ArrayList)localObject).contains(Long.valueOf(paramLong)))) {
        return;
      }
    }
    localObject = (c)this.c.get(paramString);
    if (localObject != null)
    {
      localObject = ((c)localObject).a();
      if (localObject != null) {
        ((ArrayList)localObject).add(Long.valueOf(paramLong));
      }
    }
    paramString = (c)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.g(System.currentTimeMillis());
      i();
    }
  }
  
  public List<Long> f(String paramString)
  {
    j.e(paramString, "deviceId");
    c localc = (c)this.c.get(paramString);
    if (localc != null)
    {
      localc.g(System.currentTimeMillis());
      i();
    }
    paramString = (c)this.c.get(paramString);
    if (paramString != null) {
      paramString = paramString.a();
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public String g(String paramString)
  {
    j.e(paramString, "deviceId");
    paramString = (c)this.c.get(paramString);
    if (paramString != null) {
      paramString = paramString.b();
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public void h(String paramString, long paramLong)
  {
    j.e(paramString, "deviceId");
    paramString = (c)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.f(paramLong);
      paramString.g(System.currentTimeMillis());
      i();
    }
  }
  
  public static final class a {}
  
  public static final class b
    extends com.google.gson.r.a<HashMap<String, c>>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */