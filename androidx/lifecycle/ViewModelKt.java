package androidx.lifecycle;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;

public final class ViewModelKt
{
  private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";
  
  public static final d0 getViewModelScope(ViewModel paramViewModel)
  {
    j.f(paramViewModel, "$this$viewModelScope");
    d0 locald0 = (d0)paramViewModel.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
    if (locald0 != null) {
      return locald0;
    }
    paramViewModel = paramViewModel.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new CloseableCoroutineScope(v1.b(null, 1, null).plus(n0.b().u())));
    j.b(paramViewModel, "setTagIfAbsent(JOB_KEY,\n…patchers.Main.immediate))");
    return (d0)paramViewModel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ViewModelKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */