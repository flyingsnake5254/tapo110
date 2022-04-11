package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.internal.u;

public final class g0
{
  private static final boolean a = false;
  private static final boolean b;
  private static final boolean c;
  private static final AtomicLong d;
  
  static
  {
    String str = u.d("kotlinx.coroutines.debug");
    boolean bool1 = true;
    if (str != null)
    {
      int i = str.hashCode();
      if (i == 0) {
        break label81;
      }
      if (i == 3551) {
        break label69;
      }
      if (i == 109935) {
        break label57;
      }
      if ((i != 3005871) || (!str.equals("auto"))) {
        break label132;
      }
    }
    boolean bool2;
    for (;;)
    {
      bool2 = false;
      break;
      label57:
      if (!str.equals("off")) {
        break label132;
      }
    }
    label69:
    if (str.equals("on")) {
      label81:
      if (str.equals(""))
      {
        bool2 = true;
        b = bool2;
        if ((bool2) && (u.e("kotlinx.coroutines.stacktrace.recovery", true))) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        c = bool2;
        d = new AtomicLong(0L);
        return;
      }
    }
    label132:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("System property 'kotlinx.coroutines.debug' has unrecognized value '");
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  public static final boolean a()
  {
    return a;
  }
  
  public static final AtomicLong b()
  {
    return d;
  }
  
  public static final boolean c()
  {
    return b;
  }
  
  public static final boolean d()
  {
    return c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */