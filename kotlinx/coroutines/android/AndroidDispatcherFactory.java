package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.MainDispatcherFactory;

public final class AndroidDispatcherFactory
  implements MainDispatcherFactory
{
  public String a()
  {
    return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
  }
  
  public int c()
  {
    return 1073741823;
  }
  
  public a d(List<? extends MainDispatcherFactory> paramList)
  {
    j.f(paramList, "allFactories");
    paramList = Looper.getMainLooper();
    j.b(paramList, "Looper.getMainLooper()");
    return new a(c.a(paramList, true), "Main");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\android\AndroidDispatcherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */