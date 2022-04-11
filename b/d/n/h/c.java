package b.d.n.h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class c
  implements Executor
{
  private static Executor c;
  private final Handler d = new Handler(Looper.getMainLooper());
  
  public static Executor a()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          c localc = new b/d/n/h/c;
          localc.<init>();
          c = localc;
        }
      }
      finally {}
    }
    return c;
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.d.post(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */