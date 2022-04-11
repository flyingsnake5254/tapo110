package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.util.HashMap;
import java.util.Map;

public class a
  implements g
{
  private static final b a = new b(null);
  private f b = new f();
  
  public static void c(TPBaseDeviceContext paramTPBaseDeviceContext)
  {
    a.a(paramTPBaseDeviceContext);
  }
  
  public static a d(TPBaseDeviceContext paramTPBaseDeviceContext)
  {
    return a.b(paramTPBaseDeviceContext);
  }
  
  private void e()
  {
    this.b.a();
  }
  
  @NonNull
  public f a()
  {
    return this.b;
  }
  
  static class b
  {
    private Map<TPBaseDeviceContext, a> a = new HashMap();
    
    void a(TPBaseDeviceContext paramTPBaseDeviceContext)
    {
      if (paramTPBaseDeviceContext != null)
      {
        paramTPBaseDeviceContext = (a)this.a.remove(paramTPBaseDeviceContext);
        if (paramTPBaseDeviceContext != null) {
          a.b(paramTPBaseDeviceContext);
        }
      }
    }
    
    a b(TPBaseDeviceContext paramTPBaseDeviceContext)
    {
      a locala = (a)this.a.get(paramTPBaseDeviceContext);
      if (locala != null) {
        return locala;
      }
      locala = new a();
      this.a.put(paramTPBaseDeviceContext, locala);
      return locala;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\kb\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */