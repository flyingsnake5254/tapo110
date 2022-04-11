package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import androidx.annotation.Keep;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.h;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Keep
public final class AndroidExceptionPreHandler
  extends kotlin.coroutines.a
  implements CoroutineExceptionHandler, kotlin.jvm.b.a<Method>
{
  private final kotlin.f preHandler$delegate = h.b(this);
  
  public AndroidExceptionPreHandler()
  {
    super(CoroutineExceptionHandler.g);
  }
  
  private final Method getPreHandler()
  {
    kotlin.f localf = this.preHandler$delegate;
    kotlin.reflect.j localj = $$delegatedProperties[0];
    return (Method)localf.getValue();
  }
  
  public void handleException(kotlin.coroutines.f paramf, Throwable paramThrowable)
  {
    kotlin.jvm.internal.j.f(paramf, "context");
    kotlin.jvm.internal.j.f(paramThrowable, "exception");
    Thread localThread = Thread.currentThread();
    if (Build.VERSION.SDK_INT >= 28)
    {
      kotlin.jvm.internal.j.b(localThread, "thread");
      localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    }
    else
    {
      paramf = getPreHandler();
      Object localObject = null;
      if (paramf != null) {
        paramf = paramf.invoke(null, new Object[0]);
      } else {
        paramf = null;
      }
      if (!(paramf instanceof Thread.UncaughtExceptionHandler)) {
        paramf = (kotlin.coroutines.f)localObject;
      }
      paramf = (Thread.UncaughtExceptionHandler)paramf;
      if (paramf != null) {
        paramf.uncaughtException(localThread, paramThrowable);
      }
    }
  }
  
  public Method invoke()
  {
    Object localObject1 = null;
    int i = 0;
    try
    {
      Method localMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
      kotlin.jvm.internal.j.b(localMethod, "it");
      int j = i;
      if (Modifier.isPublic(localMethod.getModifiers()))
      {
        boolean bool = Modifier.isStatic(localMethod.getModifiers());
        j = i;
        if (bool) {
          j = 1;
        }
      }
      if (j != 0) {
        localObject1 = localMethod;
      }
    }
    finally
    {
      for (;;) {}
    }
    return (Method)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\android\AndroidExceptionPreHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */