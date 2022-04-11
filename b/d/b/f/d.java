package b.d.b.f;

import androidx.annotation.NonNull;
import b.d.b.d.b.c;
import com.tplink.cloud.context.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements b.d.b.d.b.d
{
  private static final b a = new b(null);
  private final c b = new c();
  
  public static void c(b paramb)
  {
    a.a(paramb);
  }
  
  public static d d(b paramb)
  {
    return a.b(paramb);
  }
  
  private void e()
  {
    this.b.a();
  }
  
  @NonNull
  public c a()
  {
    return this.b;
  }
  
  static class b
  {
    private final Map<b, d> a = new HashMap();
    
    void a(b paramb)
    {
      paramb = (d)this.a.remove(paramb);
      if (paramb != null) {
        d.b(paramb);
      }
    }
    
    d b(b paramb)
    {
      d locald = (d)this.a.get(paramb);
      if (locald != null) {
        return locald;
      }
      locald = new d();
      this.a.put(paramb, locald);
      return locald;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */