package b.d.n.j;

import com.tplink.libtpinappmessaging.model.c;
import io.reactivex.m0.b;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.v;

public class f
{
  private static final g<c> a = b.n1().l1();
  private static final g<c> b = d.n1().l1();
  
  public static g<c> a()
  {
    return b;
  }
  
  public static g<c> b()
  {
    return a;
  }
  
  public static void c(c paramc)
  {
    b.onNext(paramc);
  }
  
  public static void d(Throwable paramThrowable)
  {
    a.onError(paramThrowable);
  }
  
  public static void e(c paramc)
  {
    a.onNext(paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\j\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */