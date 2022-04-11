package kotlin.u.e;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.j;

public final class a
  extends kotlin.u.a
{
  public int d(int paramInt1, int paramInt2)
  {
    return ThreadLocalRandom.current().nextInt(paramInt1, paramInt2);
  }
  
  public Random e()
  {
    ThreadLocalRandom localThreadLocalRandom = ThreadLocalRandom.current();
    j.d(localThreadLocalRandom, "ThreadLocalRandom.current()");
    return localThreadLocalRandom;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\u\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */