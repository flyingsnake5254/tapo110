package b.d.d.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class b
  implements g
{
  private static final b a = new b(null);
  private f b = new f();
  
  public static b b(c paramc)
  {
    return a.a(paramc);
  }
  
  @NonNull
  public f a()
  {
    return this.b;
  }
  
  static class b
  {
    private Map<c, b> a = new HashMap();
    
    b a(c paramc)
    {
      b localb = (b)this.a.get(paramc);
      if (localb != null) {
        return localb;
      }
      localb = new b();
      this.a.put(paramc, localb);
      return localb;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */