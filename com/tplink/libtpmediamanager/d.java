package com.tplink.libtpmediamanager;

import b.d.d.g.a;
import b.d.d.m.b;
import b.d.u.l;
import b.d.u.m;
import b.d.u.n;
import b.d.u.o;
import b.d.v.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements c, n
{
  private Map<String, m> a;
  private final Map<String, Long> b;
  private Map<String, List<c>> c;
  private final a d;
  
  private d()
  {
    a locala = new a();
    this.d = locala;
    this.a = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.c = new HashMap(1);
    b.a().c(locala);
  }
  
  public static d h()
  {
    return b.a();
  }
  
  private void i(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    Long localLong = (Long)this.b.get(paramString);
    if ((localLong != null) && (localLong.longValue() != 0L))
    {
      m localm = (m)this.a.get(paramString);
      if (localm != null) {
        localm.b(localLong.longValue(), paramArrayOfByte);
      }
      long l1 = localLong.longValue();
      long l2 = paramInt;
      this.b.put(paramString, Long.valueOf(l1 + l2));
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.b.put(paramString, Long.valueOf(paramLong));
  }
  
  public void b(String paramString, long paramLong)
  {
    Long localLong = (Long)this.b.get(paramString);
    if ((localLong == null) || (localLong.longValue() == 0L)) {
      this.b.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void d(String paramString, c paramc)
  {
    if (paramString == null) {
      return;
    }
    List localList = null;
    if (this.c.containsKey(paramString)) {
      localList = (List)this.c.get(paramString);
    }
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    if (((List)localObject).contains(paramc)) {
      return;
    }
    ((List)localObject).add(paramc);
    this.c.put(paramString, localObject);
  }
  
  public void e()
  {
    Object localObject = this.a.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((m)((Map.Entry)((Iterator)localObject).next()).getValue()).a();
    }
    this.a.clear();
    Iterator localIterator1 = this.c.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      localObject = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (localIterator2.hasNext()) {
        ((c)localIterator2.next()).onDoubleTalkClose((String)((Map.Entry)localObject).getKey());
      }
    }
    this.c.clear();
    this.b.clear();
  }
  
  public void f(String paramString)
  {
    if (paramString == null) {
      return;
    }
    m localm = (m)this.a.remove(paramString);
    if (localm != null) {
      localm.a();
    }
    this.c.remove(paramString);
    this.b.remove(paramString);
  }
  
  public m g(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = (m)this.a.get(paramString);
    }
    return paramString;
  }
  
  public void j(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    if (this.a.containsKey(paramString1)) {
      return;
    }
    if ("aec".equals(paramString2))
    {
      paramString2 = new l(paramString1, paramString2);
      paramString2.h(this);
    }
    else
    {
      paramString2 = new o(paramString1, paramString2);
    }
    this.a.put(paramString1, paramString2);
    paramString2.f(this);
    paramString2.c();
  }
  
  public void onDoubleTalkClose(String paramString)
  {
    if (paramString == null) {
      return;
    }
    b.d.p.d.a("TTTT", "Manager onDoubleTalkClose");
    Object localObject = (List)this.c.get(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((c)((Iterator)localObject).next()).onDoubleTalkClose(paramString);
        b.d.p.d.a("TTTT", "callback onDoubleTalkClose");
      }
    }
    localObject = (m)this.a.remove(paramString);
    if (localObject != null) {
      ((m)localObject).a();
    }
    this.c.remove(paramString);
    this.b.remove(paramString);
  }
  
  public void onDoubleTalkCreateFailure(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    b.d.p.d.a("TTTT", "Manager onDoubleTalkCreateFailure");
    Object localObject = (List)this.c.get(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((c)((Iterator)localObject).next()).onDoubleTalkCreateFailure(paramString, paramInt);
        b.d.p.d.a("TTTT", "callback onDoubleTalkCreateFailure");
      }
    }
    localObject = (m)this.a.remove(paramString);
    if (localObject != null) {
      ((m)localObject).a();
    }
    this.c.remove(paramString);
    this.b.remove(paramString);
  }
  
  public void onDoubleTalkCreateSuccess(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = (List)this.c.get(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).onDoubleTalkCreateSuccess(paramString);
      }
    }
  }
  
  public void onDoubleTalkSendDataFailure(String paramString, int paramInt, Exception paramException)
  {
    if (paramString == null) {
      return;
    }
    b.d.p.d.a("TTTT", "Manager onDoubleTalkCreateFailure");
    Object localObject = (List)this.c.get(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((c)((Iterator)localObject).next()).onDoubleTalkSendDataFailure(paramString, paramInt, paramException);
        b.d.p.d.a("TTTT", "callback onDoubleTalkCreateFailure");
      }
    }
    paramException = (m)this.a.remove(paramString);
    if (paramException != null) {
      paramException.a();
    }
    this.c.remove(paramString);
    this.b.remove(paramString);
  }
  
  class a
    implements a
  {
    a() {}
    
    public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
    {
      d.c(d.this, paramString, paramArrayOfByte, paramInt);
    }
  }
  
  private static class b
  {
    private static final d a = new d(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */