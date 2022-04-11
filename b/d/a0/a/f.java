package b.d.a0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private Map<String, b> a = new ConcurrentHashMap();
  private e b;
  
  public static f c()
  {
    return b.a;
  }
  
  private void e()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.a.remove(localObject);
      if (localObject != null)
      {
        ((b)localObject).x(null);
        ((b)localObject).r();
      }
    }
  }
  
  public void a(String paramString)
  {
    b localb1 = (b)this.a.get(paramString);
    b localb2 = localb1;
    if (localb1 == null)
    {
      localb2 = new b(paramString);
      this.a.put(paramString, localb2);
    }
    localb2.x(this.b);
    localb2.o();
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    b localb = (b)this.a.get(paramString);
    if (localb != null)
    {
      localb.w(paramLong1);
      localb.v(paramLong2);
      paramString = localb;
    }
    else
    {
      localb = new b(paramString, paramLong1, paramLong2);
      this.a.put(paramString, localb);
      paramString = localb;
    }
    paramString.x(this.b);
    paramString.o();
  }
  
  public void d()
  {
    e();
  }
  
  public void f(String paramString)
  {
    paramString = (b)this.a.get(paramString);
    if (paramString != null) {
      paramString.s();
    }
  }
  
  public void g(String paramString, int paramInt)
  {
    paramString = (b)this.a.get(paramString);
    if (paramString != null) {
      paramString.t(paramInt);
    }
  }
  
  public void h()
  {
    Iterator localIterator = new ArrayList(this.a.keySet()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.a.get(localObject);
      if (localObject != null) {
        ((b)localObject).u();
      }
    }
  }
  
  public void i(e parame)
  {
    this.b = parame;
  }
  
  public void j(String paramString, boolean paramBoolean)
  {
    paramString = (b)this.a.get(paramString);
    if (paramString != null) {
      paramString.y(paramBoolean);
    }
  }
  
  private static class b
  {
    public static f a = new f(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\a0\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */