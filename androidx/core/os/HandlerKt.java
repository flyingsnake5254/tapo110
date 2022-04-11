package androidx.core.os;

import android.os.Handler;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class HandlerKt
{
  public static final Runnable postAtTime(Handler paramHandler, long paramLong, Object paramObject, a<p> parama)
  {
    j.f(paramHandler, "$this$postAtTime");
    j.f(parama, "action");
    parama = new Runnable()
    {
      public final void run()
      {
        this.$action.invoke();
      }
    };
    paramHandler.postAtTime(parama, paramObject, paramLong);
    return parama;
  }
  
  public static final Runnable postDelayed(Handler paramHandler, long paramLong, Object paramObject, a<p> parama)
  {
    j.f(paramHandler, "$this$postDelayed");
    j.f(parama, "action");
    parama = new Runnable()
    {
      public final void run()
      {
        this.$action.invoke();
      }
    };
    if (paramObject == null) {
      paramHandler.postDelayed(parama, paramLong);
    } else {
      HandlerCompat.postDelayed(paramHandler, parama, paramObject, paramLong);
    }
    return parama;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\HandlerKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */