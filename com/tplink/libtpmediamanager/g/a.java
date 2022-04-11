package com.tplink.libtpmediamanager.g;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import java.util.HashMap;
import java.util.Map;

public class a
  implements f
{
  private static final b a = new b(null);
  private final e b = new e();
  
  public static void c(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    a.a(paramTPMediaDeviceContext);
  }
  
  public static a d(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    return a.b(paramTPMediaDeviceContext);
  }
  
  private void e()
  {
    this.b.a();
  }
  
  @NonNull
  public e a()
  {
    return this.b;
  }
  
  static class b
  {
    private final Map<TPMediaDeviceContext, a> a = new HashMap();
    
    void a(TPMediaDeviceContext paramTPMediaDeviceContext)
    {
      if (paramTPMediaDeviceContext != null)
      {
        paramTPMediaDeviceContext = (a)this.a.remove(paramTPMediaDeviceContext);
        if (paramTPMediaDeviceContext != null) {
          a.b(paramTPMediaDeviceContext);
        }
      }
    }
    
    a b(TPMediaDeviceContext paramTPMediaDeviceContext)
    {
      a locala = (a)this.a.get(paramTPMediaDeviceContext);
      if (locala != null) {
        return locala;
      }
      locala = new a();
      this.a.put(paramTPMediaDeviceContext, locala);
      return locala;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */