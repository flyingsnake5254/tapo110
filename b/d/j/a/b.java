package b.d.j.a;

import b.d.p.d;
import com.tplink.libtpdemux.tsdemux.common.a;
import com.tplink.libtpdemux.tsdemux.common.c;
import java.util.HashMap;
import java.util.Map;

public class b
{
  Map<String, c> a = new HashMap();
  Map<String, c> b = new HashMap();
  
  public static b a()
  {
    return b.a();
  }
  
  private c b(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_type_");
    ((StringBuilder)localObject).append(paramInt);
    String str = ((StringBuilder)localObject).toString();
    localObject = (c)this.b.get(str);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = new c(null);
      this.b.put(str, paramString);
    }
    return paramString;
  }
  
  private c d(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_type_");
    ((StringBuilder)localObject).append(paramInt);
    String str = ((StringBuilder)localObject).toString();
    localObject = (c)this.a.get(str);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = new c(null);
      this.a.put(str, paramString);
    }
    return paramString;
  }
  
  public long c(String paramString, int paramInt)
  {
    return b(paramString, paramInt).c;
  }
  
  public long e(String paramString, int paramInt)
  {
    return d(paramString, paramInt).c;
  }
  
  public void f(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_type_");
    ((StringBuilder)localObject).append(paramInt);
    String str = ((StringBuilder)localObject).toString();
    localObject = (c)this.a.get(str);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new c(null);
    }
    paramString.a();
    this.a.put(str, paramString);
    localObject = (c)this.b.get(str);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new c(null);
    }
    paramString.a();
    this.b.put(str, paramString);
  }
  
  public long g(String paramString, int paramInt1, a parama, int paramInt2)
  {
    long l1 = paramInt2 / (parama.e() * 2 / 1000);
    c localc = b(paramString, paramInt1);
    long l2 = parama.f() * 1000L;
    if (l2 != localc.d) {
      localc.e = 0L;
    }
    long l3 = localc.a;
    if ((l3 == 0L) && (localc.b == 0L))
    {
      localc.a = parama.d();
      localc.b = parama.d();
      l4 = 0L;
    }
    else
    {
      localc.b = l3;
      l3 = parama.d();
      localc.a = l3;
      l4 = (l3 - localc.b) * 1000L / 90000L;
    }
    if (Math.abs(l4) <= 1000L)
    {
      l3 = l4;
      if (l4 >= 0L) {}
    }
    else
    {
      l3 = localc.a;
      if ((l3 < 90000L) && (Math.abs(l3 - localc.b) >= 1073741824L))
      {
        localc.b = 0L;
        l3 = parama.d();
        localc.a = l3;
        l3 = (l3 - localc.b) * 1000L / 90000L;
      }
      else
      {
        localc.b = localc.a;
        l3 = 0L;
      }
    }
    if ((l3 > 0L) && (l3 < l1)) {
      l3 = l1;
    }
    long l4 = localc.e + l3;
    localc.e = l4;
    localc.c = (l4 + l2);
    if (l2 != localc.d) {
      localc.d = l2;
    }
    this.b.put(paramString, localc);
    return l3;
  }
  
  public long h(String paramString, int paramInt, c paramc)
  {
    c localc = d(paramString, paramInt);
    long l1 = paramc.c() * 1000L;
    long l2 = localc.d;
    long l3 = 0L;
    if (l1 != l2) {
      localc.e = 0L;
    }
    l2 = localc.a;
    if ((l2 == 0L) && (localc.b == 0L))
    {
      localc.a = paramc.b();
      localc.b = paramc.b();
      l2 = 0L;
    }
    else
    {
      localc.b = l2;
      l2 = paramc.b();
      localc.a = l2;
      l2 = (l2 - localc.b) * 1000L / 90000L;
    }
    if ((Math.abs(l2) <= 1000L) && (l2 >= 0L)) {
      break label292;
    }
    l2 = localc.a;
    if ((l2 < 90000L) && (Math.abs(l2 - localc.b) >= 1073741824L))
    {
      localc.b = 0L;
      l2 = paramc.b();
      localc.a = l2;
      l2 = (l2 - localc.b) * 1000L / 90000L;
    }
    else
    {
      paramc = new StringBuilder();
      paramc.append("video pts index error pts ");
      paramc.append(localc.a);
      paramc.append(" last ");
      paramc.append(localc.b);
      d.a("PtsCalculator", paramc.toString());
      localc.b = localc.a;
      l2 = l3;
    }
    label292:
    l3 = localc.e + l2;
    localc.e = l3;
    localc.c = (l3 + l1);
    if (l1 != localc.d) {
      localc.d = l1;
    }
    this.a.put(paramString, localc);
    return l2;
  }
  
  private static class b
  {
    private static final b a = new b(null);
  }
  
  private static class c
  {
    public long a = 0L;
    public long b = 0L;
    public long c = 0L;
    public long d = 0L;
    public long e = 0L;
    
    public void a()
    {
      this.a = 0L;
      this.b = 0L;
      this.c = 0L;
      this.d = 0L;
      this.e = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\j\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */