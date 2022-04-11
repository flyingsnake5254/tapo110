package com.google.android.exoplayer2.extractor.flv;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.i;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class d
  extends TagPayloadReader
{
  private long b = -9223372036854775807L;
  private long[] c = new long[0];
  private long[] d = new long[0];
  
  public d()
  {
    super(new i());
  }
  
  private static Boolean g(d0 paramd0)
  {
    int i = paramd0.D();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  @Nullable
  private static Object h(d0 paramd0, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 8)
            {
              if (paramInt != 10)
              {
                if (paramInt != 11) {
                  return null;
                }
                return i(paramd0);
              }
              return m(paramd0);
            }
            return k(paramd0);
          }
          return l(paramd0);
        }
        return n(paramd0);
      }
      return g(paramd0);
    }
    return j(paramd0);
  }
  
  private static Date i(d0 paramd0)
  {
    Date localDate = new Date(j(paramd0).doubleValue());
    paramd0.Q(2);
    return localDate;
  }
  
  private static Double j(d0 paramd0)
  {
    return Double.valueOf(Double.longBitsToDouble(paramd0.w()));
  }
  
  private static HashMap<String, Object> k(d0 paramd0)
  {
    int i = paramd0.H();
    HashMap localHashMap = new HashMap(i);
    for (int j = 0; j < i; j++)
    {
      String str = n(paramd0);
      Object localObject = h(paramd0, o(paramd0));
      if (localObject != null) {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  private static HashMap<String, Object> l(d0 paramd0)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str = n(paramd0);
      int i = o(paramd0);
      if (i == 9) {
        return localHashMap;
      }
      Object localObject = h(paramd0, i);
      if (localObject != null) {
        localHashMap.put(str, localObject);
      }
    }
  }
  
  private static ArrayList<Object> m(d0 paramd0)
  {
    int i = paramd0.H();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      Object localObject = h(paramd0, o(paramd0));
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private static String n(d0 paramd0)
  {
    int i = paramd0.J();
    int j = paramd0.e();
    paramd0.Q(i);
    return new String(paramd0.d(), j, i);
  }
  
  private static int o(d0 paramd0)
  {
    return paramd0.D();
  }
  
  protected boolean b(d0 paramd0)
  {
    return true;
  }
  
  protected boolean c(d0 paramd0, long paramLong)
  {
    if (o(paramd0) != 2) {
      return false;
    }
    if (!"onMetaData".equals(n(paramd0))) {
      return false;
    }
    if (o(paramd0) != 8) {
      return false;
    }
    Object localObject1 = k(paramd0);
    paramd0 = ((Map)localObject1).get("duration");
    if ((paramd0 instanceof Double))
    {
      double d1 = ((Double)paramd0).doubleValue();
      if (d1 > 0.0D) {
        this.b = ((d1 * 1000000.0D));
      }
    }
    paramd0 = ((Map)localObject1).get("keyframes");
    if ((paramd0 instanceof Map))
    {
      localObject1 = (Map)paramd0;
      paramd0 = ((Map)localObject1).get("filepositions");
      localObject1 = ((Map)localObject1).get("times");
      if (((paramd0 instanceof List)) && ((localObject1 instanceof List)))
      {
        paramd0 = (List)paramd0;
        List localList = (List)localObject1;
        int i = localList.size();
        this.c = new long[i];
        this.d = new long[i];
        int j = 0;
        while (j < i)
        {
          localObject1 = paramd0.get(j);
          Object localObject2 = localList.get(j);
          if (((localObject2 instanceof Double)) && ((localObject1 instanceof Double)))
          {
            this.c[j] = ((((Double)localObject2).doubleValue() * 1000000.0D));
            this.d[j] = ((Double)localObject1).longValue();
            j++;
          }
          else
          {
            this.c = new long[0];
            this.d = new long[0];
          }
        }
      }
    }
    return false;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public long[] e()
  {
    return this.d;
  }
  
  public long[] f()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\extractor\flv\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */