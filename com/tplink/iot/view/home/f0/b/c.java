package com.tplink.iot.view.home.f0.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class c
{
  static String a(ConcurrentHashMap<String, b> paramConcurrentHashMap)
  {
    Iterator localIterator = paramConcurrentHashMap.entrySet().iterator();
    paramConcurrentHashMap = null;
    Object localObject = null;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
        if (localObject == null)
        {
          paramConcurrentHashMap = (String)localEntry.getKey();
          localObject = (b)localEntry.getValue();
        }
        else
        {
          b localb = (b)localEntry.getValue();
          if (((b)localObject).a() < localb.a())
          {
            paramConcurrentHashMap = (String)localEntry.getKey();
            localObject = localb;
          }
        }
      }
    }
    return paramConcurrentHashMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */