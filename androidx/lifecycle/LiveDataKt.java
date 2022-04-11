package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LiveDataKt
{
  @MainThread
  public static final <T> Observer<T> observe(LiveData<T> paramLiveData, LifecycleOwner paramLifecycleOwner, l<? super T, p> paraml)
  {
    j.f(paramLiveData, "$this$observe");
    j.f(paramLifecycleOwner, "owner");
    j.f(paraml, "onChanged");
    paraml = new Observer()
    {
      public final void onChanged(T paramAnonymousT)
      {
        this.$onChanged.invoke(paramAnonymousT);
      }
    };
    paramLiveData.observe(paramLifecycleOwner, paraml);
    return paraml;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LiveDataKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */