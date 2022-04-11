package com.tplink.iot.cloud.bean.common;

import com.google.gson.JsonParseException;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapJsonAdapter
  implements o<Map<String, Object>>, h<Map<String, Object>>
{
  private Object read(i parami)
  {
    Object localObject;
    if (parami.f())
    {
      localObject = new ArrayList();
      parami = parami.b().iterator();
      while (parami.hasNext()) {
        ((List)localObject).add(read((i)parami.next()));
      }
      return localObject;
    }
    if (parami.h())
    {
      localObject = new HashMap();
      k localk = parami.c();
      parami = localk.p().iterator();
      while (parami.hasNext())
      {
        String str = (String)parami.next();
        ((Map)localObject).put(str, read(localk.n(str)));
      }
      return localObject;
    }
    if (parami.i())
    {
      parami = parami.d();
      if (parami.q()) {
        return parami.e();
      }
      if (parami.n()) {
        return Boolean.valueOf(parami.j());
      }
      if (parami.p())
      {
        double d = parami.m().doubleValue();
        if (d > 9.223372036854776E18D) {
          return Double.valueOf(d);
        }
        long l = d;
        if (d == l) {
          return Long.valueOf(l);
        }
        return Double.valueOf(d);
      }
    }
    else if (!parami.g()) {}
    return null;
  }
  
  public Map<String, Object> deserialize(i parami, Type paramType, g paramg)
    throws JsonParseException
  {
    if (parami.h())
    {
      paramType = new HashMap();
      k localk = parami.c();
      parami = localk.p().iterator();
      while (parami.hasNext())
      {
        paramg = (String)parami.next();
        paramType.put(paramg, read(localk.n(paramg)));
      }
      return paramType;
    }
    return (Map)paramg.b(parami, paramType);
  }
  
  public i serialize(Map<String, Object> paramMap, Type paramType, n paramn)
  {
    return paramn.a(paramMap, paramType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\common\MapJsonAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */