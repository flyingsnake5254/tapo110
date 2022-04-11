package com.tplink.tpble;

import android.app.Application;
import io.reactivex.q;
import java.util.List;

public class w
{
  private u a;
  
  public static w a()
  {
    return a.a();
  }
  
  public q<String> e(Application paramApplication, v paramv)
  {
    return f(paramApplication, paramv).g0(j.c);
  }
  
  public q<List<t>> f(Application paramApplication, v paramv)
  {
    g();
    paramApplication = new u(paramApplication, paramv);
    this.a = paramApplication;
    return paramApplication.x().y(new k(this));
  }
  
  public void g()
  {
    u localu = this.a;
    if (localu != null)
    {
      localu.y();
      this.a = null;
    }
  }
  
  private static class a
  {
    private static final w a = new w();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */