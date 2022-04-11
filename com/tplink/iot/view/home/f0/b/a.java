package com.tplink.iot.view.home.f0.b;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private final ConcurrentHashMap<String, b> a = new ConcurrentHashMap();
  private boolean b;
  private boolean c;
  private b d;
  private String e;
  
  private void d()
  {
    if (this.b) {
      return;
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        String str = c.a(this.a);
        if (str != null)
        {
          b localb = (b)this.a.get(str);
          if (localb != null)
          {
            this.e = str;
            this.d = localb;
            this.c = true;
            localb.show();
          }
        }
      }
      return;
    }
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.c = false;
    Object localObject = this.e;
    if (localObject != null) {
      this.a.remove(localObject);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((b)localObject).clear();
      this.d = null;
    }
    d();
  }
  
  protected void e(b paramb)
  {
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.b()))) {
      synchronized (this.a)
      {
        this.a.put(paramb.b(), paramb);
        if (this.b) {
          return;
        }
        if (!this.c)
        {
          d();
        }
        else if (paramb.b().equals(this.e))
        {
          this.d = paramb;
          paramb.show();
        }
        return;
      }
    }
  }
  
  public void f()
  {
    this.b = false;
    c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */