package b.d.m.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  private a a;
  private b b;
  private int c;
  private int d;
  private String e;
  private Map<String, io.reactivex.e0.c> f;
  
  public void a(String paramString, int paramInt, io.reactivex.e0.c paramc)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    paramString = (io.reactivex.e0.c)this.f.get(localObject);
    if ((paramString != null) && (!paramString.isDisposed())) {
      paramString.dispose();
    }
    this.f.put(localObject, paramc);
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        io.reactivex.e0.c localc = (io.reactivex.e0.c)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localc != null) && (!localc.isDisposed())) {
          localc.dispose();
        }
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public int c()
  {
    return this.c;
  }
  
  public a d()
  {
    return this.a;
  }
  
  public b e()
  {
    return this.b;
  }
  
  public int f()
  {
    return this.d;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public void h(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void i(a parama)
  {
    this.a = parama;
  }
  
  public void j(b paramb)
  {
    this.b = paramb;
  }
  
  public void k(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void l(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\m\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */