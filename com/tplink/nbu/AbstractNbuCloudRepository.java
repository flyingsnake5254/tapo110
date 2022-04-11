package com.tplink.nbu;

import b.d.b.f.a;
import com.tplink.cloud.context.b.a;
import com.tplink.nbu.b.m;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractNbuCloudRepository
  extends a
{
  private static final Map<com.tplink.cloud.context.b, m> c = new HashMap();
  protected m d;
  
  public AbstractNbuCloudRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.d = f(paramb);
  }
  
  private static void e(com.tplink.cloud.context.b paramb)
  {
    c.remove(paramb);
  }
  
  private static m f(com.tplink.cloud.context.b paramb)
  {
    Map localMap = c;
    m localm1 = (m)localMap.get(paramb);
    m localm2 = localm1;
    if (localm1 == null)
    {
      localm2 = new m(paramb);
      localMap.put(paramb, localm2);
      g(paramb, localm2);
    }
    return localm2;
  }
  
  private static void g(com.tplink.cloud.context.b paramb, final m paramm)
  {
    paramb.a(new a(paramm));
  }
  
  class a
    implements b.a
  {
    a(m paramm) {}
    
    public void a()
    {
      AbstractNbuCloudRepository.d(AbstractNbuCloudRepository.this);
      paramm.Q1();
      AbstractNbuCloudRepository.this.f(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\AbstractNbuCloudRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */