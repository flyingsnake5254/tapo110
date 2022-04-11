package kotlinx.coroutines.scheduling;

import kotlin.v.e;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.y;

public final class b
  extends c
{
  private static final y y;
  public static final b z;
  
  static
  {
    b localb = new b();
    z = localb;
    y = localb.u(u.f("kotlinx.coroutines.io.parallelism", e.b(64, u.a()), 0, 0, 12, null));
  }
  
  private b()
  {
    super(0, 0, null, 7, null);
  }
  
  public void close()
  {
    throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
  }
  
  public String toString()
  {
    return "DefaultDispatcher";
  }
  
  public final y x()
  {
    return y;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */