package androidx.navigation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

class NavControllerViewModel
  extends ViewModel
{
  private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory()
  {
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramAnonymousClass)
    {
      return new NavControllerViewModel();
    }
  };
  private final HashMap<UUID, ViewModelStore> mViewModelStores = new HashMap();
  
  @NonNull
  static NavControllerViewModel getInstance(ViewModelStore paramViewModelStore)
  {
    return (NavControllerViewModel)new ViewModelProvider(paramViewModelStore, FACTORY).get(NavControllerViewModel.class);
  }
  
  void clear(@NonNull UUID paramUUID)
  {
    paramUUID = (ViewModelStore)this.mViewModelStores.remove(paramUUID);
    if (paramUUID != null) {
      paramUUID.clear();
    }
  }
  
  @NonNull
  ViewModelStore getViewModelStore(@NonNull UUID paramUUID)
  {
    ViewModelStore localViewModelStore1 = (ViewModelStore)this.mViewModelStores.get(paramUUID);
    ViewModelStore localViewModelStore2 = localViewModelStore1;
    if (localViewModelStore1 == null)
    {
      localViewModelStore2 = new ViewModelStore();
      this.mViewModelStores.put(paramUUID, localViewModelStore2);
    }
    return localViewModelStore2;
  }
  
  protected void onCleared()
  {
    Iterator localIterator = this.mViewModelStores.values().iterator();
    while (localIterator.hasNext()) {
      ((ViewModelStore)localIterator.next()).clear();
    }
    this.mViewModelStores.clear();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NavControllerViewModel{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("} ViewModelStores (");
    Iterator localIterator = this.mViewModelStores.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavControllerViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */