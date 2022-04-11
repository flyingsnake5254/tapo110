package b.d.o.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private c a;
  private List<d> b;
  private Map<String, io.reactivex.e0.c> c;
  private boolean d = true;
  
  public void a(d paramd)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramd);
  }
  
  public void b(String paramString, int paramInt, io.reactivex.e0.c paramc)
  {
    if (this.c == null) {
      this.c = new ConcurrentHashMap();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    paramString = ((StringBuilder)localObject).toString();
    localObject = (io.reactivex.e0.c)this.c.get(paramString);
    if ((localObject != null) && (!((io.reactivex.e0.c)localObject).isDisposed())) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    this.c.put(paramString, paramc);
  }
  
  public void c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (io.reactivex.e0.c)((Map.Entry)localIterator.next()).getValue();
        if ((localObject != null) && (!((io.reactivex.e0.c)localObject).isDisposed())) {
          ((io.reactivex.e0.c)localObject).dispose();
        }
        localIterator.remove();
      }
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    if (this.c == null) {
      this.c = new ConcurrentHashMap();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    paramString = (io.reactivex.e0.c)this.c.get(paramString);
    if ((paramString != null) && (!paramString.isDisposed())) {
      paramString.dispose();
    }
  }
  
  public List<d> e()
  {
    return this.b;
  }
  
  public c f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public void h()
  {
    this.d = true;
  }
  
  public void i(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void j(c paramc)
  {
    this.a = paramc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\o\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */