package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c;

import androidx.annotation.VisibleForTesting;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LEColor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class b
{
  public static final b a = new b(null);
  
  @VisibleForTesting
  public static final class a
    implements a
  {
    private String a;
    
    public a(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return b((List)paramObject);
    }
    
    @VisibleForTesting
    public final Integer b(List<LEColor> paramList)
    {
      Object localObject1 = null;
      if (paramList != null)
      {
        localObject2 = new ArrayList(l.l(paramList, 10));
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          paramList = (List<LEColor>)localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          ((Collection)localObject2).add(((LEColor)localIterator.next()).getH());
        }
      }
      paramList = null;
      Object localObject2 = paramList;
      if (!(paramList instanceof List)) {
        localObject2 = null;
      }
      paramList = (List<LEColor>)localObject1;
      if (localObject2 != null) {
        paramList = Integer.valueOf((int)l.u((Iterable)localObject2));
      }
      return paramList;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  public static final class b
  {
    public final Map<String, a> a()
    {
      return b0.e(new Pair[] { n.a("mapSpeed", new b.h(null, 1, null)), n.a("minHue", new b.k(null, 1, null)), n.a("maxHue", new b.i(null, 1, null)), n.a("minSat", new b.l(null, 1, null)), n.a("maxSat", new b.j(null, 1, null)), n.a("plusHue", new b.n(null, 1, null)), n.a("minusHue", new b.m(null, 1, null)), n.a("sortHue", new b.p(null, 1, null)), n.a("sortHueDescending", new b.o(null, 1, null)), n.a("avgHue", new b.a(null, 1, null)), n.a("equals", new b.c(null, 1, null)), n.a("lessThan", new b.g(null, 1, null)), n.a("lessEqualsThan", new b.f(null, 1, null)), n.a("greaterThan", new b.e(null, 1, null)), n.a("greaterEqualsThan", new b.d(null, 1, null)) });
    }
  }
  
  @VisibleForTesting
  public static final class c
    implements a
  {
    private String a;
    
    public c(String paramString)
    {
      this.a = paramString;
    }
    
    private final boolean c(String paramString)
    {
      bool1 = false;
      bool2 = bool1;
      if (paramString != null) {}
      try
      {
        Integer.parseInt(paramString);
        bool2 = true;
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          bool2 = bool1;
        }
      }
      return bool2;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Boolean.valueOf(b(paramList.get(0), paramList.get(1)));
    }
    
    @VisibleForTesting
    public final boolean b(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = null;
      Object localObject2;
      if (paramObject1 != null) {
        localObject2 = paramObject1.toString();
      } else {
        localObject2 = null;
      }
      if (paramObject2 != null) {
        paramObject1 = paramObject2.toString();
      } else {
        paramObject1 = null;
      }
      if ((c((String)localObject2)) && (c((String)paramObject1)))
      {
        if (localObject2 != null) {
          paramObject2 = Integer.valueOf(Integer.parseInt((String)localObject2));
        } else {
          paramObject2 = null;
        }
        localObject2 = localObject1;
        if (paramObject1 != null) {
          localObject2 = Integer.valueOf(Integer.parseInt((String)paramObject1));
        }
        return j.a(paramObject2, localObject2);
      }
      return j.a(localObject2, paramObject1);
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class d
    implements a
  {
    private String a;
    
    public d(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Boolean.valueOf(b(paramList.get(0), paramList.get(1)));
    }
    
    @VisibleForTesting
    public final boolean b(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = null;
      boolean bool = false;
      if (paramObject1 != null) {
        try
        {
          paramObject1 = paramObject1.toString();
          if (paramObject1 != null) {
            paramObject1 = Integer.valueOf(Integer.parseInt((String)paramObject1));
          }
        }
        catch (NumberFormatException paramObject1)
        {
          break label98;
        }
      }
      paramObject1 = null;
      Object localObject2 = localObject1;
      if (paramObject2 != null)
      {
        paramObject2 = paramObject2.toString();
        localObject2 = localObject1;
        if (paramObject2 != null) {
          localObject2 = Integer.valueOf(Integer.parseInt((String)paramObject2));
        }
      }
      if ((paramObject1 != null) && (localObject2 != null))
      {
        int i = ((Integer)paramObject1).intValue();
        int j = ((Integer)localObject2).intValue();
        if (i >= j) {
          bool = true;
        }
        return bool;
        label98:
        ((NumberFormatException)paramObject1).printStackTrace();
      }
      return false;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class e
    implements a
  {
    private String a;
    
    public e(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Boolean.valueOf(b(paramList.get(0), paramList.get(1)));
    }
    
    @VisibleForTesting
    public final boolean b(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = null;
      boolean bool = false;
      if (paramObject1 != null) {
        try
        {
          paramObject1 = paramObject1.toString();
          if (paramObject1 != null) {
            paramObject1 = Integer.valueOf(Integer.parseInt((String)paramObject1));
          }
        }
        catch (NumberFormatException paramObject1)
        {
          break label98;
        }
      }
      paramObject1 = null;
      Object localObject2 = localObject1;
      if (paramObject2 != null)
      {
        paramObject2 = paramObject2.toString();
        localObject2 = localObject1;
        if (paramObject2 != null) {
          localObject2 = Integer.valueOf(Integer.parseInt((String)paramObject2));
        }
      }
      if ((paramObject1 != null) && (localObject2 != null))
      {
        int i = ((Integer)paramObject1).intValue();
        int j = ((Integer)localObject2).intValue();
        if (i > j) {
          bool = true;
        }
        return bool;
        label98:
        ((NumberFormatException)paramObject1).printStackTrace();
      }
      return false;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class f
    implements a
  {
    private String a;
    
    public f(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Boolean.valueOf(b(paramList.get(0), paramList.get(1)));
    }
    
    @VisibleForTesting
    public final boolean b(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = null;
      boolean bool = false;
      if (paramObject1 != null) {
        try
        {
          paramObject1 = paramObject1.toString();
          if (paramObject1 != null) {
            paramObject1 = Integer.valueOf(Integer.parseInt((String)paramObject1));
          }
        }
        catch (NumberFormatException paramObject1)
        {
          break label98;
        }
      }
      paramObject1 = null;
      Object localObject2 = localObject1;
      if (paramObject2 != null)
      {
        paramObject2 = paramObject2.toString();
        localObject2 = localObject1;
        if (paramObject2 != null) {
          localObject2 = Integer.valueOf(Integer.parseInt((String)paramObject2));
        }
      }
      if ((paramObject1 != null) && (localObject2 != null))
      {
        int i = ((Integer)paramObject1).intValue();
        int j = ((Integer)localObject2).intValue();
        if (i <= j) {
          bool = true;
        }
        return bool;
        label98:
        ((NumberFormatException)paramObject1).printStackTrace();
      }
      return false;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class g
    implements a
  {
    private String a;
    
    public g(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Boolean.valueOf(b(paramList.get(0), paramList.get(1)));
    }
    
    @VisibleForTesting
    public final boolean b(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = null;
      boolean bool = false;
      if (paramObject1 != null) {
        try
        {
          paramObject1 = paramObject1.toString();
          if (paramObject1 != null) {
            paramObject1 = Integer.valueOf(Integer.parseInt((String)paramObject1));
          }
        }
        catch (NumberFormatException paramObject1)
        {
          break label98;
        }
      }
      paramObject1 = null;
      Object localObject2 = localObject1;
      if (paramObject2 != null)
      {
        paramObject2 = paramObject2.toString();
        localObject2 = localObject1;
        if (paramObject2 != null) {
          localObject2 = Integer.valueOf(Integer.parseInt((String)paramObject2));
        }
      }
      if ((paramObject1 != null) && (localObject2 != null))
      {
        int i = ((Integer)paramObject1).intValue();
        int j = ((Integer)localObject2).intValue();
        if (i < j) {
          bool = true;
        }
        return bool;
        label98:
        ((NumberFormatException)paramObject1).printStackTrace();
      }
      return false;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class h
    implements a
  {
    private String a;
    
    public h(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Integer.valueOf(b(Integer.parseInt(paramList.get(0).toString()), Integer.parseInt(paramList.get(1).toString()), Integer.parseInt(paramList.get(2).toString())));
    }
    
    @VisibleForTesting
    public final int b(int paramInt1, int paramInt2, int paramInt3)
    {
      float f = paramInt1 / 100.0F;
      return (int)((paramInt3 - paramInt2) * f + paramInt2);
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class i
    implements a
  {
    private String a;
    
    public i(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return Integer.valueOf(b((List)paramObject));
    }
    
    @VisibleForTesting
    public final int b(List<LEColor> paramList)
    {
      int i = Integer.MIN_VALUE;
      int j = i;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = ((LEColor)localIterator.next()).getH();
          if (paramList != null) {
            i = Math.max(i, paramList.intValue());
          }
        }
      }
      return j;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class j
    implements a
  {
    private String a;
    
    public j(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return Integer.valueOf(b((List)paramObject));
    }
    
    @VisibleForTesting
    public final int b(List<LEColor> paramList)
    {
      int i = Integer.MIN_VALUE;
      int j = i;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = ((LEColor)localIterator.next()).getS();
          if (paramList != null) {
            i = Math.max(i, paramList.intValue());
          }
        }
      }
      return j;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class k
    implements a
  {
    private String a;
    
    public k(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return Integer.valueOf(b((List)paramObject));
    }
    
    @VisibleForTesting
    public final int b(List<LEColor> paramList)
    {
      int i = Integer.MAX_VALUE;
      int j = i;
      if (paramList != null)
      {
        paramList = paramList.iterator();
        for (;;)
        {
          j = i;
          if (!paramList.hasNext()) {
            break;
          }
          Integer localInteger = ((LEColor)paramList.next()).getH();
          if (localInteger != null) {
            i = Math.min(i, localInteger.intValue());
          }
        }
      }
      return j;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class l
    implements a
  {
    private String a;
    
    public l(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return Integer.valueOf(b((List)paramObject));
    }
    
    @VisibleForTesting
    public final int b(List<LEColor> paramList)
    {
      int i = Integer.MAX_VALUE;
      int j = i;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = ((LEColor)localIterator.next()).getS();
          if (paramList != null) {
            i = Math.min(i, paramList.intValue());
          }
        }
      }
      return j;
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class m
    implements a
  {
    private String a;
    
    public m(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Integer.valueOf(b(Integer.parseInt(paramList.get(0).toString()), Integer.parseInt(paramList.get(1).toString())));
    }
    
    @VisibleForTesting
    public final int b(int paramInt1, int paramInt2)
    {
      return Math.max(paramInt1 - paramInt2, 0);
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class n
    implements a
  {
    private String a;
    
    public n(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      return Integer.valueOf(b(Integer.parseInt(paramList.get(0).toString()), Integer.parseInt(paramList.get(1).toString())));
    }
    
    @VisibleForTesting
    public final int b(int paramInt1, int paramInt2)
    {
      return Math.min(paramInt1 + paramInt2, 360);
    }
    
    public String getId()
    {
      return this.a;
    }
  }
  
  @VisibleForTesting
  public static final class o
    implements a
  {
    private String a;
    
    public o(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return b((List)paramObject);
    }
    
    @VisibleForTesting
    public final List<LEColor> b(List<LEColor> paramList)
    {
      if (paramList != null) {
        paramList = l.O(paramList, new a());
      } else {
        paramList = null;
      }
      return paramList;
    }
    
    public String getId()
    {
      return this.a;
    }
    
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        return kotlin.q.a.a(((LEColor)paramT2).getH(), ((LEColor)paramT1).getH());
      }
    }
  }
  
  @VisibleForTesting
  public static final class p
    implements a
  {
    private String a;
    
    public p(String paramString)
    {
      this.a = paramString;
    }
    
    public Object a(Object paramObject, List<Object> paramList)
    {
      j.e(paramList, "params");
      paramList = paramList.get(0);
      paramObject = paramList;
      if (!(paramList instanceof List)) {
        paramObject = null;
      }
      return b((List)paramObject);
    }
    
    @VisibleForTesting
    public final List<LEColor> b(List<LEColor> paramList)
    {
      if (paramList != null) {
        paramList = l.O(paramList, new a());
      } else {
        paramList = null;
      }
      return paramList;
    }
    
    public String getId()
    {
      return this.a;
    }
    
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        return kotlin.q.a.a(((LEColor)paramT1).getH(), ((LEColor)paramT2).getH());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\f\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */