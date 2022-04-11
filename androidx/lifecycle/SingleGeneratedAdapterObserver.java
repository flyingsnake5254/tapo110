package androidx.lifecycle;

import androidx.annotation.NonNull;

class SingleGeneratedAdapterObserver
  implements LifecycleEventObserver
{
  private final GeneratedAdapter mGeneratedAdapter;
  
  SingleGeneratedAdapterObserver(GeneratedAdapter paramGeneratedAdapter)
  {
    this.mGeneratedAdapter = paramGeneratedAdapter;
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    this.mGeneratedAdapter.callMethods(paramLifecycleOwner, paramEvent, false, null);
    this.mGeneratedAdapter.callMethods(paramLifecycleOwner, paramEvent, true, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\SingleGeneratedAdapterObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */