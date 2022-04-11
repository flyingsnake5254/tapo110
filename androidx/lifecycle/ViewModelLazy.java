package androidx.lifecycle;

import kotlin.f;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

public final class ViewModelLazy<VM extends ViewModel>
  implements f<VM>
{
  private VM cached;
  private final kotlin.jvm.b.a<ViewModelProvider.Factory> factoryProducer;
  private final kotlin.jvm.b.a<ViewModelStore> storeProducer;
  private final c<VM> viewModelClass;
  
  public ViewModelLazy(c<VM> paramc, kotlin.jvm.b.a<? extends ViewModelStore> parama, kotlin.jvm.b.a<? extends ViewModelProvider.Factory> parama1)
  {
    this.viewModelClass = paramc;
    this.storeProducer = parama;
    this.factoryProducer = parama1;
  }
  
  public VM getValue()
  {
    ViewModel localViewModel = this.cached;
    Object localObject = localViewModel;
    if (localViewModel == null)
    {
      localObject = (ViewModelProvider.Factory)this.factoryProducer.invoke();
      localObject = new ViewModelProvider((ViewModelStore)this.storeProducer.invoke(), (ViewModelProvider.Factory)localObject).get(kotlin.jvm.a.a(this.viewModelClass));
      this.cached = ((ViewModel)localObject);
      j.b(localObject, "ViewModelProvider(store,…ed = it\n                }");
    }
    return (VM)localObject;
  }
  
  public boolean isInitialized()
  {
    boolean bool;
    if (this.cached != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ViewModelLazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */