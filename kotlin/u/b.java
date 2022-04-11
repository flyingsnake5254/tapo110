package kotlin.u;

import java.util.Random;
import kotlin.jvm.internal.j;

public final class b
  extends a
{
  private final a c = new a();
  
  public Random e()
  {
    Object localObject = this.c.get();
    j.d(localObject, "implStorage.get()");
    return (Random)localObject;
  }
  
  public static final class a
    extends ThreadLocal<Random>
  {
    protected Random a()
    {
      return new Random();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\u\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */