package com.tplink.libtpnetwork.cameranetwork.business.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class g
{
  private boolean a;
  private boolean b;
  private int c;
  private Boolean d = null;
  private List<d> e = new ArrayList();
  private b f = new b();
  
  public g a()
  {
    g localg = new g();
    localg.h(this.b);
    localg.g(this.a);
    localg.k(this.c);
    localg.i(this.d);
    localg.j(this.e);
    b localb = this.f;
    if (localb != null) {
      localg.f(localb);
    }
    return localg;
  }
  
  public Boolean b()
  {
    return this.d;
  }
  
  public List<d> c()
  {
    return Collections.unmodifiableList(this.e);
  }
  
  public int d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((((g)paramObject).b == this.b) && (((g)paramObject).a == this.a) && (((g)paramObject).c == this.c) && (((g)paramObject).d == this.d) && (((g)paramObject).e.equals(this.e)))
      {
        paramObject = ((g)paramObject).f;
        if (paramObject != null)
        {
          b localb = this.f;
          if (localb != null) {
            return paramObject.equals(localb);
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public void f(b paramb)
  {
    this.f = paramb.a();
  }
  
  public void g(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void h(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void i(Boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void j(List<d> paramList)
  {
    this.e.clear();
    this.e.addAll(paramList);
  }
  
  public void k(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */