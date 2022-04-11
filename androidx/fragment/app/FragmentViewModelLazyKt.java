package androidx.fragment.app;

import androidx.activity.ComponentActivity;
import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.f;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

public final class FragmentViewModelLazyKt
{
  @MainThread
  public static final <VM extends ViewModel> f<VM> createViewModelLazy(Fragment paramFragment, c<VM> paramc, a<? extends ViewModelStore> parama, a<? extends ViewModelProvider.Factory> parama1)
  {
    j.f(paramFragment, "$this$createViewModelLazy");
    j.f(paramc, "viewModelClass");
    j.f(parama, "storeProducer");
    if (parama1 == null) {
      parama1 = new Lambda(paramFragment)
      {
        public final ViewModelProvider.Factory invoke()
        {
          ViewModelProvider.Factory localFactory = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
          j.b(localFactory, "defaultViewModelProviderFactory");
          return localFactory;
        }
      };
    }
    return new ViewModelLazy(paramc, parama, parama1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentViewModelLazyKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */