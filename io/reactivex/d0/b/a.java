package io.reactivex.d0.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.w;
import java.util.concurrent.Callable;

public final class a
{
  private static final w a = io.reactivex.d0.a.a.d(new a());
  
  public static w a()
  {
    return io.reactivex.d0.a.a.e(a);
  }
  
  static final class a
    implements Callable<w>
  {
    public w a()
      throws Exception
    {
      return a.b.a;
    }
  }
  
  private static final class b
  {
    static final w a = new b(new Handler(Looper.getMainLooper()), false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\d0\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */